package forme;

import java.awt.Point;
import exception.ConstructeurException;

public class Rectangle extends Parallelogramme
{
	/**
	 * Constructeur avec paramètres
	 * 
	 * @param pCentre le point centre
	 * @param pBase la longueur de la base
	 * @param pHauteur la longueur de la hauteur
	 * 
	 * @throws ConstructeurException
	 */
	public Rectangle(Point pCentre, double pBase, double pHauteur)
			throws ConstructeurException
	{
		super((int)pCentre.getX(), (int)pCentre.getY(), pBase, pHauteur);
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
	public Rectangle(int pX, int pY, double pBase, double pHauteur)
			throws ConstructeurException
	{
		super(pX, pY, pBase, pHauteur);
	}
}
