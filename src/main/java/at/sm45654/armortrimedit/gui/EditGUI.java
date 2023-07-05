package at.sm45654.armortrimedit.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import java.util.Objects;

import static at.sm45654.armortrimedit.ArmorTrimEdit.*;
import static at.sm45654.armortrimedit.util.ChatUtil.*;

public class EditGUI implements Listener {
    public static Inventory editgui;

    public static void gui(Player user) {
        editgui = Bukkit.createInventory(user, 9, LIGHT_BLUE + "§lArmorTrimEdit");
        createItems();
    }

    public static void createItems() {

            editgui.setItem(0, guiItem(YELLOW + "Select Template", Objects.requireNonNull(TemplateGUI.template)));
            editgui.setItem(1, guiItem(YELLOW + "Select Dye Material", Objects.requireNonNull(DyeMaterialGUI.dyeMaterial)));
            editgui.setItem(8, guiItem(LIGHT_GREEN + "Set Armor Trim", Material.NETHERITE_PICKAXE));
            editgui.setItem(7, guiItem(RED + "Remove Armor Trim", Material.BARRIER));
            editgui.setItem(3, guiItem("§8§lX", Material.GRAY_STAINED_GLASS_PANE));
            editgui.setItem(4, guiItem("§8§lX", Material.GRAY_STAINED_GLASS_PANE));
            editgui.setItem(5, guiItem("§8§lX", Material.GRAY_STAINED_GLASS_PANE));
            editgui.setItem(6, guiItem("§8§lX", Material.GRAY_STAINED_GLASS_PANE));
            editgui.setItem(2, guiItem("§8§lX", Material.GRAY_STAINED_GLASS_PANE));
        }

        public static void open(Player p){
            gui(p);
            editgui.setItem(4, guiItem(LIGHT_BLUE + String.valueOf(p.getInventory().getItemInMainHand().getType()), p.getInventory().getItemInMainHand().getType()));
            p.openInventory(editgui);
        }


        protected static ItemStack guiItem(String name, Material material){
            ItemStack item = new ItemStack(material, 1);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(name);
            item.setItemMeta(meta);

            return item;
        }


    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (!(e.getInventory().equals(editgui))) return;
        e.setCancelled(true);
        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType().isAir()) return;
        final Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if (clickedItem.getItemMeta().getDisplayName().contains("Select Template")) {
            p.openInventory(TemplateGUI.templategui);
        } else if (clickedItem.getItemMeta().getDisplayName().contains("Select Dye Material")) {
            p.openInventory(DyeMaterialGUI.dyegui);

        } else if (clickedItem.getType() == Material.BARRIER) {
            ArmorMeta meta = (ArmorMeta) e.getWhoClicked().getInventory().getItemInMainHand().getItemMeta();
            if (!e.getWhoClicked().hasPermission("armortrimedit.remove")) {
                p.sendMessage(prefix + RED + "ERROR: You are not allowed to remove Armor Trims!");
            } else {
                if (meta.hasTrim()) {
                    meta.setTrim(null);
                    e.getWhoClicked().getInventory().getItemInMainHand().setItemMeta(meta);
                    e.getWhoClicked().closeInventory();
                    p.sendMessage(prefix + LIGHT_GREEN + "Armor Trim successfully removed!");
                } else {
                    p.sendMessage(prefix + RED + "ERROR: Item has no Armor Trims");
                }
            }
        } else if (clickedItem.getType() == Material.NETHERITE_PICKAXE) {
            if (!e.getWhoClicked().hasPermission("armortrimedit.add")) {
                p.sendMessage(prefix + RED + "ERROR: You are not allowed to add Armor Trims!");
            } else {
                e.getWhoClicked().closeInventory();
                final ArmorMeta armorMeta = (ArmorMeta) e.getWhoClicked().getInventory().getItemInMainHand().getItemMeta();

                TrimMaterial trimMaterial = null;

                if (DyeMaterialGUI.dyeMaterial == Material.IRON_INGOT) {
                    trimMaterial = TrimMaterial.IRON;
                } else if (DyeMaterialGUI.dyeMaterial == Material.GOLD_INGOT) {
                    trimMaterial = TrimMaterial.GOLD;
                } else if (DyeMaterialGUI.dyeMaterial == Material.COPPER_INGOT) {
                    trimMaterial = TrimMaterial.COPPER;
                } else if (DyeMaterialGUI.dyeMaterial == Material.NETHERITE_INGOT) {
                    trimMaterial = TrimMaterial.NETHERITE;
                } else if (DyeMaterialGUI.dyeMaterial == Material.REDSTONE) {
                    trimMaterial = TrimMaterial.REDSTONE;
                } else if (DyeMaterialGUI.dyeMaterial == Material.LAPIS_LAZULI) {
                    trimMaterial = TrimMaterial.LAPIS;
                } else if (DyeMaterialGUI.dyeMaterial == Material.EMERALD) {
                    trimMaterial = TrimMaterial.EMERALD;
                } else if (DyeMaterialGUI.dyeMaterial == Material.QUARTZ) {
                    trimMaterial = TrimMaterial.QUARTZ;
                } else if (DyeMaterialGUI.dyeMaterial == Material.AMETHYST_SHARD) {
                    trimMaterial = TrimMaterial.AMETHYST;
                } else if (DyeMaterialGUI.dyeMaterial == Material.DIAMOND) {
                    trimMaterial = TrimMaterial.DIAMOND;
                }


                TrimPattern template = null;

                if (TemplateGUI.template == Material.COAST_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.COAST;
                } else if (TemplateGUI.template == Material.EYE_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.EYE;
                } else if (TemplateGUI.template == Material.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.DUNE;
                } else if (TemplateGUI.template == Material.RIB_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.RIB;
                } else if (TemplateGUI.template == Material.HOST_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.HOST;
                } else if (TemplateGUI.template == Material.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.RAISER;
                } else if (TemplateGUI.template == Material.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.SENTRY;
                } else if (TemplateGUI.template == Material.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.SHAPER;
                } else if (TemplateGUI.template == Material.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.SILENCE;
                } else if (TemplateGUI.template == Material.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.SNOUT;
                } else if (TemplateGUI.template == Material.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.SPIRE;
                } else if (TemplateGUI.template == Material.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.TIDE;
                } else if (TemplateGUI.template == Material.VEX_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.VEX;
                } else if (TemplateGUI.template == Material.WARD_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.WARD;
                } else if (TemplateGUI.template == Material.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.WAYFINDER;
                } else if (TemplateGUI.template == Material.WILD_ARMOR_TRIM_SMITHING_TEMPLATE) {
                    template = TrimPattern.WILD;
                }

                if (trimMaterial == null || template == null) {
                    return;
                }

                final ArmorTrim trim = new ArmorTrim(trimMaterial, template);
                armorMeta.setTrim(trim);

                e.getWhoClicked().getInventory().getItemInMainHand().setItemMeta(armorMeta);
                p.closeInventory();
                p.sendMessage(prefix + LIGHT_GREEN + "Armor Trim successfully added!");
            }

        }
    }


    @EventHandler
    public void onInventoryClick (final InventoryDragEvent e){
        if (e.getInventory().equals(editgui)) {
            e.setCancelled(true);
        }
    }
}