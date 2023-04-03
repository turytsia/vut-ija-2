package ija.ija2022.homework2.tool.common;

import java.util.HashSet;
import java.util.Set;

/*
 *Abstraktní třída implementující operace rozhraní Observable.
 *Umožňuje vkládat a rušit observery a notifikovat registrované observery o změnách.
 */
public abstract class AbstractObservableField implements CommonField {
    private final Set<Observable.Observer> observers = new HashSet();

    public AbstractObservableField() {
    }

    /*
     * Registruje nový observer.
     * @param: o - Registrovaný observer.
     */
    public void addObserver(Observable.Observer o) {
        this.observers.add(o);
    }

    /*
     * Odregistruje observer.
     * @param: o - Observer, který má být odstraněn ze seznamu registrovaných observerů.
     */
    public void removeObserver(Observable.Observer o) {
        this.observers.remove(o);
    }

    /*
     * Notifikuje (informuje) registrované observery, že došlo ke změně stavu objektu.
     */
    public void notifyObservers() {
        this.observers.forEach((o) -> {
            o.update(this);
        });
    }
}
