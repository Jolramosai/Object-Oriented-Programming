import java.io.Serializable;
/**
 * Write a description of class Admin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Admin implements Serializable
{
    private static int type;
    private static String nif;
    private static String pass;
    
    public Admin()
    {
        this.type = 0;
        this.nif  = "admin";
        this.pass = "admin";
    }
    
    public Admin(Admin a)
    {
        a.type = this.type;
        a.nif  = this.nif;
        a.pass = this.pass;
    }
    
    public int getType()
    {
        return this.type;
    }
    
    public String getNif()
    {
        return this.nif;
    }
    
    public String getPass()
    {
        return this.pass;
    }
    
    public void setNif(String nif)
    {
        this.nif = nif;
    }
    
    public void setPass(String pass)
    {
        this.pass = pass;
    }
    
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || this.getClass() != o.getClass())
            return false;
        Admin a = (Admin) o;

        return a.type == this.type && a.getNif().equals(this.nif) && a.getPass().equals(this.pass);
    }
    
    public Admin clone()
    {
        return new Admin(this);
    }
    
    /**
     * Método que converte um Hotel numa string
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("Tipo: " + this.type + "\n");
        sb.append("NIF: "  + this.nif  + "\n"); 
        sb.append("Pass: " + this.pass + "\n");
        
        return sb.toString();       
    }
}
