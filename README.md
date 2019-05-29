# ESIR 2 TP 
## Nicolas BOURDIN et Corentin DUCHATELET

Ceci est le rendu de notre TP JPA

Le but du TP étant d'abord de se familiariser avec Hibernate et JPA (Java Persistence API), puis de créer une SPA (Single Page Application) qui utiliserait l'API du SmartDoodle qui accède à la BDD en Hibernate pour afficher des infos sur un front-end, développé ici avec Vue.js, que nous avons pu aborder dans un TP MDI. 

Pour terminer ce TP, nous avons eu beaucoup de mal à lancer l'API REST pour pouvoir y accéder avec le front.

Pour lancer l'application front, faites ```npm install``` puis ```npm run serve```

Il faut avoir installé vue-cli-service avec ```npm i -g @vue/cli @vue/cli-service-global```

Pour lancer l'application back, lancez la BDD avec le script  ```run-hsqldb-server.bat``` puis ```show-hsqldb.bat``` puis lancez l'API REST en Java

L'API est composée d'une partie RestEasy (JAX-RS) pour la partie rest, et Hibernate (JPA) pour la partie persitence/ORM.
Nous n'avons pas réussi à exécuter de container pour notre API REST et elle n'a pas pu être testée. Nous avons pourtant essayer de suivre plusieurs tutoriel, avec la mise en place de Tomcat ou Jboss mais sans succès.

Si problème de connexion avec le front, vérifiez l'url de l'API dans App.vue, ligne 28.
