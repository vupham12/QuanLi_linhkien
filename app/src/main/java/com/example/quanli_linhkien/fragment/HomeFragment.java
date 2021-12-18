package com.example.quanli_linhkien.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quanli_linhkien.R;
import com.example.quanli_linhkien.adapter.linhkienITAdapter;
import com.example.quanli_linhkien.model.linhkienIT;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<linhkienIT> list;
    linhkienITAdapter adapterlinhkien;
    ListView lstDSlk;
    SQLiteDatabase Database;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_home,container,false);


    }

    }


