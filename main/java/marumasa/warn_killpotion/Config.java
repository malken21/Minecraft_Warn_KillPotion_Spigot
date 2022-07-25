package marumasa.warn_killpotion;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public final String text;

    public Config(minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        text = config.getString("text");
    }
}
