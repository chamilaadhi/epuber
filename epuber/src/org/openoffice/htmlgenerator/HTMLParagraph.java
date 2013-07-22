/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openoffice.htmlgenerator;

/**
 *
 * @author Chamila
 */
public class HTMLParagraph extends  HTMLElement{

    public HTMLParagraph(String elem) {
         super.elem="<p>"+elem+"</p>";
    }

    @Override
    public String getElem() {
        return super.elem;
    }


}
