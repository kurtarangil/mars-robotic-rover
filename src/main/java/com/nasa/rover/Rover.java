package com.nasa.rover;

import com.nasa.command.RoverCommand;

import java.util.List;

public interface Rover {

  void execute(List<RoverCommand> commandList);

  String getCurrentPositionInfo();
}
