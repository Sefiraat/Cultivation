package dev.sefiraat.cultivation.implementation.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import dev.sefiraat.sefilib.string.Theme;
import org.bukkit.command.CommandSender;

@CommandAlias("cultivation|cv")
public class CultivationCommands extends BaseCommand {

    @Default
    public void onDefault(CommandSender sender) {
        sender.sendMessage(Theme.ERROR + "Please provide a valid subcommand.");
    }
}

