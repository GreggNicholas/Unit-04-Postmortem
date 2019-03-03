package com.example.unit_04_assessment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.unit_04_assessment.Fragment.DetailFragment;
import com.example.unit_04_assessment.View.EchinodermViewHolder;

public class SecondActivity extends AppCompatActivity implements DetailFragment.OnfragmetInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        final String name = intent.getStringExtra(EchinodermViewHolder.ANIMAL_KEY);
        final String image = intent.getStringExtra(EchinodermViewHolder.IMAGE_KEY);
        final String website = intent.getStringExtra(EchinodermViewHolder.WIKI_KEY);

        final DetailFragment detailFragment = DetailFragment.newInstance(name, image, website);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_secondactivity, detailFragment)
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onFragmentInteraction(String website) {

        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(intent);
    }
}
