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
public class Tree234 
{
    private Node root = new Node(); 
    
    //find method to check duplicates
    public boolean find(String key)
      {
      Node curNode = root;
      while(true)
         {
         if(curNode.findItem(key))
            return true;           
         else if( curNode.isLeaf() )
            return false;            
         else    
            curNode = getNextChild(curNode, key);
         }  
      }
    
    //insert items to add to tree, split if needed
    public void insert(String dValue)
    {
      if(!find(dValue))
      {
      Node curNode = root;
      DataItem tempItem = new DataItem(dValue);

      while(true)
         {
         if( curNode.isFull() ) 
            {
            split(curNode); 
            curNode = curNode.getParent();  
            curNode = getNextChild(curNode, dValue);
            } 

         else if( curNode.isLeaf() ) 
            break;           
         else
            curNode = getNextChild(curNode, dValue);
         } 

      curNode.insertItem(tempItem); 
      } 
    }
    
    //splits node at max and moves the item
   public void split(Node thisNode) 
      {
      DataItem itemB, itemC;
      Node parent, child2, child3;
      int itemIndex;

      itemC = thisNode.removeItem();    
      itemB = thisNode.removeItem();    
      child2 = thisNode.disconnectChild(2); 
      child3 = thisNode.disconnectChild(3); 

      Node newRight = new Node();      

      if(thisNode==root)         
         {
         root = new Node();        
         parent = root;                  
         root.connectChild(0, thisNode); 
         }
      else                           
         parent = thisNode.getParent(); 

      itemIndex = parent.insertItem(itemB); 
      int n = parent.getNumItems(); 

      for(int j=n-1; j>itemIndex; j--) 
         {                                      
         Node temp = parent.disconnectChild(j); 
         parent.connectChild(j+1, temp);     
         }
      parent.connectChild(itemIndex+1, newRight);

      newRight.insertItem(itemC);   
      newRight.connectChild(0, child2);
      newRight.connectChild(1, child3); 
      }  
   
   //gets the leaves of the nodes
   public Node getNextChild(Node theNode, String theValue)
      {
      int j;
      
      int numItems = theNode.getNumItems();
      for(j=0; j<numItems; j++)       
         {                       
          
        int sort = theValue.compareTo(theNode.getItem(j).dItem);
         if(sort < 0 )
            return theNode.getChild(j);
         } 
      return theNode.getChild(j);       
      }
   
   //print to run recPrint
   public String print()
    {
        return recPrint(root);
    }
        //recPrint that prints the nodes and children if needed
    public String recPrint(Node thisNode)
    {
        String out ="";
        int numItem = thisNode.getNumItems();
        for(int j = 0; j< numItem+1; j++)
        {
            Node nextNode = thisNode.getChild(j);
            
            if(nextNode != null)
            {
               out += recPrint(nextNode); 
               if(j<numItem)
               {
                   out += thisNode.getItem(j).printItem();
               }
            }    
            else
            {
                out += thisNode.printNode();
                break;
            }
        }
        return out; 
    }
    
}
