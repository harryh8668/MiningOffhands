package me.harry.miningoffhands.listeners;


import de.tr7zw.changeme.nbtapi.NBT;
import me.harry.miningoffhands.MiningOffhands;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MiningListeners implements Listener {

    private MiningOffhands plugin;

    public MiningListeners(MiningOffhands plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMine(BlockDropItemEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        ItemStack offhand = player.getInventory().getItemInOffHand();
        if (offhand.getType() == Material.AIR) return;

        AtomicInteger multiplier = new AtomicInteger(1);
        NBT.get(offhand, nbt -> {
            if (nbt.hasTag("offhand-multiplier")) {
                int newMultiplier = nbt.getByte("offhand-multiplier");
                multiplier.set(newMultiplier);
            }
        });

        if (multiplier.get() <= 1) return;
        List<String> configList = this.plugin.getConfig().getStringList("MiningOffhands.Blocks.MoreDropsBlocks");
        String blockMined = event.getBlockState().getType().toString();
        if (configList.contains(blockMined)) {
            for (int i = 1; i < multiplier.get(); i++) {
                for (Item item : event.getItems()) {
                    ItemStack itemStack = item.getItemStack();
                    Location itemLoc = item.getLocation();
                    item.getWorld().dropItem(itemLoc, itemStack);
                }
            }
        }
    }
}
