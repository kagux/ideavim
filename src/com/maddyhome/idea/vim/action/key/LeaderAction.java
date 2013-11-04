package com.maddyhome.idea.vim.action.key;

import com.intellij.openapi.actionSystem.*;
import com.maddyhome.idea.vim.action.AbstractDelegateAction;
import com.maddyhome.idea.vim.command.CommandStateChangeEvent;
import com.maddyhome.idea.vim.command.CommandStateChangeListener;
import com.maddyhome.idea.vim.key.KeyParser;
import org.jetbrains.annotations.NotNull;

public class LeaderAction extends AbstractDelegateAction implements CommandStateChangeListener{

  public LeaderAction(@NotNull AnAction origAction) {
    super(origAction);
    this.origShortcutSet = origAction.getShortcutSet();
  }

  @Override
  public void actionPerformed(AnActionEvent anActionEvent) {
    this.getOrigAction().actionPerformed(anActionEvent);
  }

  @Override
  public void commandStateChange(CommandStateChangeEvent event) {
    ShortcutSet shortcutSet = isLeaderEnabled(event) ? this.origShortcutSet : new CustomShortcutSet();
    this.setShortcutSet(shortcutSet);
  }

  private boolean isLeaderEnabled(CommandStateChangeEvent event) {
    return event.getCommandState().getMappingMode() != KeyParser.MAPPING_INSERT;
  }

  private ShortcutSet origShortcutSet;
}
