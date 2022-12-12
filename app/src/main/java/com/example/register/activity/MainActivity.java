package com.example.register.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.register.R;
import com.example.register.RetrofitAPI;
import com.example.register.domain.BoardReceivedDTO;
import com.example.register.recyclerview.MainAdapter;
import com.example.register.recyclerview.MainData;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Main main;
    private Board board;
    private Report report;
    private MyReport myReport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
            bottomNavigationView = findViewById(R.id.bottomNavi);
            bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.home:
                            setFrag(0);
                            break;
                        case R.id.writing:
                            setFrag(1);
                            break;
                        case R.id.report:
                            setFrag(2);
                            break;
                        case R.id.mreport:
                            setFrag(3);
                            break;
                    }

                    return true;
                }
            });
            main = new Main();
            board = new Board();
            report = new Report();
            myReport = new MyReport();
            setFrag(0); //첫 프래그먼트 화면을 지정한다.
        }

        private void setFrag(int n){      //프래그먼트 교체가 일어나는 실행문
            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();
            switch (n) {
                case 0:
                    ft.replace(R.id.main_frame, main);
                    ft.commit();
                    break;
                case 1:
                    ft.replace(R.id.main_frame, board);
                    ft.commit();
                    break;
                case 2:
                    ft.replace(R.id.main_frame, report);
                    ft.commit();
                    break;
                case 3:
                    ft.replace(R.id.main_frame, myReport);
                    ft.commit();
                    break;
            }
        }
    }