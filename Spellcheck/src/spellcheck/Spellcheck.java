/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellcheck;
import java.util.HashMap;
import java.io.*;
//import spellcheck.DataInput.*;
//import spellcheck.Distance.*;
/**
 *
 * @author NISHANT
 */
public class Spellcheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        System.out.println(" LOADING ........ Please Wait ");
        DataInput s = new DataInput("C:\\Users\\NISHANT\\Documents\\NetBeansProjects\\Spellcheck\\src\\spellcheck\\big_doc.txt");
        HashMap<String, Integer> dict = s.tokenize();
        System.out.println(" LOADING COMPLETED");
        System.out.print(" Enter the word to be checked:  ");
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        String word = br.readLine();
        Distance d = new Distance( dict );
        String result = d.correct(word);
        //System.out.println(result);
        if( result == word )
            System.out.println(" Entered word is spelled correct.");
        else 
            System.out.println(result);
    }
    
}
