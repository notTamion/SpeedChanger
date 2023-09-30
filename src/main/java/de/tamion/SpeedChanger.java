package de.tamion;

import de.tamion.commands.Speed;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpeedChanger extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("speed").setExecutor(new Speed());
    }
}
