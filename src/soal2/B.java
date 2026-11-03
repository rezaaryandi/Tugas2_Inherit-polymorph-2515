package soal2;

/**
 * Subclass A yang meng-override init() dan memakai atribut miliknya.
 */
public class B extends A {

    int nilai = 5;

    /**
     * Membuat objek B. Constructor A dijalankan lebih dulu,
     * sebelum inisialisasi atribut B.
     */
    B() {
        super();
        System.out.println("B dibuat, nilai=" + nilai);
    }

    /**
     * Mencetak pesan inisialisasi milik B beserta nilai atribut.
     */
    @Override
    void init() {
        System.out.println("init B, nilai=" + nilai);
    }
}
