package com.nasa.command;

import java.util.Optional;

public enum RoverCommand {
  LEFT('L'), RIGHT('R'), MOVE('M');

  private final char value;

  RoverCommand(char value) {
    this.value = value;
  }

  public static Optional<RoverCommand> create(char command) {

    for (RoverCommand roverCommand : values()) {
      if (roverCommand.value == command) {
        return Optional.of(roverCommand);
      }
    }

    return Optional.empty();

  }
}
