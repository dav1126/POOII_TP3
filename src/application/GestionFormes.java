package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;




import forme.*;

public class GestionFormes extends Application
{
	/**
	 * Pointeur sur un objet "File". Garde l'objet "File" des formes qui
	 * sont présentement affichés.
	 */
	private File fileCourant = null;

	/**
	 * Structure de données en mémoire pour contenir des objets "Formes"
	 */
	private ArrayList<Forme> vecFormes = null;

	/**
	 * Un pointeur pour l'interface
	 */
	private Interface vue;

	/**
	 * Un pointeur Stage pour le stage
	 */
	private Stage stage;

	/**
	 * Méthode qui instancie l'interface, ajoute les écouteurs sur les sous
	 * menu, récupere le fichier de formes et affiche l'interface de départ
	 */
	public void start(Stage pStage)
	{
		
	}

	/**
	 * Méthode qui permet d'ajouter un écouteur d'évenements à chacun des sous
	 * menu de la zone de menus
	 */
	private void ajouterEcouteurs()
	{
		
		
		
	}

	/**
	 * Classe interne. écouteur qui gere les boutons
	 */
	class EcouteurBoutons implements EventHandler<ActionEvent>
	{
		/**
		 * Faire l'action demandée et mettre la liste graphique à  jour.
		 * 
		 * @param event l'événement qui s'est produit
		 */
		
	}
	
	
	
	
	/**
	 * Permet de faire la gestion de la création d'un cercle
	 * 
	 * <pre>
	 * -	Saisir un cercle avec la méthode de saisie appropriée.
	 * -	Valider si on a un objet, si oui le mettre dans la liste.
	 * -	à mettre les messages en conséquence.
	 * </pre>
	 */
	public void gestionCreerCercle()
	{
		Forme unCercle = saisirEtCreerCercle();

		if (unCercle != null)
		{
			ajouterForme(unCercle);

			
		}
		else
		{
			...
			alert.setContentText("Aucun cercle n'a été ajouté à la liste");
			alert.showAndWait();

		}
	}

	/**
	 * Méthode qui permet de saisir et de créer un objet Cercle valide. La
	 * gestion de l'annulation est tres importante et la saisie se fait avec
	 * validation.
	 * 
	 * <pre>
	 * <b> Important : Utilisez les outils de saisie de la classe Util.java du
	 * paquetage "utilitaire.Util" </b>
	 * </pre>
	 * 
	 * @return Cercle, un objet Cercle valide ou null si la saisie a été
	 *         annulée.
	 */
	public Cercle saisirEtCreerCercle()
	{
		// Variable de retour
		Cercle unCercle = null;

		// Info sur le cercle (l'abscisse, l'ordonné  et le rayon du du centre du cercle
		
		int x,y,r;

		
		// Saisie de x
		do
		{
			x = saisirObjetEntier("Donnez l'abscisse du centre du cercle ?");
			
		}
		while (!Cercle.validerX(x));
		
		// Saisie de y

		// Saisie de r
		
		// Création de l'objet
		

		return unCercle;
	}
	
	/**
	 * Permet de saisir un entier. La saisie est non bloquante.
	 * 
	 * @param pQuestion chaine permettant de poser une question.
	 * 
	 * @return Integer, un objet entier (Integer) permettant de retourner la
	 *         valeur ou "null" si l'utilisateur a décidé d'annuler la saisie.
	 * 
	 */
	
	public static Integer saisirObjetEntier(String pQuestion)
	{
		

		return objetEntier;
	}
	
	/**
	 * Ajouter une forme à la structure de données de l'application, le
	 * ArrayList
	 * 
	 * @param pForme la forme à  ajouter.
	 */
	public void ajouterForme(Forme pForme)
	{
		this.vecFormes.add(pForme);
	}
	
	/**
	 * Classe interne. écouteur qui gere les items de menu
	 */
	class EcouteurMenu implements EventHandler<ActionEvent>
	{
		/**
		 * Faire l'action demandée et mettre la liste graphique à jour.
		 * 
		 * @param event l'événement qui s'est produit
		 */
		public void handle(ActionEvent event)
		{
			Object optionMenu = event.getSource();
			ObservableList<MenuItem> options = vue.menuFichier.getItems();

			// Enregistrer la liste des formes dans le fichier courant
			if (optionMenu == options.get(0))
			{
				gestionEnregistrer();
			}
			// Enregistrer la liste des formes dans un nouveau fichier
			else if (optionMenu == options.get(1))
			{
				gestionEnregistrerSous();
			}
		
			// Fermer le fichier courant
			else if (optionMenu == options.get(2))
			{
				gestionFermer();
			}
			// Quitter l'application
			else if (optionMenu == options.get(3))
			{
				gestionQuitter();
			}

			// Dans tous les cas mettre la liste graphique à  jour
			mettreAJourListe();
		}
	}
	
	
	/**
	 * Permet de faire les actions qu'il faut pour mettre la liste graphique à 
	 * jour comme:
	 * 
	 * <pre>
	 * -	Faire un backup de l'index sélectionné dans la liste graphique
	 * -	Mettre à  jour la liste graphique à  partir du contenu du ArrayList
	 * -	 </pre>
	 */
	public void mettreAJourListe()
	{
		// Backup de l'index
		int index = vue.listeObjets.getSelectionModel().getSelectedIndex();

		ObservableList<String> formes = FXCollections
				.observableArrayList();

		for (Forme f : vecFormes)
		{
			formes.add(f.toString());
		}
		vue.listeObjets.setItems(formes);

		// Remettre l'index Ã  sa position
		vue.listeObjets.getSelectionModel().select(index);
	}

	/**
	 * Permet de gérer l'enregistrement d'une liste de formes dans le
	 * fichier courant
	 * 
	 * <pre>
	 * -	Si on a un fichier courant on écrit les formes de la liste dedans
	 * -	Sinon on demande à  l'utilisateur le nom d'un fichier (gestionEnregistrerSous)
	 * -	Afficher un message si erreur lors de la sauvegarde ou sauvegarde ok
	 * </pre>
	 * 
	 */
	public void gestionEnregistrer()
	{
		if (fileCourant != null)

		{
			if (!ecrireTexte(vecFormes, fileCourant))
			{
				
			}
			else
			{
				

			}
		}
		else
		{
			gestionEnregistrerSous();
		}
	}
	
	/**
	 * Permet de gérer l'enregistrement d'une liste de formes dans un
	 * nouveau fichier (flux d'octets avec filtre de données)
	 * 
	 * <pre>
	 * -	Demander le nom du fichier, l'assigner au fichier courant et
	 * -	écrire dedans les formes
	 * -	Afficher un message si erreur lors de la sauvegarde ou sauvegarde ok
	 * </pre>
	 */
	public void gestionEnregistrerSous()
	{
		FileChooser choixFichier = new FileChooser();
		choixFichier.setInitialDirectory(new File(System
				.getProperty("user.dir")));
		File fichier = choixFichier.showSaveDialog(stage);

		if (fichier != null)
		{
			fileCourant = fichier;
			if (!ecrireTexte(vecFormes, fileCourant))
			{
				
			}
			else
			{
				
			}
		}
	}

	
	public boolean ecrireTexte(ArrayList<Forme> liste, File fichier)
	{
		boolean ecritureOk = true;
		Forme formeTemp = null;
		String forme = null;
		FileWriter fileForme = null;
		BufferedWriter bufferForme = null;

		try
		{
			// Avec tampon et orientée data (type primaire)
			fileForme = new FileWriter(fichier);
			bufferForme = new BufferedWriter(fileForme);

			try
			{
				for (int i = 0; i < liste.size(); i++)
				{
					formeTemp = liste.get(i);
					if (formeTemp instanceof Cercle)
					{
						forme = "Cercle" + ";" + formeTemp.getX() + ";" +
								formeTemp.getY()  + ";" + ((Cercle) formeTemp).getRayon();
							
					}
					else
						if (formeTemp instanceof Carre)
						{
							
						}
						else
							if (formeTemp instanceof Rectangle)
							{
								
							}

							else
								if (formeTemp instanceof Losange)
								{
									
								}

					bufferForme.write(forme, 0, forme.length());
					// Insere une fin de ligne
					bufferForme.newLine();
				}
			}
			catch (IOException e)
			{
				ecritureOk = false;
			}

			bufferForme.close();
		}
		catch (FileNotFoundException e)
		{
			ecritureOk = false;
		}
		catch (IOException e)
		{
			ecritureOk = false;
		}

		return ecritureOk;
	}
	
	
	/**
	 * Permet de fermer le fichier courant
	 * 
	 * <pre>
	 * -	Si la liste n'est pas vide et que l'utilisateur veut sauvegarder ses données,
	 * 		enregistrer les données courantes (gestionEnregistrerSous) avant de vider la liste
	 * </pre>
	 */
	public void gestionFermer()
	{
		if (!vecFormes.isEmpty())
		{
			

		}

		vecFormes.clear();
		fileCourant = null;
	}

	/**
	 * Permet de quitter l'application apres confirmation de l'utilisateur
	 */
	public void gestionQuitter()
	{
		

	}

	public static void main(String[] args)
	{
		Application.launch(args);
	}

}
