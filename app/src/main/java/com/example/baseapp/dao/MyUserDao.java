package com.example.baseapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.baseapp.po.MyUser;

import java.util.List;

@Dao
public interface MyUserDao {
    @Insert
    void insertUser(MyUser... myUsers);

    @Update
    void updateUser(MyUser... myUsers);

    @Delete()
    void deleteUser(MyUser... myUsers);

    @Query("delete from MyUser")
    void deleteAllUser();

    @Query("select * from MyUser  ")
    List<MyUser> getAllUser();
}
