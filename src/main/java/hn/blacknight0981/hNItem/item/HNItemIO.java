package hn.blacknight0981.hNItem.item;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface HNItemIO {
    String getID();
    @NotNull ItemStack getItem();

    void create();

    default void init() {
        ItemStack item = getItem();
        ItemMeta meta = item.getItemMeta();

        NamespacedKey key = new NamespacedKey("craft", "id");
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, getID());
        meta.lore(List.of(Component.text("已添加標籤")));

        item.setItemMeta(meta);
    }
}
