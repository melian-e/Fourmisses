# Fourmisses
On veut des fourmis :
- Guerrière
- Ouvrière
- Exploratrice (seule unité controlable)(capable de mettre des traces, de couper celles ennemies)

On veut des colonies


Fonctionnement :
 - L'Exploratrice peut poser des traces au sol, couper des traces adverses. Une fois une trace posée, elle doit être supprimé pour en placer une autre(force à recruter plusieurs Exploratrices).
 - L'Ouvrière suivent des traces au sol et renforcent celles sur lesquelles elles passent avec de la nourriture. Elles récupère la nourriture. 
 - La Guerrière s'active dès qu'une fourmi ouvrière se retrouve proche d'une fourmi enemie ou qu'un chemin est soit connecté à un chemin enemi. 
   La fourmi se désactive dès que la fourmi enemie n'est plus à porté ou les chemins ne sont plus connectés

 - La Colonie permet de recruter des fourmis, on y apporte la nourriture. Les traces partent d'ici.
 - Une Trace est une boucle qui part de la colonie et y revient et elle perd de la puissance avec le temps. Les ouvrières peuvent la prolonger s'il y a de la nourriture à proximité.
 
class pos
	-> class vecteur
		-> class fourmi
			-> class Ouvrière
			-> class Guerrière
			-> class Exploratrice
		-> class trace
	-> class colonie
class main
class turn
class player

controleur
modèle vue controleur