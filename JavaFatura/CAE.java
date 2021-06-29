import java.lang.String;
import java.io.Serializable;

/**
 *  Escreva a descrição da classe JavaFatura aqui.
 *
 * @author Miriam Pinto  / Jose Alves / Jose Ramos
 * @version 5 de Maio de 2018
 */
public abstract class CAE implements Serializable
{
    private int tipo; // Código de atividade económica

    //Cria uma instância de Hotel

    public CAE () {
        this.tipo = 0;
    }

    // Construtor por cópia

    public CAE (CAE c) {
        this.tipo = c.getTipo();
    }

    // Construtor por parâmetro

    public CAE (int tipo) {
        this.tipo = tipo;
    }

    public int getTipo () {
        return tipo;
    }

    public void setTipo (int tipo) {
        this.tipo = tipo;
    }
    
    // Representação no formato textual

    public String toString(){
        StringBuilder sb = new StringBuilder ();
        sb.append("Tipo: ").append(this.tipo).append("\n");
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
        CAE o = (CAE) obj;
        return o.getTipo() == this.tipo;
    }

}

