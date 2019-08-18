package com.matmatt.xpstorage;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class XPstorage extends JavaPlugin {

    @Override
    public void onEnable() {
        // Load all the Eventhandlers
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new BlockSignDestruction(), this);
        pluginManager.registerEvents(new BlockManualXPSign(), this);
        pluginManager.registerEvents(new RightClickSignEventListener(), this);
        pluginManager.registerEvents(new LeftClickSignEventListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
