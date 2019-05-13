/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.Sysptoms_diagnosesDAO;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Min_MaxRule {

    public static final String D[] = {"sốt virut", "sốt rét", "thương hàn", "bệnh dạ dày", "bệnh tim"};

    public Min_MaxRule() {
    }

    public static double FindMax(ArrayList A) {
        double max = (double) A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if ((double) A.get(i) > max) {
                max = (double) A.get(i);
            }
        }
        return max;
    }

    public static double FindMin(ArrayList A) {
        double min = (double) A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if ((double) A.get(i) < min) {
                min = (double) A.get(i);
            }
        }
        return min;
    }

    public ArrayList<PictureFuzzySet> QuanHe_BenhNhan_Benh1(ArrayList<PictureFuzzySet> A, ArrayList<PictureFuzzySet[]> B) {
        ArrayList<PictureFuzzySet> C = new ArrayList<>();
        for (int j = 0; j < D.length; j++) {
            ArrayList<Double> arrList_x = new ArrayList<>();
            ArrayList<Double> arrList_y = new ArrayList<>();
            ArrayList<Double> arrList_z = new ArrayList<>();
            for (int k = 0; k < D.length; k++) {
                double min_x = Math.min(A.get(k).getX(), B.get(k)[j].getX());
                arrList_x.add(min_x);
                double min_y = Math.min(A.get(k).getY(), B.get(k)[j].getY());
                arrList_y.add(min_y);
                double max_z = Math.max(A.get(k).getZ(), B.get(k)[j].getZ());
                arrList_z.add(max_z);
            }
            PictureFuzzySet newSet = new PictureFuzzySet(FindMax(arrList_x), FindMin(arrList_y), FindMin(arrList_z));
            C.add(j, newSet);
        }
        return C;
    }

    public ArrayList<Double> TinhGiaTriRo(ArrayList<PictureFuzzySet> C) {
        ArrayList<Double> X = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            double pi = 1 - (C.get(j).getX() + C.get(j).getY() + C.get(j).getZ());
            double xs = C.get(j).getX() - C.get(j).getZ() * pi;
            X.add(j, xs);
        }
        return X;
    }
    
}
