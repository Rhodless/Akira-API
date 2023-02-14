package fr.rhodless.akira.uhc.api.prefix;

/*
 * This file is part of Akira-UHC.
 *
 * Copyright © 2023, Rhodless. All rights reserved.
 *
 * Unauthorized using, copying, modifying and/or distributing of this file,
 * via any medium is strictly prohibited. This code is confidential.
 */
public interface PrefixHandler {
    /**
     * Permet de récupérer le prefix de la partie.
     * Cette méthode récupère le prefix stocké dans la configuration.
     *
     * @return le prefix de la partie
     */
    String getPrefix();

    /**
     * Cette méthode récupère le prefix stocké dans la configuration et l'ajoute au string.
     * Cette méthode remplace également les formats de couleur du charactère "et".
     *
     * @param string le string à préfixer
     * @return le string préfixé
     */
    String prefix(String string);
}
