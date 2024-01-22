package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.Observable;
import org.jetbrains.annotations.NotNull;
import java.util.Map;

public class BoughtStrategy implements DisplayStrategy {
    @Override
    public @NotNull Map<String, Integer> getData(@NotNull Observable model) {
        return model.getBoughtList();
    }
}
