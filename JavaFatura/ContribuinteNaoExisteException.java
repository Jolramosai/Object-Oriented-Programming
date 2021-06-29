
/**
 * Write a description of class ContribuinteNaoExisteException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ContribuinteNaoExisteException extends Exception
{
    /**
     * Método construtor não parametrizado
     */
    public ContribuinteNaoExisteException()
    {
        super();
    }
    
    /**
     * Método construtor parametrizado
     * 
     * @param String msg
     */
    public ContribuinteNaoExisteException(String msg)
    {
        super(msg);
    }
}
