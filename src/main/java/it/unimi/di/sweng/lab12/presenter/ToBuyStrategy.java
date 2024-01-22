package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.Observable;
import org.jetbrains.annotations.NotNull;
import java.util.Map;

public class ToBuyStrategy implements DisplayStrategy {
    @Override
    public @NotNull Map<String, Integer> getData(Observable model) {
        return model.getShoppingList();
    }

}
