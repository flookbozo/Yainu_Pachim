package com.example.yainu_pachim.room;

import android.content.Context;
import android.os.AsyncTask;


import com.example.yainu_pachim.model.Menu;

import java.util.List;



public class MenuRepository {

    private Context mContext;

    public MenuRepository(Context context) {this.mContext = context;}

    public void getMenu(Callback callback) {
        GetTask getTask = new GetTask(mContext, callback);
        getTask.execute();
    }

    public void insertMenu(Menu item, InsertCallback callback) {
        InsertTask insertTask = new InsertTask(mContext, callback);
        insertTask.execute(item);
    }

    private static class GetTask extends AsyncTask<Void, Void, List<Menu>> {

        private Context mContext;
        private Callback mCallback;

        public GetTask(Context context,Callback  callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected List<Menu> doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            List<Menu> itemList = db.menuDAO().getAllMenu();
            return itemList;
        }

        @Override
        protected void onPostExecute(List<Menu> menus) {
            super.onPostExecute(menus);

            mCallback.onGet(menus);
        }


    }

    public interface Callback {
        void onGet(List<Menu> itemList);
    }

    private static class InsertTask extends AsyncTask<Menu, Void, Void> {

        private Context mContext;
        private InsertCallback mCallback;

        public InsertTask(Context mContext, InsertCallback mCallback) {
            this.mContext = mContext;
            this.mCallback = mCallback;
        }

        @Override
        protected Void doInBackground(Menu... menus) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            db.menuDAO().insertMenu(menus[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();
        }
    }

    public interface InsertCallback {
        void onInsertSuccess();
    }
}
