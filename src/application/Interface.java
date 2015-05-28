package application;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Interface 
{
	protected Scene scene = null;
	
	//Layout principal (root)
	private BorderPane root = null;
	
	//Éléments du haut (barre de menu)
	private VBox zoneHaut = null;
	private MenuBar mainMenu = null;
	protected Menu menuFichier = null;
	protected MenuItem menuItemEnregistrer = null;
	protected MenuItem menuItemEnregistrerSous = null;
	protected MenuItem menuItemFermer = null;
	protected MenuItem menuItemQuitter = null;
	protected MenuItem menuItemOuvrir = null;
	
	//Éléments de droite (menu de création des formes)
	private VBox zoneDroite = null;
	protected Button creerCercle = null;
	protected Button creerCarre = null;
	protected Button creerLosange = null;
	protected Button creerRectangle = null;
	
	//Éléments de la zone centrale (affichage des formes)
	protected ListView <String> listeObjets = null;
	
	public Interface()
	{
		creerZoneHaut();
		creerZoneDroite();
		creerZoneCentre();
		
		root = new BorderPane();		
		root.setTop(zoneHaut);
		root.setRight(zoneDroite);
		root.setCenter(listeObjets);
		
		scene = new Scene (root, 800, 450);
		
		scene.getStylesheets().add(
				this.getClass().getResource("style.css").toString());
	}
	
	private void creerZoneHaut()
	{
		menuItemOuvrir = new MenuItem("Ouvrir");
		menuItemEnregistrer = new MenuItem("Enregistrer");
		menuItemEnregistrerSous = new MenuItem("Enregistrer sous");
		menuItemFermer = new MenuItem("Fermer");
		menuItemQuitter = new MenuItem("Quitter");
		
		menuFichier = new Menu("Fichier");
		menuFichier.getItems().addAll(menuItemOuvrir, menuItemEnregistrer, menuItemEnregistrerSous, menuItemFermer, menuItemQuitter);
		
		mainMenu = new MenuBar();
		mainMenu.getMenus().addAll(menuFichier);
		
		zoneHaut = new VBox();
		zoneHaut.getChildren().add(mainMenu);
	}
	
	private void creerZoneDroite()
	{
		int largeurBouton = 200;
		int hauteurBouton = 75;
		
		creerCercle = new Button("Créer un cercle");
		creerCercle.setPrefWidth(largeurBouton);
		creerCercle.setPrefHeight(hauteurBouton);
		
		creerCarre = new Button("Créer un carré");
		creerCarre.setPrefWidth(largeurBouton);
		creerCarre.setPrefHeight(hauteurBouton);
		
		creerLosange = new Button("Créer un losange");
		creerLosange.setPrefWidth(largeurBouton);
		creerLosange.setPrefHeight(hauteurBouton);
		
		creerRectangle = new Button("Créer un rectangle");
		creerRectangle.setPrefWidth(largeurBouton);
		creerRectangle.setPrefHeight(hauteurBouton);
		
		zoneDroite = new VBox();
		zoneDroite.setStyle("-fx-background-color: #E8E8E8;");
		
		zoneDroite.getChildren().addAll(creerCercle, creerCarre, creerLosange, creerRectangle);
	}
	
	private void creerZoneCentre()
	{
		listeObjets = new ListView<String>();
	}
}
