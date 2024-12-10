package hn.blacknight0981.hNItem;

import org.bukkit.plugin.java.JavaPlugin;

public final class HNItem extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HNItem is enabled!");

    }

    @Override
    public void onDisable() {
        getLogger().info("HNItem is disabled!");
    }
}
