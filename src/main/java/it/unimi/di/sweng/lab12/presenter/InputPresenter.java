package it.unimi.di.sweng.lab12.presenter;

import org.jetbrains.annotations.NotNull;

public interface InputPresenter {
  // nel caso della InputView viene invocato con alimento e quantità
  // nel caso delle CommandView viene invocato con la riga e il testo dell'alimento acquistato
  // non è detto che servano per tutte sempre entrambi i parametri
  // a seconda delle volte scelte progettuali potrebbe servire solo uno dei due
  void action(int num, @NotNull String text);
}
