
public class Ship {
    private Coordinate position;
    private boolean isHit;

    public Ship(Coordinate position) {
        this.position = position;
        this.isHit = false;
    }

    public Coordinate getPosition() {
        return position;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
