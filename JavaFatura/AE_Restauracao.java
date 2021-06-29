import java.io.Serializable;

/**
 * Escreva a descrição da classe SubEmpresa aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class AE_Restauracao extends CAE implements Serializable {

    // variávéis de instância
    private double cf; // coeficiente fiscal
    private String descricao; 

    /**
     * Construtor por omissão de Contribuinte.
     */

    public AE_Restauracao () {
        super(5);
        this.descricao = "Restauraçao";
        this.cf = 0.05; //15% do IVA (Fatura com limite de € 250) para agregado familiar
    }

    /**
     * Construtor de cópia
     */

    public AE_Restauracao (AE_Restauracao rest) {
        super(rest);
        this.descricao = getDesc();
        this.cf = rest.getCf();
    }

    /**
     * Construtor parametrizado de Contribuinte.
     * Aceita como parâmetros os valores para cada variável de instância.
     */

    public AE_Restauracao (int tipo, String descricao, double cf) {
        super(tipo);
        this.descricao = descricao;
        this.cf = cf;
    }
    
    public String getDesc () {
        return descricao;
    }

    public void setDesc (String descricao) {
        this.descricao = descricao;
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

    /**
     * Clone
     */
    public AE_Restauracao clone () {
        return new AE_Restauracao (this);
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
        AE_Restauracao o = (AE_Restauracao) obj;
        return super.equals(o)  && o.getDesc().equals(this.descricao) && o.getCf() == this.cf;
    }

}