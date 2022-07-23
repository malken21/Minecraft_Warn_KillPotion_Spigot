package marumasa.warn_killpotion;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class tick extends BukkitRunnable {

    private final minecraft mc;
    private final Config config;
    private final List<UUID> hasPotionList = new ArrayList<>();

    public tick(minecraft minecraft, Config con) {
        mc = minecraft;
        config = con;
    }

    public void run() {

        Collection<? extends Player> players = mc.getServer().getOnlinePlayers();

        for (Player player : players) {
            boolean hasPotion = false;
            Inventory inventory = player.getInventory();
            ItemStack[] itemStacks = inventory.getContents();
            for (ItemStack itemStack : itemStacks) {
                if (itemStack == null) continue;
                Material type = itemStack.getType();
                if (type == Material.POTION || type == Material.LINGERING_POTION || type == Material.SPLASH_POTION) {
                    if (potion.check((PotionMeta) itemStack.getItemMeta())) {
                        hasPotion = true;
                        break;
                    }
                }
            }

            if (hasPotion) {
                if (hasPotionList.contains(player.getUniqueId())) continue;
                String name = player.getName();
                if (config.text == null) return;
                String message = String.format(config.text, name);
                Bukkit.broadcastMessage(message);
                hasPotionList.add(player.getUniqueId());
            } else {
                hasPotionList.remove(player.getUniqueId());
            }
        }
    }
}
