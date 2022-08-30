package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CellView implements FXComponent {
  private Controller controller;
  private int row;
  private int col;
  private Color appearance;

  private static final Color shaded = Color.BLACK;
  private static final Color eliminated = Color.WHITE;
  private static final Color neither = Color.GREY;

  public CellView(Controller controller, int row, int col) {
    this.controller = controller;
    this.row = row;
    this.col = col;
    if (controller.isShaded(row, col)) {
      appearance = shaded;
    } else if (controller.isEliminated(row, col)) {
      appearance = eliminated;
    } else {
      appearance = neither;
    }
  }

  @Override
  public Parent render() {
    Group holder = new Group();
    Rectangle btn = new Rectangle(PuzzleView.COL_WIDTH, PuzzleView.ROW_HEIGHT);
    btn.setFill(appearance);
    btn.setStroke(Color.WHITE);

    btn.setOnMouseClicked(
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
            MouseButton button = event.getButton();
            if (button == MouseButton.PRIMARY) {
              controller.toggleShaded(row, col);
            } else if (button == MouseButton.SECONDARY) {
              controller.toggleEliminated(row, col);
            }
          }
        });

    holder.getChildren().add(btn);
    return holder;
  }
}
