package org.example.plugin.sample3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.World;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sample3 extends JavaPlugin implements Listener {

  private int count;

  @Override
  public void onEnable() {
    Bukkit.getPluginManager().registerEvents(this, this);


  }




  /**
   * プレイヤーがスニークを開始/終了する際に起動されるイベントハンドラ。
   *
   * @param e イベント
   */
  @EventHandler
  public void onPlayerToggleSneak(PlayerToggleSneakEvent e) throws IOException {
    // イベント発生時のプレイヤーやワールドなどの情報を変数に持つ。
    Player player = e.getPlayer();
    World world = player.getWorld();

    if (count % 2 == 0) {

      // 花火オブジェクトをプレイヤーのロケーション地点に対して出現させる。
      Firework firework = world.spawn(player.getLocation(), Firework.class);

      // 花火オブジェクトが持つメタ情報を取得。
      FireworkMeta fireworkMeta = firework.getFireworkMeta();

      // 今回は青色で星型の花火を打ち上げる。
      fireworkMeta.addEffect(
          FireworkEffect.builder()
              .withColor(Color.RED)
              .withColor(Color.WHITE)
              .with(Type.BALL_LARGE)
              .withFlicker()
              .build());
      fireworkMeta.setPower(3);

      // 追加した情報で再設定する。
      firework.setFireworkMeta(fireworkMeta);

      Path path = Path.of("firework.txt");
      Files.writeString(path, "たまーやー");
      player.sendMessage(Files.readString(path));

    }

    count++;

  }


}
