package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.Main;
import it.unimi.di.sweng.lab12.Model;
import it.unimi.di.sweng.lab12.view.CommandView;
import org.jetbrains.annotations.NotNull;
import it.unimi.di.sweng.lab12.Observable;
import it.unimi.di.sweng.lab12.Observer;
import java.util.Map;

public class CommandPresenter implements InputPresenter, Observer {

    private @NotNull final Model model;
    private @NotNull final CommandView view;

    public CommandPresenter(@NotNull Model model, @NotNull CommandView view) {
        this.model = model;
        this.view = view;
        model.addObserver(this);
        view.addHandlers(this);
    }

    @Override
    public void action(int num, @NotNull String text) {
        model.buy(text);
    }

    @Override
    public void update(Observable model) {
        int i = 0;
        for (Map.Entry<String, Integer> item : model.getShoppingList().entrySet()) {
            view.set(i, item.getKey());
            i++;
        }
        for (; i < Main.MAX_FOOD; i++) {
            view.set(i, "---");
        }
    }
}
