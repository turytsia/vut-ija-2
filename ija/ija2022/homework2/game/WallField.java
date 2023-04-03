package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMazeObject;

/**
 * Třída reprezentující zeď v bludišti. Na polícko nelze vstoupit (vložit
 * objekt). Metody pracující s objekty (put a remove) a okolními poli nextField
 * nejsou implementovány, tj. generují výjimku UnsupportedOperationException
 * (při správném použití by neměly být nikdy volány nad objekty této třídy).
 */
public class WallField extends FieldObject {

    public WallField(int row, int col) {
        super(row, col);
    }

    /**
     * Objekty jsou shodné, pokud reprezentují stejný typ polícka (zeď) na stejné
     * pozici (row, col).
     * 
     * @param obj Srovnávaný objekt
     * 
     * @return Výsledek testu
     */
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

    public CommonField nextField(CommonField.Direction dirs) {
        throw new UnsupportedOperationException("Unimplemented method 'nextField'");
    }

    public boolean put(CommonMazeObject object) {
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }
    
    public boolean remove(CommonMazeObject object) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean contains(CommonMazeObject obj) {
        return false;
    }
}
