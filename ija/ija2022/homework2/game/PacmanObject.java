package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.CommonField;

/**
 * Třída reprezentujicí panačka
 */
public class PacmanObject extends MazeMovable {

    private int lives;

    public PacmanObject(CommonField field) {
        super(field);
        this.lives = 3;
    }

    /**
     * Vratí počet životů
     * 
     * @return počet životů
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * Udělá damage
     */
    public void damage() {
        this.lives--;
    }
}
