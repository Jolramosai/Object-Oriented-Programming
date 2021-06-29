import java.util.*;
import java.util.stream.Collectors;
import java.lang.StringBuilder;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Date;
/**
 * Write a description of class JavaFatura here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GestaoFatura implements Serializable
{
    private HashMap<String,Fatura> faturas;
    
    /**
     * Método construtor não parametrizado
     */
    public GestaoFatura()
    {
        this.faturas = new HashMap<>();
    }
    
    /**
     * Método construtor parametrizado
     * @param Map<String,Fatura> h
     */
    public GestaoFatura(Map<String, Fatura> h){
        this.faturas = (HashMap)h.values().stream().collect(Collectors.toMap(a->a.getCodigo(), a->a.clone()));
    }
    
    /**
     * Método construtor por cópia
     */
    public GestaoFatura(GestaoFatura f){
        this.faturas = (HashMap)f.getFaturas();
    }
    
     /**
     * Método que devolve o Map das Faturas
     */
    public Map<String, Fatura> getFaturas(){
        return this.faturas.values().stream().collect(Collectors.toMap(a->a.getCodigo(), a->a.clone()));
    }
    
    /**
     * Método que define o Map das Faturas
     * @param Map<String,Fatura> f
     */
    public void setFaturas(Map<String,Fatura> f){
        this.faturas = (HashMap)f.values().stream().collect(Collectors.toMap(a->a.getCodigo(), a->a.clone()));
    }
    
    /**
     * Método que adiciona informação sobre um Contribuinte
     * @param Contribuinte cs
     */
    public void addFatura(Fatura f) throws FaturaJaExisteException {
        if( this.faturas.containsKey(f.getCodigo()) == true ){
            throw new FaturaJaExisteException("Fatura já existente");
        }    
        this.faturas.put(f.getCodigo(), f.clone());
    }
    
    /**
     * Método que verifica se existe uma fatura dado o seu codigo
     */
    public boolean existeFatura(String codigo){
        return this.faturas.containsKey(codigo);
    }
    
    /**
     * Método que compara as datas de uma fatura e "diz" se a 1ª data é antes da segunda
     * @param (Date data1, Date data2)
     */
    
    public boolean comparaDatas(Date data1, Date data2){
        return (data1.compareTo(data2)<0);
    }
   
    /**
     * Método que verifica se uma data está num período de tempo dado
     * @param (LocalDate data1,LocalDate dataI, LocalDate dataF)
     */
    
    public boolean inData (LocalDate data1,LocalDate dataI, LocalDate dataF){
        return (data1.isAfter(dataI) && data1.isBefore(dataF));
    }
    
    
    
    /**
     * Método que devolve a quantidade de faturas existentes
     */
    public int numFaturas(){
        return (int)this.faturas.keySet().stream().count();
    }
    
     /**
     * Método que devolve a informaçao de uma Fatura
     * 
     * @param String codigo
     */
    public Fatura getFatura(String codigo) throws FaturaNaoExisteException{
        if( this.faturas.containsKey(codigo) == false ){
            throw new FaturaNaoExisteException("Não existe Fatura com o código " + codigo);
        }
        return this.faturas.get(codigo);
    }
    
     /**
     * Método que devolve/imprime a informaçao de uma Fatura
     * 
     * @param String codigo
     */
    public String printFatura(String codigo) throws FaturaNaoExisteException{
        if( this.faturas.containsKey(codigo) == false ){
            throw new FaturaNaoExisteException("Não existe Fatura com o código " + codigo);
        }
        return this.faturas.get(codigo).clone().toString();
    }
    
    /**
     * Método que devovle uma String com as Faturas
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Fatura f: this.faturas.values()){
            sb.append("\n" + f.toString());
        }
        return sb.toString();
    }
    
    /**
     * Escrever o estado do jogo num ficheiro binário
     */
    public void SaveFile(String fileName) throws FileNotFoundException, IOException{
        FileOutputStream fos   = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();        
    } 
    
    /**
     * Ler de um ficheiro binário o estado do programa
     */
    public static GestaoFatura LoadFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis   = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        GestaoFatura h          = (GestaoFatura) ois.readObject();
        ois.close();
        return h;
    }
}
