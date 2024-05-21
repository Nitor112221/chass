package Pieces;

import java.util.ArrayList;

public class Queen extends Piece {


    public Queen(int color) {
        super(color);
    }

    @Override
    public String Char() {
        return (color == 1 ? "w" : "b") + "Q";
    }

    @Override
    public boolean canMove(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece) {
        if (! (0 <= row && row < 8 && 0 <= col && col < 8 && 0 <= row1 && row1 < 8 && 0 <= col1 && col1 < 8)) return false;
        if (!field.get(row1).get(col1).equals(voidPiece) && field.get(row1).get(col1).getColor() == color) return false;
        int step = (row1 >= row) ? 1 : -1;
        step = (row1 == row) ? 0 : step;
        if (row == row1 || col == col1) {
            for (int r = row + step; r != row1; r += step) if (!field.get(r).get(col).equals(voidPiece)) return false;
            step = (col1 >= col) ? 1 : -1;
            step = (col1 == col) ? 0 : step;
            for (int c = col + step; c != col1; c += step) if (!field.get(row).get(c).equals(voidPiece)) return false;
            return true;
        }
        if (row - col == row1 - col1) {
            for (int r = row + step; r != row1; r += step) {
                int c = col - row + r;
                if (! field.get(r).get(c).equals(voidPiece)) return false;
            }
            return true;
        }
        if (row + col == row1 + col1) {
            for (int r = row + step; r != row1; r += step) {
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
