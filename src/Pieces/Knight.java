package Pieces;

import java.util.ArrayList;

public class Knight extends Piece {


    public Knight(int color) {
        super(color);
    }

    @Override
    public String Char() {
        return (color == 1 ? "w" : "b") + "N";
    }


    @Override
    public boolean canMove(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece) {
        if (! (0 <= row && row < 8 && 0 <= col && col < 8 && 0 <= row1 && row1 < 8 && 0 <= col1 && col1 < 8)) return false;
        if (!field.get(row1).get(col1).equals(voidPiece)) return false;
        if (Math.abs(col - col1) * Math.abs(row - row1) == 2 && row1 != row && col1 != col) return true;
        return false;
    }

    @Override
    public boolean canAttack(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece) {
        return canMove(row, col, row1, col1, field, voidPiece);
    }
}