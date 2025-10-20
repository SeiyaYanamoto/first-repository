package org.example.plugin.sample3;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AllSetLevelCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
    if (sender instanceof Player player) {
      player.sendMessage("実行できませんでした");
    } else {
      for (Player player : sender.getServer().getOnlinePlayers()){
        player.setLevel(Integer.parseInt(args[0]));
        System.out.println("プレイヤーのレベルが" + args[0] + "になりました");
      }
    }
    return false;
  }
}
