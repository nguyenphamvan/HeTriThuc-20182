/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author nguyen
 */
public class DiagnosticRule {
    
//    public static final String D[] = {"sốt virut", "sốt rét", "thương hàn", "bệnh dạ dày", "bệnh tim"};
    public static final String D[] = {"fever", "malaria", "typhoid", "stomach", "chest_problem"};
    
    public ArrayList<String> ChuanDoanBenh(ArrayList<Double> X) {
        ArrayList<String> chiTietBenh = new ArrayList<>();
        for (int i = 0; i < D.length; i++) {
            if (X.get(i) >= 0.5) {
            	NumberFormat numEN = NumberFormat.getPercentInstance();
            	String percent = numEN.format(X.get(i));
            	String benh = D[i];
                chiTietBenh.add(benh);
            }
        }
        return chiTietBenh;
    }
    
    
    
}
