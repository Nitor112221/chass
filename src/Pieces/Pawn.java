package Pieces;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(int color) {
        super(color);
    }

    @Override
    public String Char() {
        return (color == 1 ? "w" : "b") + "P";
    }


    @Override
    public boolean canMove(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece) {
        if (! (0 <= row && row < 8 && 0 <= col && col < 8 && 0 <= row1 && row1 < 8 && 0 <= col1 && col1 < 8)) return false;
        if (col1 != col) return false;
        int direction;
        int start_now;
        if (color == 1) {
            direction = 1;
            start_now = 1;
        } else {
            direction = -1;
            start_now = 6;
        }
        if (row + direction == row1) return true;
        if (!field.get(row1).get(col1).equals(voidPiece)) return false;
        if (row == start_now && row + 2 * direction == row1 && field.get(row + direction).get(col).equals(voidPiece))
            return true;

        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece) {
        int direction = (this.color == 1) ? 1 : -1;
        return row + direction == row1 && (col + 1 == col1 || col - 1 == col1);
    }
}
