package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMaze;
import ija.ija2022.homework2.tool.common.CommonMazeObject;
import ija.ija2022.homework2.tool.common.Observable;

import java.util.HashSet;
import java.util.Set;

public class PathField extends FieldObject implements CommonField {
    private CommonMaze maze;
    private CommonMazeObject object;
    private final Set<Observer> observers = new HashSet();

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

    @Override
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

    @Override
    public boolean remove(CommonMazeObject object) {
        if (this.object != object)
            return false;
        this.object = null;
        return true;
    }

    @Override
    public void setMaze(CommonMaze maze) {
        this.maze = maze;
    }

    @Override
    public void addObserver(Observer o) {
        // TODO Auto-generated method stub
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        // TODO Auto-generated method stub
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        this.observers.forEach((o) -> {
            o.update(this);
        });
    }

    @Override
    public boolean contains(CommonMazeObject obj) {
        return obj == this.object;
    }

}
