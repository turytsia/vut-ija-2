package ija.ija2022.homework2.tool;

import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMaze;
import ija.ija2022.homework2.tool.common.CommonMazeObject;
import ija.ija2022.homework2.tool.view.FieldView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 *Třída ověřující implementaci vzoru Observer nad bludištěm. Simuluje objekty presenteru (view),
 * které jsou schopny přijímat notifikace. Ověřuje notifikace správných objektů (políček) a správný počet notifikací.
 */
public class MazeTester {
    private final CommonMaze maze;
    private final List<FieldView> fields;

    public MazeTester(CommonMaze maze) {
        this.maze = maze;
        this.fields = new ArrayList();
        int rows = maze.numRows();
        int cols = maze.numCols();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                FieldView field = new FieldView(maze.getField(i, j));
                this.fields.add(field);
            }
        }

    }

    /*
     * Ověří, že žádné políčko nebylo notifikováno.
     */
    public boolean checkEmptyNotification() {
        return this.check().isEmpty();
    }

    /*
     * Ověří správný průběh notifikace při přesunu objektu mezi políčky - tato políčka generují notifikace o změnách.
     * O změně musí notifikovat políčka current a previous.
     * Ověřuje, zda notifikaci zaslala správná políčka ve správném počtu.
     * Po ověření smaže záznamy o notifikacích (odpovídá stavu žádné políčko nebylo notifikováno).
     *
     * Parametry:
     *   msg - Objekt, do kterého se uloží zpráva případné chybě.
     *   obj - Objekt, který se přesouval.
     *   current - Políčko, na kterém je objekt po změně (přesunu).
     *   previous - Políčko, na kterém byl objekt před změnou (přesunem).
     */
    public boolean checkNotification(StringBuilder msg, CommonMazeObject obj, CommonField current, CommonField previous) {
        boolean res = this.privCheckNotification(msg, obj, current, previous);
        this.fields.forEach((f) -> {
            f.clearChanged();
        });
        return res;
    }

    private boolean privCheckNotification(StringBuilder msg, CommonMazeObject obj, CommonField current, CommonField previous) {
        List<FieldView> changed = this.check();
        int size = changed.size();
        if (size != 2) {
            msg.append("Chyba - nespravny pocet notifikovanych policek!").append(" Ocekava se 2, je ").append(size);
            return false;
        } else {
            FieldView fv1 = (FieldView) changed.get(0);
            FieldView fv2 = (FieldView) changed.get(1);
            CommonField f1 = fv1.getField();
            CommonField f2 = fv2.getField();
            size = fv1.numberUpdates();
            if (size != 1) {
                msg.append("Chyba - nespravny pocet notifikovani policka ").append(" Ocekava se 1, je ").append(size);
                return false;
            } else {
                size = fv2.numberUpdates();
                if (size != 1) {
                    msg.append("Chyba - nespravny pocet notifikovani policka ").append(" Ocekava se 1, je ").append(size);
                    return false;
                } else {
                    CommonField c;
                    CommonField p;
                    if (f1.equals(current) && f2.equals(previous)) {
                        c = f1;
                        p = f2;
                    } else {
                        if (!f2.equals(current) || !f1.equals(previous)) {
                            msg.append("Chyba - notifikovana nespravna policka. ").append(" Ocekavaji se ").append(current).append(", ").append(previous).append(". Jsou ").append(f1).append(", ").append(f2);
                            return false;
                        }

                        c = f2;
                        p = f1;
                    }

                    if (!c.contains(obj)) {
                        msg.append("Chyba - cilove policko neobsahuje presouvany objekt!");
                        return false;
                    } else if (p.contains(obj)) {
                        msg.append("Chyba - zdrojove policko obsahuje presouvany objekt!");
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }


    private List<FieldView> check() {
        List<FieldView> changed = (List) this.fields.stream().filter((f) -> {
            return f.numberUpdates() > 0;
        }).collect(Collectors.toList());
        return changed;
    }
}
