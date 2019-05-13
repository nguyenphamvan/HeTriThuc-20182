/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nguyen
 */
public class Patient {
    private int id;
    private String name;
    private String birth;
    private String gender;
    private String Bhyt;
    private String image;

    public Patient() {
    }

    public Patient(int id, String name, String birth, String gender, String Bhyt, String image) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.Bhyt = Bhyt;
        this.image = image;
    }

    public int getId() {
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBhyt() {
        return Bhyt;
    }

    public void setBhyt(String Bhyt) {
        this.Bhyt = Bhyt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}
