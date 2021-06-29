import java.util.Scanner;
/**
 * Write a description of class MenuIndividual here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuIndividual
{
    public MenuIndividual(GestaoContribuinte jcont, String nif)
    {
        int entry1 = 9;
        int entry2 = 9;
        Scanner input = new Scanner(System.in);
        Individual ci = new Individual();
        
        try{
            ci = jcont.getContribuinteInd(nif); 
        }
        catch(ContribuinteNaoExisteException e){
            entry1 = 0;
        }
            
        
        while(entry1 != 0 ) {
            System.out.println("\n-*- Bem Vindo -*- 1");
            System.out.println("1 - Consultar Fatura");
            System.out.println("2 - Nº de Faturas");
            System.out.println("3 - Consultar Dados");
            System.out.println("4 - Alterar Dados");  
            System.out.println("5 - Faturas pendentes");
            System.out.println("6 - Deduçoes");
            System.out.println("0 - Sair");
            
            System.out.print("Enter: ");
            entry1 = input.nextInt();
            
            switch( entry1 ){                
                case 1 : System.out.print("\nCodigo da fatura que pretende consultar: ");
                         String cod = input.next();
                         try{
                             System.out.println(ci.getFaturasInd().printFatura(cod));
                         }
                         catch(FaturaNaoExisteException e){
                             System.out.println(e.getMessage());
                         }
                         break;
                case 2 : System.out.println("Nº de Faturas: " + ci.getFaturasInd().numFaturas());
                         break;
                case 3 : System.out.println("\nMeus Dados: \n" + ci.toString());
                         break;                
                case 4 : System.out.println("\n1 - Alterar nome");
                         System.out.println("2 - Alterar email");
                         System.out.println("3 - Alterar morada");
                         System.out.println("4 - Alterar pass"); 
                         System.out.println("0 - Sair");
                         System.out.print("Enter: ");
                         entry2 = input.nextInt();
                         switch( entry2 ){
                             case 1 : System.out.print("\nNovo nome: ");
                                      String nome = input.next();
                                      ci.setNome(nome);
                                      break;                
                             case 2 : System.out.print("\nNovo email: ");
                                      String email = input.next();
                                      try{
                                          ci.setEmail(email);
                                      }
                                      catch(ValorIncorretoException e){
                                          System.out.println(e.getMessage());
                                      }
                                      break;
                             case 3 : System.out.print("\nNova morada: ");
                                      String morada = input.next();
                                      ci.setMorada(morada);
                                      break;              
                             case 4 : System.out.print("\nNova pass: ");
                                      String pass = input.next();
                                      ci.setPass(pass);
                                      break;
                             case 0 : break;
                         }
                case 5 : int pend = 0;
                         for (Fatura fat : ci.getFaturasInd().getFaturas().values()){
                             int[] ac = fat.getActEco();
                             if (ac.length>1){
                                 System.out.println("\n" + fat.toString());
                                 System.out.print("Selecione Actividade: ");
                                 ac = new int[1];
                                 ac[0] = input.nextInt();
                                 try{
                                     fat = ci.getFaturasInd().getFatura(fat.getCodigo());
                                 }
                                 catch(FaturaNaoExisteException e){
                                     System.out.println(e.getMessage());
                                 }
                                 try{
                                     fat.setActEco(ac);
                                 }
                                 catch(ValorIncorretoException e){
                                     System.out.println(e.getMessage());
                                 }
                                 pend = 1;
                             }
                         }
                         if (pend == 1){
                             ci.updateCF();
                         }
                         if (pend == 0){
                             System.out.println("\nNao existem faturas pendentes\n");
                         }
                         break;
                case 6 : System.out.println("\nDeduçoes: " + ci.getCf() + "€");
                         break;
                case 0 : break;
            }
        };
    } 
}
