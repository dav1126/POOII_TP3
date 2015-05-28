package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
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
		stage = pStage;
		vue = new Interface();
		stage.setTitle("Formes géométriques: Un exemple d'héritage et de polymorphisme");
		stage.setScene(vue.scene);
		
		vecFormes = new ArrayList<Forme>();

		ajouterEcouteurs();
		
		stage.show();
	}

	/**
	 * Méthode qui permet d'ajouter un écouteur d'évenements à chacun des sous
	 * menu de la zone de menus
	 */
	private void ajouterEcouteurs()
	{
		vue.creerCercle.setOnAction(new EcouteurBoutons());
		vue.creerCarre.setOnAction(new EcouteurBoutons());
		vue.creerLosange.setOnAction(new EcouteurBoutons());
		vue.creerRectangle.setOnAction(new EcouteurBoutons());
		
		vue.menuItemEnregistrer.setOnAction(new EcouteurMenu());
		vue.menuItemEnregistrerSous.setOnAction(new EcouteurMenu());
		vue.menuItemFermer.setOnAction(new EcouteurMenu());
		vue.menuItemQuitter.setOnAction(new EcouteurMenu());
		vue.menuItemOuvrir.setOnAction(new EcouteurMenu());
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
		@Override
		public void handle(ActionEvent event)
		{
			if (event.getSource() == vue.creerCercle)
			{
				gestionCreerCercle();
			}
			
			if (event.getSource() == vue.creerCarre)
			{
				gestionCreerCarre();
			}
			
			if (event.getSource() == vue.creerLosange)
			{
				gestionCreerLosange();
			}
				
			if (event.getSource() == vue.creerRectangle)
			{
				gestionCreerRectangle();
			}
			mettreAJourListe();
		}
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
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
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
			x = saisirObjetEntier("Donnez l'abscisse du centre du cercle");
			
		}
		while (!Cercle.validerX(x));
		
		// Saisie de y
		do
		{
			y = saisirObjetEntier("Donnez l'ordonné du centre du cercle");
		}
		while (!Cercle.validerY(y));

		// Saisie de r
		do
		{
			r = saisirObjetEntier("Donnez le rayon du cercle");
		}
		while (!Cercle.validerRayon(r));
		
		// Création de l'objet
		
		unCercle = new Cercle(x,y,r);
		
		return unCercle;
	}
	
	public void gestionCreerCarre()
	{
		Forme unCarre = saisirEtCreerCarre();
		
		if (unCarre != null)
		{
			ajouterForme(unCarre);	
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setContentText("Aucun carré n'a été ajouté à la liste");
			alert.showAndWait();
		}
	}
	
	public Carre saisirEtCreerCarre()
	{
		// Variable de retour
		Carre carre = null;

		// Info sur le carre (l'abscisse, l'ordonné  et le cote du carré
		
		int x,y;
		double c;

		
		// Saisie de x
		do
		{
			x = saisirObjetEntier("Donnez l'abscisse du centre du carre");
			
		}
		while (!Carre.validerX(x));
		
		// Saisie de y
		do
		{
			y = saisirObjetEntier("Donnez l'ordonné du centre du carre");
		}
		while (!Carre.validerY(y));

		// Saisie de r
		do
		{
			c = saisirObjetEntier("Donnez le côté du carre");
		}
		while (!Carre.validerCote(c));
		
		// Création de l'objet
		
		carre = new Carre(x,y,c);
		
		return carre;
	}
	
	public void gestionCreerRectangle()
	{
		Forme unRectangle = saisirEtCreerRectangle();
		
		if (unRectangle != null)
		{
			ajouterForme(unRectangle);	
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setContentText("Aucun rectangle n'a été ajouté à la liste");
			alert.showAndWait();
		}
	}
	
	public Rectangle saisirEtCreerRectangle()
	{
		// Variable de retour
		Rectangle rectangle = null;

		// Info sur le rectangle (l'abscisse, l'ordonné  et le cote du carré
		
		int x,y;
		double b,h;

		
		// Saisie de x
		do
		{
			x = saisirObjetEntier("Donnez l'abscisse du centre du rectangle");
			
		}
		while (!Rectangle.validerX(x));
		
		// Saisie de y
		do
		{
			y = saisirObjetEntier("Donnez l'ordonné du centre du rectangle");
		}
		while (!Rectangle.validerY(y));

		// Saisie de b
		do
		{
			b = saisirObjetEntier("Donnez la base du rectangle");
		}
		while (!Rectangle.validerBase(b));
		
		// Saisie de b
		do
		{
			h = saisirObjetEntier("Donnez la hauteur du rectangle");
		}
		while (!Rectangle.validerHauteur(h));
		
		// Création de l'objet
		
		rectangle = new Rectangle(x,y,b,h);
		
		return rectangle;
	}
	
	public void gestionCreerLosange()
	{
		Forme unLosange = saisirEtCreerLosange();
		
		if (unLosange != null)
		{
			ajouterForme(unLosange);	
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setContentText("Aucun losange n'a été ajouté à la liste");
			alert.showAndWait();
		}
	}
	
	public Losange saisirEtCreerLosange()
	{
		// Variable de retour
		Losange losange = null;

		// Info sur le losange (l'abscisse, l'ordonné  et le cote du carré
		
		int x,y;
		double b,h;

		
		// Saisie de x
		do
		{
			x = saisirObjetEntier("Donnez l'abscisse du centre du losange");
			
		}
		while (!Losange.validerX(x));
		
		// Saisie de y
		do
		{
			y = saisirObjetEntier("Donnez l'ordonné du centre du losange");
		}
		while (!Losange.validerY(y));

		// Saisie de b
		do
		{
			b = saisirObjetEntier("Donnez la petite diagonale du losange");
		}
		while (!Losange.validerBase(b));
		
		// Saisie de b
		do
		{
			h = saisirObjetEntier("Donnez la grande diagonale du losange");
		}
		while (!Losange.validerHauteur(h));
		
		// Création de l'objet
		
		losange = new Losange(x,y,b,h);
		
		return losange;
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
		Integer objetEntier = -1;
		
		
		TextInputDialog saisie = new TextInputDialog();
		saisie.setTitle("Saisie d'un entier");
		saisie.setContentText(pQuestion);
		
		Optional <String> result = saisie.showAndWait();
		objetEntier = Integer.parseInt(result.get());
		
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

			// Ouvrir un fichier de formes
			if (optionMenu == options.get(0))
			{
				gestionOuvrir();
			}
			
			// Enregistrer la liste des formes dans le fichier courant
			else if (optionMenu == options.get(1))
			{
				gestionEnregistrer();
			}
			// Enregistrer la liste des formes dans un nouveau fichier
			else if (optionMenu == options.get(2))
			{
				gestionEnregistrerSous();
			}
		
			// Fermer le fichier courant
			else if (optionMenu == options.get(3))
			{
				gestionFermer();
			}
			// Quitter l'application
			else if (optionMenu == options.get(4))
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

		ObservableList<String> formes = FXCollections.observableArrayList();

		for (Forme f : vecFormes)
		{
			formes.add(f.toString());
		}
		vue.listeObjets.setItems(formes);

		// Remettre l'index Ã  sa position
		vue.listeObjets.getSelectionModel().select(index);
	}

	public void gestionOuvrir()
	{	
		if (!vecFormes.isEmpty())
		{
			Alert dialog = new Alert(AlertType.CONFIRMATION);
			dialog.setTitle("Gestion Formes");
			dialog.setHeaderText(null);
			dialog.setContentText("Voulez-vous sauvegarder les données courantes avant d'ouvrir un nouveau fichier?");
			Optional<ButtonType> reponse = dialog.showAndWait();
			if (reponse.get() == ButtonType.OK)
			{
				gestionEnregistrerSous();
			}
		}

		FileChooser choixFichier = new FileChooser();
		choixFichier.setInitialDirectory(new File(System
				.getProperty("user.dir")));
		File fichier = choixFichier.showOpenDialog(stage);
		if (fichier != null)
		{
			vecFormes.clear();
			fileCourant = fichier;

			if (!lireFichierFormes(fileCourant, vecFormes))
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur E/S");
				alert.setHeaderText("");
				alert.setContentText("Erreur lors de la lecture des données");
				alert.showAndWait();
			}
		}
		mettreAJourListe();
	}
	
	public boolean lireFichierFormes(File pFichier, ArrayList<Forme> vecFormes)
	{
		boolean lectureOK = false;
		BufferedReader tampon = null;
		String ligne = "";
		String separateur = ";";
		try{
			
			tampon = new BufferedReader(new FileReader(pFichier));
			while((ligne = tampon.readLine())!= null)
			{
				lectureOK=true;
				String[] vect_forme = ligne.split(separateur);
				
				if(vect_forme[0].equals("Cercle"))
				{
					Cercle cercle = new Cercle(Integer.valueOf(vect_forme[1]), Integer.valueOf(vect_forme[2]), Double.valueOf(vect_forme[3]));
					ajouterForme(cercle);
				}
				
				else if (vect_forme[0].equals("Carre"))
				{
					Carre carre = new Carre(Integer.valueOf(vect_forme[1]), Integer.valueOf(vect_forme[2]), Double.valueOf(vect_forme[3]));
					ajouterForme(carre);
				}
				
				else if (vect_forme[0].equals("Rectangle"))
				{
					Rectangle rectangle = new Rectangle(Integer.valueOf(vect_forme[1]), Integer.valueOf(vect_forme[2]), Double.valueOf(vect_forme[3]), Double.valueOf(vect_forme[4]));
					ajouterForme(rectangle);
				}
				
				else if (vect_forme[0].equals("Losange"))
				{
					Losange losange = new Losange(Integer.valueOf(vect_forme[1]), Integer.valueOf(vect_forme[2]), Double.valueOf(vect_forme[3]), Double.valueOf(vect_forme[4]));
					ajouterForme(losange);
				}		
			}
			
			}catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				
			} finally {
				if (tampon != null) {
					try {
						tampon.close();
					} catch (IOException e) {
					
					}
				}
			}
			return lectureOK;
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
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setContentText("Erreur d'écriture dans le fichier");
				alert.showAndWait();
			}
			else
			{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sauvegarde");
				alert.setContentText("Sauvegarde effectuée avec succès.");
				alert.showAndWait();
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
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur");
				alert.setContentText("Erreur d'écriture dans le fichier");
				alert.showAndWait();
			}
			else
			{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sauvegarde");
				alert.setContentText("Sauvegarde effectuée avec succès.");
				alert.showAndWait();
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
							forme = "Carre" + ";" + formeTemp.getX() + ";" +
									formeTemp.getY()  + ";" + ((Carre) formeTemp).getBase();
						}
						else
							if (formeTemp instanceof Rectangle)
							{
								forme = "Rectangle" + ";" + formeTemp.getX() + ";" +
										formeTemp.getY()  + ";" + ((Rectangle) formeTemp).getBase()+ ";" +((Rectangle) formeTemp).getHauteur();
							}

							else
								if (formeTemp instanceof Losange)
								{
									forme = "Losange" + ";" + formeTemp.getX() + ";" +
											formeTemp.getY()  + ";" + ((Losange) formeTemp).getBase()+ ";" +((Losange) formeTemp).getHauteur();
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
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Sauvegarde");
			alert.setContentText("Voulez-vous sauvegarder avant de fermer?");
			
			ButtonType buttonTypeSave = new ButtonType("Sauvegarder");
			ButtonType buttonTypeCancel = new ButtonType("Fermer");
			ButtonType buttonTypeAnnuler = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(buttonTypeSave, buttonTypeCancel, buttonTypeAnnuler);
			
			Optional<ButtonType> result = alert.showAndWait();
			
			if (result.get() == buttonTypeSave)
			{
				gestionEnregistrerSous();
				vecFormes.clear();
				fileCourant = null;
			} 
			
			else if (result.get() == buttonTypeCancel)
			{
				vecFormes.clear();
				fileCourant = null;
			}
		}
	}

	/**
	 * Permet de quitter l'application apres confirmation de l'utilisateur
	 */
	public void gestionQuitter()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Sauvegarde");
		alert.setContentText("Voulez-vous sauvegarder avant de quitter?");
		
		ButtonType buttonTypeSave = new ButtonType("Sauvegarder et quitter");
		ButtonType buttonTypeCancel = new ButtonType("Quitter sans sauvegarder", ButtonData.CANCEL_CLOSE);
		
		alert.getButtonTypes().setAll(buttonTypeSave, buttonTypeCancel);
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.get() == buttonTypeSave)
		{
			gestionEnregistrer();
		} 	
		System.exit(0);
	}

	public static void  main(String[] args)
	{
		Application.launch(args);
	}

}
