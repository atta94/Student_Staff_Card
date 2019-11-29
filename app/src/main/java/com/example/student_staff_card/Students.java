package com.example.student_staff_card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Students {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("First_name")
    @Expose
    public String firstName;
    @SerializedName("Last_name")
    @Expose
    public String lastName;
    @SerializedName("Father_name")
    @Expose
    public String fatherName;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("adress")
    @Expose
    public String adress;
    @SerializedName("contact")
    @Expose
    public String contact;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("file_name")
    @Expose
    public Object fileName;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getGender() {
        return gender;
    }

    public String getAdress() {
        return adress;
    }

    public String getContact() {
        return contact;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Object getFileName() {
        return fileName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setFileName(Object fileName) {
        this.fileName = fileName;
    }
}
