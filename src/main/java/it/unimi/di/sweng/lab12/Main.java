package it.unimi.di.sweng.lab12;

import it.unimi.di.sweng.lab12.view.CommandView;
import it.unimi.di.sweng.lab12.view.DisplayView;
import it.unimi.di.sweng.lab12.view.InputView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import it.unimi.di.sweng.lab12.presenter.*;

public class Main extends Application {
  //TODO da completare

  public static final int MAX_FOOD = 8;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    primaryStage.setTitle("Grocery List");

    CommandView[] command = new CommandView[2];

    InputView input = new InputView();
    DisplayView display = new DisplayView(MAX_FOOD, "Cose da comprare");
    DisplayView display2 = new DisplayView(MAX_FOOD, "Cose comprate");

    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    gridPane.setPadding(new Insets(10, 10, 10, 10));

    gridPane.add(input, 0, 0);
    GridPane.setColumnSpan(input, GridPane.REMAINING);
    for (int i = 0; i < 2; i++) {
      command[i] = new CommandView("Buy", MAX_FOOD, "Compratore#" + i);
      gridPane.add(command[i], i, 1);
    }

    gridPane.add(display, 0, 2);
    gridPane.add(display2, 1, 2);

    // TODO da completare creando modello e presenter e collegandoli opportunamente
    Model model = new Model();

    InputPresenter formPresenter = new FormPresenter(model, input);
    InputPresenter commandPresenter1 = new CommandPresenter(model, command[0]);
    InputPresenter commandPresenter2 = new CommandPresenter(model, command[1]);
    DisplayPresenter displayPresenter1 = new DisplayPresenter(model, display, new ToBuyStrategy());
    DisplayPresenter displayPresenter2 = new DisplayPresenter(model, display2, new BoughtStrategy());


    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();

    //HINT: utile dopo aver definito model per inizializzare viste
    model.notifyObservers();
  }
}
