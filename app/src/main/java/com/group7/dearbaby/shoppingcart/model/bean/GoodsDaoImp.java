package com.group7.dearbaby.shoppingcart.model.bean;/**
 * Created by holmes k on 2017.05.24.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.group7.dearbaby.shoppingcart.model.utils.GoodsHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * auth:holmes k
 * date:2017.05.24
 */
public class GoodsDaoImp implements GoodsDao {

    private Context context;
    private GoodsHelper helper;
    private final SQLiteDatabase db;
    private final String TABLE_NAME = "goods";


    public GoodsDaoImp(Context context) {
        this.context = context;
        helper = new GoodsHelper(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public List<GoodsForCart> queryAll() {

        Cursor query = db.query(TABLE_NAME, null, null, null, null, null, null);
        List<GoodsForCart> carts = new ArrayList<>();

        while (query.moveToNext()) {
            String picUrl = query.getString(query.getColumnIndex("picUrl"));
            String title = query.getString(query.getColumnIndex("title"));
            int price = query.getInt(query.getColumnIndex("price"));
            int count = query.getInt(query.getColumnIndex("count"));
            int gid = query.getInt(query.getColumnIndex("gid"));
            int isChecked = query.getInt(query.getColumnIndex("isChecked"));
            carts.add(new GoodsForCart(gid, isChecked, picUrl, title, price, count));
        }


        return carts;
    }

    @Override
    public void insert(List<GoodsForCart> goods) {

        for (GoodsForCart good : goods) {
            ContentValues value = new ContentValues();
            value.put("picUrl", good.getPicUrl());
            value.put("title", good.getTitle());
            value.put("price", good.getPrice());
            value.put("count", good.getCount());
            value.put("gid", good.getGid());
            value.put("isChecked", good.getIsChecked());
            db.insert(TABLE_NAME, null, value);
        }


    }

    @Override
    public boolean delete(int id) {

        int delete = db.delete(TABLE_NAME, "gid=?", new String[]{id + ""});
        if (delete > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean upData(GoodsForCart goods) {

        ContentValues value = new ContentValues();
        value.put("count", goods.getCount());
        int update = db.update(TABLE_NAME, value, "gid=?", new String[]{goods.getGid() + ""});
        if (update > 0) {
            return true;
        }

        return false;
    }
}
