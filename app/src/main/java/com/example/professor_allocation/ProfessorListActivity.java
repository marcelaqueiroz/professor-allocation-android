package com.example.professor_allocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.professor_allocation.config.RetrofitConfig;
import com.example.professor_allocation.config.RoomConfig;
import com.example.professor_allocation.model.Departament;
import com.example.professor_allocation.model.Professor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProfessorAdapter professorAdapter;
    private RoomConfig instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_list);

        instance = RoomConfig.getInstance(this);

        recyclerView = findViewById(R.id.recyclerViewProf);
        professorAdapter = new ProfessorAdapter(this, new ArrayList<Professor>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(professorAdapter);


        getAllProfessors(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {

                List<Professor> pList = instance.professorDAO().getAllProfessors();

                professorAdapter = new ProfessorAdapter(ProfessorListActivity.this, pList);
                recyclerView.setAdapter(professorAdapter);

            }

            @Override
            public void returnError(String message) {
                Toast.makeText(ProfessorListActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }


    private void createProfessor() {
        Departament departament = new Departament(271,"");
        Professor p1 = new Professor("Tiago Santos", "555.555.555-55", departament);
        Call<Professor> call = new RetrofitConfig().getProfessorService().createProfessor(p1);

        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                if (response.isSuccessful()) {
                    Professor professor = response.body();
                    Toast.makeText(ProfessorListActivity.this, "sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ProfessorListActivity.this, "sucesso no erro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                Toast.makeText(ProfessorListActivity.this, "Falha na requisição", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void getAllProfessors(final RequestResult requestResult) {

        Call<List<Professor>> call = new RetrofitConfig().getProfessorService().getAllProfessors();

        call.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> professorsList = response.body();
                instance.professorDAO().insertAllProfessors(professorsList);
                requestResult.returnSuccess(professorsList);


            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                requestResult.returnError("Falha na requisição! Error Message: \n" + t.getMessage());

            }
        });
    }
}