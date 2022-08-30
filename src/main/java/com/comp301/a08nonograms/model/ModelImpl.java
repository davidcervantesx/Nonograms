package com.comp301.a08nonograms.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ModelImpl implements Model {
  List<Puzzle> puzzles;
  int currentPuzzleIndex;
  List<ModelObserver> observers;

  public ModelImpl(List<Clues> clues) {
    if (clues == null || clues.size() == 0) {
      throw new IllegalArgumentException();
    }

    puzzles = new ArrayList<>();
    for (Clues clueSet : clues) {
      puzzles.add(new PuzzleImpl(clueSet));
    }
    currentPuzzleIndex = 0;

    observers = new LinkedList<>();
  }

  private void updateObservers() {
    for (ModelObserver o : observers) {
      o.update(this);
    }
  }

  @Override
  public int getPuzzleCount() {
    return puzzles.size();
  }

  @Override
  public int getPuzzleIndex() {
    return currentPuzzleIndex;
  }

  @Override
  public void setPuzzleIndex(int index) {
    if (index < 0) {
      index = 0;
    } else if (index >= getPuzzleCount()) {
      index = getPuzzleCount() - 1;
    }

    currentPuzzleIndex = index;
    updateObservers();
  }

  @Override
  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  @Override
  public boolean isSolved() {
    return puzzles.get(currentPuzzleIndex).isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return puzzles.get(currentPuzzleIndex).isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return puzzles.get(currentPuzzleIndex).isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return puzzles.get(currentPuzzleIndex).isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    puzzles.get(currentPuzzleIndex).toggleCellShaded(row, col);
    updateObservers();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    puzzles.get(currentPuzzleIndex).toggleCellEliminated(row, col);
    updateObservers();
  }

  @Override
  public void clear() {
    puzzles.get(currentPuzzleIndex).clear();
    updateObservers();
  }

  @Override
  public int getWidth() {
    return puzzles.get(currentPuzzleIndex).getWidth();
  }

  @Override
  public int getHeight() {
    return puzzles.get(currentPuzzleIndex).getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return puzzles.get(currentPuzzleIndex).getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return puzzles.get(currentPuzzleIndex).getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return puzzles.get(currentPuzzleIndex).getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return puzzles.get(currentPuzzleIndex).getColCluesLength();
  }
}
