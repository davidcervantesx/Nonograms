package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

public class AllColumnsCluesView implements FXComponent {
  Controller controller;

  public AllColumnsCluesView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane columns = new GridPane();
    columns.setAlignment(Pos.BASELINE_CENTER);

    for (int colNum = 0; colNum < controller.getClues().getWidth(); colNum++) {
      OneColumnCluesView colView = new OneColumnCluesView(controller, colNum);
      columns.add(colView.render(), colNum, 0);
    }

    return columns;
  }
}
