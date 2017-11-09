/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author Alina
 */
public class DataItem
{
    // item for data and counter
 public String dItem;      
 public int dcount;
//--------------------------------------------------------------
   public DataItem(String Item)
   { dItem = Item;
     dcount = 1;
   }
//--------------------------------------------------------------
   public String printItem()
    {
        //string to print item and count
        String ItemOut = " " + dItem + " " + dcount +  " ; ";
        return ItemOut;
    }
}