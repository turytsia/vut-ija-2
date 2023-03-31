package ija.ija2022.homework2.common;

public interface Field {
    
    static enum Direction {
        D,
        L,
        R,
        U
    };

    /**
     * Vrací informaci, zda je možné na pole umístit objekt (MazeObject).
     * 
     * @return
     */
    public boolean canMove();

    /**
     * Vrací objekt, který leží na poli.
     * 
     * @return
     */
    public MazeObject get();

    /**
     * Test, zda je pole prázdné.
     * 
     * @return
     */
    public boolean isEmpty();

    /**
     * Vrátí sousední pole v daném směru dirs.
     * 
     * @return
     */
    public Field nextField(Field.Direction dirs);

    /**
     * Vloží na pole objekt bludiště.
     * 
     * @param object
     * @return
     */
    public boolean put(MazeObject object);

    /**
     * Odebere zadaný objekt z pole.
     * 
     * @param object
     * @return
     */
    public boolean remove(MazeObject object);

    /**
     * Asociuje polícko s bludištěm, do kterého je vloženo.
     * 
     * @param maze
     */
    public void setMaze(Maze maze);

}
