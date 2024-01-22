package it.unimi.di.sweng.lab12.presenter;


import it.unimi.di.sweng.lab12.Main;
import it.unimi.di.sweng.lab12.view.DisplayView;
import org.jetbrains.annotations.NotNull;
import java.util.Map;
import it.unimi.di.sweng.lab12.Observable;
import it.unimi.di.sweng.lab12.Observer;

public class DisplayPresenter implements Observer{

    private @NotNull final DisplayView view;
    private @NotNull final DisplayStrategy strategy;

    public DisplayPresenter(@NotNull Observable model, @NotNull DisplayView view, @NotNull DisplayStrategy strategy) {
        this.view = view;
        this.strategy = strategy;
        model.addObserver(this);
    }

    @Override
    public void update(Observable model) {
        Map<String, Integer> items = strategy.getData(model);

        int i = 0;
        for (Map.Entry<String, Integer> item : items.entrySet()) {
            view.set(i, String.format("%s %d", item.getKey(), item.getValue()));
            i++;
        }
        for (; i < Main.MAX_FOOD; i++) {
            view.set(i, "");
        }
    }

}
