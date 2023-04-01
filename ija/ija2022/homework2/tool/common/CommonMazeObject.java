package ija.ija2022.homework2.tool.common;

/**
 * Rozhraní reprezentuje objekt, který lze umístit na políčka CommonField
 * bludiště (Maze). Rozhraní definuje operace pro přesun objektu na sousední
 * políčka (pohyb objektu). Objekty se mohou přesouvat mezi políčky pouze ve
 * stanoveném směru (Field.Direction) a vždy o jeden krok (jedno políčko).
 */
public interface CommonMazeObject {

    public void setField(CommonField field);
    
    /**
     * Ověří, zda je možné přesunout objekt zadaným směrem.
     * 
     * @param dir Směr, kam se má objekt přesunout.
     * @return
     */
    public boolean canMove(CommonField.Direction dir);

    /**
     * Přesune objekt na pole v zadaném směru, pokud je to možné.
     * 
     * @param dir Směr, kam se má objekt přesunout.
     * @return
     */
    public boolean move(CommonField.Direction dir);

    /**
     * Ověřuje, zda objekt reprezentuje panáčka Pacman.
     * 
     * @return Výsledek testu. Defaultní implementace vrací false.
     */
    public boolean isPacman();

    /**
     * Vrátí objekt políčka, na kterém je objekt umístěn.
     * 
     * @return Políčko, na kterém je objekt umístěn.
     */
    public CommonField getField();

    /**
     * Vrátí aktuální počet životů objektu.
     * 
     * @return Počet životů.
     */
    public int getLives();
}
