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
/**
 * Write a description of class GestaoContribuinte here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GestaoContribuinte implements Serializable
{
    private HashMap<String, Individual> cind;
    private HashMap<String, Empresas> cemp;
    
    /**
     * Método construtor não parametrizado
     */
    public GestaoContribuinte()
    {
        this.cind = new HashMap<>();
        this.cemp = new HashMap<>();
    }
    
    /**
     * Método construtor parametrizado
     * @param Map<String, Individual> ci
     * @param Map<String, Empresas> ce
     */
    public GestaoContribuinte(Map<String, Individual> ci, Map<String, Empresas> ce){
        this.cind = (HashMap)ci.values().stream().collect(Collectors.toMap(a->a.getNif(), a->a.clone()));
        this.cemp = (HashMap)ce.values().stream().collect(Collectors.toMap(a->a.getNif(), a->a.clone()));
    }
    
    /**
     * Método construtor por cópia
     */
    public GestaoContribuinte(GestaoContribuinte c){
        this.cind = (HashMap)c.getContribuintes();
        this.cemp = (HashMap)c.getEmpresas();
    }
    
    /**
     * Método que devolve o Map dos Contribuintes individuais
     */
    public Map<String, Individual> getContribuintes(){
        return this.cind.values().stream().collect(Collectors.toMap(a->a.getNif(), a->a.clone()));
    }
    
    /**
     * Método que devolve o Map das Empresas
     */
    public Map<String, Empresas> getEmpresas(){
        return this.cemp.values().stream().collect(Collectors.toMap(a->a.getNif(), a->a.clone()));
    }
    
    /**
     * Método que define o Map dos Contribuintes individuais
     * @param Map<String, Individual> c
     */
    public void setContribuintesInd(Map<String, Individual> c){
        this.cind = (HashMap)c.values().stream().collect(Collectors.toMap(a->a.getNif(), a->a.clone()));
    }
    
    
    /**
     * Método que define o Map das Empresas
     * @param Map<String, Individual> c
     */
    public void setContribuintesEmp(Map<String, Individual> c){
        this.cemp = (HashMap)c.values().stream().collect(Collectors.toMap(a->a.getNif(), a->a.clone()));
    }
    
    /**
     * Método que adiciona informação sobre um Contribuinte Individual
     * @param Individual c
     */
    public void addContribuinte(Individual c) throws ContribuinteJaExisteException {
        if( this.cind.containsKey(c.getNif()) == true ){
            throw new ContribuinteJaExisteException("Contribuinte já existente");
        }    
        this.cind.put(c.getNif(), c.clone());
    }
    
    /**
     * Método que adiciona informação sobre uma Empresa
     * @param Empresas c
     */
    public void addEmpresa(Empresas c) throws ContribuinteJaExisteException {
        if( this.cemp.containsKey(c.getNif()) == true ){
            throw new ContribuinteJaExisteException("Contribuinte já existente");
        }    
        this.cemp.put(c.getNif(), c.clone());
    }
    
    /**
     * Método que verifica se existe uma fatura dado o seu codigo
     */
    public boolean existeContribuinte(String nif){
        return this.cind.containsKey(nif) || this.cemp.containsKey(nif);
    }
    
    /**
     * Método que devolve a quantidade de Contribuintes Individuais
     */
    public int numContribuintesInd(){
        return (int)this.cind.keySet().stream().count();
    }
    
    /**
     * Método que devolve a quantidade de Empresas
     */
    public int numContribuintesEmp(){
        return (int)this.cemp.keySet().stream().count();
    }
    
    /**
     * Método que devolve um Contribuinte Individual dado o seu NIF
     * 
     * @param String nif
     */
    public Individual getContribuinteInd(String nif) throws ContribuinteNaoExisteException{
        if(this.cind.containsKey(nif) == false){
            throw new ContribuinteNaoExisteException("Não existe Contribuinte com o NIF: " + nif);
        }
        return this.cind.get(nif);
    }
    
    /**
     * Método que devolve uma Empresa dado o seu NIF
     * 
     * @param String nif
     */
    public Empresas getContribuinteEmp(String nif) throws ContribuinteNaoExisteException{
        if(this.cemp.containsKey(nif) == false){
            throw new ContribuinteNaoExisteException("Não existe Empresa com o NIF: " + nif);
        }
        return this.cemp.get(nif);
    }
    
    /**
     * Método que devovle uma String com os Contribuintes
     */
    public String toStringInd(){
        StringBuilder sb = new StringBuilder();
        for(Individual f: this.cind.values()){
            sb.append(f.toString());
        }
        return sb.toString();
    }
    
    /**
     * Método que devovle uma String com as Empresas
     */
    public String toStringEmp(){
        StringBuilder sb = new StringBuilder();
        for(Empresas f: this.cemp.values()){
            sb.append(f.toString());
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
        fos.close();
    } 
    
    /**
     * Ler de um ficheiro binário o estado do jogo
     */
    public static GestaoContribuinte LoadFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis   = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        GestaoContribuinte c  = (GestaoContribuinte) ois.readObject();
        ois.close();
        fis.close();
        return c;
    }
}
