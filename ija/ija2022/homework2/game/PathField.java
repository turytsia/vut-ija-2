package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMazeObject;

/**
 * Třída reprezentující polícko na cestě v bludišti. Na polícko lze vložit
 * objekt MazeObject.
 */
public class PathField extends FieldObject {
    private CommonMazeObject object;

    public PathField(int row, int col) {
        super(row, col);
    }

    /**
     * Objekty jsou shodné, pokud reprezentují stejný typ polícka (polícko na cestě)
     * na stejné pozici (row, col).
     * 
     * @param obj Srovnávaný objekt
     * 
     * @return Výsledek testu
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof PathField))
            return false;

        PathField field = (PathField) obj;
        return field.getRow() == this.getRow() && field.getCol() == this.getCol();
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public CommonMazeObject get() {
        return this.object;
    }

    @Override
    public boolean isEmpty() {
        return this.object == null;
    }

    @Override
    public CommonField nextField(CommonField.Direction dirs) {
        CommonField field = null;
        switch (dirs) {
            case R:
                field = this.maze.getField(this.row, this.col + 1);
                break;
            case L:
                field = this.maze.getField(this.row, this.col - 1);
                break;
            case D:
                field = this.maze.getField(this.row + 1, this.col);
                break;
            case U:
                field = this.maze.getField(this.row - 1, this.col);
                break;
        }

        if (field == null)
            throw new UnsupportedOperationException("field is null");

        return field;
    }

    public boolean put(CommonMazeObject object) {
        if (this.object instanceof PacmanObject) {
            ((PacmanObject) this.object).damage();
            return true;
        }
        if (!this.isEmpty()) {
            return false;
        }
        this.object = object;
        return true;
    }

    public boolean remove(CommonMazeObject object) {
        if (this.object != object)
            return false;
        this.object = null;
        this.notifyObservers();
        return true;
    }

    @Override
    public boolean contains(CommonMazeObject obj) {
        return obj == this.object;
    }

}
