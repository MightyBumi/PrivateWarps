package pro.homiecraft;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitScheduler;

/**
 * Created with IntelliJ IDEA.
 * User: Ellen Thing
 * Date: 17-04-13
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class PlayerListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerMove(PlayerMoveEvent e) {

        Player player = e.getPlayer();

        BukkitScheduler task = PrivateWarps.pluginST.getServer().getScheduler();
        boolean pMove = PrivateWarps.pluginST.getConfig().getBoolean("PrivateWarps.settings.Cancel-Warp-On-Player-Move", true);

        double locX = player.getLocation().getX();
        double locY = player.getLocation().getY();
        double locZ = player.getLocation().getZ();

       // player.sendMessage("1");

        if (CommandWarp.pLoc.containsKey(player.getName())) {
            //double plocX = CommandWarp.pLoc.get(player.getName() + "x");
            //double plocY = CommandWarp.pLoc.get(player.getName() + "y");
            //double plocZ = CommandWarp.pLoc.get(player.getName() + "z");

            Location playerLoc = CommandWarp.pLoc.get(player.getName());
            double  plocX = playerLoc.getX();
            double  plocY = playerLoc.getY();
            double  plocZ = playerLoc.getZ();

            //player.sendMessage("2");

            if (!(locX == plocX)) {
                if (pMove) {
                    if (CommandWarp.taskIDs.containsKey(player.getName())) {
                        if (task.isQueued(CommandWarp.taskIDs.get(player.getName()))) {
                            task.cancelTask(CommandWarp.taskIDs.get(player.getName()));
                            CommandWarp.taskIDs.remove(player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "You moved! Warp canceled!");

                            //player.sendMessage("3");
                        }
                    }
                }
            }

            if (!(locY == plocY)) {
                if (pMove) {
                    if (CommandWarp.taskIDs.containsKey(player.getName())) {
                        if (task.isQueued(CommandWarp.taskIDs.get(player.getName()))) {
                            task.cancelTask(CommandWarp.taskIDs.get(player.getName()));
                            CommandWarp.taskIDs.remove(player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "You moved! Warp canceled!");

                            //player.sendMessage("3");
                        }
                    }
                }
            }

            if (!(locZ == plocZ)) {
                if (pMove) {
                    if (CommandWarp.taskIDs.containsKey(player.getName())) {
                        if (task.isQueued(CommandWarp.taskIDs.get(player.getName()))) {
                            task.cancelTask(CommandWarp.taskIDs.get(player.getName()));
                            CommandWarp.taskIDs.remove(player.getName());
                            player.sendMessage(ChatColor.DARK_GRAY + "You moved! Warp canceled!");

                            //player.sendMessage("3");
                        }
                    }
                }
            }
        }
    }
}
