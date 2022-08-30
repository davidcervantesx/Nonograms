package com.comp301.a08nonograms.controller;

import com.comp301.a08nonograms.model.Model;

public interface ControllerObserver {
  /**
   * When a controller is changed, the controller calls update() on all active ControllerObserver
   * objects
   */
  void update(Controller controller);
}
