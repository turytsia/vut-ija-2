package ija.ija2022.homework2.game;

import ija.ija2022.homework2.common.Field;
import ija.ija2022.homework2.common.Maze;
import ija.ija2022.homework2.common.MazeObject;

public class WallField extends FieldObject implements Field {
    private Maze maze;

    public WallField(int row, int col) {
        super(row, col);
    }

    public boolean equals(Object obj) {

        if (!(obj instanceof WallField))
            return false;

        WallField field = (WallField) obj;
        return field.getRow() == this.getRow() && field.getCol() == this.getCol();
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public MazeObject get() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Field nextField(Field.Direction dirs) {
        throw new UnsupportedOperationException("Unimplemented method 'nextField'");
    }

    @Override
    public boolean put(MazeObject object) {
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public boolean remove(MazeObject object) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}
