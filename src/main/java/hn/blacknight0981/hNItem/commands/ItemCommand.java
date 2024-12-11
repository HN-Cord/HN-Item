package hn.blacknight0981.hNItem.commands;

import hn.blacknight0981.hNItem.HNItem;
import hn.blacknight0981.hNItem.item.HNItemManager;
import hn.blacknight0981.hNLib.commands.HNCommandIO;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemCommand implements HNCommandIO {
    @Override
    public String getName() {
        return "item";
    }

    @Override
    public boolean execute(CommandSender commandSender, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage(Component.text("請提供一個 子命令").color(NamedTextColor.RED));

            if (commandSender instanceof Player player) {
                ItemStack itemStack = HNItemManager.getItemStack("block_placer");
                if (itemStack == null) return true;
                player.getInventory().addItem(itemStack);
            }
            return true;
        }

        String subCommand = strings[0];
        String[] subStrings = new String[strings.length - 1];
        System.arraycopy(strings, 1, subStrings, 0, subStrings.length);

        return HNItem.getCommandManager().execute(subCommand, commandSender, subStrings);
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String[] args) {
        if (args.length == 1) {
            List<String> subStrings = new ArrayList<>();
            String partial = args[0].toLowerCase();
            for (String subCommand : HNItem.getCommandManager().getCommands().keySet()) {
                if (subCommand.startsWith(partial)) {
                    subStrings.add(subCommand);
                }
            }
            return subStrings;
        } else if (args.length > 1){
            // 交給 子命令參數
            HNCommandIO commandIO = HNItem.getCommandManager().getCommands().get(args[0].toLowerCase());
            if (commandIO != null) {
                String[] subStrings = new String[args.length - 1];
                System.arraycopy(args, 1, subStrings, 0, subStrings.length);
                return commandIO.tabComplete(sender, subStrings);
            }
        }
        return List.of();
    }
}
