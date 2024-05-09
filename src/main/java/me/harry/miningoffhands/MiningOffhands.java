package me.harry.miningoffhands;

import me.harry.miningoffhands.commands.DoubleDropsCommand;
import me.harry.miningoffhands.commands.QuadDropsCommand;
import me.harry.miningoffhands.commands.TripleDropsCommand;
import me.harry.miningoffhands.listeners.MiningListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MiningOffhands extends JavaPlugin {

    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("setdoubledropsitem").setExecutor(new DoubleDropsCommand());
        getCommand("settripledropsitem").setExecutor(new TripleDropsCommand());
        getCommand("setquaddropsitem").setExecutor(new QuadDropsCommand());
        Bukkit.getPluginManager().registerEvents(new MiningListeners(this), this);
    }

    public void onDisable() {

    }
}
