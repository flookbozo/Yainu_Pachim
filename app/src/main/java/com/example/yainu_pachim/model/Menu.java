package com.example.yainu_pachim.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "menu")
public class Menu {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "cal")
    public int cal;

    @ColumnInfo(name = "image")
    public int imageRes;


    public Menu( String name, String type, int cal, int imageRes) {

        this.name = name;
        this.type = type;
        this.cal = cal;
        this.imageRes = imageRes;
    }
}
