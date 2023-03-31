package ija.ija2022.homework2.game;

public class FieldObject {
    protected int row, col;

    public FieldObject(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
