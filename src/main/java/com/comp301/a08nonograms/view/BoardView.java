package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class BoardView implements FXComponent {
  private Controller controller;
  private int width;
  private int height;

  public BoardView(Controller controller) {
    this.controller = controller;
    this.width = controller.getClues().getWidth();
    this.height = controller.getClues().getHeight();
  }

  @Override
  public Parent render() {
    TilePane board = new TilePane();

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        CellView cell = new CellView(controller, row, col);
        board.getChildren().add(cell.render());
      }
    }
    board.setPrefColumns(width);

    return board;
  }
}
