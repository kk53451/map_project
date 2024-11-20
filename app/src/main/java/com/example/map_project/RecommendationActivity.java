package com.example.map_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class RecommendationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        // 화면 전환 버튼 클릭 시 메인 화면으로 이동
        Button transitionButton = findViewById(R.id.transitionButton);
        transitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MainActivity로 이동
                Intent intent = new Intent(RecommendationActivity.this, MainActivity.class);
                startActivity(intent);

                // 현재 액티비티 종료
                finish();
            }
        });
    }
}
