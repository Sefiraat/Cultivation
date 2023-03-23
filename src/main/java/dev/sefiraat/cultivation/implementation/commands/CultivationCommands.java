package dev.sefiraat.cultivation.implementation.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import dev.sefiraat.cultivation.implementation.utils.DisplayUtils;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import dev.sefiraat.sefilib.entity.display.builders.ItemDisplayBuilder;
import dev.sefiraat.sefilib.string.Theme;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Display;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;

@CommandAlias("cultivation|cv")
public class CultivationCommands extends BaseCommand {

    @Default
    public void onDefault(CommandSender sender) {
        sender.sendMessage(Theme.ERROR + "Please provide a valid subcommand.");
    }
    
    @Subcommand("test_spawn")
    @CommandPermission("Cultivation.Admin")
    @Description("Testing Only")
    public void test_spawn(CommandSender sender, String[] args) {
        if (sender instanceof Player player) {
            final DisplayGroup displayGroup = new DisplayGroup(player.getLocation());
            Vector direction = new Vector(Float.parseFloat(args[1]), Float.parseFloat(args[2]),
                Float.parseFloat(args[3]));
            direction.normalize();
            Vector direction2 = new Vector(Float.parseFloat(args[5]), Float.parseFloat(args[6]),
                Float.parseFloat(args[7]));
            direction2.normalize();
            final Transformation transformation4 = new Transformation(
                new Vector3f(0, 0, 0),
                new AxisAngle4f((float) (Float.parseFloat(args[0]) * 2 * Math.PI / 360), (float) direction.getX(),
                    (float) direction.getY(), (float) direction.getZ()),
                new Vector3f(1f, 1f, 1f),
                new AxisAngle4f((float) (Float.parseFloat(args[4]) * 2 * Math.PI / 360), (float) direction2.getX(),
                    (float) direction2.getY(), (float) direction2.getZ())
            );
            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(Float.parseFloat(args[9]), Float.parseFloat(args[10]),
                        Float.parseFloat(args[11])))
                    .setItemStack(new ItemStack(Material.valueOf(args[8])))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation4)
                    .build(displayGroup)
            );
        } else {
            sender.sendMessage("NO!");
        }
    }

    @Subcommand("test_spawn_2")
    @CommandPermission("Cultivation.Admin")
    @Description("Testing Only")
    public void test_spawn_2(CommandSender sender) {
        System.out.println("Starting");
        if (sender instanceof Player player) {
            final DisplayGroup displayGroup = new DisplayGroup(player.getLocation());
            Vector directionUP = new Vector(0, 0, 1);
            directionUP.normalize();
            Vector direction2 = new Vector(1, 0, 0);
            direction2.normalize();
            final Transformation transformation4 = new Transformation(
                new Vector3f(0, 0, 0),
                new AxisAngle4f((float) (45 * 2 * Math.PI / 360), (float) directionUP.getX(),
                    (float) directionUP.getY(), (float) directionUP.getZ()),
                new Vector3f(1f, 1f, 1f),
                new AxisAngle4f((float) (0 * 2 * Math.PI / 360), (float) direction2.getX(), (float) direction2.getY()
                    , (float) direction2.getZ())
            );

            Vector directionFlatLeftRight = new Vector(0, 1, 0);
            directionUP.normalize();
            Vector directionFlatRightLeft = new Vector(1, 0, 0);
            direction2.normalize();
            final Transformation transformation5 = new Transformation(
                new Vector3f(0, 0, 0),
                new AxisAngle4f((float) (135 * 2 * Math.PI / 360), (float) directionFlatLeftRight.getX(),
                    (float) directionFlatLeftRight.getY(), (float) directionFlatLeftRight.getZ()),
                new Vector3f(1f, 1f, 1f),
                new AxisAngle4f((float) (90 * 2 * Math.PI / 360), (float) directionFlatRightLeft.getX(),
                    (float) directionFlatRightLeft.getY(), (float) directionFlatRightLeft.getZ())
            );
            final Transformation transformation6 = new Transformation(
                new Vector3f(0, 0, 0),
                new AxisAngle4f((float) (45 * 2 * Math.PI / 360), (float) directionFlatLeftRight.getX(),
                    (float) directionFlatLeftRight.getY(), (float) directionFlatLeftRight.getZ()),
                new Vector3f(1f, 1f, 1f),
                new AxisAngle4f((float) (90 * 2 * Math.PI / 360), (float) directionFlatRightLeft.getX(),
                    (float) directionFlatRightLeft.getY(), (float) directionFlatRightLeft.getZ())
            );


            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(-0.45, 0.5, -0.47))
                    .setItemStack(new ItemStack(Material.STICK))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation4)
                    .build(displayGroup)
            );
            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(0.37, 0.5, -0.47))
                    .setItemStack(new ItemStack(Material.STICK))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation4)
                    .build(displayGroup)
            );
            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(0.37, 0.5, 0.47))
                    .setItemStack(new ItemStack(Material.STICK))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation4)
                    .build(displayGroup)
            );
            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(-0.45, 0.5, 0.47))
                    .setItemStack(new ItemStack(Material.STICK))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation4)
                    .build(displayGroup)
            );
            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
//                    Links achter
                    .setGroupParentOffset(new Vector(0, 1, -0.43))
                    .setItemStack(new ItemStack(Material.STICK))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation6)
                    .build(displayGroup)
            );
            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(0, 1, 0.5))
                    .setItemStack(new ItemStack(Material.STICK))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation6)
                    .build(displayGroup)
            );
            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(0.45, 1, 0))
                    .setItemStack(new ItemStack(Material.STICK))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation5)
                    .build(displayGroup)
            );
            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(-0.35, 1, 0))
                    .setItemStack(new ItemStack(Material.STICK))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation5)
                    .build(displayGroup)
            );
        } else {
            sender.sendMessage("NO!");
        }
    }

    @Subcommand("test_spawn_3")
    @CommandPermission("Cultivation.Admin")
    @Description("Testing Only")
    public void test_spawn_3(CommandSender sender) {
        if (sender instanceof Player player) {
            DisplayUtils.generateCrossedCropStickGroup(player.getLocation());
        }
    }

    @Subcommand("test_spawn_4")
    @CommandPermission("Cultivation.Admin")
    @Description("Testing Only")
    public void test_spawn_4(CommandSender sender) {
        if (sender instanceof Player player) {
            DisplayUtils.generateCropStickGroup(player.getLocation());
        }
    }

}

