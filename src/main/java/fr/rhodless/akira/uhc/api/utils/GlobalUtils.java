package fr.rhodless.akira.uhc.api.utils;

import fr.rhodless.akira.uhc.api.API;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Material;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class GlobalUtils {

    private static final DecimalFormat decimalFormater = new DecimalFormat("#.##");

    public static DecimalFormat getDecimalFormater() {
        return decimalFormater;
    }

    public static void spawnParticle(final Location loc, final EnumParticle particle) {
        for (final Player online : Bukkit.getOnlinePlayers()) {
            spawnParticle(online, loc, particle);
        }
    }

    public static String getBeautyHealth(final Player player) {
        return getDecimalFormater().format(player.getHealth() + ((CraftPlayer) player).getHandle().getAbsorptionHearts());
    }

    public static void spawnParticle(final Location loc, final EnumParticle particle, final float xOffset, final float yOffset, final float zOffset, final float speed, final int count) {
        for (final Player online : Bukkit.getOnlinePlayers()) {
            spawnParticle(online, loc, particle, xOffset, yOffset, zOffset, speed, count);
        }
    }

    public static void spawnColoredParticle(final Location loc, final EnumParticle particle, final float red, final float green, final float blue) {
        for (final Player online : Bukkit.getOnlinePlayers()) {
            spawnColoredParticle(online, loc, particle, red, green, blue);
        }
    }

    public static void spawnParticle(final Player player, final Location loc, final EnumParticle particle) {
        spawnParticle(player, loc, particle, 0.0f, 0.0f, 0.0f, 0.0f, 1);
    }

    public static void spawnParticle(final Player player, final Location loc, final EnumParticle particle, final float xOffset, final float yOffset, final float zOffset, final float speed, final int count) {
        final PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particle, true, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), xOffset, yOffset, zOffset, speed, count);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    public static void spawnColoredParticle(final Player player, final Location loc, final EnumParticle particle, final float red, final float green, final float blue) {
        final PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particle, true, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), red, green, blue, 1.0f, 0);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    public static void spawnParticle(final Location loc, final Effect particle) {
        loc.getWorld().playEffect(loc, particle, 1);
    }

    public static void spawnFakeLightning(final Player player, final Location loc) {
        spawnFakeLightning(player, loc, false);
    }

    public static void spawnFakeLightning(final Player player, final Location loc, final boolean isEffect) {
        final EntityPlayer nmsPlayer = ((CraftPlayer) player).getHandle();
        final EntityLightning lightning = new EntityLightning(nmsPlayer.getWorld(), loc.getX(), loc.getY(), loc.getZ(), isEffect, false);
        nmsPlayer.playerConnection.sendPacket(new PacketPlayOutSpawnEntityWeather(lightning));
        player.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 1.0f, 1.0f);
    }

    public static double getDistanceBetweenTwoLocations(final Location one, final Location two) {
        final double minX = Math.min(one.getX(), two.getX());
        final double maxX = Math.max(one.getX(), two.getX());
        final double minZ = Math.min(one.getZ(), two.getZ());
        final double maxZ = Math.max(one.getZ(), two.getZ());
        final double xDiff = maxX - minX;
        final double zDiff = maxZ - minZ;
        return Math.sqrt(xDiff * xDiff + zDiff * zDiff);
    }

    public static void createBeautyExplosion(final Location loc, final int power) {
        createBeautyExplosion(loc, power, false);
    }

    public static void createBeautyExplosion(final Location loc, final int power, final boolean fire) {
        List<Location> blocks = generateSphere(loc, power, false);
        for (final Location blockLoc : blocks) {
            final Block block = blockLoc.getBlock();
            if (block.getType() != Material.AIR && block.getType() != Material.BEDROCK) {
                blockLoc.getBlock().setType(Material.AIR);
            }
        }
    }

    public static List<Player> getNearbyPlayers(final Location loc, final double radius, Player... exclude) {
        List<Player> toExclude = new ArrayList<>(Arrays.asList(exclude));
        return loc.getWorld().getNearbyEntities(loc, radius, radius, radius).stream()
                .filter(entity -> entity instanceof Player)
                .map(entity -> (Player) entity)
                .filter(player -> API.getGameHandler().getPlayers().contains(player.getUniqueId()) &&
                        !toExclude.contains(player) &&
                        player.getGameMode() == GameMode.SURVIVAL)
                .collect(Collectors.toList());
    }

    public static List<Player> getNearbyPlayersUUID(final Location loc, final double radius, UUID... exclude) {
        List<UUID> toExclude = new ArrayList<>(Arrays.asList(exclude));
        return loc.getWorld().getNearbyEntities(loc, radius, radius, radius).stream()
                .filter(entity -> entity instanceof Player)
                .map(entity -> (Player) entity)
                .filter(player -> API.getGameHandler().getPlayers().contains(player.getUniqueId()) &&
                        !toExclude.contains(player.getUniqueId()) &&
                        player.getGameMode() == GameMode.SURVIVAL)
                .collect(Collectors.toList());
    }

    public static List<Player> getNearbyPlayersUUID(final Player p, final double radius, UUID... exclude) {
        List<UUID> toExclude = new ArrayList<>(Arrays.asList(exclude));
        return p.getNearbyEntities(radius, radius, radius).stream()
                .filter(entity -> entity instanceof Player)
                .map(entity -> (Player) entity)
                .filter(player -> API.getGameHandler().getPlayers().contains(player.getUniqueId()) &&
                        !toExclude.contains(player.getUniqueId()) &&
                        player.getGameMode() == GameMode.SURVIVAL)
                .collect(Collectors.toList());
    }

    public static List<Player> getNearbyPlayers(final Player playerToLook, final double radius, Player... exclude) {
        List<Player> toExclude = new ArrayList<>(Arrays.asList(exclude));
        return playerToLook.getNearbyEntities(radius, radius, radius).stream()
                .filter(entity -> entity instanceof Player)
                .map(entity -> (Player) entity)
                .filter(player -> API.getGameHandler().getPlayers().contains(player.getUniqueId()) &&
                        !toExclude.contains(player) &&
                        player.getGameMode() == GameMode.SURVIVAL)
                .collect(Collectors.toList());
    }

    public static List<Location> generateSphere(final Location centerBlock, final int radius, final boolean hollow) {
        if (centerBlock == null) return new ArrayList<>();
        final List<Location> circleBlocks = new ArrayList<>();
        final int bx = centerBlock.getBlockX();
        final int by = centerBlock.getBlockY();
        final int bz = centerBlock.getBlockZ();
        for (int x = bx - radius; x <= bx + radius; ++x) {
            for (int y = by - radius; y <= by + radius; ++y) {
                for (int z = bz - radius; z <= bz + radius; ++z) {
                    final double distance = (bx - x) * (bx - x) + (bz - z) * (bz - z) + (by - y) * (by - y);
                    if (distance < radius * radius && (!hollow || distance >= (radius - 1) * (radius - 1))) {
                        final Location l = new Location(centerBlock.getWorld(), x, y, z);
                        circleBlocks.add(l);
                    }
                }
            }
        }
        return circleBlocks;
    }

    public static String getArrow(Location from, Location to) {
        if (from == null || to == null)
            return "?";
        if (!from.getWorld().getName().equals(to.getWorld().getName()))
            return "?";
        from.setY(0.0D);
        to.setY(0.0D);
        String[] arrows = {"⬆", "⬈", "➡", "⬊", "⬇", "⬋", "⬅", "⬉", "⬆"};
        Vector d = from.getDirection();
        Vector v = to.subtract(from).toVector().normalize();
        double a = Math.toDegrees(Math.atan2(d.getX(), d.getZ()));
        a -= Math.toDegrees(Math.atan2(v.getX(), v.getZ()));
        a = ((int) (a + 22.5D) % 360);
        if (a < 0.0D)
            a += 360.0D;
        return arrows[(int) a / 45];
    }
}