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

    public static final String D[] = {"fever", "malaria", "typhoid", "stomach", "chest_problem"};

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

    public ArrayList<PictureFuzzySet> QuanHe_BenhNhan_Benh1(ArrayList<PictureFuzzySet> S, ArrayList<PictureFuzzySet[]> R) {
        ArrayList<PictureFuzzySet> T = new ArrayList<>();
        for (int j = 0; j < D.length; j++) {
            ArrayList<Double> arrList_x = new ArrayList<>();
            ArrayList<Double> arrList_y = new ArrayList<>();
            ArrayList<Double> arrList_z = new ArrayList<>();
            for (int k = 0; k < D.length; k++) {
                double min_x = Math.min(S.get(k).getX(), R.get(k)[j].getX());
                arrList_x.add(min_x);
                double min_y = Math.min(S.get(k).getY(), R.get(k)[j].getY());
                arrList_y.add(min_y);
                double max_z = Math.max(S.get(k).getZ(), R.get(k)[j].getZ());
                arrList_z.add(max_z);
            }
            PictureFuzzySet newSet = new PictureFuzzySet(FindMax(arrList_x), FindMin(arrList_y), FindMin(arrList_z));
            T.add(j, newSet);
        }
        return T;
    }

    public ArrayList<Double> TinhGiaTriRo(ArrayList<PictureFuzzySet> T) {
        ArrayList<Double> X = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            double pi = 1 - (T.get(j).getX() + T.get(j).getY() + T.get(j).getZ());
            double xs = T.get(j).getX() - T.get(j).getZ() * pi;
            X.add(j, xs);
        }
        return X;
    }
    
}
