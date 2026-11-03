package soal2;

/**
 * Superclass yang memanggil method overridable dari constructor-nya.
 */
public class A {

    /**
     * Membuat objek A dan memanggil {@link #init()}.
     * Pemanggilan ini berisiko karena init() dapat di-override subclass.
     */
    A() {
        System.out.println("A dibuat");
        init();
    }

    /**
     * Mencetak pesan inisialisasi milik A.
     */
    void init() {
        System.out.println("init A");
    }
}
