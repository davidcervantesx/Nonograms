package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class OneColumnCluesView implements FXComponent {
  private Controller controller;
  private int col;

  public OneColumnCluesView(Controller controller, int col) {
    this.controller = controller;
    this.col = col;
  }

  @Override
  public Parent render() {
    GridPane clues = new GridPane();
    ColumnConstraints columnConstraint = new ColumnConstraints(PuzzleView.COL_WIDTH + 1);
    columnConstraint.setHalignment(HPos.CENTER);
    clues.getColumnConstraints().add(columnConstraint);

    int index = 0;
    for (int clueNum : controller.getClues().getColClues(col)) {
      String clueString = clueNum > 0 ? Integer.toString(clueNum) : " ";
      Text clueText = new Text(clueString);
      clues.add(clueText, 0, index);
      index++;
    }

    return clues;
  }
}
