package org.example.plugin.sample3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

public final class Main extends JavaPlugin implements Listener {

  private int count;

  @Override
  public void onEnable() {
    saveConfig();
    getConfig().getString("Message");

    Bukkit.getPluginManager().registerEvents(this, this);
    getCommand("setLevel").setExecutor(new SetLevelCommand(this));
    getCommand("setweather").setExecutor(new SetWeather());
    getCommand("allsetlevel").setExecutor(new AllSetLevelCommand());
  }

@EventHandler
public void onJoinPlayer(PlayerJoinEvent e){
  Player player = e.getPlayer();
  World world = player.getWorld();
  Location playerLocation = player.getLocation();

  /** ログイン時に鳥が出現。
   *
   */
  world.spawn(
      new Location(world,
          playerLocation.getX() + 3,
          playerLocation.getY(),
          playerLocation.getZ()),Chicken.class);

  /** ログイン時にブロックが出現。
   *
   */
  world.getBlockAt(
      new Location(world,
          playerLocation.getX() + 3,
          playerLocation.getY(),
          playerLocation.getZ())).setType(Material.GOLD_BLOCK);



}


  /**ログイン時にメッセージが表示されるようになる。
   *
   * @param event
   */
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    player.sendMessage("ようこそ、" + player.getName() + " さん！");
  }




  
}
