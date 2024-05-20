package Pieces;

import java.util.ArrayList;

public class Bishop extends Piece {


    public Bishop(int color) {
        super(color);
    }

    @Override
    public String Char() {
        return (color == 1 ? "w" : "b") + "B";
    }


    @Override
    public boolean canMove(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece) {
        if (!(Math.abs(row - row1) == Math.abs(col - col1))) return false;
        if (row - col == row1 - col1) {
            int step = (row1 >= row) ? 1 : -1;
            for (int r = row + step; r < row1; r += step) {
                int c = col - row + r;
                if (! field.get(r).get(c).equals(voidPiece)) return false;
            }
            return true;
        }
        if (row + col == row1 + col1) {
            int step = (row1 >= row) ? 1 : -1;
            for (int r = row + step; r < row1; r += step) {
                int c = row + col - r;
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
