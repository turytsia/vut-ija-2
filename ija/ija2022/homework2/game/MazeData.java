package ija.ija2022.homework2.game;
import ija.ija2022.homework2.common.Field;
import ija.ija2022.homework2.common.Maze;

import java.util.ArrayList;


public class MazeData implements Maze {

    private int rows;
    private int cols;
    private ArrayList<ArrayList<Field>> mapList;

    public MazeData(int rows, int cols) {
        this.rows = rows + 2;
        this.cols = cols + 2;
        this.mapList = new ArrayList<ArrayList<Field>>();
    }

    /**
     * @brief Vloží a validuje line
     * 
     * @param line
     * @return True pokud je chyba, jinak se vratí false
     */
    public boolean insertLine(String line) {
        if (line.length() != this.cols)
            return true;
        if (this.mapList.size() >= this.rows)
            return true;

        
        ArrayList<Field> rowList = new ArrayList<Field>();

        for (char symbol : line.toCharArray()) {

            Field field = createField(symbol, this.mapList.size(), rowList.size());

            if (field == null)
                return true;

            field.setMaze(this);
            rowList.add(field);
        }

        this.mapList.add(rowList);

        return false;
    }
    
    /**
     * @brief Vytvoří položku Field
     * 
     * @param symbol
     * @param row
     * @param col
     * @return Nový Field
     */
    private Field createField(char symbol, int row, int col) {
        Field field = new PathField(row, col);

        switch (symbol) {
            case 'X':
                return new WallField(row, col);
            case '.':
                return new PathField(row, col);
            case 'S':
                field.put(new PacmanObject(field));
                return field;
            default:
                return null;
        }
    }

    @Override
    public Field getField(int row, int col) {
        try{
            return this.mapList.get(row).get(col);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public int numRows() {
        return this.rows;
    }

    @Override
    public int numCols() {
        return this.cols;
    }

}
