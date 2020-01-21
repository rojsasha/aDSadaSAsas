package com.example.weatherapp.ui.onboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.widget.Toolbar;

import com.example.weatherapp.R;
import com.example.weatherapp.ui.base.BaseActivity;

import java.util.Objects;

import butterknife.BindView;

public class OnBoardActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override    
    protected int getViewLayout() {
        return R.layout.activity_on_board;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_onboard_skip, menu);
        return true;
    }

    public static void start(Context context){
        context.startActivity(new Intent(context, OnBoardActivity.class));
    }
}
