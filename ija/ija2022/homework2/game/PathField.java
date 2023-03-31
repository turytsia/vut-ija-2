package ija.ija2022.homework2.game;

import ija.ija2022.homework2.common.Field;
import ija.ija2022.homework2.common.Maze;
import ija.ija2022.homework2.common.MazeObject;

public class PathField extends FieldObject implements Field {
    private Maze maze;
    private MazeObject object;


    public PathField(int row, int col) {
        super(row, col);
    }

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
    public MazeObject get() {
        return this.object;
    }

    @Override
    public boolean isEmpty() {
        return this.object == null;
    }

    @Override
    public Field nextField(Field.Direction dirs) {
        Field field = null;
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

    @Override
    public boolean put(MazeObject object) {
        if (!this.isEmpty())
            return false;
        this.object = object;
        return true;
    }

    @Override
    public boolean remove(MazeObject object) {
        if (this.object != object)
            return false;
        this.object = null;
        return true;
    }

    @Override
    public void setMaze(Maze maze) {
        this.maze = maze;
    }
    
}
