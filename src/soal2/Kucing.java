package soal2;

/**
 * Hewan berjenis kucing yang bersuara "meong" dan dapat memanjat.
 */
public class Kucing extends Hewan {

    /**
     * Membuat kucing dan mencetak pesan pembuatan.
     *
     * @param nama nama kucing
     */
    Kucing(String nama) {
        super(nama);
        System.out.println("Kucing dibuat");
    }

    /**
     * Mencetak suara kucing.
     */
    @Override
    void suara() {
        System.out.println("meong");
    }

    /**
     * Mencetak aktivitas memanjat, hanya dimiliki oleh kucing.
     */
    void panjat() {
        System.out.println(nama + " memanjat");
    }
}
