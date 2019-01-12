package com.example.shraddha.rate1;

public class itemInfo {

    String name;
    int age;
    public itemInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public itemInfo() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
