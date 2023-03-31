package ija.ija2022.homework2.game;

import ija.ija2022.homework2.common.Field;
import ija.ija2022.homework2.common.Field.Direction;
import ija.ija2022.homework2.common.MazeObject;

public class MazeMovable implements MazeObject {

    protected Field field;

    public MazeMovable(Field field) {
        this.setField(field);
    }

    @Override
    public void setField(Field field) {
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

        Field nextField = this.field.nextField(dir);

        this.field.remove(this);
        this.setField(nextField);

        return nextField.put(this);
    }
    
}
