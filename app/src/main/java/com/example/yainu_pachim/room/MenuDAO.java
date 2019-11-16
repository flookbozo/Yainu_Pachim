package com.example.yainu_pachim.room;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.yainu_pachim.model.Menu;

import java.util.List;

@Dao
public interface MenuDAO {

    @Query("SELECT * FROM menu")
    List<Menu> getAllMenu();

    @Insert
    void insertMenu(Menu menu);
}
