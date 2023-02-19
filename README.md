<br>

<p align="center">
    <img width="200" src="https://imgur.com/AxKQPw9.png" alt="Icon">
</p>

<h3 align="center">
    AKIRA est la nouvelle génération <br>
    d'api pour les modes de jeux uhc
</h3>

<h3 align="center">Développez plus rapidement. &nbsp; Configurez plus facilement.</h3>
<h3 align="center"><a href="https://akira-docs.rhodless.fr" target="_BLANK">» Documentation complète «</a></h3>

<br>

<p align="center">
    <a href="#"><img src="https://img.shields.io/github/v/release/rhodless/akira-api?color=f58a42&include_prereleases&label=version&sort=semver&style=flat-square"></a>
    &nbsp;
    <a href="#"><img src="https://img.shields.io/badge/built_with-Java-dca282.svg?style=flat-square"></a>
    &nbsp;
    <a href="https://github.com/surrealdb/surrealdb/actions"><img src="https://img.shields.io/github/actions/workflow/status/rhodless/akira-api/ci.yml?style=flat-square&branch=main"></a>
    &nbsp;
    <a href="#"><img src="https://img.shields.io/badge/license-MIT-00bfff.svg?style=flat-square"></a>
</p>
<p align="center">
	<a href="#"><img src="https://img.shields.io/discord/1068487764074565642?label=discord&style=flat-square&color=5a66f6"></a>
	&nbsp;
    <a href="https://twitter.com/Rhodless"><img src="https://img.shields.io/badge/twitter-follow-1d9bf0.svg?style=flat-square"></a>
</p>

<h2><img height="20" src="https://imgur.com/AxKQPw9.png">&nbsp;C'est quoi AKIRA ?</h2>
AKIRA vous propose une API très complète pour créer des modes de jeu UHC personnalisés selon vos besoins. Vous pouvez facilement faire tout et n'importe quoi, que ce soit créer des rôles ou des pouvoirs. Tout est entièrement modifiable pour s'adapter à vos préférences.
<br><br>
L'UHC est à 90% configurable, avec des options pour les messages dans le chat, les items dans le lobby, les NPC, et bien plus encore. Vous avez le contrôle total de l'UHC.
<br><br>
Enfin, AKIRA est un UHC très complet qui propose une configuration en jeu très complète. Le plugin contenant entre autre un système de monde très complet avec des options pour changer la génération des minerais, ajouter des limites d'objets, etc. Laissez votre créativité s'exprimer.
  
## Ajouter le projet en dépendance avec Maven
 
Pas besoin de rajouter une repository pour la dépendance. Celle-ci est disponible sur la centrale de Maven.
   
```xml
<dependency>
  <groupId>fr.rhodless.akira</groupId>
  <artifactId>uhc-api</artifactId>
  <version>VERSION</version>
</dependency>
```

## Ajouter le projet en dépendance avec Gradle
 
Pas besoin de rajouter une repository pour la dépendance. Celle-ci est disponible sur la centrale de Maven.
   
```groovy
dependencies {
    compileOnly 'fr.rhodless.akira:uhc-api:VERSION'
}
```

## Conditions requises

### Exigences matérielles

<li>AMD64/x86-64 CPU</li>
<li>Linux ou Windows OS</li>
<li>Connexion internet active et ininterrompue</li>

### Recommandations du hardware

<li>Par instance de serveur</li>
<li>2 CPU cores ou plus</li>
<li>Pas moins de 60 Mo de RAM/joueur et pas moins de 3 Go en tout.</li>

### Besoins logiciels

<li>Java 8 ou plus</li>
<li>ProtocolLib v5.x.x</li>
<li>Spigot ou Paper</li>
<li>Hotspot Java</li>

## Commencer à développer son mode de jeu

<p>
Pour commencer à développer son mode de jeu, il faut définir le module d'UHC.

### Définir le module
```java
public class MyGame extends JavaPlugin {
    @Getter
    private static MyGame instance;

    @Override
    public void onEnable() {
        instance = this;
        
        API.registerModule(new MyGameModule());
    }
}
```

### Créer son module
```java
public class MyGameModule extends Module {
    public MyGameModule() {
        super("Mon Super Module !", "Mon super lien", "1.0.0");
    }

    @Override
    public ChatColor getMainColor() {
        return ChatColor.GREEN;
    }

    @Override
    public List<Camp> getCamps() {
        // mes camps
    }

    @Override
    public List<QuickRoleInfo> getRoles() {
        // mes roles
    }

    @Override
    public String getCommandPrefix() {
        return "prefix";
    }

    @Override
    public String[] getGameDesigners() {
        return new String[]{"Quelqu'un"};
    }

    @Override
    public String[] getContributors() {
        return new String[]{};
    }

    @Override
    public String[] getDevelopers() {
        return new String[]{"Quelqu'un"};
    }

    @Override
    public Camp getHeroesCamp() {
        // l'instance d'un camp
    }

    @Override
    public Camp getVillainsCamp() {
        // l'instance d'un camp
    }

    @Override
    public Camp getOtherCamp() {
        // un troisième camp (peut être null)
    }

    @Override
    public boolean isEnabledRoles() {
        return true;
    }
}
```

### Tout le reste de la documentation est disponible sur le gitbook à cette adresse: [GitBook](https://akira-docs.rhodless.fr) 
