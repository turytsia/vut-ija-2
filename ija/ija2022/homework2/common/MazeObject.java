package ija.ija2022.homework2.common;

public interface MazeObject {

    public void setField(Field field);
    /**
     * Ověří, zda je možné přesunout objekt zadaným směrem.
     * 
     * @param dir
     * @return
     */
    public boolean canMove(Field.Direction dir);

    /**
     * Přesune objekt na pole v zadaném směru, pokud je to možné.
     * 
     * @param dir
     * @return
     */
    public boolean move(Field.Direction dir);
}
