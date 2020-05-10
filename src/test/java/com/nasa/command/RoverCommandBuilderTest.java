package com.nasa.command;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoverCommandBuilderTest {

  @Test(expected = NullPointerException.class)
  public void build_nullCommandStr() {
    RoverCommandBuilder.build(null);
  }

  @Test()
  public void build_emptyStr() {
    List<RoverCommand> commandList = RoverCommandBuilder.build("");
    assertNotNull(commandList);
    assertEquals(0,commandList.size());
  }

  @Test
  public void build() {
    List<RoverCommand> commandList = RoverCommandBuilder.build("LMLMLMLMM");

    assertNotNull(commandList);
    assertEquals(9, commandList.size());
    assertEquals(RoverCommand.LEFT, commandList.get(0));
    assertEquals(RoverCommand.MOVE, commandList.get(8));
  }

  @Test
  public void build_unknownChar_skipped() {
    List<RoverCommand> commandList = RoverCommandBuilder.build("LABC");

    assertNotNull(commandList);
    assertEquals(1, commandList.size());
    assertEquals(RoverCommand.LEFT, commandList.get(0));

  }
}
