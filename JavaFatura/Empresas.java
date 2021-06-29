import java.io.Serializable;

/**
 * Escreva a descrição da classe SubEmpresa aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Empresas extends Contribuinte implements Serializable
{

    // variávéis de instância
    private int type;
    private int[] codes; // códigos das atividades económicas
    private int beneficio;
    private GestaoFatura faturas; // Faturas da empresa

    /**
     * Construtor por omissão de Contribuinte.
     */

    public Empresas () {
        super();
        this.type = 2;
        this.codes = new int[0];
        this.beneficio = 0;
        this.faturas = new GestaoFatura();
    }

    /**
     * Construtor de cópia de Contribuinte.
     * Aceita como parâmetro outro Contribuinte e utiliza os métodos de
     * acesso aos valores das variáveis de instância.
     */

    public Empresas (Empresas c) {
        super(c);
        this.type = c.getType();
        this.codes = c.getCodes();
        this.beneficio = c.getBeneficio();
        this.faturas = c.getFaturasEmp();
    }

    /**
     * Construtor parametrizado de Contribuinte.
     * Aceita como parâmetros os valores para cada variável de instância.
     */

    public Empresas (String nif, String nome, String email, String morada, String pass, int[] codes, double dedfisc, int beneficio, GestaoFatura faturas) {
        super(nif, nome, email, morada, pass);
        this.codes = codes;
        this.beneficio = beneficio;
        this.faturas = faturas;
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
     * Devolve o se uma Empresa tem beneficio fiscal
     * @return tipo de utilizador.
     */
    public int getBeneficio () {
        return this.beneficio;
    }
    
    /**
     * Devolve o se uma Empresa tem beneficio fiscal
     * @return tipo de utilizador.
     */
    public void setBeneficio (int ben) {
        this.beneficio = ben;
    }
    
    /**
     * Devolve os codigos das Actividades Economicas
     * @return Codigos.
     */
    public int[] getCodes () {
        return this.codes;
    }
    
    /**
     * Define os codigos das Actividades Economicas
     * @return Codigos.
     */
    public void setCodes (int[] codes) throws ValorIncorretoException{
        for (int i=0; i<codes.length; i++){
            if (codes[i]<1 || codes[i]>11){
                throw new ValorIncorretoException("Nao existe AE: " + codes);
            }
        }
        this.codes = codes;
    }
    
    /**
     * Devolve as Faturas da Empresa
     * @return GestaoFatura.
     */
    public GestaoFatura getFaturasEmp () {
        return this.faturas;
    }
    
    /**
     * ToString
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        for (int i=0; i<this.codes.length; i++){
            sb.append("Actividade económica: ").append(this.codes[i]).append("\n");
        }
        return sb.toString();
    }

    /**
     * Clone
     */
    public Empresas clone () {
        return new Empresas(this);
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
        Empresas o = (Empresas) obj;
        return super.equals(o) && o.getType() == this.type && o.getBeneficio() == this.beneficio && o.getCodes() == this.codes;
    }
    
}
