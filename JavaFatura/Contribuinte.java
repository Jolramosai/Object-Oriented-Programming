import java.lang.String;
import java.lang.Object;
import java.io.Serializable;
/**
 *  Escreva a descrição da classe JavaFatura aqui.
 *
 * @author Miriam Pinto  / Jose Alves / Jose Ramos
 * @version 5 de Maio de 2018
 */
public class Contribuinte implements Serializable
{
    private String nif; // Nº de Contribuinte
    private String nome;
    private String email;
    private String morada;
    private String pass;

    //Cria uma instância de Contribuinte

    public Contribuinte () {
        this.nif    = "";
        this.nome   = "";
        this.email  = "";
        this.morada = "";
        this.pass   = "";
    }

    // Construtor por cópia

    public Contribuinte (Contribuinte c) {
        this.nif = c.getNif();
        this.nome = c.getNome();
        this.email = c.getEmail();
        this.morada = c.getMorada();
        this.pass = c.getPass();
    }

    // Construtor por parâmetro

    public Contribuinte (String nif, String nome, String email, String morada, String pass) {
        this.nif = nif;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.pass = pass;
    }

    public String getNif () {
        return nif;
    }

    public void setNif (String nif) throws ValorIncorretoException{
        if ((nif.length()<8 || nif.length()>10)) {
            throw new ValorIncorretoException("NIF errado");
        }
        this.nif = nif;
    }

    public String getNome( ) {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) throws ValorIncorretoException{
        if (email.indexOf('@')==-1) {
            throw new ValorIncorretoException("Email invalido");
        }
        this.email = email;
    }

    public String getMorada () {
        return morada;
    }

    public void setMorada (String morada) {
        this.morada = morada;
    }

    public String getPass () {
        return pass;
    }

    public void setPass (String pass) {
        this.pass = pass;
    }
    
    public double reducaoImposto(Individual i){
        double d = 1;
        if (i.getDep()>3){
            d += (0.05 * i.getDep()-3);
        }
        return 1;
    }
    
    /**
     * Clone
     */
    public Contribuinte clone () {
        return new Contribuinte(this);
    }

    // Representação no formato textual

    public String toString(){
        StringBuilder sb = new StringBuilder ();
        sb.append("NIF: ").append(this.nif).append("\n");
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Email: ").append(this.email).append("\n");
        sb.append("Morada: ").append(this.morada).append("\n");
        sb.append("Pass: ").append(this.pass).append("\n");
        return sb.toString();
    }

    // compara a igualdade com outro objeto

    public boolean equals (Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Contribuinte o = (Contribuinte) obj;
        return o.getNif().equals(this.nif) && o.getNome().equals(this.nome) && o.getEmail().equals(this.email) && o.getMorada().equals(this.morada) && o.getPass().equals(this.pass);
    }

    

}

