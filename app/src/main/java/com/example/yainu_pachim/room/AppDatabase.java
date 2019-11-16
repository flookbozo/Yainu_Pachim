package com.example.yainu_pachim.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.yainu_pachim.R;
import com.example.yainu_pachim.model.Menu;

import java.util.concurrent.Executors;

@Database(entities = {Menu.class},exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "menu.db";

    public abstract MenuDAO menuDAO();

    private static AppDatabase mInstance;

    public static synchronized AppDatabase getInstance(final Context context) {
        if (mInstance == null) {
            mInstance = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            DB_NAME
                    )
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                @Override
                                public void run() {
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ก๋วยเตี๋ยวคั่วไก่", "อาหารคาว", 435, R.drawable.taewkai
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ผัดไทยใส่ไข่", "อาหารคาว", 577, R.drawable.padthaikai
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "กุ้งอบวุ้นเส้น", "อาหารคาว", 300, R.drawable.kungwunsan
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "เกี๊ยวซ่า", "อาหารคาว", 63, R.drawable.keawsa
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ข้าวแกงกะหรี่ไก่", "อาหารคาว", 470, R.drawable.karikai
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ไก่ทอด", "อาหารคาว", 345, R.drawable.kaitod
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ไก่ย่าง", "อาหารคาว", 165, R.drawable.kaiyang
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ครัวซอง", "ขนมหวาน", 235, R.drawable.pousong
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "เฉาก๊วย", "ขนมหวาน", 90, R.drawable.shoukui
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ซาหริ่ม", "ขนมหวาน", 217, R.drawable.sahlim
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ชาดำเย็น", "เครื่องดื่ม", 110, R.drawable.chadamyen
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ชานมเย็น", "เครื่องดื่ม", 100, R.drawable.chayen
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ชานมไข่มุก", "เครื่องดื่ม", 360, R.drawable.chanomkaimook
                                            )
                                    );
                                }
                            });
                            Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                                @Override
                                public void run() {

                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "กุ้งอบวุ้นเส้น", "อาหารคาว", 300, R.drawable.kungwunsan
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "เกี๊ยวซ่า", "อาหารคาว", 63, R.drawable.keawsa
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ข้าวแกงกะหรี่ไก่", "อาหารคาว", 470, R.drawable.karikai
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ไก่ทอด", "อาหารคาว", 345, R.drawable.kaitod
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ไก่ย่าง", "อาหารคาว", 165, R.drawable.kaiyang
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ครัวซอง", "ขนมหวาน", 235, R.drawable.pousong
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "เฉาก๊วย", "ขนมหวาน", 90, R.drawable.shoukui
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ซาหริ่ม", "ขนมหวาน", 217, R.drawable.sahlim
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ชาดำเย็น", "เครื่องดื่ม", 110, R.drawable.chadamyen
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ชานมเย็น", "เครื่องดื่ม", 100, R.drawable.chayen
                                            )
                                    );
                                    mInstance.menuDAO().insertMenu(
                                            new Menu(
                                                    "ชานมไข่มุก", "เครื่องดื่ม", 360, R.drawable.chanomkaimook
                                            )
                                    );
                                }
                            });
                        }

                        @Override
                        public void onOpen(@NonNull SupportSQLiteDatabase db) {
                            super.onOpen(db);
                        }
                    })
                    .build();
        }
        return mInstance;
    }
}
