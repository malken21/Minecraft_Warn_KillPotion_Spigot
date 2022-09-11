package marumasa.warn_killpotion;

import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import java.util.List;

public class potion {
    public static boolean check(PotionMeta meta) {
        if (meta == null) return false;
        List<PotionEffect> effectList = meta.getCustomEffects();
        for (PotionEffect effect : effectList) {
            final String name = effect.getType().getName();
            if (name.equals("HEAL") || name.equals("HARM")) {
                if (Amplifier(effect.getAmplifier())) return true;
            }
        }
        return false;
    }

    public static boolean Amplifier(int effect) {
        return effect == 29 || effect == 61 || effect == 93 || effect == 125;
    }
}
