package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.AbstractObservableField;
import ija.ija2022.homework2.tool.common.CommonMaze;

/**
 * Abstraktní třída která implementuje a sdilí defaultní chování
 * metod v buňce. (PathField a WallField)
 */
public abstract class FieldObject extends AbstractObservableField {
    protected int row, col; // pozice buňky v bludišti
    protected CommonMaze maze; // bludiště ke kterému buňka patří

    public FieldObject(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Váže bludiště na konkrétní buňku
     * 
     * @param maze bludiště ke kterému buňka patří
     */
    public void setMaze(CommonMaze maze) {
        this.maze = maze;
    }
    
    /**
     * Vratí pozice v řádku
     * 
     * @return pozice v řádku
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Vratí pozice ve sloupci
     * 
     * @return pozice ve sloupci
     */
    public int getCol() {
        return this.col;
    }
}
