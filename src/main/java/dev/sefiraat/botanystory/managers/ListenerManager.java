package dev.sefiraat.botanystory.managers;

import com.google.common.base.Preconditions;
import dev.sefiraat.botanystory.BotanyStory;
import dev.sefiraat.botanystory.implementation.listeners.CustomPlacementListener;
import dev.sefiraat.botanystory.implementation.listeners.DropListener;
import org.bukkit.event.Listener;

import javax.annotation.Nonnull;

/**
 * This class is used to register all listeners in one place
 */
public class ListenerManager {

    private static ListenerManager instance;

    public ListenerManager() {
        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the ListenerManager");
        instance = this;
        addListener(new DropListener());
        addListener(new CustomPlacementListener());
    }

    private void addListener(@Nonnull Listener listener) {
        BotanyStory.getPluginManager().registerEvents(listener, BotanyStory.getInstance());
    }

    public static ListenerManager getInstance() {
        return instance;
    }
}
