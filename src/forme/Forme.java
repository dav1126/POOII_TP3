package forme;

import java.awt.Point;
import exception.ConstructeurException;

/**
 * Classe abstraite principale pour des formes géométriques placées dans un plan
 * positif
 * 
 * 
 */
public abstract class Forme implements Comparable<Forme>, Deplacable
{
	/**
	 * Le point centre de la forme
	 */
	private Point centre = null;

	
	/**
	 * Constructeur avec paramètre
	 * 
	 * @param pCentre un objet de type Point qui représente le point centre de
	 *            la forme
	 * 
	 * @throws ConstructeurException
	 */
	public Forme(Point pCentre) throws ConstructeurException
	{
		this((int) pCentre.getX(), (int) pCentre.getY());
	}

	/**
	 * Constructeur avec paramètre
	 * 
	 * @param pX la coordonnée x du point centre de la forme
	 * @param pY la coordonnée y du point centre de la forme
	 * 
	 * @throws ConstructeurException
	 */
	public Forme(int pX, int pY) throws ConstructeurException
	{
		boolean ok = setCentre(pX, pY);

		if (!ok)
		{
			throw new ConstructeurException();
		}
	}

	/**
	 * Obtenir le point centre de la forme
	 * 
	 * @return Point, le point centre
	 */
	public Point getCentre()
	{
		
	}

	/**
	 * Obtenir la valeur de la coordonnée x du point centre de la forme
	 * 
	 * @return int, la valeur de la coordonnée x du point centre
	 */
	public int getX()
	{
		
	}

	/**
	 * Obtenir la valeur de la coordonnée y du point centre de la forme
	 * 
	 * @return int, la valeur de la coordonnée y du point centre
	 */
	public int getY()
	{
		
	}

	/**
	 * Modifier la valeur du point centre d'une forme
	 * 
	 * @param pX la coordonnée x du point centre de la forme
	 * @param pY la coordonnée y du point centre de la forme
	 * 
	 * @return boolean, vrai si la mise à jour a été effectué
	 */
	public boolean setCentre(int pX, int pY)
	{
		
	}

	/**
	 * Modifier la valeur du point centre d'une forme
	 * 
	 * @param pCentre un objet de type qui représente le point centre
	 * 
	 * @return boolean, vrai si la mise à jour a été effectué
	 */
	public boolean setCentre(Point pCentre)
	{
		
	}

	/**
	 * Valider la coordonnée x du point centre de la forme
	 * 
	 * @param pX la coordonnée x du point centre de la forme
	 * 
	 * @return boolean, vrai si la valeur de y >= 0
	 */
	public static boolean validerX(int pX)
	{
		
	}

	/**
	 * Valider la coordonnée x du point centre de la forme
	 * 
	 * @param pX la coordonnée y du point centre de la forme
	 * 
	 * @return boolean, vrai si la valeur de y >= 0
	 */
	public static boolean validerY(int pY)
	{
		
	}

	/**
	 * Valider les coordonnées que contient un objet point pour devenir le point
	 * centre de la forme
	 * 
	 * @param pCentre le point à valider
	 * 
	 * @return vrai si les cordonnées du point sont valides
	 */
	public static boolean validerPoint(Point pCentre)
	{
		
	}

	@Override
	public boolean deplacer(int pDeltaX, int pDeltaY)
	{
		
	}

	/**
	 * Valeur du périmètre de la forme
	 * 
	 * @return double, la valeur du périmètre
	 */
	public abstract double perimetre();

	/**
	 * Valeur de l'aire de la forme
	 * 
	 * @return double, la valeur du périmètre
	 */
	public abstract double aire();

	/**
	 * Obtenir le nombre de côté
	 * 
	 * @return int, le nombre de coté
	 */
	public abstract int getNbrCote();
}
