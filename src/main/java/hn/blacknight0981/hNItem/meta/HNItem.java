package hn.blacknight0981.hNItem.meta;

import org.bukkit.inventory.ItemStack;

public interface HNItem {
    String getID();
    ItemStack getItem();

    void create();
}
