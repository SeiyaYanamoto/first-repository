package plugin.enemyDown;

import java.util.Objects;
import plugin.enemyDown.Command.EnemyDownCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.enemyDown.Command.EnemySpawnCommand;

public final class Main extends JavaPlugin {

  @Override
  public void onEnable() {
    EnemyDownCommand enemyDownCommand = new EnemyDownCommand(this);
    EnemySpawnCommand enemySpawnCommand = new EnemySpawnCommand(this);
    Bukkit.getPluginManager().registerEvents(enemyDownCommand, this);
    Objects.requireNonNull(getCommand("enemyDown")).setExecutor(enemyDownCommand);
    Objects.requireNonNull(getCommand("enemySpawn")).setExecutor(enemySpawnCommand);
  }




}
