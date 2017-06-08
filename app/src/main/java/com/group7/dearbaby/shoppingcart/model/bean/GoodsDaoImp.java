package com.group7.dearbaby.shoppingcart.model.bean;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.group7.dearbaby.shoppingcart.presenter.ShopCartUpdataListener;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

/**
 * auth:holmes k
 * date:2017.05.24
 */
public class GoodsDaoImp implements GoodsDao {

    private Context context;
    private SQLiteDatabase db;
    private final String TABLE_NAME = "goods";
private ShopCartUpdataListener shopCartLister;
 private List<GoodsForCart> insertGoods;
    public GoodsDaoImp(Context context,ShopCartUpdataListener shopCartLister) {
        this.context = context;
        db = Connector.getDatabase();
        this.shopCartLister=shopCartLister;
        insertGoods=new ArrayList<>();
    }

    //查询方法
    @Override
    public List<GoodsForCart> queryAll() {

        List<GoodsForCart> carts = DataSupport.findAll(GoodsForCart.class);

        return carts;
    }

    //添加方法
    @Override
    public void insert(GoodsForCart goods) {
        insertGoods.add(goods);
        DataSupport.saveAll(insertGoods);
       // shopCartLister.dataChange(queryAll());
    }

    //删除方法
    @Override
    public boolean delete(List<GoodsForCart> goods) {
        int delete=0;
        for (GoodsForCart good:
             goods) {
           delete += DataSupport.delete(GoodsForCart.class, good.getGid());
        }

        if (delete > 0) {
           // shopCartLister.dataChange(queryAll());
            return true;
        }
        return false;
    }

    @Override
    public boolean upData(GoodsForCart goods) {

        ContentValues values = new ContentValues();
        values.put("count", goods.getCount());
        values.put("isChecked",goods.getIsChecked());
        int update = DataSupport.update(GoodsForCart.class, values,goods.getGid());
        if (update > 0) {
         //   shopCartLister.dataChange(queryAll());
            return true;
        }

        return false;
    }

    public void upData(List<GoodsForCart> goods) {
        int update =0;
        ContentValues values = new ContentValues();
        for (GoodsForCart cart:goods){
            values.clear();

        values.put("isChecked",cart.getIsChecked());
    update += DataSupport.update(GoodsForCart.class, values,cart.getGid());
        }
        if (update > 0) {
       //     shopCartLister.dataChange(queryAll());

        }

    }
}
