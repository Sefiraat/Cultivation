package dev.sefiraat.cultivation.api.utils;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.sefilib.entity.LivingEntityCategory;
import dev.sefiraat.sefilib.entity.LivingEntityDefinition;
import dev.sefiraat.sefilib.entity.LivingEntitySelector;
import io.github.bakedlibs.dough.versions.MinecraftVersion;
import io.github.bakedlibs.dough.versions.UnknownServerVersionException;
import org.bukkit.Server;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class EntityDefinitions {

    private EntityDefinitions() {
        throw new IllegalStateException("Utility class");
    }

    private static Set<LivingEntityDefinition> passiveMobs;
    private static Set<LivingEntityDefinition> hostileMobs;
    private static Set<LivingEntityDefinition> bossMobs;
    private static Set<LivingEntityDefinition> flyingMobs;

    static {
        Server server = Cultivation.getInstance().getServer();

        try {
            passiveMobs = LivingEntitySelector.start()
                .includeCategories(LivingEntityCategory.PASSIVE)
                .setVersion(MinecraftVersion.of(Cultivation.getInstance().getServer()))
                .process(LivingEntitySelector.MatchType.MATCH_ALL);
        } catch (UnknownServerVersionException e) {
            passiveMobs = new HashSet<>();
            server.getLogger().severe(e.getMessage());
        }

        try {
            hostileMobs = LivingEntitySelector.start()
                .includeCategories(LivingEntityCategory.HOSTILE)
                .setVersion(MinecraftVersion.of(Cultivation.getInstance().getServer()))
                .process(LivingEntitySelector.MatchType.MATCH_ALL);
        } catch (UnknownServerVersionException e) {
            hostileMobs = new HashSet<>();
            server.getLogger().severe(e.getMessage());
        }

        try {
            bossMobs = LivingEntitySelector.start()
                .includeCategories(LivingEntityCategory.BOSS)
                .setVersion(MinecraftVersion.of(Cultivation.getInstance().getServer()))
                .process(LivingEntitySelector.MatchType.MATCH_ALL);
        } catch (UnknownServerVersionException e) {
            bossMobs = new HashSet<>();
            server.getLogger().severe(e.getMessage());
        }

        try {
            flyingMobs = LivingEntitySelector.start()
                .includeCategories(LivingEntityCategory.FLYING)
                .setVersion(MinecraftVersion.of(Cultivation.getInstance().getServer()))
                .process(LivingEntitySelector.MatchType.MATCH_ALL);
        } catch (UnknownServerVersionException e) {
            flyingMobs = new HashSet<>();
            server.getLogger().severe(e.getMessage());
        }
    }

    public static Set<LivingEntityDefinition> getPassiveMobs() {
        return Collections.unmodifiableSet(passiveMobs);
    }

    public static Set<LivingEntityDefinition> getHostileMobs() {
        return Collections.unmodifiableSet(hostileMobs);
    }

    public static Set<LivingEntityDefinition> getBossMobs() {
        return Collections.unmodifiableSet(bossMobs);
    }

    public static Set<LivingEntityDefinition> getFlyingMobs() {
        return flyingMobs;
    }
}
