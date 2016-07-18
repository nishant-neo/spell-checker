package spellcheck;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.regex.*;
import java.util.*;



/**
 *
 * @author NISHANT
 */
class DataInput {

    String filepath;
    HashMap<String, Integer> dict = new HashMap<String, Integer>();
    // This method takes input from the file, and stores the words(tokens) into HashMap
    
    public DataInput( String filepath)
    {
        this.filepath = filepath;
    }
    public HashMap tokenize() {
        BufferedReader br = null;
        try 
        {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(this.filepath));
        
            Pattern pattern = Pattern.compile("\\w+");
            //String line = ""; 
            int l = 0;
            for(String line = ""; line != null; line = br.readLine()){
                String t_line = br.readLine();
                System.out.println(l);
                l++;
                
                try
                {
                line = t_line.toLowerCase();
                }
                catch(Exception e)
                {
                ;
                }
          
                Matcher matcher = pattern.matcher( line );
                while ( matcher.find() ) //find(): return bolean True for every find
                { 
                    
                    //group(): Returns the input subsequence matched by the previous match.
                    dict.put((line = matcher.group()), dict.containsKey(line) ? dict.get( line ) + 1 : 1);
                }
            
            }
           
            br.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        return dict;
        
    }
   

}
