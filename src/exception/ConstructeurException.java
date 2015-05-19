package exception;

/**
 * Classe d'exception utilisée lorsque un constructeur ne peut se terminer correctement.
 * 
 * @author 
 * 
 * */
public class ConstructeurException extends RuntimeException
{
	/**
	 * Constructeur par défaut
	 */
	public ConstructeurException()
	{
		super();
	}

	/**
	 * Constructeur avec parametres
	 * 
	 * @param message le message à  mettre dans l'objet
	 */
	public ConstructeurException(String message)
	{
		super(message);
	}
}
