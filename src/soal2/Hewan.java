package soal2;

/**
 * Superclass hewan yang menjadi contoh urutan constructor dan polimorfisme.
 */
public class Hewan {

    /** Nama hewan; protected agar dapat dipakai subclass. */
    protected String nama;

    /**
     * Membuat hewan dan mencetak pesan pembuatan.
     *
     * @param nama nama hewan
     */
    Hewan(String nama) {
        this.nama = nama;
        System.out.println("Hewan dibuat: " + nama);
    }

    /**
     * Mencetak suara default hewan. Subclass dapat meng-override method ini.
     */
    void suara() {
        System.out.println("...");
    }

    /**
     * Mencetak aktivitas makan lalu memanggil {@link #suara()}.
     * Method suara() yang dijalankan ditentukan oleh tipe dinamis objek.
     */
    void makan() {
        System.out.println(nama + " makan");
        suara();
    }
}
