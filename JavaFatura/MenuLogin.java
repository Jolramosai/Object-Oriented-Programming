import java.util.Scanner;
/**
 * Write a description of class MenuLogin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuLogin
{
    private String nif;
    private String pass;
    
    public MenuLogin(GestaoContribuinte jcont)
    {
        int type=0;// tipo de contribuinte (Default Admin)
        int entry1 = 9;
        int entry2 = 9;
        int entry3 = 9;
        String r = "";
        Scanner input = new Scanner(System.in);
        Individual ci = new Individual();
        Empresas ce = new Empresas();
        Admin admin = new Admin();
        
        System.out.println("\n-----Login-----");
        System.out.print("NIF: ");
        this.nif = input.next();
        System.out.print("Pass: ");
        this.pass = input.next();
        
        if (!admin.getNif().equals(this.nif) || !admin.getPass().equals(this.pass)){
            try{
                ci = jcont.getContribuinteInd(this.nif);
                if (ci.getPass().equals(this.pass)){
                    type = ci.getType();
                } else {
                    entry1 = 0;
                }
            }
            catch(ContribuinteNaoExisteException e){
                entry1 = 0;
            }
            
            if (type!=1){
                try{
                    ce = jcont.getContribuinteEmp(this.nif);
                    if (ce.getPass().equals(this.pass)){
                        type = ce.getType();
                    } else {
                        System.out.println("NIF ou Pass incorretos");
                        entry1 = 0;
                    }
                }
                catch(ContribuinteNaoExisteException ex){
                    System.out.println("NIF ou Pass incorretos");
                    entry1 = 0;
                }
            }
        }
        
        if (type==1){
            MenuIndividual mi = new MenuIndividual(jcont, this.nif);
        }
        if (type==2){
            MenuEmpresa me = new MenuEmpresa(jcont, this.nif);
        }
        
        if (type==0){
            while(entry1 != 0 ) {
                System.out.println("\n-*- Bem Vindo -*- " + type +"\n");
                System.out.println("1 - Consultar Fatura");
                System.out.println("2 - Consultar Dados");
                System.out.println("3 - Alterar Dados");
                System.out.println("4 - Nº de Faturas");
                System.out.println("5 - Nº de Contribuintes");
                System.out.println("6 - Nº de Empresas");  
                System.out.println("7 - Top 10 Contribuintes");  
                System.out.println("8 - Top N Empresas"); 
                System.out.println("0 - Sair");
                
                System.out.print("Enter: ");
                entry1 = input.nextInt();
                
                switch(entry1){                
                    case 1 : System.out.print("\nCodigo da fatura que pretende consultar: ");
                             String cod = input.next();
                             for (Empresas emp : jcont.getEmpresas().values()){
                                 try{
                                     System.out.println(emp.getFaturasEmp().printFatura(cod));
                                 }
                                 catch(FaturaNaoExisteException e){
                                 }
                             }
                             break;
                    case 2 : System.out.println("\nMeus Dados: \n" + admin.toString());
                             break;               
                    case 3 : System.out.println("1 - Alterar Info de Contribuinte");
                             System.out.println("2 - Alterar Beneficio de Empresa");
                             System.out.println("0 - Sair");
                             System.out.print("Enter: ");
                             entry2 = input.nextInt();
                             switch(entry2){               
                                 case 1 : System.out.print("NIF contribuinte: ");
                                          String nifc = input.next();
                                          try{
                                              ci = jcont.getContribuinteInd(nifc); 
                                          }
                                          catch(ContribuinteNaoExisteException e){
                                              entry2 = 0;
                                          }
                                          if (ci != null){
                                             System.out.println("1 - Alterar estado civil - 1-> Solteiro | 2-> Casado");
                                             System.out.println("2 - Alterar numero de dependentes do agregado");
                                             System.out.print("Enter: ");
                                             entry3 = input.nextInt();
                                                 switch(entry3){
                                                     case 1 : System.out.print("\nNovo estado civil: ");
                                                              int est = input.nextInt();
                                                              ci.setEstCivil(est);
                                                              break;
                                                     case 2 : System.out.print("\nNovo numero de dependentes do agregado: ");
                                                              int dep = input.nextInt();
                                                              ci.setDep(dep);
                                                              break;
                                                     case 0 : break;
                                             }
                                          }
                                 case 2 : System.out.print("NIF Empresa: ");
                                          String nife = input.next();
                                          try{
                                              ce = jcont.getContribuinteEmp(nife); 
                                          }
                                          catch(ContribuinteNaoExisteException e){
                                              System.out.println(e.getMessage());
                                          }
                                          int ben = 2;
                                          while (ben!=0 || ben !=1){
                                              System.out.print("1 -> Com Beneficio | 0 -> Sem Beneficio : ");
                                              ben = input.nextInt();
                                          }
                                          ce.setBeneficio(ben);
                                 case 0 : break;
                             }
                    case 4 : int count=0;
                             for (Empresas emp : jcont.getEmpresas().values()){
                                 count += emp.getFaturasEmp().numFaturas();
                             }
                             System.out.println("Nº de Faturas carregadas " + count);
                             break;
                    case 5 : System.out.println("Nº de Contribuintes carregados " + jcont.numContribuintesInd());
                             break;
                    case 6 : System.out.println("Nº de Empresas carregadss " + jcont.numContribuintesEmp());
                             break;
                    case 7 : String[] top10 = new String[10]; double[] topG = new double[10]; 
                             for (Individual ind : jcont.getContribuintes().values()){
                                 double g = 0;
                                 for (Fatura fat : ind.getFaturasInd().getFaturas().values()){
                                     g += fat.getPreco();
                                 }
                                 for (int j=0; j<10; j++){
                                     if (g > topG[j]){
                                         top10[j] = ind.getNif();
                                         topG[j] = g;
                                         break;
                                     }
                                 }
                             }
                             System.out.println("\nTop 10 Contribuintes"); 
                             for (int i=0; i<10; i++){
                                System.out.println("Nº " + (i+1) + ": " + top10[i] + " -> " + topG[i]);
                             }
                             break;
                    case 8 : System.out.print("\nQuantos Empresas: ");
                             int n = input.nextInt();
                             String[] topN = new String[n]; double[] topNg = new double[n]; 
                             for (Empresas emp : jcont.getEmpresas().values()){
                                 double g = 0;
                                 for (Fatura fat : emp.getFaturasEmp().getFaturas().values()){
                                     g += fat.getPreco();
                                 }
                                 for (int j=0; j<n; j++){
                                     if (g > topNg[j]){
                                         topN[j] = emp.getNif();
                                         topNg[j] = g;
                                         break;
                                     }
                                 }
                             }
                             System.out.println("\nTop " + n + " Empresas"); 
                             for (int i=0; i<n; i++){
                                System.out.println("Nº " + (i+1) + ": " + topN[i] + " -> " + topNg[i]);
                             }
                             break;
                    case 0 : break;
                }
            };
        }
    }

}
