# Traditional T9
Ce manuel explique comment configurer et utiliser Traditional T9 dans différents scénarios. Pour les instructions d'installation et des informations sur les versions "lite" et "complète", consultez le [guide d'installation](https://github.com/sspanak/tt9/blob/master/docs/installation.md) sur GitHub. Enfin, vous pouvez également consulter la [page principale du dépôt](https://github.com/sspanak/tt9), qui inclut tout le code source, un guide du développeur, la politique de confidentialité, et la documentation supplémentaire.

## Configuration initiale
Après l'installation, il est d'abord nécessaire d'activer Traditional T9 comme clavier Android. Pour cela, cliquez sur l'icône de l'application. Si une action est nécessaire, toutes les options à l'exception de "Configuration initiale" seront désactivées, et une étiquette "TT9 est désactivé" sera affichée. Allez dans "Configuration initiale" et activez-le.

_Si l'icône n'apparaît pas immédiatement après l'installation, redémarrez votre téléphone et elle devrait apparaître. Cela est dû à Android qui essaie d'économiser de l'énergie en ne rafraîchissant pas la liste des applications nouvellement installées._

### Utilisation sur un téléphone à écran tactile uniquement
Sur les appareils à écran tactile, il est fortement recommandé de désactiver le correcteur orthographique du système. Il ne peut pas être utilisé lors de la saisie avec les touches numériques, ce qui vous permet de prolonger l'autonomie de la batterie en le désactivant.

Un autre problème est que le correcteur orthographique peut afficher une fenêtre contextuelle "Ajouter un mot" qui ajoute des mots au clavier système par défaut (souvent Gboard) et non au dictionnaire de Traditional T9. Pour éviter cela, le correcteur orthographique du système doit être désactivé.

Si vous devez effectuer cette étape, l'élément "Correcteur orthographique système" dans l'écran de configuration initiale sera activé. Cliquez dessus pour désactiver le composant système. Si cet élément n'est pas visible, vous n'avez rien d'autre à faire.

Une fois la configuration terminée, consultez la section [Pavé numérique à l’écran](#pavé-numérique-à-l-écran) pour des astuces supplémentaires.

### Activation du Mode Prédictif
Le Mode Prédictif nécessite le chargement d’un dictionnaire linguistique pour proposer des suggestions de mots. Vous pouvez activer les langues et charger leurs dictionnaires depuis Écran de Paramètres → [Langues](#options-de-langue). Si vous oubliez de charger un dictionnaire, Traditional T9 le fera automatiquement au début de la saisie. Pour plus d'informations, [voir ci-dessous](#options-de-langue).

#### Remarques pour les téléphones bas de gamme
Le chargement du dictionnaire peut saturer les téléphones bas de gamme. Avec la version "lite" de TT9, cela peut entraîner l'abandon de l'opération par Android. Si le chargement prend plus de 30 secondes, branchez le chargeur ou assurez-vous que l’écran reste allumé pendant le chargement.

Vous pouvez éviter cela en utilisant la version "complète" à la place.

#### Remarques pour Android 13 ou version supérieure
Par défaut, les notifications pour les applications nouvellement installées sont désactivées. Il est recommandé de les activer. Cela vous permet d’être informé des mises à jour des dictionnaires, et une fois que vous choisissez de les installer, TT9 affichera la progression du chargement. Les nouvelles mises à jour sont publiées au maximum une fois par mois, vous n’avez donc pas à craindre un excès de notifications.

Vous pouvez activer les notifications en allant dans Paramètres → Langues et en activant Notifications de Dictionnaire.

_Si vous choisissez de les garder désactivées, TT9 continuera de fonctionner sans problème, mais vous devrez gérer manuellement les dictionnaires._

## Raccourcis clavier

Tous les raccourcis clavier peuvent être reconfigurés ou désactivés via Paramètres → Clavier → Sélectionner les Raccourcis.

### Touches de saisie

#### Touche de suggestion précédente (par défaut : flèche gauche) :
Sélectionne la suggestion de mot ou de lettre précédente.

#### Touche de suggestion suivante (par défaut : flèche droite) :
Sélectionne la suggestion de mot ou de lettre suivante.

#### Touche de filtrage des suggestions (par défaut : flèche vers le haut) :
_Mode Prédictif uniquement._

- **Appui simple** : Filtre la liste des suggestions, ne laissant que celles qui commencent par le mot actuel. Par exemple, tapez "remin" et appuyez sur Filtrer pour ne garder que les mots commençant par "remin" : "remin", "remind", "reminds", "reminded", "reminding", etc.
- **Double appui** : Élargit le filtre à la suggestion complète. Par exemple, tapez "remin" et appuyez deux fois sur Filtrer pour filtrer par "remind". Vous pouvez continuer à élargir le filtre jusqu'à obtenir le mot le plus long du dictionnaire.

Le filtrage est aussi utile pour taper des mots inconnus. Par exemple, pour taper "Anakin", commencez par "A", puis appuyez sur Filtrer pour masquer "B" et "C". Appuyez ensuite sur la touche 6. Avec le filtre activé, cela proposera toutes les combinaisons possibles pour 1+6 : "A..." + "m", "n", "o". Sélectionnez "n" et appuyez sur Filtrer pour valider votre sélection et obtenir "An". Ensuite, appuyez sur la touche 2 pour obtenir "An..." + "a", "b", "c". Continuez jusqu’à obtenir "Anakin".

Lorsque le filtrage est activé, le texte de base devient en gras et en italique.

#### Touche Effacer le Filtre (par défaut : flèche vers le bas) :
_Mode Prédictif uniquement._

Efface le filtre des suggestions, si appliqué.

#### Touche centrale (OK ou Entrée) :
- Lorsque des suggestions sont affichées, saisit la suggestion sélectionnée.
- Sinon, exécute l’action par défaut de l’application (par exemple, envoyer un message, accéder à une URL, ou insérer un retour à la ligne).

_**Remarque** : Chaque application décide de la fonction à effectuer lorsqu’OK est pressé, et TT9 n'a aucun contrôle sur ce comportement._

_**Remarque 2** : Pour envoyer des messages avec OK dans les applications de messagerie, vous devez activer leur paramètre "Envoyer avec Entrée" ou un paramètre similaire. Si l'application n'a pas de tel paramètre, elle ne supporte probablement pas l'envoi par cette méthode. Dans ce cas, utilisez l'application KeyMapper depuis le [Play Store](https://play.google.com/store/apps/details?id=io.github.sds100.keymapper) ou [F-droid](https://f-droid.org/packages/io.github.sds100.keymapper/). Elle peut détecter les applications de messagerie et simuler une touche sur le bouton d'envoi de message. Consultez le [guide de démarrage rapide](https://docs.keymapper.club/quick-start/) pour plus d'informations._

#### Touche 0 :
- **En mode 123 :**
  - **Appui** : tape "0".
  - **Appui long** : tape des caractères spéciaux/mathématiques.
  - **Appui long sur "0", puis appui sur Maj (par défaut : appui long sur "0", puis sur "✱") :** tape des symboles monétaires.
- **En mode ABC :**
  - **Appui** : tape espace, nouvelle ligne, ou caractères spéciaux/mathématiques.
  - **Appui long** : tape "0".
  - **Appui sur "0", puis appui sur Maj (par défaut : appui sur "0", "✱") :** tape des symboles monétaires.
- **En mode Prédictif :**
  - **Appui** : tape un espace, une nouvelle ligne, ou caractères spéciaux/mathématiques.
  - **Double appui** : tape le caractère attribué dans les paramètres du mode Prédictif (par défaut : ".").
  - **Appui long** : tape "0".
  - **Appui sur "0", puis appui sur Maj (par défaut : appui sur "0", "✱") :** tape des symboles monétaires.
- **En mode Cheonjiin (Coréen) :**
  - **Appui :** tape "ㅇ" et "ㅁ".
  - **Appui long :** tape un espace, une nouvelle ligne, "0" ou des caractères spéciaux/mathématiques.
  - **Appui long sur "0", puis appui sur Maj (Par défaut : appui long sur "0", appuyer sur "✱") :** tape des symboles monétaires.

#### Touche 1 :
- **En mode 123 :**
  - **Appui** : tape "1".
  - **Appui long** : tape des caractères de ponctuation.
- **En mode ABC :**
  - **Appui** : tape des caractères de ponctuation.
  - **Appui long** : tape "1".
- **En mode Prédictif :**
  - **Appui** : tape des caractères de ponctuation.
  - **Appui multiple** : tape des émojis.
  - **Appui 1-1-3** : tape des émojis ajoutés (vous devez en ajouter en utilisant [la touche Ajouter un Mot](#touche-ajouter-un-mot)).
  - **Appui long** : tape "1".
- **En mode Cheonjiin (Coréen) :**
  - **Appui :** tape la voyelle "ㅣ".
  - **Appui long :** tape des caractères de ponctuation.
  - **Appui long, puis appui court :** tape des emojis.
  - **Appui long sur 1, appui sur 1, puis sur 3 :** tape des emojis ajoutés (vous devez en ajouter en utilisant [la touche Ajouter un Mot](#touche-ajouter-un-mot)).

#### Touche 2 à 9 :
- **En mode 123** : tape le chiffre correspondant.
- **En mode ABC et Prédictif** : tape une lettre ou appuyez longuement pour taper le chiffre correspondant.

### Touches de fonction

#### Touche Ajouter un Mot :
Ajoute un nouveau mot au dictionnaire pour la langue actuelle.

Vous pouvez également ajouter de nouveaux émojis, accessibles en appuyant sur 1-1-3. Indépendamment de la langue sélectionnée, tous les émojis sont disponibles dans toutes les langues.

#### Touche Retour Arrière (Retour, Suppr, ou Retour Arrière) :
Supprime du texte.

Si votre téléphone a une touche "Suppr" ou "Effacer" dédiée, vous n'avez rien à configurer, sauf si vous souhaitez un autre Retour Arrière. Dans ce cas, l’option vide : "--" sera automatiquement présélectionnée.

Sur les téléphones avec une touche combinée "Supprimer"/"Retour", cette touche sera sélectionnée automatiquement. Vous pouvez néanmoins attribuer la fonction "Retour Arrière" à une autre touche pour que "Retour" n’ait qu’une fonction de navigation.

_**NB** : Utiliser "Retour" comme retour arrière ne fonctionne pas dans toutes les applications, notamment Firefox, Spotify, et Termux, car ces applications peuvent redéfinir la fonction de la touche. "Retour" ayant un rôle spécial dans Android, son usage est limité par le système._

_**NB 2** : Maintenir la touche "Retour" déclenche toujours l’action système par défaut (par exemple, afficher la liste des applications en cours)._

_Dans ces cas, vous pouvez attribuer une autre touche (toutes les autres sont utilisables) ou utiliser le retour arrière à l’écran._

#### Touche Changer de Mode de Saisie (par défaut : appui sur #) :
Change le mode de saisie (abc → Prédictif → 123).

_Le mode Prédictif n'est pas disponible dans les champs de mot de passe._

_Dans les champs numériques uniquement, changer de mode est impossible. Dans ce cas, la touche revient à sa fonction par défaut (c’est-à-dire taper "#")._

#### Touche Modifier le Texte :
Affiche le panneau de modification de texte, permettant de sélectionner, couper, copier et coller du texte. Vous pouvez fermer le panneau en appuyant à nouveau sur la touche "✱" ou, dans la plupart des applications, en appuyant sur le bouton Retour. Détails disponibles [ci-dessous](#édition-de-texte).

#### Touche Langue Suivante (par défaut : appui long sur #) :
Sélectionne la langue suivante lorsque plusieurs langues sont activées dans les Paramètres.

#### Touche Sélectionner le Clavier :
Ouvre la boîte de dialogue de changement de clavier d'Android, où vous pouvez choisir parmi tous les claviers installés.

#### Touche Maj (par défaut : appui sur ✱) :
- **Lors de la saisie de texte** : Alterne entre majuscules et minuscules.
- **Lors de la saisie de caractères spéciaux avec la touche 0** : Affiche le groupe de caractères suivant.

#### Touche Afficher les Paramètres :
Ouvre l’écran de configuration des Paramètres, où vous pouvez choisir les langues pour la saisie, configurer les raccourcis clavier, modifier l’apparence de l’application, ou améliorer la compatibilité avec votre téléphone.

#### Touche Saisie Vocale :
Active la saisie vocale pour les téléphones compatibles. Voir [ci-dessous](#saisie-vocale) pour plus d'informations.

#### Touche Liste des Commandes / Palette de Commandes / (par défaut : appui long sur ✱) :
Affiche une liste de toutes les commandes (ou fonctions).

De nombreux téléphones ont seulement deux ou trois touches "libres" pouvant être utilisées comme raccourcis. Mais, Traditional T9 a beaucoup plus de fonctions, donc il est impossible de toutes les avoir sur le clavier. La Palette de Commandes résout ce problème en permettant d’invoquer des fonctions supplémentaires via des combinaisons de touches.

Voici une liste des commandes possibles :
- **Afficher l’Écran des Paramètres (Combo par défaut : appui long sur ✱, touche 1).** Identique à l’appui sur [Afficher les Paramètres](#touche-afficher-les-paramètres).
- **Ajouter un Mot (Combo par défaut : appui long sur ✱, touche 2).** Identique à l’appui sur [Ajouter un Mot](#touche-ajouter-un-mot).
- **Saisie Vocale (Combo par défaut : appui long sur ✱, touche 3).** Identique à l’appui sur [Saisie Vocale](#touche-saisie-vocale).
- **Modifier le Texte (Combo par défaut : appui long sur ✱, touche 5).** Identique à l’appui sur [Modifier le Texte](#touche-modifier-le-texte).
- **Sélectionner un Clavier Différent (Combo par défaut : appui long sur ✱, touche 8).** Identique à l’appui sur [Sélectionner le Clavier](#touche-sélectionner-le-clavier).

_Cette touche ne fait rien lorsque l'Affichage de l'Écran est réglé sur "Pavé Virtuel", car toutes les touches pour toutes les fonctions possibles sont déjà disponibles à l’écran._

## Saisie vocale
La fonction de saisie vocale permet de convertir la voix en texte, similaire à Gboard. Comme tous les autres claviers, Traditional T9 ne réalise pas lui-même la reconnaissance vocale, mais il demande à votre téléphone de le faire.

_Le bouton de saisie vocale est masqué sur les appareils qui ne le prennent pas en charge._

### Appareils pris en charge
Sur les appareils avec les services Google, il utilise l'infrastructure de Google Cloud pour convertir vos paroles en texte. Vous devez être connecté à un réseau Wi-Fi ou activer les données mobiles pour que cette méthode fonctionne.

Sur les appareils sans Google, si l'appareil dispose d'une application d'assistant vocal ou si le clavier natif prend en charge la saisie vocale, ce qui est disponible sera utilisé pour la reconnaissance vocale. Notez que cette méthode est nettement moins performante que Google. Elle ne fonctionnera pas dans un environnement bruyant et reconnaîtra généralement uniquement des phrases simples, telles que : « ouvrir le calendrier » ou « jouer de la musique ». L'avantage est qu'elle fonctionne hors ligne.

Les autres téléphones sans Google ne prendront généralement pas en charge la saisie vocale. Les téléphones chinois n'ont pas de capacités de reconnaissance vocale en raison des politiques de sécurité chinoises. Sur ces téléphones, il peut être possible d'activer la saisie vocale en installant l'application Google, nom de package : « com.google.android.googlequicksearchbox ».

## Pavé numérique à l'écran
Sur les téléphones entièrement tactiles, un pavé numérique complet est disponible et sera activé automatiquement. Si, pour une raison quelconque, votre téléphone n'a pas été détecté comme ayant un écran tactile, activez-le en allant dans Paramètres → Apparence → Disposition à l'écran et en sélectionnant « Pavé numérique virtuel ».

Si vous disposez d'un écran tactile et d'un pavé numérique matériel et préférez avoir plus d'espace à l'écran, désactivez les touches logicielles dans Paramètres → Apparence.

Il est également recommandé de désactiver le comportement spécial de la touche « Retour » fonctionnant comme « Effacer ». Cette option est utile uniquement pour un clavier matériel. Habituellement, cela se fait automatiquement, mais si ce n'est pas le cas, allez dans Paramètres → Clavier → Sélectionner les raccourcis → Touche Effacer, puis sélectionnez l'option « -- ».

### Aperçu des touches virtuelles
Le clavier à l'écran fonctionne de la même manière que le pavé numérique d'un téléphone avec des touches physiques. Si une touche offre une seule fonction, elle comporte une seule étiquette (ou icône) indiquant cette fonction. Si la touche offre une fonction secondaire lorsque vous la maintenez enfoncée, elle comportera deux étiquettes (ou icônes).

Voici une description des touches ayant plus d'une fonction.

#### Touche F2 droite (deuxième touche en partant du haut dans la colonne de droite)
_Mode prédictif uniquement._

- **Appuyer :** Filtre la liste des suggestions. Voir [ci-dessus](#touche-de-filtrage-des-suggestions-par-défaut-flèche-vers-le-haut) pour savoir comment fonctionne le filtrage des mots.
- **Maintenir enfoncé :** Supprime le filtre, s'il est actif.

#### Touche F3 droite (troisième touche en partant du haut dans la colonne de droite)
- **Appuyer :** Ouvre les options de copier-coller et d'édition de texte.
- **Maintenir enfoncé :** Active l'entrée vocale.

#### Touche F4 gauche (la touche en bas à gauche)
- **Appuyer :** Alterne entre les modes de saisie (abc → Prédictif → 123).
- **Maintenir enfoncé :** Passe à la langue suivante, si plusieurs langues ont été activées dans les paramètres.
- **Balayer horizontalement :** Passe au dernier clavier utilisé, autre que TT9.
- **Balayer verticalement :** Ouvre la boîte de dialogue de changement de clavier Android où vous pouvez sélectionner parmi tous les claviers installés.

_La touche affichera une petite icône de globe si vous avez activé plus d'une langue dans Paramètres → Langues. L'icône indique qu'il est possible de changer de langue en maintenant la touche enfoncée._

### Redimensionner le panneau du clavier pendant la saisie
Dans certains cas, vous pouvez trouver que le pavé numérique virtuel occupe trop d'espace à l'écran, vous empêchant de voir ce que vous tapez ou certains éléments de l'application. Si c'est le cas, vous pouvez le redimensionner en maintenant enfoncée et en faisant glisser la touche Paramètres/Palette de commandes ou en faisant glisser la barre d'état (elle affiche la langue ou le mode de saisie actuel). Lorsque la hauteur devient trop petite, la disposition sera automatiquement changée en « touches de fonction » ou en « liste de suggestions uniquement ». Respectivement, en redimensionnant vers le haut, la disposition reviendra au « pavé numérique virtuel ». Vous pouvez également double-cliquer sur la barre d'état pour minimiser ou maximiser instantanément.

_Redimensionner Traditional T9 entraîne également le redimensionnement de l'application en cours. Faire les deux est très exigeant en ressources et peut provoquer un scintillement ou des ralentissements sur de nombreux téléphones, même ceux de gamme supérieure._

### Changer la hauteur des touches
Il est également possible de modifier la hauteur des touches à l'écran. Pour ce faire, allez dans Paramètres → Apparence → Hauteur des touches et ajustez-la selon vos préférences.

La valeur par défaut de 100 % est un bon compromis entre une taille de bouton utilisable et l’espace occupé sur l’écran. Cependant, si vous avez de grands doigts, vous voudrez peut-être augmenter un peu cette valeur, tandis que si vous utilisez TT9 sur un écran plus grand, comme une tablette, vous souhaiterez peut-être la réduire.

_Si l'espace disponible à l'écran est limité, TT9 ignorera ce paramètre et réduira automatiquement sa hauteur, pour laisser suffisamment de place à l'application en cours._

## Édition de texte
Depuis le panneau d'édition de texte, vous pouvez sélectionner, couper, copier et coller du texte, de la même manière qu'avec un clavier d'ordinateur. Pour quitter l'édition de texte, appuyez sur la touche « ✱ » ou sur la touche Retour (sauf dans les navigateurs Web, Spotify et quelques autres applications). Ou appuyez sur la touche de lettres du clavier à l'écran.

Voici une liste des commandes de texte possibles :
1. Sélectionner le caractère précédent (comme Shift+Gauche sur un clavier d'ordinateur)
2. Ne rien sélectionner
3. Sélectionner le caractère suivant (comme Shift+Droite)
4. Sélectionner le mot précédent (comme Ctrl+Shift+Gauche)
5. Tout sélectionner
6. Sélectionner le mot suivant (comme Ctrl+Shift+Droite)
7. Couper
8. Copier
9. Coller

Pour faciliter l'édition, les touches d'effacement, d'espace et de validation sont également actives.

## Écran des paramètres
Sur l’écran des paramètres, vous pouvez choisir les langues de saisie, configurer les touches de raccourci du pavé numérique, changer l'apparence de l'application ou améliorer la compatibilité avec votre téléphone.

### Comment accéder aux paramètres ?

#### Méthode 1
Cliquez sur l'icône de lancement de Traditional T9.

#### Méthode 2 (avec un écran tactile)
- Appuyez sur un champ de texte ou de numéro pour activer TT9.
- Utilisez le bouton d'engrenage à l'écran.

#### Méthode 3 (avec un clavier physique)
- Commencez à taper dans un champ de texte ou de numéro pour activer TT9.
- Ouvrez la liste de commandes en utilisant le bouton d'outils à l'écran ou en appuyant sur la touche de raccourci attribuée [par défaut : Maintenez ✱].
- Appuyez sur la touche 2.

### Naviguer dans les paramètres
Si vous disposez d'un clavier matériel, il existe deux manières de naviguer dans les paramètres.

1. Utilisez les touches Haut/Bas pour faire défiler et OK pour ouvrir ou activer une option.
2. Appuyez sur les touches de 1 à 9 pour sélectionner l'option correspondante et appuyez deux fois dessus pour l’ouvrir/activer. L'appui double fonctionne peu importe où vous êtes à l'écran. Par exemple, même si vous êtes en haut, appuyer deux fois sur la touche 3 activera la troisième option. Enfin, la touche 0 est un raccourci pratique pour faire défiler jusqu'à la fin mais n'ouvre pas la dernière option.

### Options de langue

#### Chargement d'un dictionnaire
Après avoir activé une ou plusieurs nouvelles langues, vous devez charger les dictionnaires correspondants pour le mode prédictif. Une fois un dictionnaire chargé, il restera jusqu'à ce que vous utilisiez l'une des options de « suppression ». Cela signifie que vous pouvez activer et désactiver les langues sans recharger leurs dictionnaires à chaque fois, seulement une fois au début.

Cela signifie aussi que si vous devez utiliser la langue X, vous pouvez désactiver toutes les autres langues, charger uniquement le dictionnaire X (et gagner du temps !), puis réactiver toutes les langues que vous utilisiez auparavant.

Gardez à l’esprit que le rechargement d'un dictionnaire réinitialisera la popularité des suggestions aux valeurs par défaut. Toutefois, il n'y a pas de quoi s'inquiéter. Dans la plupart des cas, vous verrez peu ou pas de différence dans l'ordre des suggestions, sauf si vous utilisez fréquemment des mots peu courants.

#### Chargement automatique du dictionnaire

Si vous oubliez de charger un dictionnaire depuis l'écran des paramètres, cela se fera automatiquement plus tard, lorsque vous ouvrirez une application dans laquelle vous pouvez taper et que vous passerez en mode prédictif. Vous serez invité à patienter pendant le chargement, et après cela, vous pourrez commencer à taper immédiatement.

Si vous supprimez un ou plusieurs dictionnaires, ils ne se rechargeront PAS automatiquement. Vous devrez le faire manuellement. Seuls les dictionnaires pour les langues nouvellement activées se chargeront automatiquement.

#### Suppression d'un dictionnaire
Si vous avez cessé d'utiliser les langues X ou Y, vous pouvez les désactiver et utiliser l'option « Supprimer les non-sélectionnés » pour libérer de l'espace de stockage.

Pour tout supprimer, indépendamment de la sélection, utilisez « Tout supprimer ».

Dans tous les cas, vos mots ajoutés personnalisés seront préservés et restaurés une fois que vous rechargerez les dictionnaires plus tard.

#### Mots ajoutés
L'option "Exporter" vous permet d'exporter tous les mots ajoutés, pour toutes les langues, y compris les émojis ajoutés, dans un fichier CSV. Ensuite, vous pouvez utiliser ce fichier CSV pour améliorer Traditional T9 ! Rendez-vous sur GitHub et partagez les mots dans un [nouveau ticket](https://github.com/sspanak/tt9/issues) ou une [pull request](https://github.com/sspanak/tt9/pulls). Une fois révisés et approuvés, ils seront inclus dans la prochaine version.

Avec "Importer", vous pouvez importer un fichier CSV précédemment exporté. Cependant, il y a certaines restrictions :
- Vous pouvez importer uniquement des mots constitués de lettres. Les apostrophes, tirets, autres signes de ponctuation ou caractères spéciaux ne sont pas autorisés.
- Les émojis ne sont pas autorisés.
- Un fichier CSV peut contenir un maximum de 250 mots.
- Vous pouvez importer jusqu'à 1000 mots, ce qui signifie que vous pouvez importer au maximum 4 fichiers de 250 mots chacun. Au-delà de cette limite, vous pourrez toujours ajouter des mots en les tapant.

L'option "Supprimer" vous permet de rechercher et de supprimer les mots mal orthographiés ou ceux que vous ne souhaitez plus dans le dictionnaire.

### Options de compatibilité
Pour certaines applications ou appareils, il est possible d'activer des options spéciales, qui permettront à Traditional T9 de mieux fonctionner avec eux. Vous les trouverez à la fin de chaque écran de paramètres, dans la section Compatibilité.

#### Méthode alternative de défilement des suggestions
_Dans : Paramètres → Apparence._

Sur certains appareils, en mode prédictif, il peut être impossible de faire défiler la liste jusqu'à la fin, ou vous devrez faire défiler plusieurs fois en arrière et en avant jusqu'à ce que la dernière suggestion apparaisse. Ce problème survient parfois sur Android 9 ou les versions antérieures. Activez cette option si vous rencontrez ce problème.

#### Toujours au premier plan
_Dans : Paramètres → Apparence._

Sur certains téléphones, notamment le Sonim XP3plus (XP3900), Traditional T9 peut ne pas s'afficher lorsque vous commencez à taper, ou il peut être partiellement couvert par les touches virtuelles. Dans d'autres cas, il peut y avoir des bandes blanches autour. Ce problème peut se produire dans une application spécifique ou dans toutes. Pour l’éviter, activez l'option « Toujours au premier plan ».

#### Protection contre la répétition des touches
_Dans : Paramètres → Clavier._

Les téléphones CAT S22 Flip et Qin F21 sont connus pour leurs claviers de mauvaise qualité qui se dégradent rapidement avec le temps et commencent à enregistrer plusieurs clics pour une seule pression. Vous pouvez le remarquer en tapant ou en naviguant dans les menus du téléphone.

Pour les téléphones CAT, la valeur recommandée est de 50 à 75 ms. Pour le Qin F21, essayez entre 20 et 30 ms. Si le problème persiste, augmentez la valeur légèrement, mais essayez de la garder aussi basse que possible.

_**Remarque :** Plus la valeur est élevée, plus vous devrez taper lentement. TT9 ignorera les pressions très rapides._

_**Remarque 2 :** Outre ce qui précède, les téléphones Qin peuvent également ne pas détecter les pressions longues. Malheureusement, dans ce cas, rien ne peut être fait._

#### Les stickers et panneaux d'emoji de Telegram/Snapchat ne s'ouvrent pas
Cela se produit si vous utilisez l'un des petits formats de clavier. Actuellement, il n'existe pas de solution permanente, mais vous pouvez utiliser la solution suivante :
- Allez dans Paramètres → Apparence et activez le Pavé numérique à l'écran.
- Retournez dans le chat et cliquez sur le bouton emoji ou stickers. Ils apparaîtront maintenant.
- Vous pouvez maintenant retourner dans les paramètres et désactiver le pavé numérique à l'écran. Les panneaux d'emoji et de stickers resteront accessibles jusqu'à ce que vous redémarriez l'application ou le téléphone.

#### Traditional T9 ne s'affiche pas immédiatement dans certaines applications
Si vous avez ouvert une application dans laquelle vous pouvez taper, mais que TT9 n'apparaît pas automatiquement, commencez simplement à taper et il apparaîtra. Sinon, appuyez sur les touches de raccourci pour changer [le mode de saisie](#touche-changer-de-mode-de-saisie-par-défaut-appui-sur) ou la [langue](#touche-langue-suivante-par-défaut-appui-long-sur) pour faire apparaître TT9 s'il est caché.

Sur certains appareils, TT9 peut rester invisible, peu importe ce que vous faites. Dans ce cas, vous devez activer l'option [Toujours au premier plan](#toujours-au-premier-plan).

**Explication longue.** Ce problème est dû au fait qu'Android est principalement conçu pour les appareils à écran tactile, et attend donc que vous touchiez le champ texte/numéro pour afficher le clavier. Il est possible de faire apparaître TT9 sans cette confirmation, mais dans certains cas, Android oubliera alors de le cacher quand il le devrait, par exemple après avoir composé un numéro de téléphone ou après avoir soumis un texte dans un champ de recherche.

Pour cette raison, et afin de respecter les normes Android, le contrôle est entre vos mains. Appuyez simplement sur une touche pour « toucher » l'écran et continuez à taper.

#### Sur le Qin F21 Pro, maintenir enfoncée la touche 2 ou 8 augmente ou diminue le volume au lieu de taper un chiffre
Pour atténuer ce problème, allez dans Paramètres → Apparence et activez « Icône de statut ». TT9 devrait détecter automatiquement le Qin F21 et activer les paramètres, mais si la détection automatique échoue ou si vous avez désactivé l'icône pour une raison quelconque, vous devez l'activer pour que toutes les touches fonctionnent correctement.

**Explication longue.** Le Qin F21 Pro (et peut-être le F22) a une application de raccourcis qui permet d'assigner les fonctions de Volume Haut et Bas aux touches numériques. Par défaut, le gestionnaire de raccourcis est activé et maintenir la touche 2 augmente le volume, tandis que maintenir la touche 8 le diminue. Cependant, lorsque l'icône de statut est absente, le gestionnaire suppose qu'aucun clavier n'est actif et ajuste le volume au lieu de permettre à Traditional T9 de taper un chiffre. En activant l'icône, on contourne simplement le gestionnaire de raccourcis et tout fonctionne correctement.

#### Problèmes généraux sur les téléphones Xiaomi
Xiaomi a introduit plusieurs autorisations non standard sur ses téléphones, ce qui empêche le clavier virtuel de Traditional T9 de fonctionner correctement. Plus précisément, les touches « Afficher les paramètres » et « Ajouter un mot » peuvent ne pas fonctionner. Pour corriger cela, vous devez accorder les autorisations « Afficher les fenêtres contextuelles » et « Afficher les fenêtres contextuelles en arrière-plan » à TT9 dans les paramètres de votre téléphone. [Ce guide](https://parental-control.flashget.com/how-to-enable-display-pop-up-windows-while-running-in-the-background-on-flashget-kids-on-xiaomi) pour une autre application explique comment le faire.

Il est également fortement recommandé d'accorder l'autorisation « Notification permanente ». Cela est similaire à l'autorisation de « Notifications » introduite dans Android 13. Voir [ci-dessus](#remarques-pour-android-13-ou-version-supérieure) pour plus d'informations sur son importance.

_Les problèmes Xiaomi ont été discutés dans [ce problème GitHub](https://github.com/sspanak/tt9/issues/490)._

#### La saisie vocale prend beaucoup de temps pour s'arrêter
C'est [un problème connu](https://issuetracker.google.com/issues/158198432) sous Android 10 que Google n'a jamais corrigé. Il est impossible de le résoudre côté TT9. Pour arrêter l'opération de saisie vocale, restez silencieux pendant quelques secondes. Android éteint automatiquement le microphone lorsqu'il ne détecte aucune parole.

## Questions Fréquemment Posées

#### Ne peux-tu pas ajouter la fonctionnalité X ?
Non.

Chacun a ses préférences. Certains veulent des touches plus grandes, d'autres dans un ordre différent, certains veulent une touche de raccourci pour taper ".com", et d'autres regrettent leur ancien téléphone ou clavier. Mais veuillez comprendre que je fais ce travail bénévolement sur mon temps libre. Il est impossible de satisfaire des milliers de demandes différentes, dont certaines se contredisent même.

Henry Ford a dit un jour : "Le client peut choisir n'importe quelle couleur, tant que c'est noir." De la même manière, Traditional T9 est simple, efficace et gratuit, mais vous obtenez ce qui est proposé.

#### Ne peux-tu pas le rendre plus similaire à Sony Ericsson ou Xperia, Nokia C2, Samsung, ou un autre clavier logiciel ?
Non.

Traditional T9 n'est pas conçu pour être un substitut ou une application clonée. Il possède un design unique, principalement inspiré des Nokia 3310 et 6303i. Et bien qu'il capture l'essence des classiques, il offre une expérience propre qui ne répliquera exactement aucun appareil.

#### Tu devrais copier Touchpal, c'est le meilleur clavier du monde !
Non, je ne devrais pas. Voir les points précédents.

Touchpal était autrefois le meilleur clavier en 2015 lorsqu'il n'avait pas de réelle concurrence. Cependant, les choses ont changé depuis. Voici une comparaison entre Traditional T9 et Touchpal :

_**Traditional T9**_
- Respecte votre vie privée.
- Ne contient pas de publicités et est gratuit.
- Compatible avec un large éventail d'appareils : téléphones basiques et téléviseurs avec claviers physiques, ainsi que smartphones et tablettes uniquement tactiles.
- Offre un véritable clavier T9 à 12 touches adapté à chaque langue.
- Fournit des suggestions de mots améliorées. Par exemple, si vous essayez de taper des expressions textonymes comme "go in", il apprendra à ne pas suggérer "go go" ou "in in", mais l'expression correcte que vous aviez en tête.
- Tout ce que vous tapez reste sur votre téléphone. Aucune information n'est envoyée ailleurs.
- Est open source, vous permettant de consulter tout le code source et les dictionnaires, de contribuer au projet pour l'améliorer (de nombreux utilisateurs ont aidé à corriger des bugs et à ajouter de nouvelles langues et traductions) ou même de créer un mod basé sur vos préférences et votre vision.
- A un design propre et très lisible qui s'intègre au système. Il n'y a pas d'éléments inutiles pour vous distraire, vous permettant ainsi de vous concentrer sur la saisie.
- La vitesse de chargement du dictionnaire est lente.

_**Touchpal**_
- Demande agressivement l'accès à tout votre appareil et à vos contacts ; écrit des fichiers aléatoires partout ; il a finalement été banni du Play Store parce qu'il se comportait comme un virus.
- Rempli de publicités.
- Ne prend en charge que les appareils à écran tactile.
- N'est pas un vrai clavier T9. Il propose un agencement T9 uniquement pour certaines langues. De plus, certains agencements sont incorrects (par exemple, le bulgare manque d'une lettre et certaines lettres sont mal placées entre la touche 8 et la touche 9).
- Lors de la saisie de textonymes à la suite, il ne suggère que le dernier mot sélectionné. Par exemple, si vous essayez de taper "go in", il affichera soit "go go" soit "in in".
- Les suggestions basées sur le cloud pourraient améliorer la précision. Cependant, pour que cela fonctionne, vous et tous les autres utilisateurs devez envoyer tout ce que vous tapez aux serveurs de Touchpal pour traitement.
- Code fermé. Il n'y a aucun moyen de vérifier ce qu'il fait en arrière-plan.
- Inclut de nombreux thèmes, couleurs, GIFs et autres distractions sans rapport avec la saisie.
- La vitesse de chargement du dictionnaire est rapide. Touchpal remporte ce point.

Si vous n'êtes pas d'accord ou souhaitez expliquer votre point de vue, rejoignez [la discussion ouverte](https://github.com/sspanak/tt9/issues/647) sur GitHub. N'oubliez pas de rester respectueux envers les autres. Les messages haineux ne seront pas tolérés.

#### J'ai besoin d'utiliser un clavier QWERTY (uniquement pour les appareils tactiles)
Traditional T9 est un clavier T9 et en tant que tel, il ne propose pas de disposition de type QWERTY.

Si vous apprenez encore à utiliser T9 et que vous devez parfois revenir en arrière, ou si vous trouvez plus pratique de taper de nouveaux mots en utilisant QWERTY, glisser vers le haut la touche F4 Gauche pour passer à un autre clavier. Pour plus d'informations, voir [l'aperçu des touches virtuelles](#aperçu-des-touches-virtuelles).

La plupart des autres claviers permettent de revenir à Traditional T9 en maintenant la barre d'espace ou la touche « changer de langue ». Consultez la documentation ou le manuel respectif pour plus d'informations.

#### Je ne peux pas changer de langue sur un téléphone tactile
Tout d'abord, assurez-vous d'avoir activé toutes les langues souhaitées dans Paramètres → Langues. Ensuite, maintenez la [touche F4 gauche](#touche-f4-gauche-la-touche-en-bas-à-gauche) pour changer de langue.