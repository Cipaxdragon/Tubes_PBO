# Tugas Besar PBO kelompok 4b
## Nama Kelompok : 

| Pekerja | NIM |
|--|--|
|AHMAD GHAZALI | 60900121064 |
|DIKCY SUKKRYSNO| 60900121052 |
|ADAM ABDUL MAJID F| 60900121033 |
|APRISAL| 60900121080 |
|MUH AFDAL|60900121017|


## Panduan Bermain Game
- Setiap pemain diberikan papan permainan berukuran 50x50 (Mainkan game ini di full screen window cmd nah).
Kapal pemain akan ditempatkan secara acak pada papan permainan.
- Setiap sel pada papan permainan dapat memiliki status berikut:

```
"_" (garis bawah): Tidak memiliki makna khusus, digunakan sebagai pemisah atau pemformatan.
"S": Menandakan adanya kapal pada sel tersebut.
"X": Menandakan bahwa sel tersebut telah ditembak dan mengenai kapal.
"O": Menandakan bahwa sel tersebut telah ditembak tetapi tidak mengenai kapal.
```
- Pemain bergantian untuk menebak koordinat tembakan di papan lawan.
- Jika tembakan mengenai kapal lawan, maka pemain tersebut mencetak poin.
- Jika tembakan tidak mengenai kapal lawan, maka giliran pemain berikutnya.
- Permainan berlanjut hingga salah satu pemain berhasil menenggelamkan semua kapal lawan.
Pemain yang berhasil menenggelamkan semua kapal lawan menjadi pemenangnya.

## Penjelasan Kode

implementasi dari permainan Battleship dalam bahasa pemrograman Java. Battleship adalah permainan strategi untuk dua pemain yang bertujuan untuk menenggelamkan kapal lawan.

Kelas `BattleshipGame` merupakan kelas utama yang mengatur jalannya permainan. Berikut adalah penjelasan singkat tentang beberapa metode dan variabel dalam kelas ini:

1. Variabel:
   - `boardSize`: Ukuran papan permainan, dalam hal ini 50x50.
   - `emptyCell`: Karakter yang mewakili sel kosong pada papan.
   - `shipCell`: Karakter yang mewakili sel yang berisi kapal.
   - `hitCell`: Karakter yang mewakili sel yang telah ditembak dan mengenai kapal.
   - `missCell`: Karakter yang mewakili sel yang telah ditembak tetapi tidak mengenai kapal.
   - `boardPlayer1`: Papan permainan untuk pemain 1.
   - `boardPlayer2`: Papan permainan untuk pemain 2.
   - `numShips`: Jumlah kapal yang akan ditempatkan di papan.
   - `player1`: Nama pemain 1.
   - `player2`: Nama pemain 2.
   - `country1`: Negara pemain 1.
   - `country2`: Negara pemain 2.
   - `isPlayer1Turn`: Menandakan giliran pemain 1. Jika `true`, maka giliran pemain 1; jika `false`, maka giliran pemain 2.

2. Konstruktor `BattleshipGame`:
   - Menerima argumen jumlah kapal, nama pemain, dan negara pemain.
   - Menginisialisasi variabel-variabel dan papan permainan.

3. Metode `placeShips`:
   - Menempatkan kapal-kapal secara acak di papan permainan untuk pemain 1 dan pemain 2.
   - Jumlah kapal yang ditempatkan sesuai dengan `numShips`.

4. Metode `playGame`:
   - Mengatur jalannya permainan.
   - Pemain secara bergantian menebak koordinat tembakan pada papan lawan.
   - Memeriksa hasil tembakan (apakah mengenai kapal atau tidak) dan mengupdate papan permainan.
   - Permainan berlanjut hingga salah satu pemain berhasil menenggelamkan semua kapal lawan.

5. Metode `printBoard`:
   - Mencetak papan permainan untuk pemain 1 dan pemain 2.

Kelas `Main` merupakan kelas yang berisi metode `main` yang menjadi titik masuk program. Di dalam metode `main`, terdapat implementasi logika menu dan pemilihan opsi untuk memulai permainan atau menampilkan informasi tentang permainan Battleship.

Metode `displayGuide` dan `displayAbout` digunakan untuk menampilkan panduan permainan dan informasi tentang permainan Battleship kepada pengguna.

Saat program dijalankan, pengguna akan disambut dengan menu utama dan diminta untuk memilih opsi yang diinginkan. Jika pengguna memilih untuk memulai permainan, maka akan diminta untuk memasukkan nama pemain dan negara pemain. Setelah itu

akan dibuat objek `BattleshipGame` dengan parameter yang sesuai dan permainan akan dimulai dengan pemanggilan metode `placeShips` dan `playGame`.

Selama permainan berlangsung, pemain akan diminta untuk memasukkan koordinat tembakan secara bergantian. Hasil tembakan akan diperiksa dan papan permainan akan diperbarui. Permainan akan berlanjut hingga salah satu pemain berhasil menenggelamkan semua kapal lawan.

Setelah permainan selesai, akan ditampilkan pesan dengan menyebutkan pemenangnya dan jumlah total percobaan yang dilakukan.

Itulah penjelasan singkat mengenai koding di atas yang mengimplementasikan permainan Battleship dalam bahasa pemrograman Java.

## Implementasi #1

1. Abstraksi: Konsep abstraksi digunakan dalam kodingan ini dengan menggunakan class `BattleshipGame` untuk merepresentasikan permainan Battleship. Class ini mengabstraksi semua detail permainan, termasuk papan permainan, penempatan kapal, giliran pemain, dan logika permainan.

2. Enkapsulasi: Konsep enkapsulasi diterapkan dalam kodingan ini dengan mengenkapsulasi data anggota private seperti `boardPlayer1`, `boardPlayer2`, `numShips`, `player1`, `player2`, `country1`, `country2`, dan `isPlayer1Turn`. Data anggota ini hanya dapat diakses dan dimodifikasi melalui metode-metode publik yang ditentukan dalam class `BattleshipGame`.

3. Polimorfisme: Kodingan ini tidak secara eksplisit menggunakan polimorfisme. Polimorfisme umumnya melibatkan penggunaan pewarisan dan penggunaan metode yang dioverride atau overloaded. Kodingan ini menggunakan pewarisan melalui penulisan class `BattleshipGame` yang menjadi superclass dari class `Main`, tetapi tidak ada penggunaan metode yang dioverride atau overloaded.

4. Pewarisan: Konsep pewarisan diterapkan dalam kodingan ini dengan membuat class `BattleshipGame` sebagai superclass dan class `Main` sebagai subclass-nya. Class `Main` mewarisi semua anggota (termasuk variabel dan metode) dari class `BattleshipGame`. Pewarisan memungkinkan subclass untuk memperluas atau mengubah perilaku yang diwarisi dari superclass.

5. Interface: Kodingan ini tidak mengimplementasikan interface secara langsung. Interface biasanya digunakan untuk mendefinisikan kontrak metode yang harus diimplementasikan oleh class-class yang mengimplementasikan interface tersebut. Dalam kodingan ini, tidak ada penggunaan interface secara eksplisit.

Jadi, kodingan ini mengimplementasikan beberapa konsep pemrograman berorientasi objek, termasuk abstraksi, enkapsulasi, dan pewarisan, tetapi tidak menggunakan polimorfisme dan interface secara langsung.