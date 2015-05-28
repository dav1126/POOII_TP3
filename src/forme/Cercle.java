package forme;

import java.awt.Point;

import exception.ConstructeurException;

public class Cercle extends Forme
{
	/**
	 * Nombre de côtés d'un cercle.
	 * 
	 * N.B. Selon le "net" il y a 2 réponses possibles soit 0 ou infini, ici on
	 * opte pour 0.
	 */
	private static final int NBR_COTE_CERCLE = 0;

	/**
	 * Rayon du cercle, doit être obligatoirement > 0.
	 */
	private double rayon = 0;

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param pRayon le rayon du cercle
	 * @param pPoint les coordonnées x et y à partir d'un objet Point
	 * 
	 * @throws ConstructeurException
	 */
	public Cercle(Point pCentre, double pRayon) throws ConstructeurException
	{
		this((int) pCentre.getX(), (int) pCentre.getY(), pRayon);
	}

	/**
	 * Constructeur avec paramètres
	 * 
	 * @param pRayon le rayon du cercle
	 * @param pPx la valeur sur l'axe des x
	 * @param pPy la valeur sur l'axe des y
	 * 
	 * @throws ConstructeurException
	 */
	public Cercle(int pX, int pY, double pRayon) throws ConstructeurException
	{
		super(pX, pY);
		
		boolean ok = setRayon(pRayon);
		
		if(!ok)
		{
			throw new ConstructeurException();
		}
	}

	/**
	 * Obtenir le rayon
	 * 
	 * @return double, la valeur du rayon
	 */
	public double getRayon()
	{
		return rayon;
	}

	/**
	 * Mettre à jour la valeur du rayon
	 * 
	 * @param rayon le nouvelle valeur du rayon
	 * 
	 * @return boolean, vrai si la valeur à été mis à jour
	 */
	public boolean setRayon(double pRayon)
	{
		boolean ok = validerRayon(pRayon);
		
		if (ok)
		{
			rayon = pRayon;
		}
		
		return ok;
	}

	/**
	 * Valider la valeur du rayon, doit être obligatoirement > 0.
	 * 
	 * @param pRayon la valeur à valider
	 * 
	 * @return boolean, vrai si la valeur du rayon est valide
	 */
	public static boolean validerRayon(double pRayon)
	{
		return pRayon >= 0;
	}

	@Override
	public double aire()
	{
		return Math.PI*rayon*rayon;
	}

	@Override
	public double perimetre()
	{
		return Math.PI*rayon*2;
	}

	@Override
	public int getNbrCote()
	{
		// Selon le net il y a 2 réponses possibles soit 0 ou infini, ici on
		// opte pour 0.
		return NBR_COTE_CERCLE;
	}

	
	@Override
	public int compareTo(Forme pCercle)
	{
		Cercle cercle = (Cercle) pCercle; 
		int result=0;
		
		if(this.aire() > cercle.aire())
			
		{
			result = 1;
		}
		
		else if (this.aire() < cercle.aire())
		{
			result = -1;
		}
		
		return result;
	}

	@Override
	public String toString()
	{
		return this.getClass().getName() +"x: " +this.getX() 
				+ " y: " +this.getY() + " Rayon: " +getRayon()+".";
	}
}