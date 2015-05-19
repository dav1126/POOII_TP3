package forme;

import java.awt.Point;
import exception.ConstructeurException;

public abstract class Parallelogramme extends Forme
{
	/**
	 * Nombre de côtés d'un parallélogramme.
	 */
	private static final int NBR_COTE_PARALLELOGRAMME = 4;

	/**
	 * La longueur de la base du parallélogramme, doit être obligatoirement > 0
	 */
	private double base = 0;

	/**
	 * La longueur de la base du parallélogramme, doit être obligatoirement > 0
	 */
	private double hauteur = 0;

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param pCentre le point centre
	 * @param pBase la longueur de la base
	 * @param pHauteur la longueur de la hauteur
	 * 
	 * @throws ConstructeurException
	 */
	public Parallelogramme(Point pCentre, double pBase, double pHauteur)
			throws ConstructeurException
	{
		
	}

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param pX la coordonnée de x pour le point centre
	 * @param pY la coordonnée de y pour le point centre
	 * @param pBase la longueur de la base
	 * @param pHauteur la longueur de la hauteur
	 * 
	 * @throws ConstructeurException
	 */
	public Parallelogramme(int pX, int pY, double pBase, double pHauteur)
			throws ConstructeurException
	{
		
	}

	/**
	 * Obtenir la valeur de la base
	 * 
	 * @return double, la valeur de la base
	 */
	public double getBase()
	{
		
	}

	/**
	 * Modifier la valeur de la base
	 * 
	 * @param base la nouvelle valeur
	 * 
	 * @return boolean, vrai si la valeur a été modifiée
	 */
	public boolean setBase(double pBase)
	{
		

	}

	/**
	 * Obtenir la valeur de la hauteur
	 * 
	 * @return double, la valeur dela hauteur
	 */
	public double getHauteur()
	{
		
	}

	/**
	 * Modifier la valeur de la hauteur du rectangle
	 * 
	 * @param pHauteur la nouvelle valeur de la hauteur
	 * 
	 * @return boolean, vrai si la valeur a été modifiée
	 */
	public boolean setHauteur(double pHauteur)
	{
		
	}

	/**
	 * Valider la valeur de la base du rectangle, doit être obligatoirement > 0
	 * 
	 * @param pBase la valeur à valider
	 * 
	 * @return boolean, vrai si la valeur est valide
	 */
	public static boolean validerBase(double pBase)
	{
		
	}

	/**
	 * Valider la valeur de la hauteur du rectangle, doit être obligatoirement >
	 * 0
	 * 
	 * @param pHauteur la valeur à valider
	 * 
	 * @return boolean, vrai si la valeur est valide
	 */
	public static boolean validerHauteur(double pHauteur)
	{
		
	}

	@Override
	public int compareTo(Forme pParrallelogramme)
	{
		
	}

	@Override
	public double perimetre()
	{
		
	}

	@Override
	public double aire()
	{
		
	}

	@Override
	public int getNbrCote()
	{
		
	}

	

	@Override
	public String toString()
	{
		
	}

}
