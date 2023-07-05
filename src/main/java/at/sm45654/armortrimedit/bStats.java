package at.sm45654.armortrimedit;

import org.bstats.bukkit.Metrics;

public class bStats {
    public void registerbStats(ArmorTrimEdit plugin) {
        int pluginId = 18797;
        Metrics metrics = new Metrics(plugin, pluginId);
    }
}
