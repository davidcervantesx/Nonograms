package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class OneRowCluesView implements FXComponent {
  private Controller controller;
  private int row;

  public OneRowCluesView(Controller controller, int row) {
    this.controller = controller;
    this.row = row;
  }

  @Override
  public Parent render() {
    GridPane clues = new GridPane();
    RowConstraints rowConstraints = new RowConstraints(PuzzleView.ROW_HEIGHT + 1);
    rowConstraints.setValignment(VPos.CENTER);
    clues.getRowConstraints().add(rowConstraints);

    int index = 0;
    for (int clueNum : controller.getClues().getRowClues(row)) {
      String clueString = clueNum > 0 ? Integer.toString(clueNum) : " ";
      Text clueText = new Text(" " + clueString + " ");
      clues.add(clueText, index, 0);
      index++;
    }

    return clues;
  }
}
