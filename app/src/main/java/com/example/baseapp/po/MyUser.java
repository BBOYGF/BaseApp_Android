package com.example.baseapp.po;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyUser {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo(name = "t_name")
    private String name;
    @ColumnInfo(name = "t_age")
    private Integer age;

    public MyUser( String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
