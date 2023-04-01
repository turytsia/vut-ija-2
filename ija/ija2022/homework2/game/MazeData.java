package ija.ija2022.homework2.game;
import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMaze;
import ija.ija2022.homework2.tool.common.CommonMazeObject;

import java.util.ArrayList;
import java.util.List;


public class MazeData implements CommonMaze {

    private int rows;
    private int cols;
    private ArrayList<ArrayList<CommonField>> mapList;
    private ArrayList<CommonMazeObject> ghostList;

    public MazeData(int rows, int cols) {
        this.rows = rows + 2;
        this.cols = cols + 2;
        this.mapList = new ArrayList<ArrayList<CommonField>>();
        this.ghostList = new ArrayList<CommonMazeObject>();
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

        
        ArrayList<CommonField> rowList = new ArrayList<CommonField>();

        for (char symbol : line.toCharArray()) {

            CommonField field = this.createField(symbol, this.mapList.size(), rowList.size());

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
    private CommonField createField(char symbol, int row, int col) {
        CommonField field = new PathField(row, col);

        switch (symbol) {
            case 'X':
                return new WallField(row, col);
            case '.':
                return new PathField(row, col);
            case 'G':
                CommonMazeObject ghost = new GhostObject(field);
                this.ghostList.add(ghost);
                field.put(ghost);
                return field;
            case 'S':
                field.put(new PacmanObject(field));
                return field;
            default:
                return null;
        }
    }

    @Override
    public CommonField getField(int row, int col) {
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

    @Override
    public List<CommonMazeObject> ghosts() {
        return new ArrayList<>(this.ghostList);
    }

}
