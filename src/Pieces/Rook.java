package Pieces;

import java.util.ArrayList;

public class Rook extends Piece{


    public Rook(int color) {
        super(color);
    }

    @Override
    public String Char() {
        return (color == 1 ? "w" : "b") + "R";
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece) {
        if (! (0 <= row && row < 8 && 0 <= col && col < 8 && 0 <= row1 && row1 < 8 && 0 <= col1 && col1 < 8)) return false;
        if (row - col == row1 - col1) {
            int step = (row1 > row) ? 1 : -1;
            step = (row1 == row) ? 0 : step;
            for (int r = row + step; r != row1; r += step) {
                int c = col - row + r;
                if (! field.get(r).get(c).equals(voidPiece)) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece) {
        return canMove(row, col, row1, col1, field, voidPiece);
    }
}
