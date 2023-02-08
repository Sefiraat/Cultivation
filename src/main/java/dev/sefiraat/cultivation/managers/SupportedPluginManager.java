package dev.sefiraat.cultivation.managers;

import com.google.common.base.Preconditions;

/**
 * This class is used to check, register and manage/provide supported plugins
 */
public class SupportedPluginManager {

    private static SupportedPluginManager instance;

    public SupportedPluginManager() {
        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the SupportedPluginManager");
        instance = this;
        setup();
    }

    private void setup() {

    }

    public static SupportedPluginManager getInstance() {
        return instance;
    }
}
