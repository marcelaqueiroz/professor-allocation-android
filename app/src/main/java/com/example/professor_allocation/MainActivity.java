package com.example.professor_allocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.professor_allocation.model.Departament;
import com.example.professor_allocation.model.Professor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private List<Professor> professorsList = new ArrayList<>();
    private String [] professorsNames = new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);

        getAllProfessors(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {
                professorsList = (List<Professor>) requestResult;

                professorsNames = new String[professorsList.size()];

                for(int i =0; i<professorsNames.length; i++){
                     professorsNames[i] = professorsList.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, professorsNames);
                listview.setAdapter(adapter);
            }

            @Override
            public void returnError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }


    private void CreateProfessor() {
        Departament departament = new Departament(271,"");
        Professor p1 = new Professor("Tiago Santos", "555.555.555-55", departament);
        Call<Professor> call = new RetrofitConfig().getProfessorService().createProfessor(p1);

        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if (response.isSuccessful()) {
                    Professor professor = response.body();
                    Toast.makeText(MainActivity.this, "sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "sucesso no erro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha na requisição", Toast.LENGTH_LONG).show();

            }
        });
    }


    private void getAllProfessors(final RequestResult listner) {

        Call<List<Professor>> call = new RetrofitConfig().getProfessorService().getAllProfessors();

        call.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> professorsList = response.body();
                listner.returnSuccess(professorsList);

            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                listner.returnError("Erro na requisição! Error Message: \n" + t.getMessage());

            }
        });
    }
}