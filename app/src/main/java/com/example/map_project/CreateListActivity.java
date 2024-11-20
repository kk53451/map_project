package com.example.map_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CreateListActivity extends AppCompatActivity {

    private RestaurantList restaurantList = new RestaurantList();  // 새로운 맛집 리스트 생성
    private ArrayList<String> storeList = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        // 제목 입력 폼
        final EditText editListTitle = findViewById(R.id.editListTitle);

        // 텍스트 입력창
        final EditText editStoreName = findViewById(R.id.editStoreName);
        final EditText editAddress = findViewById(R.id.editAddress);
        final EditText editBusinessHours = findViewById(R.id.editBusinessHours);
        final EditText editHoliday = findViewById(R.id.editHoliday);
        final EditText editOtherDetails = findViewById(R.id.editOtherDetails); // 기타 입력 사항

        // 리스트뷰 어댑터 설정
        ListView storeListView = findViewById(R.id.storeListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, storeList);
        storeListView.setAdapter(adapter);

        // 추가 버튼 클릭 시
        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String storeName = editStoreName.getText().toString();
                String address = editAddress.getText().toString();
                String businessHours = editBusinessHours.getText().toString();
                String holiday = editHoliday.getText().toString();
                String otherDetails = editOtherDetails.getText().toString();  // 기타 입력 사항

                String storeInfo = storeName + " | " + address + " | " + businessHours + " | " + holiday;

                // 리스트에 추가
                storeList.add(storeInfo);
                adapter.notifyDataSetChanged();  // 리스트뷰 갱신

                // 맛집 객체 생성하여 리스트에 추가
                Restaurant restaurant = new Restaurant(storeName, address, businessHours, holiday, otherDetails);
                restaurantList.addRestaurant(restaurant);

                // 입력 폼 초기화
                editStoreName.setText("");
                editAddress.setText("");
                editBusinessHours.setText("");
                editHoliday.setText("");
                editOtherDetails.setText(""); // 기타 입력 사항 초기화
            }
        });

        // 저장 버튼 클릭 시
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 맛집 리스트 제목을 메인 화면으로 전달
                String listTitle = editListTitle.getText().toString();
                Intent intent = new Intent(CreateListActivity.this, MainActivity.class);
                intent.putExtra("restaurantList", restaurantList);  // RestaurantList 전달
                intent.putExtra("listTitle", listTitle);  // 리스트 제목 전달
                startActivity(intent);
                finish();  // 현재 액티비티 종료
            }
        });

        // 삭제 버튼 클릭 시
        Button deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 리스트를 비우고 메인 화면으로 이동
                restaurantList.clearList();
                storeList.clear();  // 문자열 리스트도 비우기
                adapter.notifyDataSetChanged();  // 리스트뷰 갱신
                Intent intent = new Intent(CreateListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
