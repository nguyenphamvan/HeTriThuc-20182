package Controller;

import java.util.HashMap;

public class Hedge_algebra {

    public HashMap<String, Double> hashMap1 = new HashMap<String, Double>();
    public HashMap<String, Double> hashMap2 = new HashMap<String, Double>();

    public Hedge_algebra() {
        hashMap1.put("Không", 0.0);
        hashMap1.put("Rất thấp", 0.125);
        hashMap1.put("Thấp", 0.25);
        hashMap1.put("Hơi thấp", 0.375);
        hashMap1.put("Trung bình", 0.5);
        hashMap1.put("Hơi cao", 0.625);
        hashMap1.put("Cao", 0.75);
        hashMap1.put("Rất cao", 0.875);
        hashMap1.put("Hoàn toàn", 1.0);

    }

    public HashMap<String, Double> getHashMap() {
        return hashMap1;
    }


    public double getValue(String input) {
        for (String key : hashMap1.keySet()) {
            if (input.equals(key)) {
                return hashMap1.get(key);
            }
        }
        return 0.0;
    }

}
