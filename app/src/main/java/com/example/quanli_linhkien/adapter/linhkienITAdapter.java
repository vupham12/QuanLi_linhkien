package com.example.quanli_linhkien.adapter;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.quanli_linhkien.fragment.HomeFragment;
import com.example.quanli_linhkien.model.linhkienIT;

import java.util.ArrayList;

public class linhkienITAdapter extends BaseAdapter {
    HomeFragment context;
    ArrayList<linhkienIT> list;
    SQLiteDatabase Database;
    String DATABASE_NAME = "linhkienIT.db";
    TextView txtID,txtTenLK,txtgialk;
    ImageView imgAnh;
    Button btnSua,btnXoa;

    public linhkienITAdapter(HomeFragment context, ArrayList<linhkienIT> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;

    }

    }

