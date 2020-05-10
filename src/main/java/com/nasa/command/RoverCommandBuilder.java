package com.nasa.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoverCommandBuilder {

  private RoverCommandBuilder() { // To make static class
  }

  public static List<RoverCommand> build(String commandStr) {

    Objects.requireNonNull(commandStr,"Command string cannot be null");

    List<RoverCommand> roverCommandList = new ArrayList<>();

    commandStr.chars().
        forEach(c -> RoverCommand.create((char) c)
            .ifPresent(roverCommandList::add));

    return roverCommandList;
  }
}
