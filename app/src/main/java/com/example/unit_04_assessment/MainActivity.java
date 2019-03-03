package com.example.unit_04_assessment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.unit_04_assessment.Controller.EchinodermAdapter;
import com.example.unit_04_assessment.Model.Echinoderm;
import com.example.unit_04_assessment.Model.EchinodermsList;
import com.example.unit_04_assessment.Network.EchinodermService;
import com.example.unit_04_assessment.Network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.echinoderm_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        final Retrofit retrofit = RetrofitSingleton.newInstance();
        EchinodermService service = retrofit.create(EchinodermService.class);
        Call<EchinodermsList> echinoListCall = service.getEchinodermsListService();
        echinoListCall.enqueue(new Callback<EchinodermsList>() {
            @Override
            public void onResponse(Call<EchinodermsList> call, Response<EchinodermsList> response) {
                Log.d(TAG, "onResponse: " + response.body().getEchinodermResponseList().get(0).getImage());
                List<Echinoderm> messageList = response.body().getEchinodermResponseList();
                recyclerView.setAdapter(new EchinodermAdapter(messageList));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<EchinodermsList> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });


    }
}
