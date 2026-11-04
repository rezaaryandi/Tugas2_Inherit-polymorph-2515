package soal3;

/**
 * Merepresentasikan garis lurus yang disusun dari dua objek {@link Titik}
 * (composition, relasi has-a). Garis menyimpan salinan titik sehingga
 * perubahan objek di luar tidak memengaruhi isinya (defensive copy).
 */
public class Garis {

    private Titik awal;
    private Titik akhir;

    /**
     * Membuat garis dari dua titik. Kedua titik disalin.
     *
     * @param awal  titik awal, tidak boleh null
     * @param akhir titik akhir, tidak boleh null
     * @throws IllegalArgumentException jika salah satu titik null
     */
    public Garis(Titik awal, Titik akhir) {
        this.awal = salin(awal);
        this.akhir = salin(akhir);
    }

    /**
     * Membuat garis dari koordinat dua titik. Memanfaatkan constructor utama.
     *
     * @param x1 koordinat x titik awal
     * @param y1 koordinat y titik awal
     * @param x2 koordinat x titik akhir
     * @param y2 koordinat y titik akhir
     */
    public Garis(double x1, double y1, double x2, double y2) {
        this(new Titik(x1, y1), new Titik(x2, y2));
    }

    /**
     * Mengambil salinan titik awal.
     *
     * @return salinan titik awal
     */
    public Titik getAwal() {
        return salin(awal);
    }

    /**
     * Mengganti titik awal dengan salinan titik yang diberikan.
     *
     * @param awal titik awal baru, tidak boleh null
     * @throws IllegalArgumentException jika titik null
     */
    public void setAwal(Titik awal) {
        this.awal = salin(awal);
    }

    /**
     * Mengambil salinan titik akhir.
     *
     * @return salinan titik akhir
     */
    public Titik getAkhir() {
        return salin(akhir);
    }

    /**
     * Mengganti titik akhir dengan salinan titik yang diberikan.
     *
     * @param akhir titik akhir baru, tidak boleh null
     * @throws IllegalArgumentException jika titik null
     */
    public void setAkhir(Titik akhir) {
        this.akhir = salin(akhir);
    }

    /**
     * Menghitung panjang garis dengan memanfaatkan {@link Titik#jarakKe(Titik)}.
     *
     * @return panjang garis
     */
    public double getPanjang() {
        return awal.jarakKe(akhir);
    }

    /**
     * Menyusun representasi teks garis.
     *
     * @return teks berformat (x1, y1) - (x2, y2)
     */
    @Override
    public String toString() {
        return awal + " - " + akhir;
    }

    private static Titik salin(Titik titik) {
        if (titik == null) {
            throw new IllegalArgumentException("Titik tidak boleh null");
        }
        return new Titik(titik.getX(), titik.getY());
    }
}
