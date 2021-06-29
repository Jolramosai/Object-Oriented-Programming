
/**
 * Write a description of class ContribuinteJaExisteException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ContribuinteJaExisteException extends Exception
{
    /**
     * Método construtor não parametrizado
     */
    public ContribuinteJaExisteException(){
        super();
    }
    
    /**
     * Método construtor parametrizado
     * 
     * @param String msg
     */
    public ContribuinteJaExisteException(String msg){
        super(msg);
    }
}
