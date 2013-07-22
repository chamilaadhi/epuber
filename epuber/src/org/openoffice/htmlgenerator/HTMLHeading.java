/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openoffice.htmlgenerator;

/**
 *
 * @author Chamila
 */
public class HTMLHeading extends HTMLElement {

    public HTMLHeading(String elem) {
        super.elem="<h1>"+elem+"</h1>";
    }

     public HTMLHeading(String elem,String hn) {
         super.elem="<h"+hn+">"+elem+"</h"+hn+">";
    }

    
    

    @Override
    public String getElem() {
        return super.elem;
    }
}
