package ija.ija2022.homework2.tool.view;
import ija.ija2022.homework2.tool.common.CommonField;
import ija.ija2022.homework2.tool.common.Observable;

import java.awt.Graphics;
import javax.swing.JPanel;


/**
 * Třída reprezentující grafickou podobu políčka. Implementuje
 * Observable.Observer, může být notifikován o změně stavu políčka.
 */
public class FieldView extends JPanel implements Observable.Observer {

    public FieldView(ComponentView model) {

    }
    
    /**
     * Vynuluje informaci o počtu notifikací objektu z Observable.
     */
    public void clearChanged() {

    }
    
    protected void paintComponent(Graphics g) {

    }
    
    /**
     * Vrací objekt políčka, které je zobrazováno tímto pohledem.
     * 
     * @return Objekt políčka.
     */
    public CommonField getField() {
        throw new UnsupportedOperationException("Unimplemented method");
    }

    /**
     * Vrací počet notifikací objektu z Observable.
     * 
     * @return Počet notifikací.
     */
    public int numberUpdates() {
        throw new UnsupportedOperationException("Unimplemented method");
    }
    
    @Override
    public final void update(Observable field) {
        
    }
    
}
