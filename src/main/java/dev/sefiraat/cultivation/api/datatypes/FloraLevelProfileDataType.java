package dev.sefiraat.cultivation.api.datatypes;

import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;

/**
 * A {@link PersistentDataType} for {@link FloraLevelProfile}
 */
public class FloraLevelProfileDataType implements PersistentDataType<PersistentDataContainer, FloraLevelProfile> {

    public static final PersistentDataType<PersistentDataContainer, FloraLevelProfile> TYPE = new FloraLevelProfileDataType();

    public static final NamespacedKey KEY = Keys.newKey("seed_instance");
    public static final NamespacedKey LEVEL_GROWTH_SPEED = Keys.newKey("growth_speed");
    public static final NamespacedKey LEVEL_DROP_RATE = Keys.newKey("drop_rate");
    public static final NamespacedKey LEVEL_STRENGTH = Keys.newKey("strength");
    public static final NamespacedKey ANALYZED = Keys.newKey("analyzed");

    @Override
    @Nonnull
    public Class<PersistentDataContainer> getPrimitiveType() {
        return PersistentDataContainer.class;
    }

    @Override
    @Nonnull
    public Class<FloraLevelProfile> getComplexType() {
        return FloraLevelProfile.class;
    }

    @Override
    @Nonnull
    public PersistentDataContainer toPrimitive(@Nonnull FloraLevelProfile complex,
                                               @Nonnull PersistentDataAdapterContext context
    ) {
        final PersistentDataContainer container = context.newPersistentDataContainer();

        container.set(LEVEL_GROWTH_SPEED, INTEGER, complex.getSpeed());
        container.set(LEVEL_DROP_RATE, INTEGER, complex.getLevel());
        container.set(LEVEL_STRENGTH, INTEGER, complex.getStrength());
        container.set(ANALYZED, INTEGER, complex.isAnalyzed() ? 1 : 0);

        return container;
    }

    @Override
    @Nonnull
    public FloraLevelProfile fromPrimitive(@Nonnull PersistentDataContainer primitive,
                                           @Nonnull PersistentDataAdapterContext context
    ) {
        int speed = primitive.getOrDefault(LEVEL_GROWTH_SPEED, INTEGER, 1);
        int level = primitive.getOrDefault(LEVEL_DROP_RATE, INTEGER, 1);
        int strength = primitive.getOrDefault(LEVEL_STRENGTH, INTEGER, 1);
        int analyzed = primitive.getOrDefault(ANALYZED, INTEGER, 0);
        return new FloraLevelProfile(level, speed, strength, analyzed == 1);
    }
}
