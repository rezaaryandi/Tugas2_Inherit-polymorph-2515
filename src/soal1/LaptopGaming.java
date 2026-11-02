package soal1;

/**
 * Laptop untuk gaming yang memiliki kartu grafis dan garansi tambahan.
 */
public class LaptopGaming extends Laptop {

    private static final int GARANSI_TAMBAHAN_BULAN = 6;

    private final String kartuGrafis;

    /**
     * Membuat laptop gaming baru. Garansi otomatis ditambah enam bulan.
     *
     * @param merek           merek laptop
     * @param harga           harga laptop
     * @param garansiBulan    garansi dasar dalam bulan (sebelum tambahan)
     * @param ramGb           kapasitas RAM dalam GB
     * @param ukuranLayarInci ukuran layar dalam inci
     * @param kartuGrafis     nama kartu grafis
     * @throws IllegalArgumentException jika data dasar perangkat tidak valid
     */
    public LaptopGaming(String merek, double harga, int garansiBulan, int ramGb,
                        double ukuranLayarInci, String kartuGrafis) {
        super(merek, harga, garansiBulan + GARANSI_TAMBAHAN_BULAN, ramGb, ukuranLayarInci);
        this.kartuGrafis = kartuGrafis;
    }

    /**
     * Menyusun ringkasan laptop gaming: data laptop ditambah kartu grafis.
     *
     * @return teks ringkasan satu baris
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | GPU " + kartuGrafis;
    }
}
