package marumasa.warn_killpotion;

import marumasa.warn_killpotion.Meta.getMeta;
import marumasa.warn_killpotion.Meta.setMeta;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class eventListener implements Listener {

    private final minecraft mc;
    private final Config con;

    eventListener(minecraft minecraft, Config config) {
        mc = minecraft;
        con = config;
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        for (Player player : mc.getServer().getOnlinePlayers()) {

            if (!(boolean) getMeta.get(player, mc, "hasPotion", false)) continue;

            String name = player.getName();
            if (con.text == null) return;
            String message = String.format(con.text, name);
            event.getPlayer().sendMessage(message);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        setMeta.set(event.getPlayer(), mc, "hasPotion", false);
    }
}