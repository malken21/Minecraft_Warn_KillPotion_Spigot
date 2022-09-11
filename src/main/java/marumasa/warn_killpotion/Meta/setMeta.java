package marumasa.warn_killpotion.Meta;

import marumasa.warn_killpotion.minecraft;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class setMeta {
    public static void set(Player player, minecraft minecraft, String key, Object object) {
        player.setMetadata(key, new FixedMetadataValue(
                minecraft,
                object
        ));
    }
}
