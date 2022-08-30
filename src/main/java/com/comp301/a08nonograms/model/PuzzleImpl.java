package com.comp301.a08nonograms.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleImpl implements Puzzle {
  private final Clues clues;
  private final Board board;

  public PuzzleImpl(Clues clues) {
    this.clues = clues;
    this.board = new BoardImpl(clues.getWidth(), clues.getHeight());
  }

  private boolean rowMatchesClues(int index) {
    int[] rowInfo = new int[getRowCluesLength()];
    int rowInfoIndex = rowInfo.length - 1;

    for (int col = getWidth() - 1; col >= 0; col--) {
      if (isShaded(index, col)) {
        if (rowInfoIndex < 0) {
          return false; // too many clues
        }
        ++rowInfo[rowInfoIndex];
      } else {
        if (rowInfoIndex >= 0) {
          if (rowInfo[rowInfoIndex] > 0) {
            --rowInfoIndex;
          }
        }
      }
    }

    return Arrays.equals(getRowClues(index), rowInfo);
  }

  private boolean allRowsMatchClues() {
    for (int row = 0; row < getHeight(); row++) {
      if (!rowMatchesClues(row)) {
        return false;
      }
    }
    return true;
  }

  private boolean colMatchesClues(int index) {
    int[] colInfo = new int[getColCluesLength()];
    int colInfoIndex = colInfo.length - 1;

    for (int row = getHeight() - 1; row >= 0; row--) {
      if (isShaded(row, index)) {
        if (colInfoIndex < 0) {
          return false; // too many clues.
        }
        ++colInfo[colInfoIndex];
      } else {
        if (colInfoIndex >= 0) {
          if (colInfo[colInfoIndex] > 0) {
            --colInfoIndex;
          }
        }
      }
    }

    return Arrays.equals(getColClues(index), colInfo);
  }

  private boolean allColMatchClues() {
    for (int col = 0; col < getWidth(); col++) {
      if (!colMatchesClues(col)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isSolved() {
    return allRowsMatchClues() && allColMatchClues();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return board.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return board.isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return board.isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    board.toggleCellShaded(row, col);
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    board.toggleCellEliminated(row, col);
  }

  @Override
  public void clear() {
    board.clear();
  }

  @Override
  public int getWidth() {
    return clues.getWidth();
  }

  @Override
  public int getHeight() {
    return clues.getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return clues.getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return clues.getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return clues.getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return clues.getColCluesLength();
  }
}
