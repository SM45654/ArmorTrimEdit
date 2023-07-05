package at.sm45654.armortrimedit.gui;

import at.sm45654.armortrimedit.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static at.sm45654.armortrimedit.util.ChatUtil.*;
public class DyeMaterialGUI implements Listener {

    public static Inventory dyegui;

        public static Material dyeMaterial = Material.EMERALD;

    public static void gui() {
        dyegui = Bukkit.createInventory(null, 27, ChatUtil.YELLOW + "ArmorTrimEdit");
        createItems();
    }

    public static void createItems() {

        dyegui.setItem(0, guiItem(YELLOW + "Iron", Material.IRON_INGOT));
        dyegui.setItem(1, guiItem(YELLOW + "Gold", Material.GOLD_INGOT));
        dyegui.setItem(2, guiItem(YELLOW + "Copper", Material.COPPER_INGOT));
        dyegui.setItem(3, guiItem(YELLOW + "Netherite", Material.NETHERITE_INGOT));
        dyegui.setItem(4, guiItem(YELLOW + "Diamond", Material.DIAMOND));
        dyegui.setItem(5, guiItem(YELLOW + "Emerald", Material.EMERALD));
        dyegui.setItem(6, guiItem(YELLOW + "Redstone", Material.REDSTONE));
        dyegui.setItem(7, guiItem(YELLOW + "Lapis", Material.LAPIS_LAZULI));
        dyegui.setItem(8, guiItem(YELLOW + "Amethyst", Material.AMETHYST_SHARD));
        dyegui.setItem(9, guiItem(YELLOW + "Quartz", Material.QUARTZ));
    }

    protected static ItemStack guiItem(String name, Material material) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);

        return item;
    }


    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (!(e.getInventory().equals(dyegui))) return;
        e.setCancelled(true);
        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType().isAir()) return;
        final Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);

        dyeMaterial = clickedItem.getType();
        EditGUI.open(p);
    }


    @EventHandler
    public void onInventoryClick (final InventoryDragEvent e){
        if (e.getInventory().equals(dyegui)) {
            e.setCancelled(true);
        }
    }
}



