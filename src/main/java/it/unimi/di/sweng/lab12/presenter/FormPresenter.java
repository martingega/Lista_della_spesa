package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.Model;
import it.unimi.di.sweng.lab12.view.InputView;
import org.jetbrains.annotations.NotNull;

public class FormPresenter implements InputPresenter {

    @NotNull private final Model model;

    public FormPresenter(@NotNull Model model, InputView view) {
        this.model = model;
        view.addHandlers(this);
    }

    @Override
    public void action(int num, @NotNull String text) {
        model.addItem(text, num);
    }
}
