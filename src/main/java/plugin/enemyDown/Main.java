package plugin.enemyDown;

import plugin.enemyDown.Command.EnemyDownCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemyDown.Command.EnemySpawnCommand;

public final class Main extends JavaPlugin {

  @Override
  public void onEnable() {
    EnemyDownCommand enemyDownCommand = new EnemyDownCommand(this);
    EnemySpawnCommand enemySpawnCommand = new EnemySpawnCommand(this);
    Bukkit.getPluginManager().registerEvents(enemyDownCommand, this);
    getCommand("enemyDown").setExecutor(enemyDownCommand);
    getCommand("enemySpawn").setExecutor(enemySpawnCommand);
  }




}
