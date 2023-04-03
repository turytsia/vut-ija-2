package ija.ija2022.homework2.game;

import ija.ija2022.homework2.tool.common.CommonMaze;

/**
 * Třída pro nactení mapového podkladu a vytvoření hry (bludiště). V této
 * implementaci nenacítá ze souboru, ale přijímá mapový podklad po řádcích
 * prostřednictvím metod. Implementace pracuje pouze s následujícími prvky
 * bludiště: X (zeď, reprezentováno třídou WallField), . (průchozí polícko,
 * cesta, reprezentováno třídou PathField) a S (výchozí pozice panácka Pacmana
 * na cestě PathField, při inicializaci bude na polícku s tímto symbolem umístěn
 * objekt MazeObject reprezentující panácka). Mapový podklad neobsahuje
 * ohranicující zeď. Při vytváření bludiště je toto ohranicení vygenerováno
 * automaticky. Skutecný rozměr bludiště je tedy rozměr mapového podkladu
 * zvýšený o hodnotu 2 v každém směru.
 */
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
    public CommonMaze createMaze() {
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
