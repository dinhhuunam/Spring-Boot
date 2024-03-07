package com.luv2code.springdemo.mvc;

public class Test {
    public static void main(String[] args) {
        String mess = new String("     ");
        System.out.println(mess.length());
        mess = mess.replaceAll("\\s+","");
        System.out.println(mess.length());
        if(mess == ""){
            System.out.println("Null");
        }else{
            System.out.println("Not null");
        }
    }
}
