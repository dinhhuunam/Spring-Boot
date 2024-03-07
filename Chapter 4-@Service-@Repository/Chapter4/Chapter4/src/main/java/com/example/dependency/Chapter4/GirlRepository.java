package com.example.dependency.Chapter4;

public interface GirlRepository {

    //Tìm kiếm một cô gái trong database theo tên
    Girl getGirlByName(String name);
}
