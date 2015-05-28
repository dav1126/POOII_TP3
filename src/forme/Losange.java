package forme;

import java.awt.Point;
import exception.ConstructeurException;

public class Losange extends Parallelogramme
{

	/**
	 * Constructeur avec paramètres.
	 * 
	 * Attention: Ici la base == la grande diagonale (D) et la hauteur == la
	 * petite diagonale (d).
	 * 
	 * @param pCentre le point centre
	 * @param pGrandeDiago la longueur de la base
	 * @param pPetiteDiago la longueur de la hauteur
	 * 
	 * @throws ConstructeurException
	 */
	public Losange(Point pCentre, double pGrandeDiago, double pPetiteDiago)
			throws ConstructeurException
	{
		super(pCentre, pGrandeDiago, pPetiteDiago);
	}

	/**
	 * Constructeur avec paramètres. Ici la base et la hauteur égale la petite
	 * diagonale (d) et la grande diagonale (D).
	 * 
	 * @param pX la coordonnée de x pour le point centre
	 * @param pY la coordonnée de y pour le point centre
	 * @param pGrandeDiago la longueur de la base
	 * @param pPetiteDiago la longueur de la hauteur
	 * 
	 * @throws ConstructeurException
	 */
	public Losange(int pX, int pY, double pGrandeDiago, double pPetiteDiago)
			throws ConstructeurException
	{
		super(pX, pY, pGrandeDiago, pPetiteDiago);
	}

	@Override
	public double aire()
	{
		// Pour un losange aire = ((D * d) / 2)
		return ((this.getBase()*this.getHauteur())/2);
		
	}

	@Override
	public String toString()
	{
		return this.getClass().getName() +"x: " +this.getX() 
				+ " y: " +this.getY() + " petite diagonale: " +getBase()+ " grande diagonale: " +getHauteur() +".";
	}
}
