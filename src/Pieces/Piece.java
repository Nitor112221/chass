package Pieces;

import java.util.ArrayList;

public abstract class Piece {
    protected int color;

    public Piece(int color) {
        this.color = color;
    }
    public abstract String Char();

    public int getColor() {
        return color;
    }

    public abstract boolean canMove(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece);

    public abstract boolean canAttack(int row, int col, int row1, int col1, ArrayList<ArrayList<Piece>> field, Piece voidPiece);
}
