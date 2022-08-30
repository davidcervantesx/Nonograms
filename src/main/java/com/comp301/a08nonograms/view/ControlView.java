package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ControlView implements FXComponent {
  Controller controller;

  public ControlView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox controls = new VBox();
    controls.setAlignment(Pos.CENTER);

    String currentPuzzle = Integer.toString(controller.getPuzzleIndex() + 1);
    String totalPuzzles = Integer.toString(controller.getPuzzleCount());
    Text puzzleInfo = new Text("Puzzle " + currentPuzzle + "/" + totalPuzzles);
    puzzleInfo.setStyle("-fx-font: 24 arial;");
    controls.getChildren().add(puzzleInfo);

    Button prev = new Button("Previous");
    prev.setOnAction(
        (ActionEvent event) -> {
          controller.prevPuzzle();
        });
    controls.getChildren().add(prev);

    Button next = new Button("next");
    next.setOnAction(
        (ActionEvent event) -> {
          controller.nextPuzzle();
        });
    controls.getChildren().add(next);

    Button random = new Button("Random");
    random.setOnAction(
        (ActionEvent event) -> {
          controller.randPuzzle();
        });
    controls.getChildren().add(random);

    Button clear = new Button("Clear");
    clear.setOnAction(
        (ActionEvent event) -> {
          controller.clearBoard();
        });
    controls.getChildren().add(clear);

    return controls;
  }
}
