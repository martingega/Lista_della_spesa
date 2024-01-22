package it.unimi.di.sweng.lab12;

import org.jetbrains.annotations.NotNull;
import java.util.Map;

// Observable e Observer non sono generici in quanto il pattern è in modalità 'pull'
// e il dato concreto non è mai passato.

public interface Observable {

    void addObserver(@NotNull Observer obs);
    void notifyObservers();

    @NotNull Map<String, Integer> getShoppingList();
    @NotNull Map<String, Integer> getBoughtList();

}
