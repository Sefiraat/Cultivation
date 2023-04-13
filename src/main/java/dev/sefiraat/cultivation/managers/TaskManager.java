package dev.sefiraat.cultivation.managers;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.Cultivation;

/**
 * This class is used to run Runnables from one place
 */
public class TaskManager {

    private static TaskManager instance;

    public TaskManager() {
        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the TaskManager");
        instance = this;
        Cultivation plugin = Cultivation.getInstance();
    }

    public static TaskManager getInstance() {
        return instance;
    }
}
