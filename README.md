# Akira-API

<h2><img height="20" src="/img/whatissurreal.svg">&nbsp;&nbsp;C'est quoi AKIRA ?</h2>
AKIRA vous propose une API très complète pour créer des modes de jeu UHC personnalisés selon vos besoins. Vous pouvez facilement faire tout et n'importe quoi, que ce soit créer des rôles ou des pouvoirs. Tout est entièrement modifiable pour s'adapter à vos préférences.
<br><br>
L'UHC est à 90% configurable, avec des options pour les messages dans le chat, les items dans le lobby, les NPC, et bien plus encore. Vous avez le contrôle total de l'UHC.
<br><br>
Enfin, AKIRA est un UHC très complet qui propose une configuration en jeu très complète. Le plugin contenant entre autre un système de monde très complet avec des options pour changer la génération des minerais, ajouter des limites d'objets, etc. Laissez votre créativité s'exprimer.

## Authentification
Vous pouvez vous authentifier avec GitHub pour Maven en modifiant votre fichier *\~/.m2/settings.xml* afin d'ajouter votre token personnel. Créez un nouveau fichier *\~/.m2/settings.xml* s'il n'en existe pas.

Dans la balise `servers`, ajoutez une balise `server` avec un `id`, en remplaçant *USERNAME* par votre nom d'utilisateur GitHub, et *TOKEN* par votre token d'accès personnel.

<a href="https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token">Comment créer un token d'accès personnel ?<a/>

Exemple de fichier `settings.xml`
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
          http://maven.apache.org/xsd/settings-1.0.0.xsd">
  
  <servers>
    <server>
      <id>akira</id>
      <username>Rhodless</username>
      <password>mon_super_token</password>
    </server>
  </servers>
</settings>

```
  
## Ajouter le projet en dépendance avec Maven
 
```xml
<repository>
  <id>akira</id>
  <url>https://maven.pkg.github.com/Rhodless/AKIRA-API</url>
</repository>
```
   
```xml
<dependency>
  <groupId>fr.rhodless</groupId>
  <artifactId>akira-api</artifactId>
  <version>VERSION</version>
</dependency>
```

## Ajouter le projet en dépendance avec Gradle
 
```groovy
repositories {
    maven { url 'https://maven.pkg.github.com/Rhodless/AKIRA-API' }
}
```
   
```groovy
dependencies {
    compileOnly 'fr.rhodless:akira-api:VERSION'
}
```

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
