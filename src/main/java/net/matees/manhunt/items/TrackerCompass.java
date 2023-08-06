package net.matees.manhunt.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TrackerCompass {
    public static ItemStack newTrackerCompass() {
        ItemStack tracker = new ItemStack(Material.COMPASS);

        ItemMeta compassMeta = tracker.getItemMeta();

        compassMeta.setDisplayName("Tracker Compass");

        List<String> lore = new ArrayList<>();
        lore.add("This compass will allow you to track a non hunter");
        lore.add("Right click to update location");
        compassMeta.setLore(lore);

        Enchantment glint = Enchantment.LOYALTY;
        int enchantmentLevel = 1;
        compassMeta.addEnchant(glint, enchantmentLevel, true);

        tracker.setItemMeta(compassMeta);

        return tracker;
    }
}
