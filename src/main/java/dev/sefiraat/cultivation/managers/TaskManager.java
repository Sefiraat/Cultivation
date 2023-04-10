package dev.sefiraat.cultivation.managers;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.implementation.tasks.AirTimeTask;

/**
 * This class is used to run Runnables from one place
 */
public class TaskManager {

    private static TaskManager instance;

    private final AirTimeTask airTimeTask = new AirTimeTask();

    public TaskManager() {
        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the TaskManager");
        instance = this;
        Cultivation plugin = Cultivation.getInstance();

        airTimeTask.runTaskTimerAsynchronously(plugin, 20, AirTimeTask.TICK_RATE);
    }

    public static TaskManager getInstance() {
        return instance;
    }

    public AirTimeTask getAirTimeTask() {
        return airTimeTask;
    }
}
