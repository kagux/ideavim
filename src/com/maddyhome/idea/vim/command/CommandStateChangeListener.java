package com.maddyhome.idea.vim.command;


import java.util.EventListener;

public interface CommandStateChangeListener extends EventListener {
  public void commandStateChange(CommandStateChangeEvent event);
}
