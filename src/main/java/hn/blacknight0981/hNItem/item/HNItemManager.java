package hn.blacknight0981.hNItem.item;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class HNItemManager {
    private static final Map<String, HNItemIO> items = new HashMap<>();

    public static void registerItem(HNItemIO item) {
        item.init();
        item.create();
        items.put(item.getID(), item);
    }

    public static HNItemIO getItem(String id) {
        return items.get(id);
    }

    public static ItemStack getItemStack(String id) {
        HNItemIO item = getItem(id);
        if (item == null) return null;
        return item.getItem();
    }

    public static Map<String, HNItemIO> getItems() {
        return items;
    }
}
