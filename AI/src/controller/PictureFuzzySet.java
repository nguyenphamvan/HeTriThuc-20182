package Controller;

public class PictureFuzzySet {

    private double x;//do tich cuc
    private double y;//do trung lap
    private double z;//do phu dinh

    public PictureFuzzySet() {
    }

    public PictureFuzzySet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }


    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }

}
