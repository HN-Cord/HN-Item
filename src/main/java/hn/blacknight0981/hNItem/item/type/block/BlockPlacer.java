package hn.blacknight0981.hNItem.item.type.block;

import hn.blacknight0981.hNItem.item.HNItemIO;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class BlockPlacer implements HNItemIO {
    private final ItemStack itemStack = new ItemStack(Material.DISPENSER);

    @Override
    public String getID() {
        return "block_placer";
    }

    @Override
    public @NotNull ItemStack getItem() {
        return itemStack;
    }

    @Override
    public void create() {
        ItemMeta meta = itemStack.getItemMeta();
        meta.displayName(Component.text("方塊放置器"));
        meta.setRarity(ItemRarity.UNCOMMON);
        itemStack.setItemMeta(meta);
    }
}
