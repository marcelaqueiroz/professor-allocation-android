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
import com.example.professor_allocation.model.Course;
import com.example.professor_allocation.model.Departament;
import com.example.professor_allocation.model.Professor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private RoomConfig instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        instance = RoomConfig.getInstance(this);

        recyclerView = findViewById(R.id.recyclerViewCourse);
        courseAdapter = new CourseAdapter(this, new ArrayList<Course>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(courseAdapter);


        getAllCourses(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {

                List<Course> cList = instance.courseDAO().getAllCourses();

                courseAdapter = new CourseAdapter(CourseListActivity.this, cList);
                recyclerView.setAdapter(courseAdapter);

            }

            @Override
            public void returnError(String message) {
                Toast.makeText(CourseListActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }


    private void createCourse() {
        Course c1 = new Course("Disciplina 2");
        Call<Course> call = new RetrofitConfig().getCourseService().createCourse(c1);

        call.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if (response.isSuccessful()) {
                    Course course = response.body();
                    Toast.makeText(CourseListActivity.this, "sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CourseListActivity.this, "sucesso no erro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                Toast.makeText(CourseListActivity.this, "Falha na requisição", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void getAllCourses(final RequestResult requestResult) {

        Call<List<Course>> call = new RetrofitConfig().getCourseService().getAllCourses();

        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                List<Course> courseList = response.body();
                instance.courseDAO().insertAllCourses(courseList);
                requestResult.returnSuccess(courseList);


            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                requestResult.returnError("Falha na requisição! Error Message: \n" + t.getMessage());

            }
        });
    }
}
