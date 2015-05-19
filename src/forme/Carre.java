/**
 * 
 */
package forme;

import java.awt.Point;

import exception.ConstructeurException;

/**
 * 
 */
public class Carre extends Rectangle
{
	/**
	 * Constructeur avec paramètre
	 * 
	 * @param pCentre le point centre du carré
	 * @param pCote la longueur d'un côté.
	 * 
	 * @throws ConstructeurException
	 */
	public Carre(Point pCentre, double pCote)
			throws ConstructeurException
	{
		this((int) pCentre.getX(), (int) pCentre.getY(),  pCote);
	}

	/**
	 * Constructeur avec paramètre. Il faut faire attention car il faut que la
	 * base égale la hauteur.
	 * 
	 * @param pX la coordonnée x du point centre
	 * @param pY la coordonnée y du point centre
	 * @param pCote la longueur d'un côté.
	 * 
	 * @throws ConstructeurException
	 */
	public Carre(int pX, int pY, double pCote)
			throws ConstructeurException
	{
		
	}

	/**
	 * Modifier la valeur de la base si elle = à la hauteur
	 * 
	 * @param pBase la nouvelle base
	 * 
	 * @return boolean, vrai si la valeur a été modifiée
	 */
	public boolean setBase(double pBase)
	{
		
	}

	/**
	 * Modifier la valeur de la hauteur si elle = à la base
	 * 
	 * @param pHauteur la nouvelle hauteur
	 * 
	 * @return boolean, vrai si la valeur a été modifiée
	 */
	public boolean setHauteur(double pHauteur)
	{
		
	}

	/**
	 * Modifier en même temps la base et la hauteur si elles sont valides et
	 * égales entre elles
	 * 
	 * @param pBase la nouvelle valeur de la base
	 * @param pHauteur la nouvelle valeur de la hauteur
	 * 
	 * @return boolean, vrai si la base et la hauteur ont été modifiées
	 */
	public boolean setCote(double pCote)
	{
		
	}

	/**
	 * Valider la valeur du côté du carré, doit être obligatoirement > 0
	 * 
	 * @param pCote la valeur à valider
	 * 
	 * @return boolean, vrai si la valeur est valide
	 */
	public static boolean validerCote(double pCote)
	{
		
	}
}
