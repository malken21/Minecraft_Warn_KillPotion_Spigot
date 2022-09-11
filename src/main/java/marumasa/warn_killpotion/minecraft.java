package marumasa.warn_killpotion;

import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);
        getServer().getPluginManager().registerEvents(new eventListener(this, config), this);
        new tick(this, config).runTaskTimer(this, 1L, 1L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
