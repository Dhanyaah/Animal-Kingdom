import java.awt.*;

public class Giant extends Critter {
    private int moveCount;

    // Overrides getColor method
    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    // Overrides toString method
    @Override
    public String toString() {
        // Alternates between "fee", "fie", "foe", "fum" for 6 moves each
        String[] phrases = {"fee", "fie", "foe", "fum"};
        return phrases[(moveCount / 6) % 4];
    }

    // Overrides getMove method
    @Override
    public Action getMove(CritterInfo info) {
        moveCount++;

        // Always infect if an enemy is in front
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }

        // Hop if possible, turn right otherwise
        if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }
}
