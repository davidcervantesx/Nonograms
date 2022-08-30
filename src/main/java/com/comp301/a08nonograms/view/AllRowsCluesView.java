package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

public class AllRowsCluesView implements FXComponent {
  Controller controller;

  public AllRowsCluesView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane clues = new GridPane();
    ColumnConstraints columnConstraints = new ColumnConstraints();
    columnConstraints.setHalignment(HPos.RIGHT);
    clues.getColumnConstraints().add(columnConstraints);

    for (int row = 0; row < controller.getClues().getHeight(); row++) {
      OneRowCluesView clue = new OneRowCluesView(controller, row);
      clues.add(clue.render(), 0, row);
    }

    return clues;
  }
}
