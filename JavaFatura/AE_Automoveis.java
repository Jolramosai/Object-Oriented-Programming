import java.io.Serializable;

/**
 * Escreva a descrição da classe SubEmpresa aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class AE_Automoveis extends CAE implements Serializable {

    // variávéis de instância
    private double cf; // coeficiente fiscal
    private String descricao; 

    /**
     * Construtor por omissão de Contribuinte.
     */

    public AE_Automoveis () {
        super(1);
        this.descricao = "Automoveis";
        this.cf = 0.05; // 15% do IVA (Fatura com limite de € 250) para agregado familiar

    }

    /**
     * Construtor de cópia
     */

    public AE_Automoveis (AE_Automoveis auto) {
        super(auto);
        this.descricao = getDesc();
        this.cf = auto.getCf();
    }

    /**
     * Construtor parametrizado de Contribuinte.
     * Aceita como parâmetros os valores para cada variável de instância.
     */

    public AE_Automoveis (int tipo, String descricao, double cf) {
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
    public AE_Automoveis clone () {
        return new AE_Automoveis (this);
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
        AE_Automoveis o = (AE_Automoveis) obj;
        return super.equals(o)  && o.getDesc().equals(this.descricao) && o.getCf() == this.cf;
    }

}
