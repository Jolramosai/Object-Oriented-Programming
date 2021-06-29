
/**
 * Write a description of class ValorIncorretoException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ValorIncorretoException extends Exception
{
    /**
     * Método construtor não paramtrizado
     */
    public ValorIncorretoException(){
        super();
    }
    
    /**
     * Método construtor parametrizado
     * 
     * @param String msg
     */
    public ValorIncorretoException(String msg){
        super(msg);
    }
}
