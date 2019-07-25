package com.example.home.mockapiresponse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Gson gson = new GsonBuilder()

                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")

                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://127.0.0.1:8080")
                        //.baseUrl("https://api.github.com")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                GithubApi github_api = retrofit.create(GithubApi.class);

                Call<Githubuser> call = github_api.getGithubUsers();

                call.enqueue(new Callback<Githubuser>() {
                    @Override
                    public void onResponse(Call<Githubuser> call, Response<Githubuser> response) {
                        textView1.setText(response.body().id);
                        textView2.setText(response.body().login);
                        textView3.setText(response.body().created_at);
                    }

                    @Override
                    public void onFailure(Call<Githubuser> call, Throwable t) {
                        textView1.setText("error");
                        textView2.setText("error");
                        textView3.setText("error");

                    }
                });



            }
        });

    }
}
