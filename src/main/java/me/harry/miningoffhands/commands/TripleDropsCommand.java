package me.harry.miningoffhands.commands;

import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TripleDropsCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {
        if (sender instanceof Player player) {
            if (player.hasPermission("offhand.set")) {
                ItemStack heldItem = player.getInventory().getItemInMainHand();
                NBT.modify(heldItem, nbt -> {
                    nbt.setByte("offhand-multiplier", (byte) 3);
                });
            }
        }
        return true;
    }
}

