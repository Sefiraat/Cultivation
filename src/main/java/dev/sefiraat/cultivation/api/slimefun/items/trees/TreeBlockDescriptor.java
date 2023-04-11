package dev.sefiraat.cultivation.api.slimefun.items.trees;

import io.github.bakedlibs.dough.blocks.BlockPosition;
import org.bukkit.Axis;
import org.bukkit.block.BlockFace;

public final class TreeBlockDescriptor {
    private final String name;
    private final int x;
    private final int y;
    private final int z;
    private BlockFace blockFace;
    private Axis axis;

    public TreeBlockDescriptor(String name, int x, int y, int z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public BlockFace getBlockFace() {
        return blockFace;
    }

    public void setBlockFace(BlockFace blockFace) {
        this.blockFace = blockFace;
    }

    public Axis getAxis() {
        return axis;
    }

    public void setAxis(Axis axis) {
        this.axis = axis;
    }
}
