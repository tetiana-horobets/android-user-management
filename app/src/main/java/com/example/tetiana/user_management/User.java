package com.example.tetiana.user_management;

import java.util.List;

class User {

    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private Boolean isFemale;
    private List<String> hobbies;
    private String image;
    private String back;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Integer id, String name, String email, Integer age, Boolean isFemale, List<String> hobbies, String image, String back) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.isFemale = isFemale;
        this.hobbies = hobbies;
        this.image = image;
        this.back = back;
    }

    Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

}
