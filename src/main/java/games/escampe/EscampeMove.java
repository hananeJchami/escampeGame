package games.escampe;

import iialib.games.model.IMove;

public class EscampeMove implements IMove {

    public final int startX;
    public final int startY;
    public final int endX;
    public final int endY;

    public EscampeMove(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public String toString() {
        return String.format("Move from (%d,%d) to (%d,%d)", startX, startY, endX, endY);
    }
}