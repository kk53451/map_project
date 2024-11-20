package com.example.map_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int restaurantCount = 0; // 맛집 개수
    private LinearLayout restaurantListLayout; // 리스트 버튼들을 동적으로 추가할 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 화면 전환 버튼 클릭 시 추천 맛집 리스트 화면으로 이동
        Button transitionButton = findViewById(R.id.transitionButton);
        transitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추천 맛집 리스트로 이동
                Intent intent = new Intent(getApplicationContext(), RecommendationActivity.class);
                startActivity(intent);
            }
        });

        // 새로운 맛집 추가하기 버튼 클릭 시
        Button addNewRestaurantButton = findViewById(R.id.addNewRestaurantButton);
        addNewRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 맛집을 추가하는 화면으로 이동
                Intent intent = new Intent(getApplicationContext(), CreateListActivity.class);
                startActivity(intent);
            }
        });

        // 전체 맛집 리스트 텍스트 업데이트
        TextView totalRestaurantCount = findViewById(R.id.totalRestaurantCount);
        totalRestaurantCount.setText("전체 맛집 리스트 (" + restaurantCount + ")");

        // 맛집 리스트 버튼을 추가할 레이아웃 초기화
        restaurantListLayout = findViewById(R.id.restaurantListLayout);

        // CreateListActivity에서 넘어온 RestaurantList 객체 받기
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("restaurantList") && intent.hasExtra("listTitle")) {
            // 맛집 리스트 제목 받기
            String listTitle = intent.getStringExtra("listTitle");

            // 새 버튼 생성
            Button restaurantButton = new Button(this);
            restaurantButton.setText(listTitle); // 맛집 리스트 제목 설정
            restaurantButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 버튼 클릭 시 해당 리스트의 상세 정보를 보여주는 액티비티로 이동 (추후 구현)
                }
            });

            // 버튼을 레이아웃에 추가
            restaurantListLayout.addView(restaurantButton);

            // 맛집 개수 업데이트
            restaurantCount++;
            totalRestaurantCount.setText("전체 맛집 리스트 (" + restaurantCount + ")");
        }
    }
}
