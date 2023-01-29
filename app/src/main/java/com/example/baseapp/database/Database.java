package com.example.baseapp.database;

import androidx.room.RoomDatabase;

import com.example.baseapp.dao.MyUserDao;
import com.example.baseapp.po.MyUser;

@androidx.room.Database(entities = {MyUser.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract MyUserDao getUserDao();
}
