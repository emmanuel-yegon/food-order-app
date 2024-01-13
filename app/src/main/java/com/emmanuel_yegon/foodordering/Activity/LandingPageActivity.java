package com.emmanuel_yegon.foodordering.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.emmanuel_yegon.foodordering.databinding.ActivityLandingPageBinding;

public class LandingPageActivity extends AppCompatActivity {

    ActivityLandingPageBinding binding;
    private ConstraintLayout startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLandingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        startBtn = binding.startBtn;

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingPageActivity.this, MainActivity.class));
            }
        });

        binding.getRoot();
    }
}