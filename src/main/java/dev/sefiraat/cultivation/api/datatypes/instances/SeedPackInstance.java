package dev.sefiraat.cultivation.api.datatypes.instances;

import java.util.HashMap;
import java.util.Map;

public class SeedPackInstance {

    public String storedItemId;
    public Map<FloraLevelProfile, Integer> amountMap = new HashMap<>();

    public String getStoredItemId() {
        return storedItemId;
    }

    public void setStoredItemId(String storedItemId) {
        this.storedItemId = storedItemId;
    }

    public Map<FloraLevelProfile, Integer> getAmountMap() {
        return amountMap;
    }

    public void setAmountMap(Map<FloraLevelProfile, Integer> amountMap) {
        this.amountMap = amountMap;
    }

    public void takeOne(int level, int speed, int strength) {
        FloraLevelProfile profile = new FloraLevelProfile(level, speed, strength, true);
        takeOne(profile);
    }

    public void takeOne(FloraLevelProfile profile) {
        int amount = amountMap.get(profile);
        if (amount > 0) {
            int newAmount = amount - 1;
            if (newAmount > 0) {
                amountMap.put(profile, amount - 1);
            } else {
                amountMap.remove(profile);
            }
        }
    }

    public void add(int level, int speed, int strength, int amount) {
        FloraLevelProfile profile = new FloraLevelProfile(level, speed, strength, true);
        add(profile, amount);
    }

    public void add(FloraLevelProfile profile, int amount) {
        amountMap.merge(profile, amount, Integer::sum);
    }

    public int getAmount(int level, int speed, int strength) {
        FloraLevelProfile profile = new FloraLevelProfile(level, speed, strength, true);
        return getAmount(profile);
    }

    public int getAmount(FloraLevelProfile profile) {
        return amountMap.getOrDefault(profile, 0);
    }

    public boolean isEmpty() {
        return this.amountMap.isEmpty();
    }
}
