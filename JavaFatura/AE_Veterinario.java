import java.io.Serializable;

/**
 * Escreva a descrição da classe SubEmpresa aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class AE_Veterinario extends CAE implements Serializable {

    // variávéis de instância
    private double cf; // coeficiente fiscal
    private String descricao; 

    /**
     * Construtor por omissão de Contribuinte.
     */

    public AE_Veterinario () {
        super(9);
        this.descricao = "Animais";
        this.cf = 0.10; //15% do IVA (Fatura com limite de € 250) para agregado familiar
    }

    /**
     * Construtor de cópia
     */

    public AE_Veterinario (AE_Veterinario vet) {
        super(vet);
        this.descricao = getDesc();
        this.cf = vet.getCf();
    }

    /**
     * Construtor parametrizado de Contribuinte.
     * Aceita como parâmetros os valores para cada variável de instância.
     */

    public AE_Veterinario (int tipo, String descricao, double cf) {
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
    public AE_Veterinario clone () {
        return new AE_Veterinario (this);
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
        AE_Veterinario o = (AE_Veterinario) obj;
        return super.equals(o)  && o.getDesc().equals(this.descricao) && o.getCf() == this.cf;
    }

}