package net.xornick.karmasystem.listeners;

import me.johnzeh.plugins.pr.PlayerRating;
import net.xornick.karmasystem.KarmaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class NegativeKarmaChatEvent implements Listener {

    @EventHandler
    public void onNegativeKarmaChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().toLowerCase();

        // boilerplate lol
        for (String blacklistedWord : KarmaPlugin.getInstance().getConfig().getStringList("chat.negative")) {
            if (message.contains(blacklistedWord)) {
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "-1 Karma");
                PlayerRating.setRating(event.getPlayer(), PlayerRating.getRating(event.getPlayer()) - 1);
            }
        }
    }
}
