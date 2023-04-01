package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMaze;
import ija.ija2022.homework2.tool.common.CommonMazeObject;

public class WallField extends FieldObject implements CommonField {
    private CommonMaze maze;

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
    public CommonMazeObject get() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public CommonField nextField(CommonField.Direction dirs) {
        throw new UnsupportedOperationException("Unimplemented method 'nextField'");
    }

    @Override
    public boolean put(CommonMazeObject object) {
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public boolean remove(CommonMazeObject object) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public void setMaze(CommonMaze maze) {
        this.maze = maze;
    }

    @Override
    public void addObserver(Observer o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addObserver'");
    }

    @Override
    public void removeObserver(Observer o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeObserver'");
    }

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyObservers'");
    }

    @Override
    public boolean contains(CommonMazeObject obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}
