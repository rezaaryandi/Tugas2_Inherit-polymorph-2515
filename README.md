# Tugas 2 Praktikum PBO: Inheritance, Composition, dan Polimorfisme

| | |
|---|---|
| **Mata kuliah** | Praktikum Pemrograman Berorientasi Objek |
| **Nama** | `Muhammad Reza Aryandi` |
| **NPM** | `250810701100015` (awal dan akhir: 2515) |
| **Kelas** | A |
| **Tugas** | 2 (Praktikum 6: Inheritance, Praktikum 7: Composition dan Polimorfisme) |
| **Repository** | `https://github.com/rezaaryandi/Tugas2_Inherit-polymorph-2515` |

## Deskripsi Singkat

Repository ini berisi penyelesaian empat soal latihan dan satu bagian analisis konsep. Soal 1 melatih
inheritance (protected, `super`, multi level), Soal 2 melatih analisis urutan constructor, polimorfisme, dan
downcasting, Soal 3 melatih composition dan aliasing, dan Soal 4 menggabungkan semuanya dalam program
kecil toko digital. Semua kode ditulis dengan Javadoc, konstanta bernama, dan validasi lewat exception.

## Fitur Utama

**Soal 1: Perangkat elektronik**
- Mencatat laptop, ponsel, dan laptop gaming beserta merek, harga, dan garansi.
- Menampilkan ringkasan satu baris untuk tiap perangkat.
- Menghitung pajak 10 persen dan harga promo laptop setelah diskon.
- Laptop gaming otomatis mendapat garansi tambahan 6 bulan.
- Menolak data tidak valid (merek kosong atau harga negatif) dengan pesan yang jelas.

**Soal 2: Analisis output dan polimorfisme**
- Program peragaan urutan pembuatan objek, pemanggilan method hasil override, dan kegagalan downcasting.
- Versi perbaikan yang aman memakai `instanceof`.
- Peragaan risiko memanggil method overridable dari constructor.
- Peragaan lingkaran dan titik (lingkaran berjari-jari nol).

**Soal 3: Titik dan Garis**
- Membuat garis dari dua titik atau dari empat koordinat.
- Menghitung panjang garis dan menampilkan garis dalam format `(x1, y1) - (x2, y2)`.
- Perubahan pada titik di luar tidak mengubah garis yang sudah dibuat.

**Soal 4: Toko digital**
- Keranjang dapat berisi produk fisik, produk digital, dan langganan.
- Harga akhir dihitung sesuai jenis produk (ongkos kirim, diskon digital, diskon langganan 12 bulan ke atas).
- Mencetak struk lengkap dengan total dan merekap jumlah produk per jenis.
- Menolak produk dengan kode ganda dan menolak data produk yang tidak valid.
- Opsional: bundel produk dengan diskon bundel.

## Konsep OOP yang Diterapkan

| Konsep | Lokasi penerapan | Alasan singkat |
|---|---|---|
| Inheritance (is-a) | `Laptop`, `Ponsel` extends `Perangkat`; `ProdukFisik`, `ProdukDigital` extends `Produk` | Laptop dan ponsel memang perangkat; data dan perilaku umum cukup ditulis sekali |
| Multi level inheritance | `LaptopGaming` → `Laptop` → `Perangkat`; `Langganan` → `ProdukDigital` → `Produk` | Laptop gaming adalah laptop khusus; langganan adalah produk digital khusus |
| Hak akses `protected` | `Perangkat.harga` dipakai di `Laptop.hitungHargaPromo` | Subclass perlu membaca harga langsung, tanpa membukanya sebagai `public` |
| `super(...)` pada constructor | Semua constructor subclass di Soal 1 dan 4 | Bagian superclass harus dibuat dan divalidasi lebih dulu |
| `super.metode()` | `infoSingkat()` di `Laptop`, `Ponsel`, `LaptopGaming` | Menghindari menyalin kode superclass |
| Method overriding | `infoSingkat()`, `hitungHargaAkhir()`, `deskripsi()`, `luas()`, `suara()` | Setiap subclass punya perilaku sendiri untuk kontrak yang sama |
| Method overloading | Dua constructor `Garis`; dua constructor `Titik` | Objek dapat dibuat dari bentuk data yang berbeda |
| Composition (has-a) | `Garis` memiliki dua `Titik`; `Keranjang` memiliki daftar `Produk`; `ProdukBundel` memiliki daftar `Produk` | Hubungan bagian dan keseluruhan, bukan hubungan jenis |
| Polimorfisme | `Keranjang.hitungTotal()` dan `cetakStruk()` | Loop atas `Produk` tanpa perlu tahu jenis konkretnya |
| Upcasting | `Hewan h = new Kucing(...)`, `List<Produk>` berisi subclass | Variabel bertipe umum dapat menampung objek turunan |
| Downcasting aman | `Keranjang.rekapJenis(...)`, `TesSoal2Perbaikan` | `instanceof` mencegah `ClassCastException` |
| Defensive copy | `Garis` (constructor, setter, getter) | Mencegah aliasing yang mengubah isi objek dari luar |
| Exception | `IllegalArgumentException` di constructor; `IllegalStateException` di `Keranjang.tambah` | Data tidak valid ditolak sedini mungkin |
| Konstanta | `TARIF_PAJAK`, `GARANSI_TAMBAHAN_BULAN`, `ONGKOS_KIRIM_PER_KG`, `DISKON_DIGITAL`, `DISKON_LANGGANAN`, `BATAS_DURASI_DISKON_BULAN` | Tidak ada magic number dan mudah diubah dari satu tempat |

## Struktur Project

```
Tugas2_Inherit-polymorph-2515/
├── src/
│   ├── soal1/
│   │   ├── Perangkat.java
│   │   ├── Laptop.java
│   │   ├── Ponsel.java
│   │   ├── LaptopGaming.java
│   │   ├── TesSoal1.java
│   │   └── TesSoal1Validasi.java    (skenario data tidak valid)
│   ├── soal2/
│   │   ├── Hewan.java
│   │   ├── Kucing.java
│   │   ├── A.java
│   │   ├── B.java
│   │   ├── Lingkaran.java
│   │   ├── Titik.java
│   │   ├── TesSoal2.java            (Bagian A, sengaja berakhir dengan ClassCastException)
│   │   ├── TesSoal2Perbaikan.java   (Bagian A versi perbaikan dengan instanceof)
│   │   ├── TesSoal2B.java           (Bagian B)
│   │   └── TesSoal2C.java           (Bagian C)
│   ├── soal3/
│   │   ├── Titik.java
│   │   ├── Garis.java
│   │   └── TesSoal3.java
│   └── soal4/
│       ├── Produk.java
│       ├── ProdukFisik.java
│       ├── ProdukDigital.java
│       ├── Langganan.java
│       ├── ProdukBundel.java        (tantangan opsional)
│       ├── Keranjang.java
│       ├── TesSoal4.java
│       ├── TesSoal4Validasi.java    (skenario exception pada constructor)
│       └── TesSoal4Bundel.java      (peragaan bundel)
├── .gitignore
└── README.md
```

Kelas `Titik` ada di dua package (`soal2` dan `soal3`) dengan tujuan berbeda; keduanya tidak saling bercampur
karena berada di package terpisah.

## Prasyarat

- JDK 17 atau lebih baru (kode diuji dengan OpenJDK 21 dan tidak memakai fitur di atas Java 8).
- IDE yang disarankan: IntelliJ IDEA (Community Edition cukup). Tanpa IDE, cukup JDK dan terminal.

## Cara Menjalankan Program

### Lewat IntelliJ IDEA

1. Pilih **File → Open**, lalu pilih folder root repository.
2. Klik kanan folder `src`, pilih **Mark Directory as → Sources Root**.
3. Atur JDK di **File → Project Structure → Project → SDK** (JDK 17 atau lebih baru).
4. Buka **Run → Edit Configurations → + → Application**, lalu isi:
   - **Name**: nama bebas, misalnya `TesSoal1`
   - **Main class**: nama lengkap dengan package, misalnya `soal1.TesSoal1`
   - **Module / classpath**: modul project ini
5. Klik **Run**. Ulangi untuk kelas uji lain (lihat tabel di bawah).

### Lewat command line

Jalankan dari root repository. Hasil kompilasi masuk ke folder `out` yang diabaikan Git.

```bash
# Linux / macOS / Git Bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out soal1.TesSoal1
```

```powershell
# Windows PowerShell
mkdir out -Force
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out soal1.TesSoal1
```

Kelas yang dapat dijalankan:

| Soal | Perintah (setelah kompilasi) |
|---|---|
| 1 | `java -cp out soal1.TesSoal1` |
| 1 (validasi) | `java -cp out soal1.TesSoal1Validasi` |
| 2 Bagian A | `java -cp out soal2.TesSoal2` (berakhir dengan exception, memang disengaja) |
| 2 Bagian A (perbaikan) | `java -cp out soal2.TesSoal2Perbaikan` |
| 2 Bagian B | `java -cp out soal2.TesSoal2B` |
| 2 Bagian C | `java -cp out soal2.TesSoal2C` |
| 3 | `java -cp out soal3.TesSoal3` |
| 4 | `java -cp out soal4.TesSoal4` |
| 4 (validasi) | `java -cp out soal4.TesSoal4Validasi` |
| 4 (bundel, opsional) | `java -cp out soal4.TesSoal4Bundel` |

## Contoh Output

<!-- Tambahkan screenshot hasil eksekusi di sini bila diperlukan. Teks di bawah adalah output asli program. -->

**Soal 1** (`soal1.TesSoal1`), skenario normal:

```
Asus | garansi 24 bulan | RAM 16 GB | layar 14.0 inci
Samsung | garansi 12 bulan | 128 GB | 3 kamera
MSI | garansi 18 bulan | RAM 32 GB | layar 15.6 inci | GPU RTX 4060
Pajak laptop: Rp800000
Promo laptop 10 persen: Rp7200000
```

`soal1.TesSoal1Validasi`, skenario exception tertangani:

```
Gagal membuat perangkat: Merek tidak boleh kosong
Gagal membuat perangkat: Harga tidak boleh negatif
```

**Soal 2** (`soal2.TesSoal2`, `TesSoal2Perbaikan`, `TesSoal2B`, `TesSoal2C`):

```
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
Exception in thread "main" java.lang.ClassCastException: class soal2.Hewan cannot be cast to class soal2.Kucing (...)
	at soal2.TesSoal2.main(TesSoal2.java:23)
```
```
Hewan dibuat: Generik
Generik bukan Kucing, downcasting dilewati
```
```
A dibuat
init B, nilai=0
B dibuat, nilai=5
```
```
78.53981633974483
0.0
0.0
```

**Soal 3** (`soal3.TesSoal3`, versi dengan defensive copy):

```
(0.0, 0.0) - (3.0, 4.0) panjang=5.0
(1.0, 1.0) - (5.0, 5.0)
```

**Soal 4** (`soal4.TesSoal4`), termasuk exception kode ganda yang tertangani:

```
F01 | Keyboard Mekanik | fisik 1.5 kg | Rp515000
D01 | Ebook Java | digital 20.0 MB | Rp90000
L01 | Kelas Online | langganan 12 bulan | Rp1440000
TOTAL: Rp2045000
Fisik: 1, Digital: 1, Langganan: 1
Gagal: Produk dengan kode F01 sudah ada di keranjang
```

`soal4.TesSoal4Validasi` (exception pada constructor dan batas diskon langganan 12 bulan):

```
Gagal (harga): Harga dasar tidak boleh negatif
Gagal (nama): Nama produk tidak boleh kosong
L02 | Kelas 11 Bulan | langganan 11 bulan | Rp1100000
L03 | Kelas 12 Bulan | langganan 12 bulan | Rp960000
TOTAL: Rp2060000
Fisik: 0, Digital: 0, Langganan: 2
```

`soal4.TesSoal4Bundel` (opsional):

```
B01 | Paket Belajar | bundel 2 produk | Rp1661750
D01 | Ebook Java | digital 20.0 MB | Rp90000
TOTAL: Rp1751750
Fisik: 1, Digital: 1, Langganan: 1
```

## Jawaban Soal dan Analisis Konsep

### Soal 1: Pertanyaan tambahan (harga dijadikan private)

Atribut `harga` di `Perangkat` diubah dari `protected` menjadi `private`, lalu dikompilasi. Pesan error:

```
soal1/Laptop.java:41: error: harga has private access in Perangkat
        return harga - (harga * diskonPersen / PERSEN_PENUH);
               ^
soal1/Laptop.java:41: error: harga has private access in Perangkat
        return harga - (harga * diskonPersen / PERSEN_PENUH);
                        ^
2 errors
```

**Penjelasan.** Anggota `private` hanya dapat diakses di dalam kelas tempat ia dideklarasikan. Subclass
memang mewarisi objek yang berisi atribut itu, tetapi tidak boleh menyebut namanya secara langsung. Karena
`hitungHargaPromo` ada di `Laptop`, bukan di `Perangkat`, kompilator menolaknya. Dua pilihan perbaikan:
mengembalikan ke `protected` (subclass akses langsung, tetapi enkapsulasi sedikit longgar), atau tetap `private`
dan menyediakan getter `getHarga()`, yang umumnya lebih aman karena semua akses lewat satu pintu.

### Soal 2

**Prediksi (ditulis sebelum menjalankan) dan hasil sebenarnya.**

**Bagian A, nomor 1: output lengkap.**

```
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
Exception in thread "main" java.lang.ClassCastException: class soal2.Hewan cannot be cast to class soal2.Kucing
	at soal2.TesSoal2.main(TesSoal2.java:23)
```

Prediksi sama dengan hasil sebenarnya. Constructor `Hewan` berjalan lebih dulu, lalu `Kucing`. `h.makan()`
mencetak "Tom makan" lalu memanggil `suara()` yang menghasilkan "meong". `h.suara()` juga "meong". Pada `new Hewan("Generik")`
hanya constructor `Hewan` yang berjalan, lalu program berhenti saat downcast gagal.

**Nomor 2: `h.panjat();` dihapus komentarnya.** Terjadi **error kompilasi**, bukan runtime:

```
error: cannot find symbol
        h.panjat();
         ^
  symbol:   method panjat()
  location: variable h of type Hewan
```

Kompilator hanya melihat **tipe statis** variabel, yaitu `Hewan`, dan kelas `Hewan` tidak punya method
`panjat()`. Fakta bahwa objek aslinya `Kucing` tidak dipertimbangkan saat kompilasi.

**Nomor 3: sumber `ClassCastException`.** Baris `Kucing k2 = (Kucing) h2;` (baris 23 di `TesSoal2.java`). Objek yang ditunjuk
`h2` dibuat dengan `new Hewan(...)`, jadi tipe dinamisnya `Hewan`, bukan `Kucing`. Setiap `Kucing` adalah `Hewan`,
tetapi tidak setiap `Hewan` adalah `Kucing`. Kompilator mengizinkan cast ini karena `Kucing` memang turunan
`Hewan` (mungkin valid), tetapi JVM memeriksanya saat runtime dan menolaknya. Perbaikan tanpa mengubah tipe `h2`
(ada di `TesSoal2Perbaikan.java`):

```java
Hewan h2 = new Hewan("Generik");
if (h2 instanceof Kucing) {
    Kucing k2 = (Kucing) h2;
    k2.panjat();
} else {
    System.out.println(h2.nama + " bukan Kucing, downcasting dilewati");
}
```

**Nomor 4: `suara()` milik kelas mana pada `h.makan()`?** Milik `Kucing`. Variabel `h` bertipe statis `Hewan`, tetapi
objeknya bertipe dinamis `Kucing`. Method `makan()` hanya ditulis di `Hewan`, sehingga kode `makan()` itulah yang
dijalankan. Di dalamnya ada pemanggilan `suara()` pada objek yang sedang berjalan (`this`). Method instance dipilih
berdasarkan tipe dinamis saat runtime (dynamic dispatch), jadi yang jalan adalah `Kucing.suara()`. Tipe statis menentukan method
apa yang boleh dipanggil, sedangkan tipe dinamis menentukan versi mana yang benar-benar dijalankan.

**Bagian B, nomor 5: `new B();`.**

Prediksi dan hasil sebenarnya:

```
A dibuat
init B, nilai=0
B dibuat, nilai=5
```

Urutannya: objek `B` dialokasikan dan semua atribut diberi nilai bawaan (`nilai = 0`). Constructor `B` langsung memanggil
`super()`, sehingga constructor `A` berjalan. Di dalamnya `init()` dipanggil dan, karena tipe dinamis objek adalah `B`,
yang jalan adalah `B.init()`. Pada saat itu inisialisasi `int nilai = 5` **belum dieksekusi**, karena
inisialisasi atribut subclass baru berjalan setelah `super()` selesai. Karena itu nilainya masih 0, dan baru menjadi 5
pada baris "B dibuat". **Risikonya:** method yang di-override berjalan pada objek yang belum selesai dibuat, sehingga
atribut subclass masih berisi nilai bawaan (0, `null`, `false`). Hal ini dapat menimbulkan hasil yang salah atau
`NullPointerException`, dan sulit dilacak. Solusinya: dari constructor hanya panggil method `private`, `final`, atau `static`,
atau pindahkan inisialisasi ke method terpisah yang dipanggil setelah objek selesai dibuat.

**Bagian C, nomor 6: `Lingkaran` dan `Titik`.**

- `l3.luas()` menghasilkan `0.0` karena tipe dinamis `l3` adalah `Titik`. Walaupun tipe statisnya `Lingkaran`,
  dynamic dispatch memilih `Titik.luas()` yang di-override.
- Secara bahasa, "Titik adalah sebuah Lingkaran" hanya masuk akal secara kebetulan matematis (jari-jari 0).
  Sebagai relasi is-a dalam desain, ini lemah: lingkaran memiliki luas dan keliling positif, sedangkan titik tidak, sehingga
  subclass melanggar perilaku yang dijanjikan superclass (Liskov Substitution Principle).
- Konsekuensinya, method yang mengharapkan `Lingkaran` dengan luas lebih dari nol dapat rusak ketika diberi `Titik`,
  misalnya pembagian dengan luas (hasil tak terhingga atau `NaN`) atau logika yang mengasumsikan luas positif.
  Sebaiknya `Titik` tidak mewarisi `Lingkaran`.

### Soal 3

**Nomor 1: prediksi dan hasil sebelum perbaikan.** Baris kedua tercetak:

```
(100.0, 1.0) - (5.0, 5.0)
```

Constructor awal hanya menyimpan referensi (`this.awal = awal`). Variabel `t` di luar dan atribut `awal` di dalam `g2` menunjuk
**objek `Titik` yang sama** (aliasing). `t.setX(100)` mengubah objek itu, sehingga garis ikut berubah.

**Nomor 2: defensive copy.** Constructor, setter, dan getter `Garis` sekarang membuat salinan `Titik`
lewat method private `salin(...)`:

```java
public Garis(Titik awal, Titik akhir) {
    this.awal = salin(awal);
    this.akhir = salin(akhir);
}

private static Titik salin(Titik titik) {
    if (titik == null) {
        throw new IllegalArgumentException("Titik tidak boleh null");
    }
    return new Titik(titik.getX(), titik.getY());
}
```

Setelah diperbaiki, baris kedua tercetak `(1.0, 1.0) - (5.0, 5.0)`, karena `t.setX(100)` hanya mengubah objek milik
pemanggil, bukan salinan milik `Garis`.

**Nomor 3: kapan masing-masing lebih tepat.**
- *Sebelum perbaikan (berbagi referensi)* lebih tepat bila memang diinginkan satu objek yang dipakai bersama dan
  perubahan harus terlihat di mana-mana, misalnya garis yang menghubungkan dua kota dan harus ikut bergerak saat
  titik kota diperbarui (relasi aggregation), atau bila objek sangat besar sehingga penyalinan mahal.
- *Sesudah perbaikan (defensive copy)* lebih tepat bila `Garis` harus memiliki titiknya sendiri dan menjaga
  konsistensinya: nilai tidak boleh berubah diam-diam dari luar, dan invarian objek terlindungi (enkapsulasi). Ini
  pilihan yang aman untuk kelas bergaya nilai (value object) dan kode yang dipakai banyak pihak.

**Nomor 4: seandainya `Garis extends Titik`.**
- Relasi is-a tidak masuk akal: garis bukan sebuah titik. Garis *memiliki* dua titik (has-a).
- `Garis` akan mewarisi `x`, `y`, `setX`, `setY`, dan `jarakKe` yang tidak bermakna bagi garis. Garis butuh dua titik,
  sementara pewarisan hanya memberi satu pasang koordinat, sehingga titik kedua tetap harus ditambahkan sendiri.
- Objek `Garis` dapat dilewatkan ke method yang meminta `Titik`, dan hasilnya tidak masuk akal (melanggar substitusi Liskov).
- Antarmuka `Garis` ikut terkotori anggota milik `Titik`, dan perubahan pada `Titik` akan berdampak ke `Garis` (kopling kuat).

### Analisis Konsep

**1. Perbedaan method overriding dan method overloading.**
*Overriding* terjadi ketika subclass menulis ulang method superclass dengan tanda tangan yang sama, misalnya
`Laptop.infoSingkat()` yang menggantikan `Perangkat.infoSingkat()`. Method mana yang berjalan ditentukan saat runtime
berdasarkan tipe dinamis objek, sehingga overriding membutuhkan inheritance dan menjadi dasar polimorfisme. *Overloading*
adalah beberapa method (atau constructor) dengan nama sama tetapi daftar parameter berbeda dalam satu kelas, misalnya dua
constructor `Garis(Titik, Titik)` dan `Garis(double, double, double, double)`. Pemilihannya dilakukan kompilator berdasarkan
tipe argumen, tidak membutuhkan inheritance, dan bukan polimorfisme runtime.

**2. Kapan memilih inheritance dan kapan memilih composition.**
Inheritance dipilih ketika hubungannya benar-benar *is-a* dan subclass dapat menggantikan superclass tanpa merusak
perilaku, misalnya `Laptop` adalah sebuah `Perangkat`, sehingga data garansi dan pajak cukup ditulis sekali di superclass.
Composition dipilih ketika hubungannya *has-a* atau bagian-keseluruhan, misalnya `Garis` memiliki dua `Titik` dan
`Keranjang` memiliki daftar `Produk`. Composition lebih fleksibel dan kopling lebih longgar, sedangkan inheritance mengikat
subclass pada detail superclass. Kalau ragu, pilih composition, seperti terlihat pada contoh `Garis extends Titik` dan
`Titik extends Lingkaran` yang bermasalah.

**3. Mengapa `cetakStruk()` tidak butuh `instanceof` sedangkan `hitungPerJenis()` butuh, dan mengapa downcasting tidak selalu aman.**
`cetakStruk()` hanya memanggil `hitungHargaAkhir()` dan `deskripsi()`, yang sudah dimiliki semua `Produk`, dan setiap objek menjalankan versi miliknya lewat dynamic dispatch, sehingga perulangan tidak perlu tahu jenis konkretnya. `hitungPerJenis()` justru perlu tahu jenis konkret, informasi yang tidak diekspos oleh method `Produk`, sehingga harus bertanya lewat `instanceof`. Urutan pengecekan penting: `Langganan` diperiksa sebelum `ProdukDigital` karena `Langganan` juga `ProdukDigital`; bila dibalik, langganan akan terhitung sebagai digital. Downcasting tidak selalu aman karena kompilator hanya memeriksa bahwa kedua tipe berkerabat, bukan bahwa objek aslinya cocok. Bila tipe dinamisnya bukan tipe tujuan, terjadi `ClassCastException` saat runtime (seperti `Hewan` ke `Kucing` di Soal 2), sehingga cast perlu dijaga dengan `instanceof`.

## Batasan dan Pengembangan Lanjutan

- Screenshot eksekusi belum disertakan; output yang dilampirkan berupa teks asli dari program.
- Tarif (pajak, ongkos kirim, diskon) berupa konstanta di kode. Bila ingin diubah tanpa kompilasi ulang, dapat dipindah ke
  berkas konfigurasi.
- Program belum memiliki unit test otomatis (misalnya JUnit); pengujian masih lewat kelas `TesSoalN`.
- `ProdukBundel` belum mencegah bundel di dalam bundel yang saling merujuk, dan belum ada fitur menghapus produk dari keranjang.
- Nilai uang memakai `double` agar sesuai soal; untuk aplikasi sungguhan lebih tepat memakai `BigDecimal`.
- `Perangkat.harga` bersifat `protected` sesuai soal; alternatif yang lebih menjaga enkapsulasi adalah `private` dengan getter.
- Project belum memakai Maven atau Gradle; kompilasi lewat `javac` atau IntelliJ.
