package soal2;

/**
 * Program uji Soal 2. Tanpa argumen, program menjalankan Bagian A persis
 * seperti soal (berakhir dengan ClassCastException). Argumen "B" atau "C"
 * menjalankan Bagian B atau Bagian C.
 */
public class TesSoal2 {

    private static final String BAGIAN_B = "B";
    private static final String BAGIAN_C = "C";

    /**
     * Titik masuk program.
     *
     * @param args kosong untuk Bagian A, "B" untuk Bagian B, "C" untuk Bagian C
     */
    public static void main(String[] args) {
        if (args.length > 0 && BAGIAN_B.equals(args[0])) {
            jalankanBagianB();
        } else if (args.length > 0 && BAGIAN_C.equals(args[0])) {
            jalankanBagianC();
        } else {
            jalankanBagianA();
        }
    }

    /**
     * Bagian A: upcasting, downcasting, dan ClassCastException.
     */
    private static void jalankanBagianA() {
        Hewan h = new Kucing("Tom");
        h.makan();
        h.suara();
        // h.panjat();
        Kucing k = (Kucing) h;
        k.panjat();

        Hewan h2 = new Hewan("Generik");
        Kucing k2 = (Kucing) h2;
        k2.panjat();
    }

    /**
     * Bagian B: method overridable dipanggil dari constructor.
     */
    private static void jalankanBagianB() {
        new B();
    }

    /**
     * Bagian C: polimorfisme pada Lingkaran dan Titik.
     */
    private static void jalankanBagianC() {
        Lingkaran l1 = new Lingkaran(5);
        Titik l2 = new Titik();
        Lingkaran l3 = new Titik();
        System.out.println(l1.luas());
        System.out.println(l2.luas());
        System.out.println(l3.luas());
    }
}
