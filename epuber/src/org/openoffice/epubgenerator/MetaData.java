/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openoffice.epubgenerator;

import java.util.ArrayList;

/**
 *
 * @author Chamila
 */
public class MetaData {
    private  String author="";
    private  String title="";
    private String cover="";
    private  ArrayList<String> chapterNames=new ArrayList<String>();//this contains the chapter names.
    private  ArrayList<Image> images=new ArrayList<Image>();
    private String location="";
    private String fileNm="";

    public MetaData() {
       
    }
    public void setTitle(String title){
        this.title=title;

    }
    public String getTitle() {
       return title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public String getAuthor() {
        return author;
    }
    public void addChapterList(ArrayList<String> chapters){
        this.chapterNames=chapters;
    }

    public void addChapter(String chapter){
        chapterNames.add(chapter);
    }

    public ArrayList<String> getChapters(){
        return chapterNames;
    }
    public  void addImage(Image img){
        this.images.add(img);
    }
    public ArrayList<Image> getImages(){
        return images;
    }
    public void addCover(String cover){
    this.cover=cover;
    }
    public String getCover(){return cover;}

    public void addOutLocation(String text) {
        this.location=text;
    }

    public void addOutName(String text) {
        this.fileNm=text;
    }
    public String getOutPutLocation(){
    return location;
    }
    public String getOutPutFileNm(){
        if("".equalsIgnoreCase(fileNm)) //if the output file name is not given, use the book title as the file name
            fileNm=title;

    return fileNm;
    }
}
