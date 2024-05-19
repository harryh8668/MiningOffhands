package me.harry.miningoffhands;

import me.harry.miningoffhands.commands.SetOffhandMultiCommand;
import me.harry.miningoffhands.listeners.MiningListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MiningOffhands extends JavaPlugin {

    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("setoffhandmulti").setExecutor(new SetOffhandMultiCommand());
        Bukkit.getPluginManager().registerEvents(new MiningListeners(this), this);
    }

    public void onDisable() {

    }
}
