package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.CommonField;

public class PacmanObject extends MazeMovable {

    private int lives;

    public PacmanObject(CommonField field) {
        super(field);
        this.lives = 3;
    }

    public int getLives() {
        return this.lives;
    }

    public void damage() {
        this.lives--;
    }
}
