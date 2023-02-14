package fr.rhodless.akira.uhc.api.npc;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public class NPC implements ConfigurationSerializable {
    private final String id;
    private final String skinValue;
    private final String skinSignature;
    private final Location location;
    private final List<String> lines;
    private final String command;
    private final boolean enabled;

    /**
     * Permet de créer un npc.
     * Pour récupérer un skin il faut se rendre sur l'API de Mojang :
     * <a href="https://sessionserver.mojang.com/session/minecraft/profile/PLAYER_UUID?unsigned=false">
     * https://sessionserver.mojang.com/session/minecraft/profile/PLAYER_UUID?unsigned=false
     * </a>
     *
     * @param id            l'id du npc
     * @param skinValue     la valeur du skin
     * @param skinSignature la signature du skin
     * @param location      la location du npc
     * @param lines         les lignes du npc
     * @param command       la commande du npc
     * @param enabled       si le npc est activé
     */
    public NPC(String id, String skinValue, String skinSignature, Location location, List<String> lines, String command, boolean enabled) {
        this.id = id;
        this.skinValue = skinValue;
        this.skinSignature = skinSignature;
        this.location = location;
        this.lines = lines;
        this.command = command;
        this.enabled = enabled;
    }

    /**
     * Permet de récupérer l'id du npc.
     *
     * @return l'id du npc
     */
    public String getId() {
        return id;
    }

    /**
     * Permet de récupérer la valeur du skin.
     *
     * @return la valeur du skin
     */
    public String getSkinValue() {
        return skinValue;
    }

    /**
     * Permet de récupérer la signature du skin.
     *
     * @return la signature du skin
     */
    public String getSkinSignature() {
        return skinSignature;
    }

    /**
     * Permet de récupérer la location du npc.
     *
     * @return la location du npc
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Permet de récupérer les lignes du npc.
     *
     * @return les lignes du npc
     */
    public List<String> getLines() {
        return lines;
    }

    /**
     * Permet de récupérer la commande du npc.
     *
     * @return la commande du npc
     */
    public String getCommand() {
        return command;
    }

    /**
     * Permet de savoir si le npc est activé.
     *
     * @return si le npc est activé
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Permet de sérialiser l'objet.
     *
     * @return la map de l'objet
     */
    public Map<String, Object> serialize() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("skinValue", skinValue);
        data.put("skinSignature", skinSignature);
        data.put("location", location);
        data.put("lines", lines);
        data.put("command", command);
        data.put("enabled", enabled);
        return data;
    }

    /**
     * Permet de désérialiser l'objet.
     *
     * @param args la map de l'objet
     * @return l'objet
     */
    public static NPC deserialize(Map<String, Object> args) {
        return new NPC(
                (String) args.get("id"),
                (String) args.get("skinValue"),
                (String) args.get("skinSignature"),
                (Location) args.get("location"),
                (List<String>) args.get("lines"),
                (String) args.get("command"),
                (boolean) args.get("enabled")
        );
    }
}
