package com.maddyhome.idea.vim.command;


import java.util.EventObject;

public class CommandStateChangeEvent extends EventObject{
  public CommandStateChangeEvent(CommandState commandState) {
    super(commandState);
  }

  public CommandState getCommandState() {
    return (CommandState) this.getSource();
  }
}
