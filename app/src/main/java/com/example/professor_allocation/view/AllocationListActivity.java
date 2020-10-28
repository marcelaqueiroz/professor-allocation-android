package com.example.professor_allocation.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.example.professor_allocation.R;
import com.example.professor_allocation.RequestResult;
import com.example.professor_allocation.config.RetrofitConfig;
import com.example.professor_allocation.config.RoomConfig;
import com.example.professor_allocation.model.Allocation;
import com.example.professor_allocation.model.Course;
import com.example.professor_allocation.model.Departament;
import com.example.professor_allocation.model.Professor;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllocationListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AllocationAdapter allocationAdapter;
    private RoomConfig instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocation_list);

        instance = RoomConfig.getInstance(this);

        recyclerView = findViewById(R.id.recyclerViewAlloc);
        allocationAdapter = new AllocationAdapter(this, new ArrayList<Allocation>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(allocationAdapter);


        getAllAllocations(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {

                List<Allocation> aList = instance.allocationDAO().getAllAllocations();

                allocationAdapter = new AllocationAdapter(AllocationListActivity.this, aList);
                recyclerView.setAdapter(allocationAdapter);

            }

            @Override
            public void returnError(String message) {
                Toast.makeText(AllocationListActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createAllocation() {
        Course course = new Course("Disciplina 2");
        Departament departament = new Departament(271, "");
        Professor professor = new Professor("Tiago Santos", "555.555.555-55", departament);
        String dayOfWeek = "Monday";
        int startHour = 14;
        int endHour = 16;
        Allocation a1 = new Allocation(dayOfWeek,startHour,endHour,professor,course);

        Call<Allocation> call = new RetrofitConfig().getAllocationService().createAllocation(a1);

        call.enqueue(new Callback<Allocation>() {
            @Override
            public void onResponse(Call<Allocation> call, Response<Allocation> response) {
                if (response.isSuccessful()) {
                    Allocation allocation = response.body();
                    Toast.makeText(AllocationListActivity.this, "sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AllocationListActivity.this, "sucesso no erro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Allocation> call, Throwable t) {
                Toast.makeText(AllocationListActivity.this, "Falha na requisição", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void getAllAllocations(final RequestResult requestResult) {

        Call<List<Allocation>> call = new RetrofitConfig().getAllocationService().getAllAllocations();

        call.enqueue(new Callback<List<Allocation>>() {
            @Override
            public void onResponse(Call<List<Allocation>> call, Response<List<Allocation>> response) {
                List<Allocation> allocationList = response.body();
                instance.allocationDAO().insertAllAllocations(allocationList);
                requestResult.returnSuccess(allocationList);


            }

            @Override
            public void onFailure(Call<List<Allocation>> call, Throwable t) {
                requestResult.returnError("Falha na requisição! Error Message: \n" + t.getMessage());

            }
        });
    }
}
