package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMazeObject;
import ija.ija2022.homework2.tool.common.CommonField.Direction;

/**
 * Dodatečná třída pro sdílené chovaní objektů v bludišti
 */
public class MazeMovable implements CommonMazeObject {

    protected PathField field;

    public MazeMovable(CommonField field) {
        this.setField(field);
    }

    public void setField(CommonField field) {
        this.field = (PathField)field;
    }

    @Override
    public boolean canMove(Direction dir) {
        return field.nextField(dir) instanceof PathField;
    }

    @Override
    public boolean move(Direction dir) {
        if (!this.canMove(dir))
            return false;

        FieldObject nextField = (FieldObject)this.field.nextField(dir);

        this.field.remove(this);
        this.setField(nextField);

        boolean res = ((PathField)nextField).put(this);

        if (res) {
            this.field.notifyObservers();
        }

        return res;
    }

    @Override
    public boolean isPacman() {
        return this.field.get() instanceof PacmanObject;
    }

    @Override
    public CommonField getField() {
        return this.field;
    }

    @Override
    public int getLives() {
        if (!this.isPacman())
            return -1;

        return ((PacmanObject) this.field.get()).getLives();
    }

}
