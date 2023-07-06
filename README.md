# Tugas Besar PBO kelompok 4b
## Develop : 

| Pekerja | NIM |
|--|--|
|Ahmad Ghazali| 60900121064 |
|Ahmad Ghazali| Penanggung Jawab |
|Ahmad Ghazali| Penanggung Jawab |
|Ahmad Ghazali| Penanggung Jawab |



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


## Implementasi #1

1. Abstraksi: Konsep abstraksi digunakan dalam kodingan ini dengan menggunakan class `BattleshipGame` untuk merepresentasikan permainan Battleship. Class ini mengabstraksi semua detail permainan, termasuk papan permainan, penempatan kapal, giliran pemain, dan logika permainan.

2. Enkapsulasi: Konsep enkapsulasi diterapkan dalam kodingan ini dengan mengenkapsulasi data anggota private seperti `boardPlayer1`, `boardPlayer2`, `numShips`, `player1`, `player2`, `country1`, `country2`, dan `isPlayer1Turn`. Data anggota ini hanya dapat diakses dan dimodifikasi melalui metode-metode publik yang ditentukan dalam class `BattleshipGame`.

3. Polimorfisme: Kodingan ini tidak secara eksplisit menggunakan polimorfisme. Polimorfisme umumnya melibatkan penggunaan pewarisan dan penggunaan metode yang dioverride atau overloaded. Kodingan ini menggunakan pewarisan melalui penulisan class `BattleshipGame` yang menjadi superclass dari class `Main`, tetapi tidak ada penggunaan metode yang dioverride atau overloaded.

4. Pewarisan: Konsep pewarisan diterapkan dalam kodingan ini dengan membuat class `BattleshipGame` sebagai superclass dan class `Main` sebagai subclass-nya. Class `Main` mewarisi semua anggota (termasuk variabel dan metode) dari class `BattleshipGame`. Pewarisan memungkinkan subclass untuk memperluas atau mengubah perilaku yang diwarisi dari superclass.

5. Interface: Kodingan ini tidak mengimplementasikan interface secara langsung. Interface biasanya digunakan untuk mendefinisikan kontrak metode yang harus diimplementasikan oleh class-class yang mengimplementasikan interface tersebut. Dalam kodingan ini, tidak ada penggunaan interface secara eksplisit.

Jadi, kodingan ini mengimplementasikan beberapa konsep pemrograman berorientasi objek, termasuk abstraksi, enkapsulasi, dan pewarisan, tetapi tidak menggunakan polimorfisme dan interface secara langsung.