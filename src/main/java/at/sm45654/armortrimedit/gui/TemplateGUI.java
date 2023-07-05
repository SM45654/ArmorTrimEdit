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

public class TemplateGUI implements Listener {

    public static Inventory templategui;

    public static Material template = Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE;
    public static void gui() {
        templategui = Bukkit.createInventory(null, 27, ChatUtil.YELLOW + "ArmorTrimEdit");
        createItems();
    }

    public static void createItems() {

        templategui.setItem(0, guiItem(ChatUtil.YELLOW + "Sentry", Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(1, guiItem(ChatUtil.YELLOW + "Dune", Material.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(2, guiItem(ChatUtil.YELLOW + "Wild", Material.WILD_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(3, guiItem(ChatUtil.YELLOW + "Coast", Material.COAST_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(4, guiItem(ChatUtil.YELLOW + "Vex", Material.VEX_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(5, guiItem(ChatUtil.YELLOW + "Ward", Material.WARD_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(6, guiItem(ChatUtil.YELLOW + "Silence", Material.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(7, guiItem(ChatUtil.YELLOW + "Tide", Material.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(8, guiItem(ChatUtil.YELLOW + "Snout", Material.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(9, guiItem(ChatUtil.YELLOW + "Rib", Material.RIB_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(10, guiItem(ChatUtil.YELLOW + "Eye", Material.EYE_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(11, guiItem(ChatUtil.YELLOW + "Spire", Material.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(12, guiItem(ChatUtil.YELLOW + "Host", Material.HOST_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(13, guiItem(ChatUtil.YELLOW + "Shaper", Material.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(14, guiItem(ChatUtil.YELLOW + "Raiser", Material.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE));
        templategui.setItem(15, guiItem(ChatUtil.YELLOW + "Wayfinder", Material.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE));
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
        if (!(e.getInventory().equals(templategui))) return;
        e.setCancelled(true);
        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType().isAir()) return;
        final Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);

        template = clickedItem.getType();
        EditGUI.open(p);
        }


    @EventHandler
    public void onInventoryClick (final InventoryDragEvent e){
        if (e.getInventory().equals(templategui)) {
            e.setCancelled(true);
        }
    }
}




