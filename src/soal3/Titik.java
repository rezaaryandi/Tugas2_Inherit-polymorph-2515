package soal3;

/**
 * Merepresentasikan titik pada bidang dua dimensi.
 */
public class Titik {

    private double x;
    private double y;

    /**
     * Membuat titik di pusat koordinat (0, 0).
     */
    public Titik() {
        this(0, 0);
    }

    /**
     * Membuat titik pada koordinat tertentu.
     *
     * @param x koordinat x
     * @param y koordinat y
     */
    public Titik(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Mengambil koordinat x.
     *
     * @return koordinat x
     */
    public double getX() {
        return x;
    }

    /**
     * Mengubah koordinat x.
     *
     * @param x koordinat x baru
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Mengambil koordinat y.
     *
     * @return koordinat y
     */
    public double getY() {
        return y;
    }

    /**
     * Mengubah koordinat y.
     *
     * @param y koordinat y baru
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Menghitung jarak Euclidean ke titik lain.
     *
     * @param lain titik tujuan
     * @return jarak antara titik ini dan titik lain
     */
    public double jarakKe(Titik lain) {
        double selisihX = lain.x - this.x;
        double selisihY = lain.y - this.y;
        return Math.sqrt(selisihX * selisihX + selisihY * selisihY);
    }

    /**
     * Menyusun representasi teks titik.
     *
     * @return teks berformat (x, y)
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
