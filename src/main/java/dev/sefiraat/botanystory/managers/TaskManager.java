package dev.sefiraat.botanystory.managers;

import com.google.common.base.Preconditions;
import dev.sefiraat.botanystory.BotanyStory;

/**
 * This class is used to run Runnables from one place
 */
public class TaskManager {

    private static TaskManager instance;

    public TaskManager() {
        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the TaskManager");
        instance = this;
        final BotanyStory plugin = BotanyStory.getInstance();

    }

    public static TaskManager getInstance() {
        return instance;
    }
}
