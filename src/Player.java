import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Ship> ships;

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public boolean hasShipsRemaining() {
        for (Ship ship : ships) {
            if (!ship.isHit()) {
                return true;
            }
        }
        return false;
    }
}
