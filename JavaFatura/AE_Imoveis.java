import java.io.Serializable;

/**
 * Escreva a descrição da classe SubEmpresa aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class AE_Imoveis extends CAE implements Serializable {

    // variávéis de instância
    private double cf; // coeficiente fiscal
    private String descricao; 

    /**
     * Construtor por omissão de Contribuinte.
     */

    public AE_Imoveis () {
        super(11);
        this.descricao = "Imoveis";
        this.cf = 0.15; // 15% até € 296 ou € 502 (5)(6)(7)
    }

    /**
     * Construtor de cópia
     */

    public AE_Imoveis (AE_Imoveis imo) {
        super(imo);
        this.descricao = getDesc();
        this.cf = imo.getCf();
    }

    /**
     * Construtor parametrizado de Contribuinte.
     * Aceita como parâmetros os valores para cada variável de instância.
     */

    public AE_Imoveis (int tipo, String descricao, double cf) {
        super(tipo);
        this.descricao = descricao;
        this.cf = cf;
    }

    /**
     * Métodos de instância
     */

    public double getCf () {
        return cf;
    }

    public void setCf (double cf) {
        this.cf = cf;
    }
    
    public String getDesc () {
        return descricao;
    }

    public void setDesc (String descricao) {
        this.descricao = descricao;
    }


    /**
     * Clone
     */
    public AE_Imoveis clone () {
        return new AE_Imoveis (this);
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
        AE_Imoveis o = (AE_Imoveis) obj;
        return super.equals(o)  && o.getDesc().equals(this.descricao) && o.getCf() == this.cf;
    }

}