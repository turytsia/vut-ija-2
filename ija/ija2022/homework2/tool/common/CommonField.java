package ija.ija2022.homework2.tool.common;

/**
 * Rozhraní k polím, které lze umístit na desku bludiště Maze. Na políčka, která
 * to umožňují, lze vkládat objekty CommonMazeObject. Rozhraní rozšiřuje
 * rozhraní Observable - umožňuje notifikovat závislé objekty
 * (Observable.Observer) o změnách provedených na políčku. Definuje pouze ty
 * operace a výčtový typ, které jsou použity nástrojem a testovací třídou v
 * rámci úkolu 2.
 */
public interface CommonField extends Observable {
    
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
    public CommonMazeObject get();

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
    public CommonField nextField(CommonField.Direction dirs);

    /**
     * Vloží na pole objekt bludiště.
     * 
     * @param object
     * @return
     */
    public boolean put(CommonMazeObject object);

    /**
     * Odebere zadaný objekt z pole.
     * 
     * @param object
     * @return
     */
    public boolean remove(CommonMazeObject object);

    /**
     * Asociuje polícko s bludištěm, do kterého je vloženo.
     * 
     * @param maze
     */
    public void setMaze(CommonMaze maze);

    /**
     * Testuje, zda políčko obsahuje specifikovaný objekt (zda je na políčku
     * umístěn).
     * 
     * @param obj Testovaný objekt
     * @return
     */
    public boolean contains(CommonMazeObject obj);

}
