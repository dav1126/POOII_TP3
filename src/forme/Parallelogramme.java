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
		this((int) pCentre.getX(),(int) pCentre.getY(), pBase, pHauteur);
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
		super(pX, pY);
		boolean ok = setBase(pBase) && setHauteur(pHauteur);
		
		if(!ok)
		{
			throw new ConstructeurException();
		}	
	}

	/**
	 * Obtenir la valeur de la base
	 * 
	 * @return double, la valeur de la base
	 */
	public double getBase()
	{
		return base;
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
		boolean ok = validerBase(pBase);
		
		if (ok)
		{
			base=pBase;
		}
		
		return ok;
	}

	/**
	 * Obtenir la valeur de la hauteur
	 * 
	 * @return double, la valeur dela hauteur
	 */
	public double getHauteur()
	{
		return hauteur;
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
		boolean ok = validerHauteur(pHauteur);
		
		if (ok)
		{
			hauteur = pHauteur;
		}
		
		return ok;
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
		return pBase >= 0;
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
		return pHauteur >=0;
	}

	@Override
	public int compareTo(Forme pParrallelogramme)
	{
		Parallelogramme parrallelogramme = (Parallelogramme) pParrallelogramme;
		
		int result = 0;
		
		if (this.aire() > parrallelogramme.aire())
		{
			result = 1;
		}
		
		else if (this.aire() < parrallelogramme.aire())
		{
			result = -1;
		}
		
		return result;
	}

	@Override
	public double perimetre()
	{
		return (base+hauteur)*2;
	}

	@Override
	public double aire()
	{
		return base*hauteur;
	}

	@Override
	public int getNbrCote()
	{
		return NBR_COTE_PARALLELOGRAMME;
	}

	

	@Override
	public String toString()
	{
		return this.getClass().getName() +"x: " +this.getX() 
				+ " y: " +this.getY() + " base: " +getBase()+ " hauteur: " +getHauteur() +".";
	}

}
