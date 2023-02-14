package fr.rhodless.akira.uhc.api.utils.world;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;


/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class Cuboid {
    private final Location minLoc;

    private final Location maxLoc;

    private final int minX;

    private final int minY;

    private final int minZ;

    private final int maxX;

    private final int maxY;

    private final int maxZ;

    public Cuboid(Location loc1, Location loc2) {
        this.minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        this.maxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
        this.minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        this.maxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
        this.minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        this.maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
        if (loc1.getY() < loc2.getY()) {
            this.minLoc = loc1;
            this.maxLoc = loc2;
        } else if (loc2.getY() < loc1.getY()) {
            this.minLoc = loc2;
            this.maxLoc = loc1;
        } else {
            this.minLoc = loc1;
            this.maxLoc = loc2;
        }
    }

    public Location getMinLoc() {
        return this.minLoc;
    }

    public Location getMaxLoc() {
        return this.maxLoc;
    }

    public World getWorld() {
        return this.minLoc.getWorld();
    }

    public Location getCenter() {
        return new Location(getWorld(), ((this.maxX - this.minX) / 2 + this.minX), ((this.maxY - this.minY) / 2 + this.minY), ((this.maxZ - this.minZ) / 2 + this.minZ));
    }

    public boolean isInside(Location location) {
        if (getWorld() == null)
            return false;
        return (location.getWorld().equals(getWorld()) && location.getX() >= this.minX && location.getX() <= this.maxX && location.getY() >= this.minY && location.getY() <= this.maxY && location.getZ() >= this.minZ && location
                .getZ() <= this.maxZ);
    }

    public List<Block> getBlockList() {
        List<Block> blocks = new ArrayList<>();
        for (int x = this.minX; x <= this.maxX; x++) {
            for (int y = this.minY; y <= this.maxY; y++) {
                for (int z = this.minZ; z <= this.maxZ; z++)
                    blocks.add(getWorld().getBlockAt(x, y, z));
            }
        }
        return blocks;
    }

    public List<Block> getBlockListWithOnly(List<Material> materials) {
        List<Block> blocks = new ArrayList<>();
        for (Block block : getBlockList()) {
            if (materials.contains(block.getType()))
                blocks.add(block);
        }
        return blocks;
    }

    public List<Block> getBlockListWithExcpect(List<Material> materials) {
        List<Block> blocks = new ArrayList<>();
        for (Block block : getBlockList()) {
            if (!materials.contains(block.getType()))
                blocks.add(block);
        }
        return blocks;
    }

    public List<Block> getWalls() {
        List<Block> blocks = new ArrayList<>();
        for (int x = this.minX; x <= this.maxX; x++) {
            for (int i = this.minY; i <= this.maxY; i++) {
                blocks.add(getWorld().getBlockAt(x, i, this.minZ));
                blocks.add(getWorld().getBlockAt(x, i, this.maxZ));
            }
        }
        for (int y = this.minY; y <= this.maxY; y++) {
            for (int z = this.minZ; z <= this.maxZ; z++) {
                blocks.add(getWorld().getBlockAt(this.minX, y, z));
                blocks.add(getWorld().getBlockAt(this.maxX, y, z));
            }
        }
        return blocks;
    }

    public List<Block> getFloor() {
        List<Block> blocks = new ArrayList<>();
        for (int x = this.minX; x < this.maxX; x++) {
            for (int z = this.minZ; z < this.maxZ; z++)
                blocks.add(getWorld().getBlockAt(x, this.minY, z));
        }
        return blocks;
    }

    public int getMinX() {
        return this.minX;
    }

    public int getMinY() {
        return this.minY;
    }

    public int getMinZ() {
        return this.minZ;
    }

    public int getMaxX() {
        return this.maxX;
    }

    public int getMaxY() {
        return this.maxY;
    }

    public int getMaxZ() {
        return this.maxZ;
    }
}