package dev.sefiraat.cultivation.implementation.utils;

import dev.sefiraat.sefilib.misc.RotationFace;
import dev.sefiraat.sefilib.misc.TransformationBuilder;
import io.papermc.lib.PaperLib;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;

import javax.annotation.Nonnull;

public enum Transformations {

    DEFAULT_TRANSFORMATION(new TransformationBuilder().build()),
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
    BUSH_HANGING_DROP(new TransformationBuilder()
                           .scale(0.31f, 0.31f, 0.31f)
                          .firstRotation(RotationFace.SIDE, 15)
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
    ),
    COUNTER_BODY(new TransformationBuilder()
                     .scale(0.9f, 0.8f, 0.9f)
                     .build()
    ),
    COUNTER_TOP(new TransformationBuilder()
                    .scale(1f, 0.05f, 1f)
                    .build()
    ),
    CHOPPING_BOARD(new TransformationBuilder()
                       .scale(0.4f, 0.05f, 0.5f)
                       .firstRotation(RotationFace.TOP, 30)
                       .build()
    ),
    CHOPPING_BOARD_2(new TransformationBuilder()
                         .scale(0.3f, 0.05f, 0.4f)
                         .firstRotation(RotationFace.TOP, 60)
                         .build()
    ),
    CHOPPING_BOARD_KNIFE(new TransformationBuilder()
                             .scale(0.3f, 0.3f, 0.3f)
                             .firstRotation(RotationFace.TOP, 135)
                             .secondRotation(RotationFace.SIDE, 90)
                             .build()
    ),
    CHOPPING_BOARD_KNIFE_2(new TransformationBuilder()
                               .scale(0.3f, 0.3f, 0.3f)
                               .firstRotation(RotationFace.TOP, 135)
                               .secondRotation(RotationFace.SIDE, 90)
                               .build()
    ),
    MASHING_BOWL(new TransformationBuilder()
                     .scale(0.4f, 0.2f, 0.4f)
                     .firstRotation(RotationFace.TOP, 10)
                     .build()
    ),
    MASHER(new TransformationBuilder()
               .scale(0.3f, 0.3f, 0.3f)
               .firstRotation(RotationFace.TOP, 135)
               .secondRotation(RotationFace.SIDE, 90)
               .build()
    ),
    GRINDING_BOWL(new TransformationBuilder()
                      .scale(0.2f, 0.1f, 0.2f)
                      .build()
    ),
    BONE(new TransformationBuilder()
             .scale(0.2f, 0.2f, 0.2f)
             .firstRotation(RotationFace.TOP, 135)
             .secondRotation(RotationFace.SIDE, 90)
             .build()
    ),
    BLENDER_BASE(new TransformationBuilder()
                     .scale(0.2f, 0.2f, 0.2f)
                     .firstRotation(RotationFace.TOP, 45)
                     .build()
    ),
    BLENDER_TOP(new TransformationBuilder()
                    .scale(0.2f, 0.3f, 0.2f)
                    .firstRotation(RotationFace.TOP, 45)
                    .build()
    ),
    OVEN_DOOR(new TransformationBuilder()
                  .scale(0.7f, 0.55f, 0.1f)
                  .build()
    ),
    GRILL_DOOR(new TransformationBuilder()
                  .scale(0.7f, 0.25f, 0.1f)
                  .build()
    ),
    COOKING_BUTTONS(new TransformationBuilder()
                     .scale(0.05f, 0.7f, 0.05f)
                     .firstRotation(RotationFace.FRONT, 90)
                     .build()
    ),
    FRY_HOB(new TransformationBuilder()
                  .scale(0.9f, 0.05f, 0.9f)
                  .build()
    ),
    FRY_HOB_CORE(new TransformationBuilder()
                  .scale(0.85f, 0.05f, 0.85f)
                  .build()
    ),
    BOILING_POT(new TransformationBuilder()
                  .scale(0.3f, 0.3f, 0.3f)
                  .build()
    );

    private final Transformation transformation;

    Transformations(@Nonnull Transformation transformation) {
        this.transformation = transformation;
    }

    public Transformation getTransformation() {
        return getTransformation(true);
    }

    public Transformation getTransformation(boolean itemDisplay) {
        // In 1.20+ the y axis of item displays are rotated by 180°
        // This corrects the visuals by rotating again
        if (itemDisplay && PaperLib.getMinecraftVersion() >= 20) {
            return new Transformation(transformation.getTranslation(),
                    transformation.getLeftRotation(),
                    transformation.getScale(),
                    new Quaternionf(transformation.getRightRotation()).rotateY((float) Math.PI));
        }
        return transformation;
    }
}
