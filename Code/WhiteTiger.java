import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean infected;

    // Constructor
    public WhiteTiger() {
        this.infected = false;
    }

    // Overrides getColor method
    @Override
    public Color getColor() {
        // Always Color.WHITE
        return Color.WHITE;
    }

    // Overrides toString method
    @Override
    public String toString() {
        // "tgr" if it hasn’t infected another Critter yet, “TGR” if it has infected
        return infected ? "TGR" : "tgr";
    }

    // Overrides getMove method
    @Override
    public Action getMove(CritterInfo info) {
        // Same as a Tiger
        Action tigerMove = new Tiger().getMove(info);

        // Check if infected and update accordingly
        if (info.getFront() == Critter.Neighbor.OTHER) {
            infected = true;
        }

        return tigerMove;
    }
}
