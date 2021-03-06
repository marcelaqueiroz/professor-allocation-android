package com.example.professor_allocation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.professor_allocation.R;
import com.example.professor_allocation.RequestResult;
import com.example.professor_allocation.config.RetrofitConfig;
import com.example.professor_allocation.config.RoomConfig;
import com.example.professor_allocation.model.Departament;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartamentListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DepartamentAdapter departamentAdapter;
    private RoomConfig instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departament_list);

        instance = RoomConfig.getInstance(this);

        recyclerView = findViewById(R.id.recyclerViewDep);
        departamentAdapter = new DepartamentAdapter(this, new ArrayList<Departament>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(departamentAdapter);

        getAllDepartaments(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {
                List<Departament> dList = instance.departamentDAO().getAllDepartament();

                departamentAdapter = new DepartamentAdapter(DepartamentListActivity.this, dList);
                recyclerView.setAdapter(departamentAdapter);
            }

            @Override
            public void returnError(String message) {
                Toast.makeText(DepartamentListActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }
    private void createDepartament() {
        Departament d1 = new Departament("");
        Call<Departament> call = new RetrofitConfig().getDepartamentService().createDepartament(d1);

        call.enqueue(new Callback<Departament>() {
            @Override
            public void onResponse(Call<Departament> call, Response<Departament> response) {
                if (response.isSuccessful()) {
                    Departament departament = response.body();
                    Toast.makeText(DepartamentListActivity.this, "sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DepartamentListActivity.this, "sucesso no erro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Departament> call, Throwable t) {
                Toast.makeText(DepartamentListActivity.this, "Falha na requisição", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getAllDepartaments(final RequestResult requestResult) {

        Call<List<Departament>> call = new RetrofitConfig().getDepartamentService().getAllDepartament();

        call.enqueue(new Callback<List<Departament>>() {
            @Override
            public void onResponse(Call<List<Departament>> call, Response<List<Departament>> response) {
                List<Departament> departamentsList = response.body();
                instance.departamentDAO().insertAllDepartament(departamentsList);
                requestResult.returnSuccess(departamentsList);
            }

            @Override
            public void onFailure(Call<List<Departament>> call, Throwable t) {
                requestResult.returnError("Falha na requisição! Error Message: \n" + t.getMessage());

            }
        });
    }
}