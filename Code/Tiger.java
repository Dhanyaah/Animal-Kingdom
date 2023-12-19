import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private int moves;
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    private Color currentColor;

    // Constructor
    public Tiger() {
        this.moves = 0;
        this.currentColor = getRandomColor();
    }

    // Overrides getColor method
    @Override
    public Color getColor() {
        // Alternate colors every three moves
        if (moves % 3 == 0) {
            currentColor = getRandomColor();
        }
        return currentColor;
    }

    // Overrides toString method
    @Override
    public String toString() {
        // "TGR"
        return "TGR";
    }

    // Overrides getMove method
    @Override
    public Action getMove(CritterInfo info) {
        moves++;

        // Always infect if an enemy is in front
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }

        // If a wall is in front or to the right, then turn left
        if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        }

        // If a fellow Tiger is in front, then turn right, otherwise hop
        if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    // Helper method to get a random color from the colors array
    private Color getRandomColor() {
        Random random = new Random();
        return colors[random.nextInt(colors.length)];
    }
}
