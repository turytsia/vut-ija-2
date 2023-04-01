package ija.ija2022.homework2.tool.common;

import java.util.List;

/**
 * Rozhraní reprezentující hru (bludiště), která pracuje s objekty
 * CommonMazeObject a poli CommonField. Pole jsou umístěna v mřížce, jejíž
 * rozměry jsou pevně nastaveny. Mřížka reprezentující bludiště je
 * inicializovaná při vzniku instance příslušné třídy. Vznik hry (instance) je
 * řízen prostřednictvím objektu třídy MazeConfigure,
 */
public interface CommonMaze {
    /**
     * Metoda vrací pole CommonField podle zadané pozice.
     * 
     * @param row Řádek, na kterém se pole nachází
     * @param col Sloupec, na kterém se pole nachází
     * @return Nalezené pole. Pokud je zadaná pozice mimo rozsah desky, vrací null.
     */
    CommonField getField(int row, int col);

    /**
     * Vrací počet řádků desky hry.
     * 
     * @return Počet řádků sloupců.
     */
    int numRows();

    /**
     * Vrací počet sloupců desky hry.
     * 
     * @return Počet řádků sloupců.
     */
    int numCols();

    /**
     * Vrátí seznam všech duchů v bludišti.
     * 
     * @return seznam všech duchů v bludišti.
     */
    List<CommonMazeObject> ghosts();
}
