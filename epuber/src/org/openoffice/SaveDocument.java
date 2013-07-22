/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openoffice;

import com.sun.star.beans.PropertyValue;
import com.sun.star.frame.XStorable;
import com.sun.star.io.IOException;
import com.sun.star.lang.XComponent;
import com.sun.star.uno.UnoRuntime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chamila
 */
public class SaveDocument {
    public static void saveAsHTML(XComponent xDoc, String storeUrl,String fileName)  {

          XStorable xStorable = (XStorable)UnoRuntime.queryInterface(XStorable.class, xDoc);
          PropertyValue[] storeProps = new PropertyValue[1];
          storeProps[0] = new PropertyValue();
          storeProps[0].Name = "FilterName";
          storeProps[0].Value = "HTML (StarWriter)";
        try {
            xStorable.storeAsURL("file:///" + (storeUrl + "\\" + fileName).replaceAll("\\\\", "/"), storeProps);
        } catch (IOException ex) {
            Logger.getLogger(SaveDocument.class.getName()).log(Level.SEVERE, null, ex);
        }

      }

}
