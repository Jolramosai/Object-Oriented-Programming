import java.io.Serializable;
/**
 * Escreva a descrição da classe GestaoAE aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class GestaoAE implements Serializable
{
    AE_Automoveis aeAuto;
    AE_Transportes aeTrans;
    AE_Lares aeLares;
    AE_Motas aeMotas;
    AE_Restauracao aeRest;
    AE_Outros aeOutros;
    AE_Estectica aeEst;
    AE_Educacao aeEduc;
    AE_Veterinario aeVet;
    AE_Saude aeSaude;
    AE_Imoveis aeImov;
    /**
     * COnstrutor para objetos da classe GestaoAE
     */
    public GestaoAE()
    {
        this.aeAuto = new AE_Automoveis();
        this.aeTrans = new AE_Transportes();
        this.aeLares = new AE_Lares();
        this.aeMotas = new AE_Motas();
        this.aeRest = new AE_Restauracao();
        this.aeOutros = new AE_Outros();
        this.aeEst = new AE_Estectica();
        this.aeEduc = new AE_Educacao();
        this.aeVet = new AE_Veterinario();
        this.aeSaude = new AE_Saude();
        this.aeImov = new AE_Imoveis();
    }
    
    
    
    public GestaoAE (GestaoAE g){
        this.aeAuto = g.getaeAuto();
        this.aeTrans = g.getaeTrans();
        this.aeLares = g.getaeLares();
        this.aeMotas = g.getaeMotas();
        this.aeRest = g.getaeRest();
        this.aeOutros = g.getaeOutros();
        this.aeEst = g.getaeEst();
        this.aeEduc = g.getaeEduc();
        this.aeVet = g.getaeVet();
        this.aeSaude = g.getaeSaude();
        this.aeImov = g.getaeImov();
    }
    
    public double getCFporTipo (int i) {
       switch(i){
           case 1 : return this.aeAuto.getCf();
           case 2 : return this.aeTrans.getCf();
           case 3 : return this.aeLares.getCf();
           case 4 : return this.aeMotas.getCf();
           case 5 : return this.aeRest.getCf();
           case 6 : return this.aeOutros.getCf();
           case 7 : return this.aeEst.getCf();
           case 8 : return this.aeEduc.getCf();
           case 9 : return this.aeVet.getCf();
           case 10 : return this.aeSaude.getCf();
           case 11 : return this.aeImov.getCf();
       }
       return 0;
    }
    
    public AE_Automoveis getaeAuto () {
        return aeAuto;
    }
    
    public AE_Transportes getaeTrans () {
        return aeTrans;
    }
    
    public AE_Lares getaeLares () {
        return aeLares;
    }
    
    public AE_Motas getaeMotas () {
        return aeMotas;
    }
    
    public AE_Restauracao getaeRest () {
        return aeRest;
    }
    
    public AE_Outros getaeOutros () {
        return aeOutros;
    }
    
    public AE_Estectica getaeEst () {
        return aeEst;
    }
    
    public AE_Educacao getaeEduc () {
        return aeEduc;
    }
    
    public AE_Veterinario getaeVet () {
        return aeVet;
    }
    
    public AE_Saude getaeSaude () {
        return aeSaude;
    }
    
    public AE_Imoveis getaeImov () {
        return aeImov;
    }
    
    public void setaeAuto (AE_Automoveis aeAuto) {
        this.aeAuto = aeAuto;
    }
    
    public void setaeTrans (AE_Transportes aeTrans) {
        this.aeTrans = aeTrans;
    }
    
    public void setaeLares (AE_Lares aeLares) {
        this.aeLares = aeLares;
    }
    
    public void setaeMotas (AE_Motas aeMotas) {
        this.aeMotas = aeMotas;
    }
    
    public void setaeRest (AE_Restauracao aeRest) {
        this.aeRest = aeRest;
    }
    
    public void setaeOutros (AE_Outros aeOutros) {
        this.aeOutros = aeOutros;
    }
    
    public void setaeEst (AE_Estectica aeEst) {
        this.aeEst = aeEst;
    }
    
    public void setaeEduc (AE_Educacao aeEduc) {
        this.aeEduc = aeEduc;
    }
    
    public void setaeVet (AE_Veterinario aeVet) {
        this.aeVet = aeVet;
    }
    
    public void setaeSaude (AE_Saude aeSaude) {
        this.aeSaude = aeSaude;
    }
    
    public void setaeImov (AE_Imoveis aeImov) {
        this.aeImov = aeImov;
    }
    
    public GestaoAE clone () {
        return new GestaoAE(this);
    }
    
}
