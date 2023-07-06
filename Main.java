import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class BattleshipGame {
    private final int boardSize = 50;
    private final char emptyCell = '-';
    private final char shipCell = 'S';
    private final char hitCell = 'X';
    private final char missCell = 'O';

    private char[][] boardPlayer1;
    private char[][] boardPlayer2;
    private int numShips;
    private String player1;
    private String player2;
    private String country1;
    private String country2;
    private boolean isPlayer1Turn;

    public BattleshipGame(int numShips, String player1, String country1, String player2, String country2) {
        boardPlayer1 = new char[boardSize][boardSize];
        boardPlayer2 = new char[boardSize][boardSize];
        for (char[] row : boardPlayer1) {
            Arrays.fill(row, emptyCell);
        }
        for (char[] row : boardPlayer2) {
            Arrays.fill(row, emptyCell);
        }
        this.numShips = numShips;
        this.player1 = player1;
        this.country1 = country1;
        this.player2 = player2;
        this.country2 = country2;
        this.isPlayer1Turn = true;
    }

    public void placeShips() {
        Random random = new Random();
        int count = 0;
        while (count < numShips) {
            int x = random.nextInt(boardSize);
            int y = random.nextInt(boardSize);
            if (boardPlayer1[x][y] != shipCell && boardPlayer2[x][y] != shipCell) {
                boardPlayer1[x][y] = shipCell;
                boardPlayer2[x][y] = shipCell;
                count++;
            }
        }
    }

    public void playGame() {
        int numAttempts = 0;
        int numHitsPlayer1 = 0;
        int numHitsPlayer2 = 0;
        try (Scanner scanner = new Scanner(System.in)) {

     
            System.out.println("Pemain 1: " + player1 + " dari " + country1);
            System.out.println("Pemain 2: " + player2 + " dari " + country2);

            while (numHitsPlayer1 < numShips && numHitsPlayer2 < numShips) {
                printBoard();

                String currentPlayer = isPlayer1Turn ? player1 : player2;
                String currentCountry = isPlayer1Turn ? country1 : country2;
                char[][] currentPlayerBoard = isPlayer1Turn ? boardPlayer2 : boardPlayer1;
                System.out.println("\nGiliran " + currentPlayer + " dari " + currentCountry);
                System.out.println("Tebak koordinat tembakan (0-49):");
                System.out.print("Baris: ");
                int x = scanner.nextInt();
                System.out.print("Kolom: ");
                int y = scanner.nextInt();

                if (x < 0 || x >= boardSize || y < 0 || y >= boardSize) {
                    System.out.println("Koordinat diluar batas papan.");
                    continue;
                }

                if (currentPlayerBoard[x][y] == hitCell || currentPlayerBoard[x][y] == missCell) {
                    System.out.println("Koordinat tersebut telah ditembak sebelumnya.");
                    continue;
                }

                numAttempts++;

                if (currentPlayerBoard[x][y] == shipCell) {
                    System.out.println("Kapal terkena!");
                    currentPlayerBoard[x][y] = hitCell;
                    if (isPlayer1Turn) {
                        numHitsPlayer1++;
                    } else {
                        numHitsPlayer2++;
                    }
                } else {
                    System.out.println("Tidak ada kapal.");
                    currentPlayerBoard[x][y] = missCell;
                }


                // Ganti giliran pemain
                isPlayer1Turn = !isPlayer1Turn;
            }
        }

        String winner = numHitsPlayer1 == numShips ? player1 : player2;
        String winnerCountry = numHitsPlayer1 == numShips ? country1 : country2;
        System.out.println("\nSelamat " + winner + " dari " + winnerCountry + "! Anda berhasil menenggelamkan semua kapal lawan.");
        System.out.println("Total percobaan: " + numAttempts);
    }

    public void printBoard() {
        System.out.println("\nPapan Permainan Pemain 1:");
        System.out.print("   ");

        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + " ");
            if (i < 10) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + " ");
            if (i < 10) {
                System.out.print(" ");
            }
            for (int j = 0; j < boardSize; j++) {
                System.out.print(boardPlayer1[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println("\nPapan Permainan Pemain 2:");
        System.out.print("   ");

        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + " ");
            if (i < 10) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 0; i < boardSize; i++) {
            System.out.print(i + " ");
            if (i < 10) {
                System.out.print(" ");
            }
            for (int j = 0; j < boardSize; j++) {
                System.out.print(boardPlayer2[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int numShips = 5;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Selamat datang di permainan Battleship!");
            System.out.println("Main Menu:");
            System.out.println("1. Main Kan");
            System.out.println("2. About");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter baru

            if (choice == 1) {
                System.out.println("\n\n==================== Panduan =======================================");
                displayGuide();
                System.out.println("\n\n==================== Input Nama Player =======================================");
                System.out.print("Masukkan nama pemain 1: ");
                String player1 = scanner.nextLine();
                System.out.print("Masukkan nama negara pemain 1: ");
                String country1 = scanner.nextLine();
                System.out.print("Masukkan nama pemain 2: ");
                String player2 = scanner.nextLine();
                System.out.print("Masukkan nama negara pemain 2: ");
                String country2 = scanner.nextLine();

                BattleshipGame game = new BattleshipGame(numShips, player1, country1, player2, country2);


                System.out.println("\n\n==================== Medan Perang =======================================");

                game.placeShips();
                game.playGame();
            } else if (choice == 2) {
                displayAbout();
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih opsi yang benar.");
            }

        }
    }

    public static void displayGuide() {
        System.out.println("Panduan Permainan Battleship:");
        // Tambahkan panduan permainan sesuai kebutuhan Anda
            System.out.println("Berikut adalah panduan permainan Battleship:");
            System.out.println("- Setiap pemain diberikan papan permainan berukuran 50x50(Mainkan game ini di full screen window cmd nah).");
            System.out.println("- Kapal pemain akan ditempatkan secara acak pada papan permainan.");
            System.out.println("- Setiap sel pada papan permainan dapat memiliki status berikut:");
            System.out.println("    - `_` (garis bawah): Tidak memiliki makna khusus, digunakan sebagai pemisah atau pemformatan.");
            System.out.println("    - `S`: Menandakan adanya kapal pada sel tersebut.");
            System.out.println("    - `X`: Menandakan bahwa sel tersebut telah ditembak dan mengenai kapal.");
            System.out.println("    - `O`: Menandakan bahwa sel tersebut telah ditembak tetapi tidak mengenai kapal.");
            System.out.println("- Pemain bergantian untuk menebak koordinat tembakan di papan lawan.");
            System.out.println("- Jika tembakan mengenai kapal lawan, maka pemain tersebut mencetak poin.");
            System.out.println("- Jika tembakan tidak mengenai kapal lawan, maka giliran pemain berikutnya.");
            System.out.println("- Permainan berlanjut hingga salah satu pemain berhasil menenggelamkan semua kapal lawan.");
            System.out.println("- Pemain yang berhasil menenggelamkan semua kapal lawan menjadi pemenangnya.");
    }

    public static void displayAbout() {
        System.out.println("Tentang Permainan Battleship:");
        System.out.println("Permainan Battleship adalah sebuah permainan strategi dua pemain yang bertujuan untuk menenggelamkan kapal lawan. Setiap pemain memiliki papan permainan sendiri dan saling menebak koordinat tembakan untuk mencari dan menghancurkan kapal lawan.");
        System.out.println("\n\n\n=============== Develope By Kelompok 4B ==================:");
        System.out.println("AHMAD GHAZALI 60900121064\r\n" + //
                "DIKCY SUKKRYSNO 60900121052\r\n" + //
                "ADAM ABDUL MAJID F 60900121033\r\n" + //
                "APRISAL 60900121080\r\n" + //
                "MUH AFDAL 60900121017\r\n" + //
                "");
    }
}
