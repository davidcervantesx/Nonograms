package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MessageView implements FXComponent {
  Controller controller;

  public MessageView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    Group holder = new Group();

    if (controller.isSolved()) {
      Text solvedText = new Text("You Solved the Puzzle!");
      solvedText.setFill(Color.GREEN);
      solvedText.setStyle("-fx-font: 32 arial;");
      holder.getChildren().add(solvedText);
    }

    return holder;
  }
}
