package soal2;

/**
 * Titik sebagai lingkaran berjari-jari nol. Dipakai untuk membahas
 * mengapa relasi is-a di sini bermasalah.
 */
public class Titik extends Lingkaran {

    private static final double JARI_JARI_NOL = 0.0;
    private static final double UKURAN_NOL = 0.0;

    /**
     * Membuat titik (lingkaran berjari-jari nol).
     */
    public Titik() {
        super(JARI_JARI_NOL);
    }

    /**
     * Mengembalikan luas titik, yaitu nol.
     *
     * @return 0.0
     */
    @Override
    public double luas() {
        return UKURAN_NOL;
    }

    /**
     * Mengembalikan keliling titik, yaitu nol.
     *
     * @return 0.0
     */
    @Override
    public double keliling() {
        return UKURAN_NOL;
    }
}
