package com.example.professor_allocation.service;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.professor_allocation.model.Allocation;

import java.util.List;

@Dao
public interface AllocationDAO {
    @Query("SELECT * FROM Allocation")
    public List<Allocation> getAllAllocations();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertAllAllocations(List<Allocation> allocations);

    }
