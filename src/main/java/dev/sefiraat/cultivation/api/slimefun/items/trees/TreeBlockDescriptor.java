package dev.sefiraat.cultivation.api.slimefun.items.trees;

import io.github.bakedlibs.dough.blocks.BlockPosition;
import org.bukkit.Axis;
import org.bukkit.block.BlockFace;

public final class TreeBlockDescriptor {
    private final BlockPosition blockPosition;
    private BlockFace blockFace;
    private Axis axis;

    public TreeBlockDescriptor(BlockPosition blockPosition) {
        this.blockPosition = blockPosition;
    }

    public BlockPosition getBlockPosition() {
        return blockPosition;
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
