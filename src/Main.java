
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        System.out.println("Selamat Datang Di Game Perang Kapa Kapalan");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Player 1: ");
        String player1Name = scanner.nextLine();
        System.out.print("Nama Player 2 : ");
        String player2Name = scanner.nextLine();

        Game game = new Game(player1Name, player2Name);
        game.start();
    }
}
