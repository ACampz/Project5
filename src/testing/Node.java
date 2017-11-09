/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**.
 * 
 *
 * @author Alina
 */
public class Node
{
    //variables to use in node class
   private static final int ORDER = 4;
   private int numItems;
   private Node parent;
   private Node childArray[] = new Node[ORDER];
   private DataItem itemArray[] = new DataItem[ORDER-1];
   
   //method to check if item is already in tree
   public boolean findItem(String key)         
      {                                   
      for(int j=0; j<ORDER-1; j++)         
         {                                 
         if(itemArray[j] == null)         
            break;
         else if(itemArray[j].dItem.compareTo(key) == 0)
         {
             itemArray[j].dcount++;
             return true;
         }
         }
      return false;
      }  
   
   //method to add leaf to node
   public void connectChild(int childNum, Node child)
      {
      childArray[childNum] = child;
      if(child != null)
         child.parent = this;
      }
   
   //disconnect leaf from node, used in split
   public Node disconnectChild(int childNum)
      {
      Node tempNode = childArray[childNum];
      childArray[childNum] = null;
      return tempNode;
      }
   
   //get variables
   public Node getChild(int childNum)
      { return childArray[childNum]; }
   
   public Node getParent()
      { return parent; }
   
   public boolean isLeaf()
      { return (childArray[0]==null) ? true : false; }
   
   public int getNumItems()
     { return numItems; }
   
   public DataItem getItem(int index)  
      { return itemArray[index]; }
   
   public boolean isFull()
      { return (numItems==ORDER-1) ? true : false; }

   //insert data item from array into node- used in 234Tree
   public int insertItem(DataItem newItem) 
   {
       
      numItems++;                         
      String newKey = newItem.dItem;      
      //add items
      for(int j=numItems-1; j>=0; j--)     
         {                            
         if(itemArray[j] == null)     
            {         
             continue;
            }
         else
         {  //move items if they are smaller
            String itsKey = itemArray[j].dItem;                        
            int sort = newKey.compareTo(itsKey);                        
            if( sort < 0) 
               itemArray[j+1] = itemArray[j];          
            
            else
               {//move item because it is bigger
               itemArray[j+1] = newItem;               
               return j+1;
               } 
             }                     
         } 
      //add item
      itemArray[0] = newItem;
      return 0;
      
      }
   
   //remove item
   public DataItem removeItem()
      {
      DataItem temp = itemArray[numItems-1];
      itemArray[numItems-1] = null;         
      numItems--;                         
      return temp;                          
      }
   
   //print node string using printItem
    public String printNode()
    {
        String NodeOut = "";
        for(int j = 0; j<numItems; j++)
        {
            NodeOut += itemArray[j].printItem();
        }
        return NodeOut;
    }
    
}