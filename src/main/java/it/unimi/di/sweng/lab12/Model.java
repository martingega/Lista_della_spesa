package it.unimi.di.sweng.lab12;

import org.jetbrains.annotations.NotNull;
import java.util.*;


public class Model implements Observable{

    @NotNull private final Map<String, Integer> shoppingList = new HashMap<>();
    @NotNull private final Map<String, Integer> boughtList = new HashMap<>();
    @NotNull private final List<Observer> observers = new ArrayList<>();

    private boolean checkItemCount() {
        Set<String> shoppingKeySet = new HashSet<>(this.shoppingList.keySet());
        Set<String> boughtKeySet = new HashSet<>(this.boughtList.keySet());

        if (boughtKeySet.size() > 0)
            shoppingKeySet.addAll(boughtKeySet);

        return shoppingKeySet.size() < Main.MAX_FOOD;
    }


    public void addItem(@NotNull String item, int n) {

        if (!checkItemCount()) {
            return;
        }

        if (this.shoppingList.containsKey(item)) {
            this.shoppingList.put(item, this.shoppingList.get(item) + n);
        } else {
            this.shoppingList.put(item, n);
        }
        this.notifyObservers();
    }

    @Override
    public void addObserver(@NotNull Observer obs) {
        this.observers.add(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : this.observers) {
            obs.update(this);
        }
    }

    public @NotNull Map<String, Integer> getShoppingList() {
        return Collections.unmodifiableMap(this.shoppingList);
    }

    // Si assuma che item sia *presente* nella mappa, ovvero
    // sia stato già aggiunto con il metodo addItem()
    // Tale assunzione è stata fatta in quanto non è possibile comprare Item non listati,
    // al netto di corse critiche che scegliamo (per ora) di non considerare.
    public void buy(String item) {
        Integer count = this.shoppingList.get(item);
        count--;

        if (count > 0) {
            this.shoppingList.put(item, count);
        } else {
            this.shoppingList.remove(item);
        }

        if (this.boughtList.containsKey(item)) {
            this.boughtList.put(item, this.boughtList.get(item)+1);
        } else {
            this.boughtList.put(item, 1);
        }
        this.notifyObservers();
    }

    public @NotNull Map<String, Integer> getBoughtList() {
        return Collections.unmodifiableMap(this.boughtList);
    }
}
