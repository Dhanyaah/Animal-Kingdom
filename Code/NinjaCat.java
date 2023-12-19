import java.awt.*;

public class NinjaCat extends Critter {
    private int moves; // to keep track of the number of moves

    // Constructor
    public NinjaCat() {
        this.moves = 0;
    }

    // Overrides getColor method
    @Override
    public Color getColor() {
        // You decide the color
        return Color.MAGENTA;
    }

    // Overrides toString method
    @Override
    public String toString() {
        // Alternates between "meow" and "cat" every 9 moves
        return (moves / 9 % 2 == 0) ? "meow" : "cat";
    }

    // Overrides getMove method
    @Override
    public Action getMove(CritterInfo info) {
        moves++;

        // Always infect if an enemy is in front
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }

        // Hop if possible, turn left if not
        if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
}
