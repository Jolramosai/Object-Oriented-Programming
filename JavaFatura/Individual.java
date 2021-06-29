import java.io.Serializable;

/**
 * Escreva a descrição da classe SubContribuinte aqui.
 * 
 * @author Miriam Pinto / Jose Alves / Jose Ramos
 * @version 7 de Março de 2018
 */
public class Individual extends Contribuinte implements Serializable
{
    // variávéis de instância
    private int type;
    private int estcivil; // 1 - solteiro; 2 - casado
    private int dep; // nr de dependentes do agregado
    private double cf; // Deduçoes
    private GestaoFatura faturas; // Faturas do contribuinte
    
    /**
     * Construtor por omissão de Contribuinte.
     */
    public Individual () {
        super();
        this.type = 1;
        this.estcivil = 1;
        this.dep = 0;
        this.cf = 0;
        this.faturas = new GestaoFatura();
    }

    /**
     * Construtor de cópia de Contribuinte.
     * Aceita como parâmetro outro Contribuinte e utiliza os métodos de
     * acesso aos valores das variáveis de instância.
     */
    public Individual (Individual cont) {
        super(cont);
        this.type = cont.getType();
        this.estcivil = cont.getEstCivil();
        this.dep = cont.getDep();
        this.cf = cont.getCf();
        this.faturas = cont.getFaturasInd();
    }
    
    /**
     * Construtor parametrizado de Contribuinte.
     * Aceita como parâmetros os valores para cada variável de instância.
     */
    public Individual (String nif, String nome, String email, String morada, String pass,int estcivil, int dep) {
        super(nif, nome, email, morada, pass);
        this.estcivil = estcivil;
        this.dep = dep;
        this.cf = cf;
    }
    
    /**
     * Métodos de instância 
     */
    
    /**
     * Devolve o tipo de utilizador
     * @return tipo de utilizador.
     */
    public int getType () {
        return this.type;
    }
    
    /**
     * Devolve o estado civil do Contribuinte.
     * @return Estado civil do Contribuinte.
     */
    public int getEstCivil () {
        return this.estcivil;
    }

    /**
     * Devolve o número de dependentes do Contribuinte.
     * @return Dependentes do Contribuinte.
     */
    public int getDep () {
        return this.dep;
    }
    
    /**
     * Devolve o coeficiente fiscal para efeitos de dedução.
     * @returns Coeficiente Fiscal para uma despesa elegível.
     */
    public double getCf () {
        return this.cf;
    }
    
    /**
     * Atualiza o estado civil de um Contribuinte.
     * @param estcivil novo estado civil do Contribuinte.
     */ 
    public void setEstCivil (int estcivil) {
        this.estcivil = estcivil;
    }
    
    /**
     * Atualiza o número de dependentes de um Contribuinte.
     * @param novoDep novo nr de dependentes do Contribuinte.
     */
    public void setDep (int novoDep) {
        this.dep = novoDep;
    }
    
    /**
     * Altera os coeficientes fiscais.
     * @param novoCf alteração dos coeficientes fiscais.
     */
    public void setCf (double novoCf) {
        this.cf = novoCf;
    }
    
     /**
     * Método que atualiza as Deduçoes das Faturas de um Contribuinte
     * @param Fatura f
     */
    public void updateCF (){
        GestaoAE gae = new GestaoAE();
        double d = 1; double c = 0;
        for (Fatura fat : this.faturas.getFaturas().values()) {
            int[] ac = fat.getActEco();
            if (ac.length==1){
                c = c + (fat.getPreco() * gae.getCFporTipo(ac[0]) * reducaoImposto(this));
            } 
        }
        setCf(c);
    }
    
     /**
     * Método que devolve as Faturas num Contribuinte
     */
    public GestaoFatura getFaturasInd () {
        return this.faturas;
    }
    
    /**
     * ToString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Estado civil: ").append(this.estcivil).append("\n");
        sb.append("Nº Dependentes: ").append(this.dep).append("\n");
        sb.append("Deduçoes: ").append(this.cf).append("€\n");
        return sb.toString();
    }

    /**
     * Clone
     */
    public Individual clone () {
        return new Individual(this);
    }

    /**
     * Equals
     */
    public boolean equals (Object obj) {
        if(obj==this) {
            return true;
        }
        if(obj==null || obj.getClass() != this.getClass()) {
            return false;
        }
        Individual o = (Individual) obj;
        return super.equals(o) && o.getType() == this.type && o.getEstCivil() == this.estcivil && o.getDep() == this.dep && o.getCf() == this.cf;
    }

}
