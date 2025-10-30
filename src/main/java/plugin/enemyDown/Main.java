package plugin.enemyDown;

import plugin.enemyDown.Command.EnemyDownCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

  @Override
  public void onEnable() {
    EnemyDownCommand enemyDownCommand = new EnemyDownCommand(this);
    Bukkit.getPluginManager().registerEvents(enemyDownCommand, this);
    getCommand("enemyDown").setExecutor(enemyDownCommand);

  }




}
