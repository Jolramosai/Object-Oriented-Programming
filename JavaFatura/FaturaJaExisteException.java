
/**
 * Write a description of class FaturaJaExisteException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FaturaJaExisteException extends Exception
{
    /**
     * Método construtor não parametrizado
     */
    public FaturaJaExisteException(){
        super();
    }
    
    /**
     * Método construtor parametrizado
     * 
     * @param String msg
     */
    public FaturaJaExisteException(String msg){
        super(msg);
    }
}
