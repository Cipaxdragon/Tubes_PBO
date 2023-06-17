import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private List<Coordinate> usedCoordinates;

    public Game(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        currentPlayer = player1;
        usedCoordinates = new ArrayList<>();
    }

    public void start() {
        // Generate ships for each player
        generateShips(player1);
        generateShips(player2);

        // Game loop
        while (true) {
            System.out.println(currentPlayer.getName() + "Gilirannu ");
            System.out.print("Masukan Target Kordinat (x y): ");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Coordinate target = new Coordinate(x, y);

            if (isCoordinateUsed(target)) {
                System.out.println("Maaf Posisi Target Sudah Di gunakan");
                continue;
            }

            boolean hit = false;
            Player opponent = (currentPlayer == player1) ? player2 : player1;
            for (Ship ship : opponent.getShips()) {
                if (ship.getPosition().getX() == target.getX() && ship.getPosition().getY() == target.getY()) {
                    hit = true;
                    ship.setHit(true);
                    break;
                }
            }

            usedCoordinates.add(target);

            if (hit) {
                System.out.println("Target Kena Ges");
            } else {
                System.out.println("Target Meleset");
            }

            if (!opponent.hasShipsRemaining()) {
                System.out.println(currentPlayer.getName() + " Menang Ko");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private boolean isCoordinateUsed(Coordinate coordinate) {
        for (Coordinate usedCoordinate : usedCoordinates) {
            if (usedCoordinate.getX() == coordinate.getX() && usedCoordinate.getY() == coordinate.getY()) {
                return true;
            }
        }
        return false;
    }

    private void generateShips(Player player) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int x = random.nextInt(7);
            int y = random.nextInt(7);
            Coordinate position = new Coordinate(x, y);
            Ship ship = new Ship(position);
            player.addShip(ship);
        }
    }
}