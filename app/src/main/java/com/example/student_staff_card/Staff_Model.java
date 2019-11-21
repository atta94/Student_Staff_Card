package com.example.student_staff_card;

public class Staff_Model {


    private String name;
    private String number;
    private  int image;

    public Staff_Model(int image,String name, String number) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
