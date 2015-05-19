package exception;

/**
 * Classe d'exception utilis�e lorsque un constructeur ne peut se terminer correctement.
 * 
 * @author 
 * 
 * */
public class ConstructeurException extends RuntimeException
{
	/**
	 * Constructeur par d�faut
	 */
	public ConstructeurException()
	{
		super();
	}

	/**
	 * Constructeur avec parametres
	 * 
	 * @param message le message � mettre dans l'objet
	 */
	public ConstructeurException(String message)
	{
		super(message);
	}
}
