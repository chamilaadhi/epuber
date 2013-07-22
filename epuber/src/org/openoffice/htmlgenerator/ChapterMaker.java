/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openoffice.htmlgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openoffice.epubgenerator.Image;
import org.openoffice.epubgenerator.MetaData;

/**
 *
 * @author Chamila
 */
public class ChapterMaker {
//this class divide the html file created by the OO writer
    private ArrayList<String> head;
    private HTMLHead htmlhead;
    private int chapterCount=0;
    private ChapterGenerator chapter;
    private final String inPath;
    private  MetaData metaData;

    public ChapterMaker(String path,MetaData md) {
        inPath="C:\\Users\\Chamila\\Documents\\NetBeansProjects\\ePUBer_v2\\Sample.html";//path;
        this.metaData=md;
        gen();
    }


    public void gen(){

     head=new ArrayList<String>();
    File inF = new File(inPath);
    

    try {
            BufferedReader in = new BufferedReader(new FileReader(inF));

          

            String line="";
                    line = in.readLine();
            String heading="";

             while (line != null)
            {

                 if("<HEAD>".equalsIgnoreCase(line)){ //create the head of the HTML file
                    head.add(line);
                     System.out.println(line);

                     do{
                          line = in.readLine();
                          System.out.println(line);
                          head.add(line);
                     }while(!("</HEAD>".equalsIgnoreCase(line)));

                   htmlhead=new HTMLHead(head);

                 }

                line = in.readLine();

                if(line!=null&&line.startsWith("<BODY"))
                {

                    chapter=new ChapterGenerator(Integer.toString(chapterCount++));
                    chapter.addHead(htmlhead);


                    do{

                      line = in.readLine();
                      if(line.startsWith("<H1"))
                      {
                          //create new html file for every new chapter. the chapter is recongized
                          //by the heading of the HTML file
                        chapter.generateChapter();//create the previous chapter
                        chapter=new ChapterGenerator(Integer.toString(chapterCount++));//begin new chapter
                        chapter.addHead(htmlhead);

                       heading=getHeading(line);
                       metaData.addChapter(heading);
                        chapter.addElement(line);
                        System.out.println(line);
                        continue;
                      }

                      if(line.matches(".*<IMG.*"))//this is to check and store image infomation
                      {
                        addImage(line,heading);
                      }
                     if("</BODY>".equalsIgnoreCase(line)) {

                         chapter.generateChapter();
                         break;
                     }
                     else
                      chapter.addElement(line);
                      System.out.println(line);

                  }while(true);


                        
                }
                
            }
            in.close();



        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChapterMaker.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(ChapterMaker.class.getName()).log(Level.SEVERE, null, ex);
        }




    }

    private String getHeading(String line) {
        char[] string=null;
        String title=line.substring(line.indexOf(">")+1, line.indexOf("</H"));
       /*
        line.getChars(line.indexOf(">")+1, line.indexOf("</H"), string, 0);

        for (char c : string) {
            title=title+Character.toString(c);
        }
*/


     return title;
    }

    public static void main(String[] args) {
        MetaData md=new MetaData();
        new ChapterMaker("2.html",md);

      for(Image m:md.getImages()){
        System.out.println(m.path+" "+m.chapter);
      }

    }

    private void addImage(String line,String chapter) {

        String ss[]=line.split(">");
     System.out.println(ss.length);
     String src="";
     for(String s:ss){
        if(s.matches(".*IMG.*"))
        {   System.out.println("IMG");

            String temp[]=s.split("\"");
            src=temp[1];

        }
     }
       
        metaData.addImage(new Image(src, chapter));
        System.out.println(src+" "+chapter);



    }
}
