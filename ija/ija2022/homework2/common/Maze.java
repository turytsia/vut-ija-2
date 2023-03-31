package ija.ija2022.homework2.common;

public interface Maze {
    Field getField(int row, int col);

    int numRows();

    int numCols();
}
