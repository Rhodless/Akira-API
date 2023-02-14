package fr.rhodless.akira.uhc.api.game.config.list;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface ConfigurationEnchantments {
    /**
     * Permet de récupérer la limite de protection pour l'armure en fer.
     *
     * @return la limite de protection pour l'armure en fer
     */
    int getIronProtectionLimit();

    /**
     * Permet de définir la limite de protection pour l'armure en fer.
     *
     * @param ironProtectionLimit la limite de protection pour l'armure en fer
     */
    void setIronProtectionLimit(int ironProtectionLimit);

    /**
     * Permet de récupérer la limite de protection pour l'armure en diamant.
     *
     * @return la limite de protection pour l'armure en diamant
     */
    int getDiamondProtectionLimit();

    /**
     * Permet de définir la limite de protection pour l'armure en diamant.
     *
     * @param diamondProtectionLimit la limite de protection pour l'armure en diamant
     */
    void setDiamondProtectionLimit(int diamondProtectionLimit);

    /**
     * Permet de récupérer la limite de sharpness pour l'épée en fer.
     *
     * @return la limite de sharpness pour l'épée en fer
     */
    int getIronSharpnessLimit();

    /**
     * Permet de définir la limite de sharpness pour l'épée en fer.
     *
     * @param ironSharpnessLimit la limite de sharpness pour l'épée en fer
     */
    void setIronSharpnessLimit(int ironSharpnessLimit);

    /**
     * Permet de récupérer la limite de sharpness pour l'épée en diamant.
     *
     * @return la limite de sharpness pour l'épée en diamant
     */
    int getDiamondSharpnessLimit();

    /**
     * Permet de définir la limite de sharpness pour l'épée en diamant.
     *
     * @param diamondSharpnessLimit la limite de sharpness pour l'épée en diamant
     */
    void setDiamondSharpnessLimit(int diamondSharpnessLimit);

    /**
     * Permet de récupérer la limite de sharpness pour l'épée en diamant.
     *
     * @return la limite de sharpness pour l'épée en diamant
     */
    int getPowerLimit();

    /**
     * Permet de définir la limite de sharpness pour l'épée en diamant.
     *
     * @param powerLimit la limite de sharpness pour l'épée en diamant
     */
    void setPowerLimit(int powerLimit);
}
