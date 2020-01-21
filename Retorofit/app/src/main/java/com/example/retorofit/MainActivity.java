package com.example.retorofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.retorofit.data.entity.CurrentWeather;
import com.example.retorofit.data.internet.RetorfitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView tvCurrentWeather;
    private EditText etWeather;
    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        initListeners();




        fetchCurrentWeather("Bishkek");
    }

    private void initListeners() {
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchCurrentWeather(etWeather.getText().toString());
            }
        });
    }

    private void initViews(){
        tvCurrentWeather = findViewById(R.id.tvCurrentWeather);
        etWeather = findViewById(R.id.etCity);
        btnClick = findViewById(R.id.click);
    }

    private void fetchCurrentWeather(String city) {
        RetorfitBuilder
                .getService()
                .fetchtCurrentWeather(city,
                        "4d63c1acf9a085448b23971128e5eddd",
                        "metric")
                .enqueue(new Callback<CurrentWeather>() {
                    @Override
                    public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                        if (response.isSuccessful() && response.body()!= null) {
                            fillViews(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<CurrentWeather> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });

    }
    private void fillViews(CurrentWeather weather) {
        tvCurrentWeather.setText(weather.getMain().getTemp().toString());
        Glide.with(getApplicationContext())
                .load("http://openweathermap.org/img/wn/" + weather.getWeather().get(0).getIcon() + "@2x.png")
                .into(imageView);


    }
}
