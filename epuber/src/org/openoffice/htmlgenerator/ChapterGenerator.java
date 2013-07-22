/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openoffice.htmlgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chamila
 */
public class ChapterGenerator {

  //this class is used to generate HTML files 
    private ArrayList<HTMLElement> htmlElements;
    private ArrayList<String> elements;
    private String chapter;
    private HTMLHead head;

    public ChapterGenerator(String chapter) {
        htmlElements=new ArrayList<HTMLElement>();
        elements=new ArrayList<String>();
        this.chapter=chapter;
    }
 
    public void addElement(String elem){

        elements.add(elem);

    }
    public void addHead(HTMLHead head){

        this.head=head;
    }
    public void generateChapter(){
        String fPath="C:\\Users\\Chamila\\Documents\\NetBeansProjects\\ePUBer_v2\\Chapter\\c"+chapter+".html";
        File file = new File(fPath);

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
            out.println("<HTML>"); //

           for (String h : head.getHead())
                    out.println(h);  //create the head of the html.

                    
            out.println("<BODY>");

            for (String elem : elements) {
                out.println(elem);
            }

            out.println("</BODY>");
            out.println("</HTML>");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(ChapterGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
