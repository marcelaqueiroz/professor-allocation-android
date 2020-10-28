package com.example.professor_allocation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.professor_allocation.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton profListButton = findViewById(R.id.professorButton);
        ImageButton depListButton = findViewById(R.id.departamentButton);
        ImageButton courseListButton = findViewById(R.id.courseButton);
        ImageButton allocListButton = findViewById(R.id.allocationButton);

        profListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfessorListActivity.class);
                startActivity(intent);
            }
        });

        depListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DepartamentListActivity.class);
                startActivity(intent);
            }
        });

        courseListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CourseListActivity.class);
                startActivity(intent);
            }
        });

        allocListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllocationListActivity.class);
                startActivity(intent);
            }
        });
    }
}