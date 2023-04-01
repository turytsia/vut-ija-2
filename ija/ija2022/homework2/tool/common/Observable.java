package ija.ija2022.homework2.tool.common;

/**
 * Rozhraní Observable reprezentující objekty, které mohou notifikovat 
 * závislé objekty (observers) o změnách. lze vkládat objekty MazeObject.
 */
public interface Observable {
    /**
     * Rozhraní Observer reprezentující objekty, které mohou registrovány u objektů
     * Observable a přijímají notifikace o jejich změnách.
     */
    public static interface Observer {
        /**
         * Zpracovává notifikaci o změně v objektu Observable.
         * 
         * @param o Objekt, v kterém došlo ke změně.
         */ 
        void update(Observable o);
    }
    
    /**
     * Registruje nový observer.
     * 
     * @param o Registrovaný observer.
     */
    void addObserver(Observable.Observer o);

    /**
     * Odregistruje observer.
     * 
     * @param o Observer, který má být odstraněn ze seznamu registrovaných
     *          observerů.
     */
    void removeObserver(Observable.Observer o);

    /**
     * Notifikuje (informuje) registrované observery, že došlo ke změně stavu
     * objektu.
     */
    void notifyObservers();
}
