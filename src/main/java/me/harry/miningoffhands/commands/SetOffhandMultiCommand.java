package me.harry.miningoffhands.commands;

import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SetOffhandMultiCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if (sender instanceof Player player) {
            if (player.hasPermission("offhand.set")) {
                if (strings.length == 1) {
                    int num = Integer.parseInt(strings[0]);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou have set the offhand to give ") + num + " Drops!");
                    ItemStack heldItem = player.getInventory().getItemInMainHand();
                    NBT.modify(heldItem, nbt -> {
                        nbt.setByte("offhand-multiplier", (byte) num);
                    });
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a/setoffhandmulti <number>"));
                }
            }
        }
        return true;
    }
}
