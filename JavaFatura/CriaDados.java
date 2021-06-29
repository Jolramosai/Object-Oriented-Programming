
/**
 * Write a description of class CriaDados here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CriaDados
{
    public CriaDados(GestaoContribuinte c)
    {
        int[] c1 = new int[1]; c1[0] = 1; // Actividades Eco
        int[] c2 = new int[2]; c2[0] = 3; c2[1] = 6; // Actividades Eco
        
        GestaoFatura fat = new GestaoFatura();
        for (int i=0; i<100; i++){
            Individual ind = new Individual(); 
            try{
                ind.setNif("1231231" + i); 
            }
            catch(ValorIncorretoException e){
                System.out.println( e.getMessage() );
            }
            ind.setNome("Individual " + (i+1)); 
            try{
                ind.setEmail( (i+40) + "@aswd.com"); 
            }
            catch(ValorIncorretoException e){
                System.out.println( e.getMessage() );
            }
            ind.setMorada("Rua " + (i+40)); ind.setPass("111111"); ind.setEstCivil(1); ind.setDep(0); ind.setCf(0);
            try{
                c.addContribuinte(ind);
            }
            catch(ContribuinteJaExisteException e){
                System.out.println(e.getMessage());
            }
            if (i<20){
                Empresas emp = new Empresas();
                try{
                    emp.setNif("12345678"+i); 
                }
                catch(ValorIncorretoException e){
                    System.out.println( e.getMessage() );
                }
                emp.setNome("Empresa " + (i+1)); 
                try{
                    ind.setEmail( i + "@aswd.com"); 
                }
                catch(ValorIncorretoException e){
                    System.out.println( e.getMessage() );
                }
                emp.setMorada("Rua "+i); emp.setPass("111111");
                if (i<10){
                    try{
                        emp.setCodes(c2);
                    }
                    catch(ValorIncorretoException e){
                        System.out.println(e.getMessage());
                    }
                } else {
                    try{
                        emp.setCodes(c1);
                    }
                    catch(ValorIncorretoException e){
                        System.out.println(e.getMessage());
                    }
                }
                try{
                    c.addEmpresa(emp);
                }
                catch(ContribuinteJaExisteException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
