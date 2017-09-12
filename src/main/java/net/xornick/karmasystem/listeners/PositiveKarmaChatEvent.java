package net.xornick.karmasystem.listeners;

import me.johnzeh.plugins.pr.PlayerRating;
import net.xornick.karmasystem.KarmaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PositiveKarmaChatEvent implements Listener {

    @EventHandler
    public void onPositiveKarmaChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().toLowerCase();

        for (String positiveWord : KarmaPlugin.getInstance().getConfig().getStringList("chat.positive")) {
            if (message.contains(positiveWord)) {
                event.getPlayer().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "+1 Karma");
                PlayerRating.setRating(event.getPlayer(), PlayerRating.getRating(event.getPlayer()) + 1);
            }
        }
    }
}
