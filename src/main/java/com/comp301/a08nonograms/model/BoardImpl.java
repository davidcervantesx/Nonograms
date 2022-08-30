package com.comp301.a08nonograms.model;

public class BoardImpl implements Board {
  private enum CellCategory {
    SHADED,
    ELIMINATED,
    SPACE
  }

  private final int width;
  private final int height;
  private final CellCategory[][] cells;

  public BoardImpl(int width, int height) {
    if (width < 1 || height < 1) {
      throw new IllegalArgumentException("width or height < 1");
    }

    this.width = width;
    this.height = height;

    cells = new CellCategory[height][width];

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        cells[row][col] = CellCategory.SPACE;
      }
    }
  }

  private boolean inBound(int row, int col) {
    return ((0 <= row) && (row < height) && (0 <= col) && (col < width));
  }

  @java.lang.Override
  public boolean isShaded(int row, int col) {
    if (!inBound(row, col)) {
      throw new IllegalArgumentException();
    }

    return cells[row][col] == CellCategory.SHADED;
  }

  @java.lang.Override
  public boolean isEliminated(int row, int col) {
    if (!inBound(row, col)) {
      throw new IllegalArgumentException();
    }

    return cells[row][col] == CellCategory.ELIMINATED;
  }

  @java.lang.Override
  public boolean isSpace(int row, int col) {
    if (!inBound(row, col)) {
      throw new IllegalArgumentException();
    }

    return cells[row][col] == CellCategory.SPACE;
  }

  @java.lang.Override
  public void toggleCellShaded(int row, int col) {
    if (isShaded(row, col)) {
      cells[row][col] = CellCategory.SPACE;
    } else {
      cells[row][col] = CellCategory.SHADED;
    }
  }

  @java.lang.Override
  public void toggleCellEliminated(int row, int col) {
    if (isEliminated(row, col)) {
      cells[row][col] = CellCategory.SPACE;
    } else {
      cells[row][col] = CellCategory.ELIMINATED;
    }
  }

  @java.lang.Override
  public void clear() {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        cells[row][col] = CellCategory.SPACE;
      }
    }
  }
}
