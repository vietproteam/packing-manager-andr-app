package com.example.parkingmanager.entities.supers;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.HashMap;
import java.util.Map;

@Entity (tableName = "super_users")
public class SuperUser {
    @PrimaryKey(autoGenerate = true)
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String company;
    private String taxNumber;
    private String password;

    public SuperUser() {
        this.id = "";
        this.name = "";
        this.phone = "";
        this.email = "";
        this.address = "";
        this.company = "";
        this.taxNumber = "";
        this.password = "";
    }

    public SuperUser(String id, String name, String phone, String email, String address, String company, String taxNumber, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.company = company;
        this.taxNumber = taxNumber;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("phone", phone);
        map.put("email", email);
        map.put("address", address);
        map.put("company", company);
        map.put("taxNumber", taxNumber);
        map.put("password", password);
        return map;
    }

    public void mapStringToSuperUser(Map<String, String> map) {
        this.id = map.get("id");
        this.name = map.get("name");
        this.phone = map.get("phone");
        this.email = map.get("email");
        this.address = map.get("address");
        this.company = map.get("company");
        this.taxNumber = map.get("taxNumber");
        this.password = map.get("password");
    }

    public void fromMap(Map<String,String> all) {
        this.id = all.get("id");
        this.name = all.get("name");
        this.phone = all.get("phone");
        this.email = all.get("email");
        this.address = all.get("address");
        this.company = all.get("company");
        this.taxNumber = all.get("taxNumber");
        this.password = all.get("password");
    }

    public void set(String k, String string) {
        switch (k) {
            case "id":
                this.id = string;
                break;
            case "name":
                this.name = string;
                break;
            case "phone":
                this.phone = string;
                break;
            case "email":
                this.email = string;
                break;
            case "address":
                this.address = string;
                break;
            case "company":
                this.company = string;
                break;
            case "taxNumber":
                this.taxNumber = string;
                break;
            case "password":
                this.password = string;
                break;
        }
    }
}
