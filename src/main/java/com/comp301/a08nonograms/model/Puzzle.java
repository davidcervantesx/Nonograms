package com.comp301.a08nonograms.model;

public interface Puzzle extends Board, Clues {
  /** Returns true only if the puzzle is solved */
  boolean isSolved();
}
