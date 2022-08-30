package com.comp301.a08nonograms.model;

public class CluesImpl implements Clues {

  private final int width;
  private final int height;
  private final int[][] rowClues;
  private final int[][] colClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    if (rowClues == null || colClues == null) {
      throw new IllegalArgumentException("Null parameters");
    } else if (rowClues.length == 0 || colClues.length == 0) {
      throw new IllegalArgumentException("No row or column clues");
    } else if (rowClues[0].length == 0 || colClues[0].length == 0) {
      throw new IllegalArgumentException("Row or column has clues, but no width");
    }

    this.colClues = colClues.clone();
    this.rowClues = rowClues.clone();
    this.width = colClues.length;
    this.height = rowClues.length;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int[] getRowClues(int index) {
    if ((0 <= index) && (index < getHeight())) {
      return rowClues[index].clone();
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public int[] getColClues(int index) {
    if ((0 <= index) && (index < getWidth())) {
      return colClues[index].clone();
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public int getRowCluesLength() {
    return rowClues[0].length;
  }

  @Override
  public int getColCluesLength() {
    return colClues[0].length;
  }
}
