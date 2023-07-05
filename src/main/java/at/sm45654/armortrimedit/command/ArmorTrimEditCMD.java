package at.sm45654.armortrimedit.command;

import at.sm45654.armortrimedit.gui.EditGUI;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static at.sm45654.armortrimedit.util.ChatUtil.*;
import static at.sm45654.armortrimedit.ArmorTrimEdit.*;

public class ArmorTrimEditCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        Player p = (Player) s;

        if (
                p.getInventory().getItemInMainHand().getType() == Material.LEATHER_BOOTS ||
                p.getInventory().getItemInMainHand().getType() == Material.LEATHER_LEGGINGS ||
                p.getInventory().getItemInMainHand().getType() == Material.LEATHER_CHESTPLATE ||
                p.getInventory().getItemInMainHand().getType() == Material.LEATHER_HELMET ||
                p.getInventory().getItemInMainHand().getType() == Material.IRON_BOOTS ||
                p.getInventory().getItemInMainHand().getType() == Material.IRON_LEGGINGS ||
                p.getInventory().getItemInMainHand().getType() == Material.IRON_CHESTPLATE ||
                p.getInventory().getItemInMainHand().getType() == Material.IRON_HELMET ||
                p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_BOOTS ||
                p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_LEGGINGS ||
                p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_CHESTPLATE ||
                p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_HELMET ||
                p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_BOOTS ||
                p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_LEGGINGS ||
                p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_CHESTPLATE ||
                p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_HELMET ||
                p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_BOOTS ||
                p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_LEGGINGS ||
                p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_CHESTPLATE ||
                p.getInventory().getItemInMainHand().getType() == Material.NETHERITE_HELMET ||
                p.getInventory().getItemInMainHand().getType() == Material.CHAINMAIL_BOOTS ||
                p.getInventory().getItemInMainHand().getType() == Material.CHAINMAIL_LEGGINGS ||
                p.getInventory().getItemInMainHand().getType() == Material.CHAINMAIL_CHESTPLATE ||
                p.getInventory().getItemInMainHand().getType() == Material.CHAINMAIL_HELMET
        ) { EditGUI.open(p);
        } else {
            p.sendMessage(prefix + RED + "Please hold an armor item in your hand!");
        }
        return false;
    }
}
