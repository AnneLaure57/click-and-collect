# 1) Initiation

Lancer le fichier h2 pour la base (depuis Git Bash)

```
./h2.sh
``` 

## Générer le jar
```
Faire la commande
mvn -DSkipTests clean package build
``` 

## Démarrer l'application
```
Faire la commande
mvn -DSkipTests clean package build
``` 

# 2) 02/12, ajout de la partie sécurité

## Ajouter la dépendances spring-boot-starter-security
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
``` 

## Créer dans le package fr.ul.miage.clickandcollect.core, WebSecurityConfig
```
package fr.ul.miage.clickandcollect.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

}
``` 

Refaire les commandes du #1 et tester sur Postman ou autre

```
http://localhost:8080/login

essayer avec l'utilisateur user sans mdp

http://localhost:8080/actuator/info

http://localhost:8080/actuators/health -> Start -> up
``` 

Dépôt du prof : https://gitlab.com/rodislav/miage2020/-/tree/master/click-and-collect