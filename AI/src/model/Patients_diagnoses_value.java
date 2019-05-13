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
public class Patients_diagnoses_value {
    private int id;
    private double fever;
    private double malaria;
    private double typhoid;
    private double stomach;
    private double chestProblem;
    private String date;
    private int idPatient;

    public Patients_diagnoses_value() {
    }

    public Patients_diagnoses_value(int id, double fever, double malaria, double typhoid, double stomach, double chestProblem, String date,int idPatient) {
        this.id = id;
        this.fever = fever;
        this.malaria = malaria;
        this.typhoid = typhoid;
        this.stomach = stomach;
        this.chestProblem = chestProblem;
        this.date = date;
        this.idPatient = idPatient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFever() {
        return fever;
    }

    public void setFever(double fever) {
        this.fever = fever;
    }

    public double getMalaria() {
        return malaria;
    }

    public void setMalaria(double malaria) {
        this.malaria = malaria;
    }

    public double getTyphoid() {
        return typhoid;
    }

    public void setTyphoid(double typhoid) {
        this.typhoid = typhoid;
    }

    public double getStomach() {
        return stomach;
    }

    public void setStomach(double stomach) {
        this.stomach = stomach;
    }

    public double getChestProblem() {
        return chestProblem;
    }

    public void setChestProblem(double chestProblem) {
        this.chestProblem = chestProblem;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }


    
}
