import java.io.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class MenuFatura {

    private String codigo;
    private double preco; 
    private String nifcont;
    private String data;
        
    public MenuFatura (GestaoContribuinte jcont, String nif) {
        
        Fatura f1 = new Fatura();
        Individual ind = new Individual();
        Empresas emp = new Empresas();
        
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        int datebreak = 1;
        
        try{
            emp = jcont.getContribuinteEmp(nif);
        }
        catch(ContribuinteNaoExisteException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n-----Fatura-----");
        String r="";
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.print("Codigo:");
            this.codigo = input.next();
            f1.setCodigo(this.codigo);
            
            if (!emp.getFaturasEmp().existeFatura(this.codigo)){
                try{
                    f1.setNifEmit(nif); 
                }
                catch(ValorIncorretoException e){
                    System.out.println( e.getMessage() );
                }
                
                f1.setEmit(emp.getNome());
               
                System.out.print("NIF Contribuinte: ");
                do {
                    this.nifcont = input.next();
                    try{
                        ind = jcont.getContribuinteInd(this.nifcont);
                    }
                    catch(ContribuinteNaoExisteException ex){
                        System.out.println("Contribuinte nao existe");
                        System.out.print("Reintruduza NIF: ");
                    }
                } while(this.nifcont.length()<8 || this.nifcont.length()>10);
                try{
                    f1.setNifCli(this.nifcont);
                }
                catch(ValorIncorretoException e){
                    System.out.println(e.getMessage());
                }
                
                while (datebreak == 1){
                    datebreak = 0;
                    System.out.print("Data da Fatura: ");
                    this.data = input.next();
                    try {
                        date = formatter.parse(this.data);
                    } 
                    catch (Exception e) {
                        System.out.println("Formato de data errado, formato admitido: dd-MM-yyyy");
                        datebreak = 1;
                    }
                }
                datebreak = 1;
                f1.setData(date);
                
                try{
                    f1.setActEco(emp.getCodes());
                }
                catch(ValorIncorretoException e){
                    System.out.println( e.getMessage() );
                }
                   
                System.out.print("Preço: ");
                this.preco = input.nextDouble();
                f1.setPreco(this.preco);
            
                try{
                    emp.getFaturasEmp().addFatura(f1);
                    ind.getFaturasInd().addFatura(f1);
                    ind.updateCF();
                }
                catch(FaturaJaExisteException e){
                    System.out.println(e.getMessage());
                }
            }
            
            System.out.print("Deseja intruduzir outra fatura? (s/n): ");
            r = input.next();
            System.out.print("\n");
            
        } while (!r.equals("n"));
        
    }
}