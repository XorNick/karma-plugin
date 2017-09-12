package net.xornick.karmasystem;

import net.xornick.karmasystem.listeners.NegativeKarmaChatEvent;
import net.xornick.karmasystem.listeners.PositiveKarmaChatEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class KarmaPlugin extends JavaPlugin {

    private static KarmaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        register(new PositiveKarmaChatEvent());
        register(new NegativeKarmaChatEvent());
    }

    public static KarmaPlugin getInstance() {
        return plugin;
    }

    private void register(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
