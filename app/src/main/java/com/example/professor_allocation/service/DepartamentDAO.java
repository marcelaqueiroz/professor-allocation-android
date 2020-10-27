package com.example.professor_allocation.service;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.professor_allocation.model.Departament;

import java.util.List;

@Dao
public interface DepartamentDAO {
    @Query("SELECT * FROM Department")
    public List<Departament> getAllDepartament();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertAllDepartament(List<Departament> departaments);
}
