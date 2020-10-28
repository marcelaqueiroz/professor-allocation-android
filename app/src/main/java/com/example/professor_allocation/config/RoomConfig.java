package com.example.professor_allocation.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.professor_allocation.model.Allocation;
import com.example.professor_allocation.model.Course;
import com.example.professor_allocation.model.Departament;
import com.example.professor_allocation.model.Professor;
import com.example.professor_allocation.service.AllocationDAO;
import com.example.professor_allocation.service.CourseDAO;
import com.example.professor_allocation.service.DepartamentDAO;
import com.example.professor_allocation.service.ProfessorDAO;

@Database(entities = {Professor.class, Departament.class, Course.class, Allocation.class}, version = 2)
@TypeConverters(Converters.class)
public abstract class RoomConfig extends RoomDatabase {

    private static RoomConfig instance = null;

    public abstract ProfessorDAO professorDAO();
    public abstract DepartamentDAO departamentDAO();
    public abstract CourseDAO courseDAO();
    public abstract AllocationDAO allocationDAO();

    public static RoomConfig getInstance(Context context){

        if(instance==null){
            instance = Room.databaseBuilder(context,
                    RoomConfig.class,
                    "databaseName")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
