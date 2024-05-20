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
        if (row != row1 && col != col1) return false;
        int step = (row1 >= row) ? 1 : -1;
        for (int r = row + step; r < row1; r+=step) if (! field.get(r).get(col).equals(voidPiece)) return false;
        step = (col1 >= col) ? 1 : -1;
        for (int c = col + step; c < col1; c += step) if (! field.get(row).get(c).equals(voidPiece)) return false;
        return true;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece) {
        return canMove(row, col, row1, col1, field, voidPiece);
    }
}
