package dev.sefiraat.cultivation.implementation.utils;

import dev.sefiraat.sefilib.misc.RotationFace;
import dev.sefiraat.sefilib.misc.TransformationBuilder;
import org.bukkit.util.Transformation;

import javax.annotation.Nonnull;

public enum Transformations {

    STICK_POINT_UPRIGHT(new TransformationBuilder()
                            .firstRotation(RotationFace.FRONT, 45)
                            .build()
    ),
    STICK_FLAT_X_ALIGN(new TransformationBuilder()
                           .firstRotation(RotationFace.TOP, 135)
                           .secondRotation(RotationFace.SIDE, 90)
                           .build()
    ),
    STICK_FLAT_Z_ALIGN(new TransformationBuilder()
                           .firstRotation(RotationFace.TOP, 45)
                           .secondRotation(RotationFace.SIDE, 90)
                           .build()
    ),
    PLANT_HANGING_DROP(new TransformationBuilder()
                           .scale(0.2f, 0.2f, 0.2f)
                           .build()
    ),
    CLOCHE_BASE(new TransformationBuilder()
                           .scale(0.5f, 1f, 0.5f)
                           .build()
    ),
    CLOCHE_GLASS(new TransformationBuilder()
                           .scale(0.5f, 0.5f, 0.5f)
                           .build()
    ),
    CLOCHE_DIRT(new TransformationBuilder()
                           .scale(0.4f, 0.4f, 0.4f)
                           .build()
    );

    private final Transformation transformation;

    Transformations(@Nonnull Transformation transformation) {
        this.transformation = transformation;
    }

    public Transformation getTransformation() {
        return transformation;
    }
}
