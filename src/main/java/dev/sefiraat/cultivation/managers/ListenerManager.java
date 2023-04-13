package dev.sefiraat.cultivation.managers;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.implementation.listeners.CustomDropListener;
import dev.sefiraat.cultivation.implementation.listeners.CustomPlacementListener;
import dev.sefiraat.cultivation.implementation.listeners.MobDropListener;
import dev.sefiraat.cultivation.implementation.listeners.TraderListener;
import dev.sefiraat.cultivation.implementation.listeners.TreeListener;
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
        addListener(new CustomDropListener());
        addListener(new CustomPlacementListener());
        addListener(new MobDropListener());
        addListener(new TreeListener());
        addListener(new TraderListener());
    }

    private void addListener(@Nonnull Listener listener) {
        Cultivation.getPluginManager().registerEvents(listener, Cultivation.getInstance());
    }

    public static ListenerManager getInstance() {
        return instance;
    }
}
