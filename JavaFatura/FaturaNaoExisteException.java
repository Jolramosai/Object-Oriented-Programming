
/**
 * Write a description of class FaturaNaoExisteException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FaturaNaoExisteException extends Exception
{
    /**
     * Método construtor não parametrizado
     */
    public FaturaNaoExisteException(){
        super();
    }
    
    /**
     * Método construtor parametrizado
     * 
     * @param String msg
     */
    public FaturaNaoExisteException(String msg){
        super(msg);
    }
}
