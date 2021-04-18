package muriplz.kryeitdeathcoords;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class KryeitDeathCoords extends JavaPlugin implements Listener{
    PluginDescriptionFile pdffile = getDescription();
    public String name = ChatColor.YELLOW+"["+ChatColor.WHITE+pdffile.getName()+ChatColor.YELLOW+"]";
    public String version = pdffile.getVersion();

    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage(name+ChatColor.GRAY+" The plugin has been activated. version: "+ChatColor.GREEN+version+ChatColor.GRAY+".");
        this.getServer().getPluginManager().registerEvents(this, this);
    }
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(name+ChatColor.WHITE+" The plugin has been deactivated.");
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Location loc = e.getEntity().getLocation();
        Objects.requireNonNull(e.getEntity().getPlayer()).sendMessage(ChatColor.GRAY+"You died on the coordinates: ("+loc.getBlockX()+ ", "+loc.getBlockY()+", "+loc.getBlockZ()+").");
    }

}

