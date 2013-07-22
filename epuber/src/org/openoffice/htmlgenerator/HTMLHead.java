/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openoffice.htmlgenerator;

import java.util.ArrayList;

/**
 *
 * @author Chamila
 */
public class HTMLHead {

    private ArrayList<String> head;

    //create HTML file with given head. if the head is empty , generate head with only head tags
    public HTMLHead(ArrayList<String> head) {
        if(head!=null)
            this.head=head;
        else
            init();
    }
    //create HTML head instance with only head tags
    public HTMLHead() {
       init();
    }
    private void init(){
        head=new ArrayList<String>();
        head.add("<head></head>");
    }



    public ArrayList<String> getHead() {
        return this.head;
    }



}
