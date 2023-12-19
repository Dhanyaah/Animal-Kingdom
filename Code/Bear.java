import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int moves;

    // Constructor
    public Bear(boolean polar) {
        this.polar = polar;
        this.moves = 0;
    }

    // Overrides getColor method
    @Override
    public Color getColor() {
        return polar ? Color.WHITE : Color.BLACK;
    }

    // Overrides toString method
    @Override
    public String toString() {
        // Alternates between "/" and "\" on different moves
        return (moves % 2 == 0) ? "/" : "\\";
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
