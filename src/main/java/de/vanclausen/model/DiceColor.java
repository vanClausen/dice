package de.vanclausen.model;

public enum DiceColor {
  WHITE("#ffffff"),
  BLUE("#0000ff"),
  RED("#ff0000"),
  BLACK("#000000");
  private final String hexColor;
  DiceColor( String hexColor ) {
    this.hexColor = hexColor;
  }

  public String getHexColor() {
    return hexColor;
  }
}
