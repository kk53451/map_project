package com.example.map_project;

import java.io.Serializable;
import java.util.ArrayList;

public class RestaurantList implements Serializable {
    private ArrayList<Restaurant> restaurantList;

    // 생성자
    public RestaurantList() {
        restaurantList = new ArrayList<>();
    }

    // 리스트에 맛집 추가
    public void addRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    // 리스트 반환
    public ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    // 리스트 비우기
    public void clearList() {
        restaurantList.clear();
    }
}
