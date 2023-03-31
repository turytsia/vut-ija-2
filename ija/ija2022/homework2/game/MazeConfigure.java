package ija.ija2022.homework2.game;

import ija.ija2022.homework2.common.Maze;

public class MazeConfigure {

    private MazeData maze;

    public MazeConfigure() {
        this.maze = null;
    }

    /**
     * @brief Vytvoří hru (bludiště) podle nacteného mapového podkladu.
     * 
     * @return vytvořený Maze
     */
    public Maze createMaze() {
        return this.maze;
    }

    /**
     * @brief Nacte (příjme) jeden řádek mapového podkladu.
     * 
     * @param line
     * @return True pokud je chyba, jinak je false
     */
    public boolean processLine(String line) {
        if (this.maze == null)
            return true;
            
        if (this.maze.insertLine("X" + line + "X")) {
            this.maze = null;
            return true;
        }
        
        return false;
    }

    /**
     * @brief Zahájí ctení mapového podkladu zadaného rozměru.
     * 
     * @param rows
     * @param cols
     */
    public void startReading(int rows, int cols) {
        this.maze = new MazeData(rows, cols);
        this.maze.insertLine("X".repeat(this.maze.numCols()));
    }

    /**
     * @brief Ukoncí ctení mapového podkladu.
     * 
     * @return True pokud je chyba, jinak je false
     */
    public boolean stopReading() {
        if (this.maze == null) {
            return true;
        }

        return this.maze.insertLine("X".repeat(this.maze.numCols()));
    }
}
