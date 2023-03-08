package fr.rhodless.akira.uhc.api.module.power.defaults;

import fr.rhodless.akira.uhc.api.API;
import fr.rhodless.akira.uhc.api.module.power.Power;
import fr.rhodless.menu.api.utils.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public abstract class ItemPower extends Power {
    public ItemPower(int cooldown, int maxUses) {
        super(cooldown, maxUses);
    }

    /**
     * @return l'item qui permet d'activer le pouvoir
     */
    public ItemStack getItemStack() {
        return format(Material.NETHER_STAR, getPowerName()).toItemStack();
    }

    /**
     * Permet de savoir si l'item est similaire à celui du pouvoir
     *
     * @param itemStack l'item à comparer
     * @return true si l'item est similaire à celui du pouvoir
     */
    public boolean isSimilar(ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta() || !itemStack.getItemMeta().hasDisplayName()) return false;

        String itemName = removeClick(itemStack);
        String powerName = removeClick(getItemStack());

        return itemName.equals(powerName) && itemStack.getType().equals(getItemStack().getType());
    }

    /**
     * Permet de récupérer le nom de l'item sans le type de clic
     *
     * @param itemStack l'item à modifier
     * @return le nom de l'item sans le clic
     */
    private String removeClick(ItemStack itemStack) {
        String name = itemStack.getItemMeta().getDisplayName();
        if (name.contains("-droit")) name = name.replace("-droit", "");
        if (name.contains("-gauche")) name = name.replace("-gauche", "");
        return name;
    }

    /**
     * Permet de formater l'item en ajoutant le type de clic à la fin du nom
     *
     * @param it   l'item à formater
     * @param name le nom du pouvoir
     * @return l'item formaté
     */
    protected ItemBuilder format(ItemStack it, String name) {
        String clic = " &7▪ &fClic";
        if (this instanceof RightClickPower || this instanceof RightClickPlayerPower) clic += "-droit";
        if (this instanceof LeftClickPower || this instanceof LeftClickPlayerPower) clic += "-gauche";

        return new ItemBuilder(it).setName(API.getModuleHandler().getCurrentModule().getMainColor() + "&l" + name + clic)
                .addEnchant(Enchantment.DURABILITY, 1).hideItemFlags();
    }

    /**
     * Permet de formater l'item en ajoutant le type de clic à la fin du nom
     *
     * @param material le type de l'item
     * @param name     le nom du pouvoir
     * @return l'item formaté
     */
    protected ItemBuilder format(Material material, String name) {
        return format(new ItemStack(material), name);
    }

    /**
     * Permet de savoir si le pouvoir doit être donné au joueur.
     * Si la méthode retourne false alors l'item ne sera pas donné au joueur lors de l'annonce des rôles.
     *
     * @return true si le pouvoir doit être donné au joueur
     */
    public boolean shouldGiveAtDistribution() {
        return true;
    }

    /**
     * Permet de savoir si l'interaction avec l'item doit être annulée.
     * Par exemple, si l'item est une canne à pêche, alors le clic-droit ne lancera pas la canne à pêche.
     *
     * @return true si l'interaction avec l'item doit être annulée
     */
    public boolean shouldCancelInteraction() {
        return false;
    }
}
