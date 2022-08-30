package com.comp301.a08nonograms.controller;

import com.comp301.a08nonograms.model.Clues;
import com.comp301.a08nonograms.model.Model;
import com.comp301.a08nonograms.model.ModelObserver;

import java.util.LinkedList;
import java.util.List;

public class ControllerImpl implements Controller {
  Model model;
  List<ControllerObserver> observers;

  public ControllerImpl(Model model) {
    this.model = model;

    observers = new LinkedList<>();
    model.addObserver(this);
  }

  @Override
  public void update(Model model) {
    updateObservers();
  }

  @Override
  public Clues getClues() {
    return model;
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return model.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return model.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    model.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    model.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    int nextIndex = model.getPuzzleIndex() + 1;

    if (nextIndex >= model.getPuzzleCount()) {
      nextIndex = 0;
    }

    model.setPuzzleIndex(nextIndex);
  }

  @Override
  public void prevPuzzle() {
    int prevIndex = model.getPuzzleIndex() - 1;

    if (prevIndex < 0) {
      prevIndex = model.getPuzzleCount() - 1;
    }

    model.setPuzzleIndex(prevIndex);
  }

  @Override
  public void randPuzzle() {
    int randomNum = (int) (Math.random() * model.getPuzzleCount());
    model.setPuzzleIndex(randomNum);
  }

  @Override
  public void clearBoard() {
    model.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return model.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return model.getPuzzleCount();
  }

  private void updateObservers() {
    for (ControllerObserver o : observers) {
      o.update(this);
    }
  }

  @Override
  public void addObserver(ControllerObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ControllerObserver observer) {
    observers.remove(observer);
  }
}
