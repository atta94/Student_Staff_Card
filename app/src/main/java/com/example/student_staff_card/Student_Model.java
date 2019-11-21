package com.example.student_staff_card;

public class Student_Model {

private String name;
private String number;
private  int image;


    public Student_Model(int image, String name, String number) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
