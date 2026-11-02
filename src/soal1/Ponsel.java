package soal1;

/**
 * Perangkat berjenis ponsel dengan data kapasitas penyimpanan dan jumlah kamera.
 */
public class Ponsel extends Perangkat {

    private final int kapasitasGb;
    private final int jumlahKamera;

    /**
     * Membuat ponsel baru.
     *
     * @param merek        merek ponsel
     * @param harga        harga ponsel
     * @param garansiBulan lama garansi dalam bulan
     * @param kapasitasGb  kapasitas penyimpanan dalam GB
     * @param jumlahKamera jumlah kamera
     * @throws IllegalArgumentException jika data dasar perangkat tidak valid
     */
    public Ponsel(String merek, double harga, int garansiBulan, int kapasitasGb, int jumlahKamera) {
        super(merek, harga, garansiBulan);
        this.kapasitasGb = kapasitasGb;
        this.jumlahKamera = jumlahKamera;
    }

    /**
     * Menyusun ringkasan ponsel: data perangkat ditambah kapasitas dan kamera.
     *
     * @return teks ringkasan satu baris
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | " + kapasitasGb + " GB | " + jumlahKamera + " kamera";
    }
}
