import java.io.*;
import java.util.Scanner;

/**
 * Write a description of class JavaFatura here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JavaFaturaMenu
{
    public static void main(String[] args){
        
        GestaoContribuinte c = new GestaoContribuinte();
        
        /** Menu Principal */
                
        /** Ler do terminal */
        Scanner input = new Scanner(System.in);
        int entry = 9;
        
        /** Carrega Ficheiro */
        
        try{
            c = c.LoadFile("Saves");
        }
        catch(IOException e){
            CriaDados cd = new CriaDados(c);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        /** Variáveis de leitura */
        
        while(entry != 0){
            System.out.println("-*- JavaFatura -*-\n");
            System.out.println("1 - Iniciar Conta");
            System.out.println("2 - Criar Conta");
            System.out.println("0 - Sair");
            
            System.out.print("Enter: ");
            try{
                entry = input.nextInt();
            }
            catch (Exception e){
                System.out.println("Comando nao reconhecido\n");
                entry=0;
            }
            
            switch(entry){
                case 1 : MenuLogin login = new MenuLogin(c);
                         break;                
                case 2 : MenuContribuinte contribuinte = new MenuContribuinte(c);                     
                         break;
                case 0 : break;
            }
            
        }
        
        // ------------------------------------------------------------------------------------------------------------------------------------
            /** Grava Ficheiro */
            
            try {
                c.SaveFile("Saves");
            } 
            catch (IOException e) {
                e.printStackTrace();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
    }
}
