package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMazeObject;
import ija.ija2022.homework2.tool.common.CommonField.Direction;

public class MazeMovable implements CommonMazeObject {

    protected CommonField field;

    public MazeMovable(CommonField field) {
        this.setField(field);
    }

    @Override
    public void setField(CommonField field) {
        this.field = field;
    }

    @Override
    public boolean canMove(Direction dir) {
        return field.nextField(dir) instanceof PathField;
    }

    @Override
    public boolean move(Direction dir) {
        if (!this.canMove(dir))
            return false;

        CommonField nextField = this.field.nextField(dir);

        this.field.remove(this);
        this.setField(nextField);

        return nextField.put(this);
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
