package com.nasa;

public enum CompassPoint {
  NORTH('N') {
    @Override public CompassPoint left() {
      return WEST;
    }

    @Override public CompassPoint right() {
      return EAST;
    }
  }, SOUTH('S') {
    @Override public CompassPoint left() {
      return EAST;
    }

    @Override public CompassPoint right() {
      return WEST;
    }
  }, EAST('E') {
    @Override public CompassPoint left() {
      return NORTH;
    }

    @Override public CompassPoint right() {
      return SOUTH;
    }
  }, WEST('W') {
    @Override public CompassPoint left() {
      return SOUTH;
    }

    @Override public CompassPoint right() {
      return NORTH;
    }
  };

  private final char value;

  CompassPoint(char value) {
    this.value = value;
  }

  public abstract CompassPoint left();

  public abstract CompassPoint right();

  public char getValue() {
    return value;
  }

  @Override public String toString() {
    return value + "";
  }
}

