package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity
        implements DetailFragment.IDetailFragment {

    @Override
    public void itemClicked(String content) {
        Toast toast = Toast.makeText(this, content, Toast.LENGTH_LONG);
        toast.show();
    }
    // Other methods


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // For brevity, itemId is hardcoded. In real app, it should be
        // retrieved from the Intent that launch this Activity
        int itemId = 2;

        FragmentManager fm = getSupportFragmentManager();
        DetailFragment fragment = (DetailFragment)
                fm.findFragmentById(R.id.detail_fragment);
        fragment.setItem(itemId);
    }


}
