package com.group7.dearbaby.base;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.group7.dearbaby.application.MyApplication;
import com.group7.dearbaby.registlogin.view.activity.LoginActivity;
import com.group7.dearbaby.utils.SharedPreferenceUtils2;

import java.util.List;

/**
 * Created by l on 2017-03-15.
 */

public class BaseFragmentActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener ,LoginListener{
    private List<Fragment> fragments;
    private FragmentManager manager;
    private int oldId;
    private int contentId;
private RadioGroup tabs;
    protected void initView(int contentId, RadioGroup tabs, List<Fragment> fragments) {
        this.contentId = contentId;
        manager = getSupportFragmentManager();
        this.fragments = fragments;
        addOrShow(0);
        this.tabs=tabs;
        ((RadioButton) tabs.getChildAt(0)).setChecked(true);
        tabs.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        hide(oldId);
        for (int i = 0; i < fragments.size(); i++) {
            if (group.getChildAt(i).getId() == checkedId) {
             if (i!=4||(boolean)SharedPreferenceUtils2.get(this,"hadLogin",false)){
                oldId = i;
                addOrShow(i);}
               else {
                     addOrShow(oldId);
                 ( (RadioButton)group.getChildAt(oldId)).setChecked(true);
                     Intent intent=new Intent(this, LoginActivity.class);
                     startActivity(intent);
                 }

             }
            }
        }


    private void addOrShow(int i) {
        Fragment fragmentByTag = manager.findFragmentByTag(contentId + "frag" + i);
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentByTag != null) {
            transaction.show(fragmentByTag);

        } else {
            transaction.add(contentId, fragments.get(i), contentId + "frag" + i);
        }
        transaction.commitAllowingStateLoss();
    }

    private void hide(int id) {
        Fragment fragmentByTag = manager.findFragmentByTag(contentId + "frag" + id);
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentByTag != null) {
            transaction.hide(fragmentByTag);
        }
        transaction.commitAllowingStateLoss();
    }
    private void remove(int id) {
        Fragment fragmentByTag = manager.findFragmentByTag(contentId + "frag" + id);
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentByTag != null) {
            transaction.remove(fragmentByTag);
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void authExit() {
        ((RadioButton) tabs.getChildAt(0)).setChecked(true);
remove(4);
        ((RadioButton) tabs.getChildAt(4)).setChecked(true);
    }

    @Override
    public void authLogin() {
        ((RadioButton) tabs.getChildAt(4)).setChecked(true);
    }
    protected void removeAll(){
        remove(0);
        remove(1);
        remove(2);
        remove(3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((MyApplication)getApplicationContext()).removeLiser(this);
    }
}
