package at.sm45654.armortrimedit;

import at.sm45654.armortrimedit.command.ArmorTrimEditCMD;
import at.sm45654.armortrimedit.gui.DyeMaterialGUI;
import at.sm45654.armortrimedit.gui.EditGUI;
import at.sm45654.armortrimedit.gui.TemplateGUI;
import at.sm45654.armortrimedit.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmorTrimEdit extends JavaPlugin {

    public static String prefix = ChatUtil.LIGHT_BLUE + "[" + ChatUtil.YELLOW + "ArmorTrimEdit" + ChatUtil.LIGHT_BLUE + "] ";


    @Override
    public void onEnable() {
        this.getCommand("armortrimedit").setExecutor(new ArmorTrimEditCMD());
        TemplateGUI.gui();
        DyeMaterialGUI.gui();
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new TemplateGUI(), this);
        pm.registerEvents(new DyeMaterialGUI(), this);
        pm.registerEvents(new EditGUI(), this);
        new bStats().registerbStats(this);
    }

    @Override
    public void onDisable() {
        //
    }
}
