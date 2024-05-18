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
            System.out.println("1");
            if (player.hasPermission("offhand.set")) {
                System.out.println("2");
                ItemStack heldItem = player.getInventory().getItemInMainHand();
                System.out.println("3");
                NBT.modify(heldItem, nbt -> {
                    System.out.println("4");
                    nbt.setByte("offhand-multiplier", (byte) 3);
                    System.out.println("5");
                });
                System.out.println("6");
            }
            System.out.println("7");
        }
        System.out.println("8");
        return true;
    }
}

