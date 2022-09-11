package marumasa.warn_killpotion.Meta;

import marumasa.warn_killpotion.minecraft;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class getMeta {
    public static Object get(Player player, minecraft minecraft, String key, Object object) {
        if (player.hasMetadata(key)) {
            List<MetadataValue> values = player.getMetadata(key);
            for (MetadataValue data : values) {
                Plugin plugin = data.getOwningPlugin();
                if (plugin == null)continue;
                if (plugin.getName().equals(minecraft.getName())) {
                    return data.value();
                }
            }
        } else {
            setMeta.set(player, minecraft, key, object);
        }
        return object;
    }
}
