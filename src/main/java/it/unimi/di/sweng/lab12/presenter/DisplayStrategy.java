package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.Observable;
import it.unimi.di.sweng.lab12.Observable;
import org.jetbrains.annotations.NotNull;
import java.util.Map;

public interface DisplayStrategy {
    @NotNull Map<String, Integer> getData(@NotNull Observable model);

}
