package ija.ija2022.homework2.tool;
import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMaze;
import ija.ija2022.homework2.tool.common.CommonMazeObject;

/**
 * Třída ověřující implementaci vzoru Observer nad bludištěm. Simuluje objekty
 * presenteru (view), které jsou schopny přijímat notifikace. Ověřuje notifikace
 * správných objektů (políček) a správný počet notifikací.
 */
public class MazeTester {
    /**
     * Konstruktor inicializující MazeTester.
     * 
     * @param maze Bludiště, které má být testováno.
     */
    public MazeTester(CommonMaze maze) {

    }

    /**
     * Ověří, že žádné políčko nebylo notifikováno.
     * 
     * @return Výsledek testu.
     */
    public boolean checkEmptyNotification() {
        throw new UnsupportedOperationException("Unimplemented method 'checkEmptyNotification'");
    }

    /**
     * Ověří správný průběh notifikace při přesunu objektu mezi políčky - tato
     * políčka generují notifikace o změnách. O změně musí notifikovat políčka
     * current a previous. Ověřuje, zda notifikaci zaslala správná políčka ve
     * správném počtu. Po ověření smaže záznamy o notifikacích (odpovídá stavu žádné
     * políčko nebylo notifikováno).
     * 
     * @param msg      Objekt, do kterého se uloží zpráva případné chybě.
     * @param obj      Objekt, který se přesouval.
     * @param current  Políčko, na kterém je objekt po změně (přesunu).
     * @param previous Políčko, na kterém byl objekt před změnou (přesunem).
     * @return Výsledek testu.
     */
    public boolean checkNotification(StringBuilder msg,
            CommonMazeObject obj,
            CommonField current,
            CommonField previous)

    {
        throw new UnsupportedOperationException("Unimplemented method 'checkNotification'");
    }
}
