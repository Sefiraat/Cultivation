package dev.sefiraat.cultivation.api.datatypes;

import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import dev.sefiraat.cultivation.api.datatypes.instances.SeedPackInstance;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

/**
 * A {@link PersistentDataType} for {@link FloraLevelProfile}
 */
public class SeedPackDataType implements PersistentDataType<PersistentDataContainer, SeedPackInstance> {

    public static final PersistentDataType<PersistentDataContainer, SeedPackInstance> TYPE = new SeedPackDataType();

    public static final NamespacedKey KEY = Keys.newKey("seed_instance");
    public static final NamespacedKey PLANT_ID = Keys.newKey("plant_id");
    public static final NamespacedKey PROFILE = Keys.newKey("profile");

    @Override
    @Nonnull
    public Class<PersistentDataContainer> getPrimitiveType() {
        return PersistentDataContainer.class;
    }

    @Override
    @Nonnull
    public Class<SeedPackInstance> getComplexType() {
        return SeedPackInstance.class;
    }

    @Override
    @Nonnull
    public PersistentDataContainer toPrimitive(@Nonnull SeedPackInstance complex,
                                               @Nonnull PersistentDataAdapterContext context
    ) {
        PersistentDataContainer container = context.newPersistentDataContainer();
        PersistentDataContainer profileContainer = context.newPersistentDataContainer();

        container.set(PLANT_ID, STRING, complex.getStoredItemId());

        for (Map.Entry<FloraLevelProfile, Integer> entry : complex.getAmountMap().entrySet()) {
            FloraLevelProfile profile = entry.getKey();
            NamespacedKey key = Keys.newKey(
                profile.getLevel() + "_" + profile.getSpeed() + "_" + profile.getStrength()
            );
            profileContainer.set(key, INTEGER, entry.getValue());
        }
        container.set(PROFILE, TAG_CONTAINER, profileContainer);

        return container;
    }

    @Override
    @Nonnull
    public SeedPackInstance fromPrimitive(@Nonnull PersistentDataContainer primitive,
                                          @Nonnull PersistentDataAdapterContext context
    ) {
        String id = primitive.get(PLANT_ID, STRING);
        SeedPackInstance instance = new SeedPackInstance();
        Map<FloraLevelProfile, Integer> map = new HashMap<>();
        PersistentDataContainer container = primitive.get(PROFILE, TAG_CONTAINER);

        for (NamespacedKey key : container.getKeys()) {
            String[] keyVals = key.getKey().split("_");
            int amount = container.getOrDefault(key, INTEGER, 0);
            int level = Integer.parseInt(keyVals[0]);
            int speed = Integer.parseInt(keyVals[1]);
            int strength = Integer.parseInt(keyVals[2]);
            FloraLevelProfile profile = new FloraLevelProfile(level, speed, strength, true);
            map.put(profile, amount);
        }

        instance.setAmountMap(map);
        instance.setStoredItemId(id);

        return instance;
    }
}
