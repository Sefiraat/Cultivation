package dev.sefiraat.cultivation.implementation.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
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
import org.joml.Quaternionf;
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
    public void test_spawn(CommandSender sender) {
        if (sender instanceof Player player) {
            final DisplayGroup displayGroup = new DisplayGroup(player.getLocation());
            final Transformation transformation = new Transformation(
                new Vector3f(0, 0, 0),
                new AxisAngle4f(0.5f, 0, 0, 0),
                new Vector3f(0.3f, 2.5f, 0.3f),
                new AxisAngle4f(0, 0, 0, 0)
            );
            final Transformation transformation2 = new Transformation(
                new Vector3f(0, 0, 0),
                new AxisAngle4f(-0.35f, 0, 0, -0.93f),
                new Vector3f(0.4f, 0.4f, 0.4f),
                new AxisAngle4f(0, 0, 0, 0)
            );
            final Transformation transformation3 = new Transformation(
                new Vector3f(0, 0, 0),
                new AxisAngle4f(-0.7f, 0.5f, 0, 0),
                new Vector3f(0.4f, 0.4f, 0.4f),
                new AxisAngle4f(0, 0.5f, 0, 0)
            );
            displayGroup.addDisplay(
                "test_object",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(0, 0, 0))
                    .setItemStack(new ItemStack(Material.STICK))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation)
                    .build(displayGroup)
            );
            displayGroup.addDisplay(
                "test_object_2",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(0, 0.1, 0))
                    .setItemStack(new ItemStack(Material.BIG_DRIPLEAF))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation2)
                    .build(displayGroup)
            );
            displayGroup.addDisplay(
                "test_object_3",
                new ItemDisplayBuilder()
                    .setGroupParentOffset(new Vector(0, 0.5, 0))
                    .setItemStack(new ItemStack(Material.BIG_DRIPLEAF))
                    .setBillboard(Display.Billboard.FIXED)
                    .setTransformation(transformation3)
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
            ItemDisplay display = (ItemDisplay) player.getLocation()
                .getWorld()
                .spawnEntity(player.getLocation(), EntityType.ITEM_DISPLAY);
            display.setItemStack(new ItemStack(Material.COOKIE));
            display.setBillboard(Display.Billboard.VERTICAL);
            display.setTransformation(
                new Transformation(
                    new Vector3f(0, 0, 0),
                    new AxisAngle4f(0, 0, 0, 0),
                    new Vector3f(1, 1, 1),
                    new AxisAngle4f(0, 0, 0, 0)
                )
            );
        } else {
            sender.sendMessage("NO!");
        }
    }

}

