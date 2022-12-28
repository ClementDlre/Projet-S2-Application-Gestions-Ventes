Bonjour.

Vous trouverez ici notre projet de SAE S2.01 S2.01.

En ce qui concerne la partie IHM :
	Comme un membre de notre groupe était absent, nous avons du diviser le travail en 3 et non 4.
	Cela nous a donc rajouté du travail.
	Nous avons fait de notre mieux, mais nous aurions aimé avoir plus de temps, afin de rendre un travail parfait.
	En effet, l'interface d'IHM est fonctionnelle, hormis pour la vue de la liste de conducteurs.
	Lorsque vous appuyez sur le bouton Valider pour ajouter ou modifier un conducteur, l'application plante, et nous n'avons pas eu le temps de débugger ca.
	Nous en sommes désolé.
	
En ce qui concerne la partie Graphes :
	Nous avons du rajouter une arête entre le sommet 2 et le sommet 4, car les classes RandomTourTSP et HeldKarpTSP ne fonctionnait pas avec un graphe non complet.
	Nous aurions aimé rendre une visualisation plus propre, mais la librairie JGraphT étant très vielle, et avec peu de destination, nous avons
	du nous contenter d'afficher simplement la tournée.
	
INFORMATIONS GENERALES - IMPORTANT.

Pour l'IHM, la classe de l'application dans le build.gradle doit être : fr.univartois.butinfo.ihm.GestionVentesApplication
Pour les graphes, selon les questions, elle doit être : fr.ua.iutlens.sae.reseau.graph.ShowGraphApp
													ou	fr.ua.iutlens.sae.reseau.graph.ShowOptimizedTourApp
													ou fr.ua.iutlens.sae.reseau.graph.ShowTourApp