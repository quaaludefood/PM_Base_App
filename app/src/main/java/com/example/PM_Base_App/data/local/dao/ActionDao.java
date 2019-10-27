package com.example.PM_Base_App.data.local.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.PM_Base_App.data.local.entity.ActionEntity;

import java.util.List;

@Dao
public interface ActionDao extends BaseDao<ActionEntity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertActions(List<ActionEntity> actions);

    @Query("SELECT * FROM action_table")
    List<ActionEntity> getAll();

    @Query("SELECT * FROM action_table WHERE name LIKE :name")
    List<ActionEntity> findActionsByName(String name);
}