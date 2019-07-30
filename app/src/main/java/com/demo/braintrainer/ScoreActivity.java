package com.demo.braintrainer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        textViewResult = findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("result")) {
            int result = intent.getIntExtra("result", 0);
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            int max = sharedPreferences.getInt("max", 0);
            textViewResult.setText(String.format("Ваше результат: %s\nВаш максимальный результат: %s", result, max));
        }

    }

    public void onClickStartNewGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
