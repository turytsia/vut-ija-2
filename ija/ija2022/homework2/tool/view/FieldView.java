package ija.ija2022.homework2.tool.view;

import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.CommonMazeObject;
import ija.ija2022.homework2.tool.common.Observable;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 *Třída reprezentující grafickou podobu políčka. Implementuje Observable.
 * Observer, může být notifikován o změně stavu políčka.
 */
public class FieldView extends JPanel implements Observable.Observer {
    private final CommonField model;
    private final List<ComponentView> objects;
    private int changedModel = 0;

    public FieldView(CommonField model) {
        this.model = model;
        this.objects = new ArrayList();
        this.privUpdate();
        model.addObserver(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.objects.forEach((v) -> {
            v.paintComponent(g);
        });
    }

    private void privUpdate() {
        if (this.model.canMove()) {
            this.setBackground(Color.white);
            if (!this.model.isEmpty()) {
                CommonMazeObject o = this.model.get();
                ComponentView v = o.isPacman() ? new PacmanView(this, this.model.get()) : new GhostView(this, this.model.get());
                this.objects.add(v);
            } else {
                this.objects.clear();
            }
        } else {
            this.setBackground(Color.lightGray);
        }

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /*
     * Zpracovává notifikaci o změně v objektu Observable.
     * @param: field - Objekt, v kterém došlo ke změně.
     */
    public final void update(Observable field) {
        ++this.changedModel;
        this.privUpdate();
    }

    /*
     * Vrací počet notifikací objektu z Observable.
     */
    public int numberUpdates() {
        return this.changedModel;
    }

    /*
     * Vynuluje informaci o počtu notifikací objektu z Observable.
     */
    public void clearChanged() {
        this.changedModel = 0;
    }

    /*
     * Vrací objekt políčka, které je zobrazováno tímto pohledem.
     */
    public CommonField getField() {
        return this.model;
    }
}
