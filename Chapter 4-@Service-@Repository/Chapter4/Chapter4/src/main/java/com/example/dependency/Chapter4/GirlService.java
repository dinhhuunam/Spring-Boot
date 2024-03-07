package com.example.dependency.Chapter4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public Girl getRandomGirl(){
        //random 1 cái tên độ dài 10
        String name = randomGirlName(10);

        // Gọi xuông tầng repository để query lấy một cô gái tên là "name" trong database
        return girlRepository.getGirlByName(name);
    }

    public String randomGirlName(int length){
        // Random một string có độ dài quy định
        // Sử dụng thư viện Apache Common Lang
        return "Đinh Hữu Nam";
    }
}
