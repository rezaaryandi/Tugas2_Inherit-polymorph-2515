# Tugas 2 Praktikum PBO: Inheritance, Composition, dan Polimorfisme

| | |
|---|---|
| **Mata kuliah** | Praktikum Pemrograman Berorientasi Objek |
| **Nama** | Muhammad Reza Aryandi |
| **NPM** | `250810701100015` (awal dan akhir: 2515) |
| **Kelas** | A |
| **Tugas** | 2 (Praktikum 6: Inheritance, Praktikum 7: Composition dan Polimorfisme) |
| **Repository** | https://github.com/rezaaryandi/Tugas2_Inherit-polymorph-2515 |

## Deskripsi Singkat

Repository ini berisi penyelesaian empat soal latihan dan satu bagian analisis konsep. Soal 1 melatih inheritance (`protected`, `super`, multi level), Soal 2 melatih analisis urutan constructor, polimorfisme, dan downcasting, Soal 3 melatih composition dan aliasing, dan Soal 4 menggabungkan semuanya dalam program kecil toko digital. Semua kode dilengkapi Javadoc, konstanta bernama, dan validasi lewat exception.

## Fitur Utama

**Soal 1: Perangkat elektronik**
- Mencatat laptop, ponsel, dan laptop gaming beserta merek, harga, dan garansi.
- Menampilkan ringkasan satu baris untuk tiap perangkat.
- Menghitung pajak 10 persen dan harga promo laptop setelah diskon.
- Laptop gaming otomatis mendapat garansi tambahan 6 bulan.
- Menolak merek kosong dan harga negatif dengan pesan yang jelas.

**Soal 2: Analisis output dan polimorfisme**
- Peragaan urutan pembuatan objek, pemanggilan method hasil override, dan kegagalan downcasting (Bagian A).
- Peragaan risiko memanggil method overridable dari constructor (Bagian B).
- Peragaan lingkaran dan titik sebagai lingkaran berjari-jari nol (Bagian C).

**Soal 3: Titik dan Garis**
- Membuat garis dari dua titik atau dari empat koordinat.
- Menghitung panjang garis dan menampilkan garis dalam format `(x1, y1) - (x2, y2)`.
- Perubahan pada titik di luar tidak mengubah garis yang sudah dibuat.

**Soal 4: Toko digital**
- Keranjang dapat berisi produk fisik, produk digital, dan langganan.
- Harga akhir dihitung sesuai jenis produk (ongkos kirim, diskon digital, diskon langganan untuk durasi 12 bulan ke atas).
- Mencetak struk lengkap dengan total dan merekap jumlah produk per jenis.
- Menolak produk dengan kode ganda, serta nama kosong dan harga dasar negatif.

## Konsep OOP yang Diterapkan

| Konsep | Lokasi penerapan | Alasan singkat |
|---|---|---|
| Inheritance (is-a) | `Laptop`, `Ponsel` extends `Perangkat`; `ProdukFisik`, `ProdukDigital` extends `Produk` | Laptop dan ponsel memang perangkat; data dan perilaku umum cukup ditulis sekali |
| Multi level inheritance | `LaptopGaming` → `Laptop` → `Perangkat`; `Langganan` → `ProdukDigital` → `Produk` | Laptop gaming adalah laptop khusus; langganan adalah produk digital khusus |
| Hak akses `protected` | `Perangkat.harga` dipakai di `Laptop.hitungHargaPromo` | Subclass perlu membaca harga langsung tanpa membukanya sebagai `public` |
| `super(...)` pada constructor | Semua constructor subclass di Soal 1 dan 4 | Bagian superclass harus dibuat dan divalidasi lebih dulu |
| `super.metode()` | `infoSingkat()` di `Laptop`, `Ponsel`, `LaptopGaming` | Menghindari menyalin kode superclass |
| Method overriding | `infoSingkat()`, `hitungHargaAkhir()`, `deskripsi()`, `luas()`, `suara()` | Setiap subclass punya perilaku sendiri untuk kontrak yang sama |
| Method overloading | Dua constructor `Garis`; dua constructor `Titik` | Objek dapat dibuat dari bentuk data yang berbeda |
| Composition (has-a) | `Garis` memiliki dua `Titik`; `Keranjang` memiliki daftar `Produk` | Hubungan bagian dan keseluruhan, bukan hubungan jenis |
| Polimorfisme | `Keranjang.hitungTotal()` dan `cetakStruk()` | Loop atas `Produk` tanpa perlu tahu jenis konkretnya |
| Upcasting | `Hewan h = new Kucing(...)`, `List<Produk>` berisi subclass | Variabel bertipe umum dapat menampung objek turunan |
| Downcasting aman | `Keranjang.kelompokkanPerJenis()` | `instanceof` mencegah `ClassCastException` |
| Defensive copy | Constructor, setter, dan getter `Garis` | Mencegah aliasing yang mengubah isi objek dari luar |
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
│   │   └── TesSoal1.java
│   ├── soal2/
│   │   ├── Hewan.java
│   │   ├── Kucing.java
│   │   ├── A.java
│   │   ├── B.java
│   │   ├── Lingkaran.java
│   │   ├── Titik.java
│   │   └── TesSoal2.java
│   ├── soal3/
│   │   ├── Titik.java
│   │   ├── Garis.java
│   │   └── TesSoal3.java
│   └── soal4/
│       ├── Produk.java
│       ├── ProdukFisik.java
│       ├── ProdukDigital.java
│       ├── Langganan.java
│       ├── Keranjang.java
│       └── TesSoal4.java
├── .gitignore
└── README.md
```

`Titik` ada di dua package (`soal2` dan `soal3`) dengan tujuan berbeda; keduanya tidak bercampur karena berada di package terpisah.

## Prasyarat

- JDK 17 atau lebih baru (kode diuji dengan OpenJDK 21).
- IDE yang disarankan: IntelliJ IDEA (Community Edition cukup). Tanpa IDE, cukup JDK dan terminal.

## Cara Menjalankan Program

### Lewat IntelliJ IDEA

1. Pilih **File → Open**, lalu pilih folder root repository.
2. Klik kanan folder `src`, pilih **Mark Directory as → Sources Root**.
3. Atur JDK di **File → Project Structure → Project → SDK** (JDK 17 atau lebih baru).
4. Buka **Run → Edit Configurations → + → Application**, lalu isi:
   - **Name**: nama bebas, misalnya `TesSoal1`
   - **Main class**: nama lengkap dengan package, misalnya `soal1.TesSoal1`
   - **Program arguments**: kosongkan, kecuali untuk Soal 2 Bagian B (`B`) atau Bagian C (`C`)
5. Klik **Run**. Ulangi untuk kelas uji lain.

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

| Soal | Perintah (setelah kompilasi) |
|---|---|
| 1 | `java -cp out soal1.TesSoal1` |
| 2 Bagian A | `java -cp out soal2.TesSoal2` (berakhir dengan exception, memang diminta soal) |
| 2 Bagian B | `java -cp out soal2.TesSoal2 B` |
| 2 Bagian C | `java -cp out soal2.TesSoal2 C` |
| 3 | `java -cp out soal3.TesSoal3` |
| 4 | `java -cp out soal4.TesSoal4` |

## Contoh Output

<!-- Tambahkan screenshot hasil eksekusi di sini. Teks di bawah adalah output asli program. -->

**Soal 1** (`soal1.TesSoal1`):

```
Asus | garansi 24 bulan | RAM 16 GB | layar 14.0 inci
Samsung | garansi 12 bulan | 128 GB | 3 kamera
MSI | garansi 18 bulan | RAM 32 GB | layar 15.6 inci | GPU RTX 4060
Pajak laptop: Rp800000
Promo laptop 10 persen: Rp7200000
```

**Soal 2 Bagian A** (`soal2.TesSoal2`), skenario exception:

```
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
Exception in thread "main" java.lang.ClassCastException: class soal2.Hewan cannot be cast to class soal2.Kucing (...)
	at soal2.TesSoal2.jalankanBagianA(TesSoal2.java:40)
	at soal2.TesSoal2.main(TesSoal2.java:24)
```

**Soal 2 Bagian B** (`soal2.TesSoal2 B`):

```
A dibuat
init B, nilai=0
B dibuat, nilai=5
```

**Soal 2 Bagian C** (`soal2.TesSoal2 C`):

```
78.53981633974483
0.0
0.0
```

**Soal 3** (`soal3.TesSoal3`):

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

## Jawaban Soal dan Analisis Konsep

### Soal 1: Pertanyaan tambahan (harga dijadikan private)

Atribut `harga` di `Perangkat` diubah dari `protected` menjadi `private`, lalu dikompilasi. Pesan error:

```
soal1/Laptop.java:37: error: harga has private access in Perangkat
        return harga - (harga * diskonPersen / PERSEN_PENUH);
               ^
soal1/Laptop.java:37: error: harga has private access in Perangkat
        return harga - (harga * diskonPersen / PERSEN_PENUH);
                        ^
2 errors
```

**Penjelasan.** Anggota `private` hanya dapat diakses di dalam kelas tempat ia dideklarasikan. Subclass memang mewarisi objek yang berisi atribut itu, tetapi tidak boleh menyebut namanya secara langsung. Karena `hitungHargaPromo` ada di `Laptop`, bukan di `Perangkat`, kompilator menolaknya. Perbaikannya: kembalikan ke `protected`, atau tetap `private` dan sediakan getter `getHarga()` yang dipanggil dari `Laptop`.

### Soal 2

**Bagian A, pertanyaan 1: output lengkap.** Prediksi (ditulis sebelum menjalankan) sama dengan hasil sebenarnya:

```
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
Exception in thread "main" java.lang.ClassCastException: class soal2.Hewan cannot be cast to class soal2.Kucing
```

Constructor `Hewan` berjalan lebih dulu, lalu `Kucing`. `h.makan()` mencetak "Tom makan" lalu memanggil `suara()` yang menghasilkan "meong". `h.suara()` juga "meong". Pada `new Hewan("Generik")` hanya constructor `Hewan` yang berjalan, lalu program berhenti saat downcast gagal.

**Pertanyaan 2: `h.panjat();` dibuka komentarnya.** Terjadi **error kompilasi**, bukan runtime:

```
error: cannot find symbol
        h.panjat();
         ^
  symbol:   method panjat()
  location: variable h of type Hewan
```

Kompilator hanya melihat **tipe statis** variabel, yaitu `Hewan`, dan kelas `Hewan` tidak punya method `panjat()`. Fakta bahwa objek aslinya `Kucing` tidak dipertimbangkan saat kompilasi.

**Pertanyaan 3: sumber `ClassCastException`.** Baris `Kucing k2 = (Kucing) h2;` (baris 40 di `TesSoal2.java`). Objek yang ditunjuk `h2` dibuat dengan `new Hewan(...)`, jadi tipe dinamisnya `Hewan`, bukan `Kucing`. Setiap `Kucing` adalah `Hewan`, tetapi tidak setiap `Hewan` adalah `Kucing`. Kompilator mengizinkan cast ini karena `Kucing` memang turunan `Hewan`, tetapi JVM memeriksanya saat runtime dan menolaknya. Perbaikan tanpa mengubah tipe `h2`:

```java
Hewan h2 = new Hewan("Generik");
if (h2 instanceof Kucing) {
    Kucing k2 = (Kucing) h2;
    k2.panjat();
} else {
    System.out.println(h2.nama + " bukan Kucing");
}
```

Hasil setelah diperbaiki: program tidak crash dan mencetak `Generik bukan Kucing` setelah baris `Hewan dibuat: Generik`.

**Pertanyaan 4: `suara()` milik kelas mana pada `h.makan()`?** Milik `Kucing`. Variabel `h` bertipe statis `Hewan`, tetapi objeknya bertipe dinamis `Kucing`. Method `makan()` hanya ditulis di `Hewan`, sehingga kode itulah yang dijalankan. Di dalamnya `suara()` dipanggil pada objek yang sedang berjalan (`this`), dan method instance dipilih berdasarkan tipe dinamis saat runtime (dynamic dispatch), jadi yang jalan adalah `Kucing.suara()`. Tipe statis menentukan method apa yang boleh dipanggil, sedangkan tipe dinamis menentukan versi mana yang dijalankan.

**Bagian B, pertanyaan 5: `new B();`.** Prediksi dan hasil sebenarnya:

```
A dibuat
init B, nilai=0
B dibuat, nilai=5
```

Objek `B` dialokasikan dan semua atribut diberi nilai bawaan (`nilai = 0`). Constructor `B` langsung memanggil `super()`, sehingga constructor `A` berjalan dan memanggil `init()`. Karena tipe dinamis objek adalah `B`, yang jalan adalah `B.init()`. Pada saat itu inisialisasi `int nilai = 5` **belum dieksekusi**, karena inisialisasi atribut subclass baru berjalan setelah `super()` selesai. Karena itu nilainya masih 0, dan baru menjadi 5 pada baris "B dibuat". **Risikonya:** method yang di-override berjalan pada objek yang belum selesai dibuat, sehingga atribut subclass masih berisi nilai bawaan (0, `null`, `false`). Ini dapat menghasilkan perilaku salah atau `NullPointerException`. Solusinya: dari constructor hanya panggil method `private`, `final`, atau `static`.

**Bagian C, pertanyaan 6.**
- `l3.luas()` menghasilkan `0.0` karena tipe dinamis `l3` adalah `Titik`. Walaupun tipe statisnya `Lingkaran`, dynamic dispatch memilih `Titik.luas()` yang di-override.
- "Titik adalah sebuah Lingkaran" hanya masuk akal secara kebetulan matematis (jari-jari 0). Sebagai relasi is-a dalam desain, ini lemah: lingkaran memiliki luas dan keliling positif, sedangkan titik tidak, sehingga subclass melanggar perilaku yang dijanjikan superclass (Liskov Substitution Principle).
- Konsekuensinya, method yang mengharapkan `Lingkaran` dengan luas lebih dari nol dapat rusak ketika diberi `Titik`, misalnya pembagian dengan luas (hasil tak terhingga atau `NaN`) atau logika yang mengasumsikan luas positif.

### Soal 3

**Pertanyaan 1: prediksi dan hasil sebelum perbaikan.** Baris kedua tercetak:

```
(100.0, 1.0) - (5.0, 5.0)
```

Constructor awal hanya menyimpan referensi (`this.awal = awal`). Variabel `t` di luar dan atribut `awal` di dalam `g2` menunjuk **objek `Titik` yang sama** (aliasing). `t.setX(100)` mengubah objek itu, sehingga garis ikut berubah.

**Pertanyaan 2: defensive copy.** Constructor `Garis` membuat salinan `Titik` lewat method private `salin(...)`. Setter dan getter juga memakai salinan agar aliasing tidak muncul lewat jalur lain.

```java
public Garis(Titik awal, Titik akhir) {
    this.awal = salin(awal);
    this.akhir = salin(akhir);
}

private static Titik salin(Titik titik) {
    return new Titik(titik.getX(), titik.getY());
}
```

Setelah diperbaiki, baris kedua tercetak `(1.0, 1.0) - (5.0, 5.0)`, karena `t.setX(100)` hanya mengubah objek milik pemanggil, bukan salinan milik `Garis`.

**Pertanyaan 3: kapan masing-masing lebih tepat.**
- *Sebelum perbaikan (berbagi referensi)* lebih tepat bila memang diinginkan satu objek yang dipakai bersama dan perubahan harus terlihat di mana-mana, misalnya garis yang menghubungkan dua kota dan harus ikut bergerak saat titik kota diperbarui, atau bila objek sangat besar sehingga penyalinan mahal.
- *Sesudah perbaikan (defensive copy)* lebih tepat bila `Garis` harus memiliki titiknya sendiri dan menjaga konsistensinya: nilai tidak boleh berubah diam-diam dari luar (enkapsulasi). Ini pilihan aman untuk kelas bergaya nilai dan kode yang dipakai banyak pihak.

**Pertanyaan 4: seandainya `Garis extends Titik`.**
- Relasi is-a tidak masuk akal: garis bukan sebuah titik. Garis *memiliki* dua titik (has-a).
- `Garis` akan mewarisi `x`, `y`, `setX`, `setY`, dan `jarakKe` yang tidak bermakna bagi garis. Garis butuh dua titik, sementara pewarisan hanya memberi satu pasang koordinat.
- Objek `Garis` dapat dilewatkan ke method yang meminta `Titik`, dan hasilnya tidak masuk akal (melanggar substitusi Liskov).
- Perubahan pada `Titik` akan berdampak ke `Garis` (kopling kuat).