package dev.sefiraat.botanystory.managers;

import co.aikar.commands.PaperCommandManager;
import com.google.common.base.Preconditions;
import dev.sefiraat.botanystory.implementation.commands.BotanyCommands;
import org.bukkit.plugin.Plugin;

public final class DispatchManager extends PaperCommandManager {

    private static DispatchManager instance;

    public DispatchManager(Plugin plugin) {
        super(plugin);

        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the DispatchManager");
        instance = this;

        registerCommand(new BotanyCommands());
    }
}
