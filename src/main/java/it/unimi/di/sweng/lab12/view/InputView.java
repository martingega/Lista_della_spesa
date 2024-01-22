package it.unimi.di.sweng.lab12.view;

import it.unimi.di.sweng.lab12.presenter.InputPresenter;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

public class InputView extends Region {
  final TextField text = new TextField();
  final TextField num = new TextField();
  final Button addButton = new Button("Add");


  public InputView() {
    setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));


    num.setPrefColumnCount(2);
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.add(text, 0, 0);
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.add(num, 1, 0);
    grid.add(addButton, 0, 1);

    this.getChildren().add(grid);
  }

  public void addHandlers(@NotNull InputPresenter presenter) {
    addButton.setOnAction(eh -> presenter.action(Integer.parseInt(num.getText()), text.getText()));
  }

}
