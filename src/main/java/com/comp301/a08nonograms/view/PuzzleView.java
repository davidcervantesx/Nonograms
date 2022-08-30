package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PuzzleView implements FXComponent {
  public static double COL_WIDTH = 40;
  public static double ROW_HEIGHT = 40;
  private Controller controller;

  public PuzzleView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    AllColumnsCluesView colsCluesView = new AllColumnsCluesView(controller);
    AllRowsCluesView rowsCluesView = new AllRowsCluesView(controller);
    BoardView board = new BoardView(controller);

    GridPane p = new GridPane();

    p.add(colsCluesView.render(), 1, 0);
    p.add(rowsCluesView.render(), 0, 1);
    p.add(board.render(), 1, 1);
    return p;
  }
}
