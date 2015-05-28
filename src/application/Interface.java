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
	
	//�l�ments du haut (barre de menu)
	private VBox zoneHaut = null;
	private MenuBar mainMenu = null;
	protected Menu menuFichier = null;
	protected MenuItem menuItemEnregistrer = null;
	protected MenuItem menuItemEnregistrerSous = null;
	protected MenuItem menuItemFermer = null;
	protected MenuItem menuItemQuitter = null;
	protected MenuItem menuItemOuvrir = null;
	
	//�l�ments de droite (menu de cr�ation des formes)
	private VBox zoneDroite = null;
	protected Button creerCercle = null;
	protected Button creerCarre = null;
	protected Button creerLosange = null;
	protected Button creerRectangle = null;
	
	//�l�ments de la zone centrale (affichage des formes)
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
		
		creerCercle = new Button("Cr�er un cercle");
		creerCercle.setPrefWidth(largeurBouton);
		creerCercle.setPrefHeight(hauteurBouton);
		
		creerCarre = new Button("Cr�er un carr�");
		creerCarre.setPrefWidth(largeurBouton);
		creerCarre.setPrefHeight(hauteurBouton);
		
		creerLosange = new Button("Cr�er un losange");
		creerLosange.setPrefWidth(largeurBouton);
		creerLosange.setPrefHeight(hauteurBouton);
		
		creerRectangle = new Button("Cr�er un rectangle");
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
