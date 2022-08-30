package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.PuzzleLibrary;
import com.comp301.a08nonograms.controller.Controller;
import com.comp301.a08nonograms.controller.ControllerImpl;
import com.comp301.a08nonograms.controller.ControllerObserver;
import com.comp301.a08nonograms.model.Model;
import com.comp301.a08nonograms.model.ModelImpl;
import com.comp301.a08nonograms.model.ModelObserver;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View implements ControllerObserver {
  Stage stage;

  public View(Stage stage, Controller controller) {
    this.stage = stage;
    controller.addObserver(this);
  }

  @Override
  public void update(Controller controller) {

    PuzzleView puzzleView = new PuzzleView(controller);
    Parent renderedPuzzleView = puzzleView.render();

    ControlView controlView = new ControlView(controller);
    Parent renderedControlView = controlView.render();

    MessageView messageView = new MessageView(controller);
    Parent renderedMessageView = messageView.render();

    AnchorPane root = new AnchorPane(renderedPuzzleView, renderedControlView, renderedMessageView);
    AnchorPane.setLeftAnchor(renderedPuzzleView, 10.0);
    AnchorPane.setRightAnchor(renderedControlView, 10.0);
    AnchorPane.setBottomAnchor(renderedMessageView, 10.0);

    Scene scene = new Scene(root, 800, 800);
    stage.setScene(scene);
    stage.show();
  }
}
