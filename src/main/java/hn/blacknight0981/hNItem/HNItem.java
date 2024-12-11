package hn.blacknight0981.hNItem;

import hn.blacknight0981.hNItem.commands.ItemCommand;
import hn.blacknight0981.hNItem.item.HNItemManager;
import hn.blacknight0981.hNItem.item.type.block.BlockPlacer;
import hn.blacknight0981.hNLib.HNLib;
import hn.blacknight0981.hNLib.commands.HNCommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class HNItem extends JavaPlugin {

    private static HNCommandManager commandManager;

    @Override
    public void onEnable() {
        commandManager = new HNCommandManager();

        HNLib.getCommandManager().register(new ItemCommand());

        HNItemManager.registerItem(new BlockPlacer());

        getLogger().info("HNItem is enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("HNItem is disabled!");
    }

    public static HNCommandManager getCommandManager() {
        return commandManager;
    }
}
