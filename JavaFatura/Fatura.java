import java.util.stream.Collectors;
import java.lang.StringBuilder;
import java.util.Comparator;
import java.io.Serializable;
import java.text.SimpleDateFormat;  
import java.util.Date;  

/**
 *  Escreva a descrição da classe JavaFatura aqui.
 *  
 * @author Miriam Pinto  / Jose Alves / Jose Ramos
 * @version 6 de Março de 2018
 */
public class Fatura implements Serializable
{
    // variávéis de instância
    private String codigo;
    private String nifemit; // NIF do emitente
    private String emit; // Descrição do emitente
    private String nifcli; // NIF do cliente
    private String despesa; // Descrição da despesa
    private int[] acteco; // Actividade económica
    private double preco;
    private Date data; 
    
    /**
     * Construtor por omissão de JavaFatura.
     */
    public Fatura () {
        this.codigo  = "";
        this.nifemit = "";
        this.emit    = "";
        this.nifcli  = "";
        this.despesa = "";
        this.acteco  = new int[0];
        this.preco   = 0;
        this.data    = null;
        
    }
    
    /**
     * Construtor parametrizado de Fatura.
     * Aceita como parâmetros os valores para cada variável de instância.
     */
    
    public Fatura (String codigo, String nifemit, String emit, String nifcli, String despesa, int[] acteco, double preco, Date data) {
        this.codigo  = codigo;
        this.nifemit = nifemit;
        this.emit    = emit;
        this.nifcli  = nifcli;
        this.despesa = despesa;
        this.acteco  = acteco;
        this.preco   = preco;
        this.data    = data;
    }
    
    /**
     * Construtor de cópia de JavaFatura.
     * Aceita como parâmetro outro JavaFatura e utiliza os métodos 
     * de acesso aos valores das variáveis de instância.
     */
    
    public Fatura (Fatura f) {
        this.codigo  = f.getCodigo();
        this.nifemit = f.getNifEmit();
        this.emit    = f.getEmit();
        this.nifcli  = f.getNifCli();
        this.despesa = f.getDespesa();
        this.acteco  = f.getActEco();
        this.preco   = f.getPreco();
        this.data    = f.getData();
    }

    /**
     * Métodos de instância
     */

    public String getCodigo () {
        return this.codigo;
    }
    
    public void setCodigo (String codigo) {
        this.codigo = codigo;
    }
    
    public String getNifEmit () {
        return this.nifemit;
    }

    public void setNifEmit (String nifemit) throws ValorIncorretoException {
        if (nifemit.length()<8 || nifemit.length()>10) {
            throw new ValorIncorretoException("NIF errado");
        }
        this.nifemit = nifemit;
    }

    public String getEmit () {
        return this.emit;
    }

    public void setEmit (String emit) {
        this.emit = emit;
    }

    public String getNifCli () {
        return this.nifcli;
    }

    public void setNifCli (String nifcli) throws ValorIncorretoException {
        if (nifcli.length()<8 || nifcli.length()>10) {
            throw new ValorIncorretoException("NIF errado");
        }
        this.nifcli = nifcli;
    }

    public String getDespesa () {
        return this.despesa;
    }

    public void setDespesa (String despesa) {
        this.despesa = despesa;
    }

    public int[] getActEco () {
        return this.acteco;
    }

    public void setActEco (int[] acteco) throws ValorIncorretoException{
        for (int i=0; i<acteco.length; i++){
            if (acteco[i]<1 || acteco[i]>11){
                    throw new ValorIncorretoException("Nao existe AE: " + acteco);
            }
        }
        this.acteco = acteco;
    }

    public double getPreco () {
        return this.preco;
    }

    public void setPreco (double preco) {
        this.preco = preco;
    }
    
    public Date getData (){
        return this.data;
    }
    
    public void setData (Date data){
        this.data = data;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo: ").append(this.codigo).append("\n");
        sb.append("Data: ").append(new SimpleDateFormat("dd-MM-yyyy").format(this.data)).append("\n");
        sb.append("NIF Emitente: ").append(this.nifemit).append("\n");
        sb.append("Descrição emitente: ").append(this.emit).append("\n");
        sb.append("NIF Contribuinte: ").append(this.nifcli).append("\n");
        //sb.append("Despesa: ").append(this.despesa).append("\n");
        for (int i=0; i<this.acteco.length; i++){
            sb.append("Actividade Economica: ").append(this.acteco[i]).append("\n");
        }
        sb.append("Preço: ").append(this.preco).append("\n");
        return sb.toString();
    }
    
    public Fatura clone () {
        return new Fatura (this);
    }
    
    public boolean equals(Object o){
        if(o==this) {
            return true;
        }
        if(o==null || o.getClass() != this.getClass()) {
            return false;
        }
        Fatura c = (Fatura) o;
        return c.getCodigo() == this.codigo && c.getNifEmit().equals(this.nifemit) && c.getEmit().equals(this.emit) 
        && c.getNifCli().equals(this.nifcli) && c.getDespesa().equals(this.despesa) && c.getActEco() == this.acteco 
        && c.getPreco() == this.preco && c.getData().equals(this.data);
    }
    
}
