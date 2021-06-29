import java.util.*;
import java.text.SimpleDateFormat;  
/**
 * Write a description of class MenuEmpresa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuEmpresa
{
    public MenuEmpresa(GestaoContribuinte jcont, String nif)
    {
        int entry1 = 9;
        int entry2 = 9;
        int datebreak = 1; 
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String data = ""; 
        Date begin = new Date(), end = new Date(); 
        double total = 0;
        Scanner input = new Scanner(System.in);
        Empresas ce = new Empresas();
        Empresas cecl = new Empresas();
        
        try{
            ce = jcont.getContribuinteEmp(nif); 
        }
        catch(ContribuinteNaoExisteException e){
            entry1 = 0;
        }
        
        while(entry1 != 0 ) {
            System.out.println("\n-*- Bem Vindo -*- 2");
            System.out.println("1 - Carregar Fatura");
            System.out.println("2 - Consultar Fatura");
            System.out.println("3 - Nº de Faturas");
            System.out.println("4 - Consultar Dados");
            System.out.println("5 - Alterar Dados");
            System.out.println("6 - Todas as Faturas");
            System.out.println("7 - Total Faturado num período");
            System.out.println("8 - Lista das Faturas num período");
            System.out.println("0 - Sair");
            
            System.out.print("Enter: ");
            entry1 = input.nextInt();
            
            switch( entry1 ){
                case 1 : MenuFatura fatura = new MenuFatura(jcont, nif); 
                         break;                
                case 2 : System.out.print("\nCodigo da fatura que pretende consultar: ");
                         String cod = input.next();
                         try{
                             System.out.println(ce.getFaturasEmp().printFatura(cod));
                         }
                         catch(FaturaNaoExisteException e){
                             System.out.println(e.getMessage());
                         }
                         break;
                case 3 : System.out.println("Nº de Faturas carregadas " + ce.getFaturasEmp().numFaturas());
                         break;
                case 4 : System.out.println("\nMeus Dados: \n" + ce.toString());
                         break;                
                case 5 : System.out.println("\n1 - Alterar nome");
                         System.out.println("2 - Alterar email");
                         System.out.println("3 - Alterar morada");
                         System.out.println("4 - Alterar pass"); 
                         System.out.println("0 - Sair");
                         System.out.print("Enter: ");
                         entry2 = input.nextInt();
                         switch( entry2 ){
                             case 1 : System.out.print("\nNovo nome: ");
                                      String nome = input.next();
                                      ce.setNome(nome);
                                      break;                
                             case 2 : System.out.print("\nNovo email: ");
                                      String email = input.next();
                                      try{
                                          ce.setEmail(email);
                                      }
                                      catch(ValorIncorretoException e){
                                          System.out.println( e.getMessage() );
                                      }
                                      break;
                             case 3 : System.out.print("\nNova morada: ");
                                      String morada = input.next();
                                      ce.setMorada(morada);
                                      break;              
                             case 4 : System.out.print("\nNova pass: ");
                                      String pass = input.next();
                                      ce.setPass(pass);
                                      break;
                             case 0 : break;
                         }
                case 6 : List<Fatura> fatList = new ArrayList<Fatura>(ce.getFaturasEmp().getFaturas().values()); 
                         Collections.sort(fatList, new Comparator<Fatura>() 
                             {
                                public int compare(Fatura f1, Fatura f2) {
                                    return (int) (f1.getPreco() - f2.getPreco());
                                }
                             }
                         );
                         Collections.reverse(fatList);
                         System.out.println("Faturas ordenadas por valor: ");
                         for (Fatura f : fatList){
                             System.out.println("\n" + f.toString());
                         }
                         break;
                case 7 : while (datebreak == 1){
                             datebreak = 0;
                             System.out.print("Inicio: ");
                             data = input.next();
                             try {
                                 begin = formatter.parse(data);
                             } 
                             catch (Exception e) {
                                 System.out.println("Formato de data errado, formato admitido: dd-MM-yyyy");
                                 datebreak = 1;
                             }
                         }
                         datebreak = 1;
                         while (datebreak == 1){
                             datebreak = 0;
                             System.out.print("Fim: ");
                             data = input.next();
                             try {
                                 end = formatter.parse(data);
                             } 
                             catch (Exception e) {
                                 System.out.println("Formato de data errado, formato admitido: dd-MM-yyyy");
                                 datebreak = 1;
                             }
                         }
                         datebreak = 1;
                         for (Fatura f : ce.getFaturasEmp().getFaturas().values()){
                             if (f.getData().before(end) && f.getData().before(begin)){
                                 total += f.getPreco();
                             }
                         }
                         System.out.print("Total Faturado: " + total + "\n");
                         break; 
                         
                case 8 : Individual ci = null;
                         do {
                            System.out.print("\nNIF do contribuinte que pretende consultar: ");
                            String nf = input.next();
                            try{
                                ci = jcont.getContribuinteInd(nf);  
                            }
                            catch(ContribuinteNaoExisteException e){
                                System.out.println( e.getMessage() );
                                System.out.print("Reintruduza NIF: ");
                            }
                         } while(nif.length()<8 || nif.length()>10);  
                         
                         while (datebreak == 1){
                             datebreak = 0;
                             System.out.print("Inicio: ");
                             data = input.next();
                             try {
                                 begin = formatter.parse(data);
                             } 
                             catch (Exception e) {
                                 System.out.println("Formato de data errado, formato admitido: dd-MM-yyyy");
                                 datebreak = 1;
                             }
                         }
                         datebreak = 1;
                         while (datebreak == 1){
                             datebreak = 0;
                             System.out.print("Fim: ");
                             data = input.next();
                             try {
                                 end = formatter.parse(data);
                             } 
                             catch (Exception e) {
                                 System.out.println("Formato de data errado, formato admitido: dd-MM-yyyy");
                                 datebreak = 1;
                             }
                         }
                         datebreak = 1;
                         for (Fatura f : ci.getFaturasInd().getFaturas().values()){
                             if (f.getData().before(end) && f.getData().before(begin)){
                                 System.out.println("\n" + f.toString());
                             }
                         }
                case 0 : break;
            }
        };
    }
}
