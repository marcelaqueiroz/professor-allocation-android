package com.example.professor_allocation.service;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.professor_allocation.model.Professor;

import java.util.List;

@Dao
public interface ProfessorDAO {

    @Query("SELECT * FROM Professor")
    public List<Professor> getAllProfessors();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertAllProfessors(List<Professor> professors);

}
