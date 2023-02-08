package dev.sefiraat.cultivation.managers;

import co.aikar.commands.PaperCommandManager;
import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.implementation.commands.CultivationCommands;
import org.bukkit.plugin.Plugin;

public final class DispatchManager extends PaperCommandManager {

    private static DispatchManager instance;

    public DispatchManager(Plugin plugin) {
        super(plugin);

        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the DispatchManager");
        instance = this;

        registerCommand(new CultivationCommands());
    }
}
