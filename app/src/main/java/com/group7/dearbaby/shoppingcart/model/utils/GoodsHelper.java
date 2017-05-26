package com.group7.dearbaby.shoppingcart.model.utils;/**
 * Created by holmes k on 2017.05.24.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * auth:holmes k
 * date:2017.05.24
 */
public class GoodsHelper extends SQLiteOpenHelper {


    public GoodsHelper(Context context) {
        super(context, "goods.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table goods (gid integer primary key autoincrement," +
                "isChecked integer,picUrl text,title text,price integer," +
                "count integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
