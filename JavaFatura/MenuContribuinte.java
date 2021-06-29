import java.io.*;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * Write a description of class MenuContribuinte here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuContribuinte
{
    private int[] ae; 
    private int estciv, dep;
    private double dedfisc, cf;
    private String nif, nome, email, morada, pass;
    
    public MenuContribuinte (GestaoContribuinte contribuinte) {
        
        int r=9;
        Scanner input = new Scanner(System.in);
        
            System.out.println("\n-----Contribuinte-----");
            System.out.println("1 -> Contribuinte Individual");
            System.out.println("2 -> Contribuinte Colectivo");
            System.out.println("0 -> Sair");
           
            System.out.print("Enter: ");
            r = input.nextInt();
            
            switch (r) {
                case 1:
                    Individual ci = new Individual();
                    System.out.print("\nNIF:");
                    do {
                        try{
                            this.nif = input.next();
                            ci.setNif(nif);
                        }
                        catch(ValorIncorretoException e){
                            System.out.println( e.getMessage() );
                            System.out.print("Reintruduza NIF: ");
                        }
                    } while(nif.length()<8 || nif.length()>10);
                    
                    System.out.print("Nome: ");
                    this.nome = input.next();
                    ci.setNome(nome);
                    
                    System.out.print("Estado civil (1-> Nao Casado | 2-> Casado): ");
                    this.estciv = input.nextInt();
                    ci.setEstCivil(estciv);
                    
                    System.out.print("Pass: ");
                    this.pass = input.next();
                    ci.setPass(pass);
                    
                    try{
                        contribuinte.addContribuinte(ci);
                    }
                    catch(ContribuinteJaExisteException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    Empresas ce = new Empresas();
                    System.out.print("NIF:");
                    do {
                        try{
                            this.nif = input.next();
                            ce.setNif(nif);
                        }
                        catch(ValorIncorretoException e){
                            System.out.println( e.getMessage() );
                            System.out.print("Reintruduza NIF: ");
                        }
                    } while(this.nif.length()<8 || this.nif.length()>10);
                    
                    System.out.print("Nome: ");
                    this.nome = input.next();
                    ce.setNome(nome);
                   
                    System.out.print("Pass: ");
                    this.pass = input.next();
                    ce.setPass(pass);
                    
                    System.out.print("Nº de Atividades Economicas: ");
                    r = input.nextInt();
                    ae = new int[r];
                    for (int i=0; i<r; i++){
                        System.out.print("Atividade Económica: ");
                        do {
                            try{
                                this.ae[i] = input.nextInt();
                            }
                            catch(Exception e){
                                System.out.println( e.getMessage() );
                            }
                        }while (this.ae[i]<1 || this.ae[i]>11);
                    } 
                    try{
                        ce.setCodes(this.ae);
                    }
                    catch(ValorIncorretoException e){
                        System.out.println( e.getMessage() );
                    }
                    
                    try{
                        contribuinte.addEmpresa(ce);
                    }
                    catch(ContribuinteJaExisteException e){
                        System.out.println(e.getMessage());
                    }
                    break; 
                case 0: break;
            }
         
    }
}
