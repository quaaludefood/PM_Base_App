package com.example.PM_Base_App.data.local;


import androidx.room.RoomDatabase;
import androidx.room.Database;

import com.example.PM_Base_App.data.local.dao.ActionDao;
import com.example.PM_Base_App.data.local.dao.PersonDao;
import com.example.PM_Base_App.data.local.entity.ActionEntity;
import com.example.PM_Base_App.data.local.entity.PersonEntity;

@Database(entities = {PersonEntity.class, ActionEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
    public abstract ActionDao actionDao();
}