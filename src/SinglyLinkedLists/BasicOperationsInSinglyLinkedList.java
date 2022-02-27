package SinglyLinkedLists;

import java.util.Scanner;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}
class SinglyLinkedList
{
    Node head;
    public void insertionAtBegin(Node node)
    {
        node.next=head;
        head=node;
    }
    public void insertionAtEnd(Node node)
    {
        if(head==null)
        {
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=node;
    }

    public void insertionAtPos(Node node, int pos)
    {
        if(pos==1)
        {
            insertionAtBegin(node);
            return;
        }
        Node temp=head;
        for (int i = 1; i < pos-1; i++)
        {
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
    }
    public int countOfNodes()
    {
        int c=0;
        Node temp=head;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        return c;
    }
    public void deletionAtBegin()
    {
        if(head==null)
        {
            System.out.println("LinkedListIsEmpty");
            return;
        }
        head=head.next;
    }
    public void deletionAtEnd()
    {
        if(head==null)
        {
            System.out.println("LinkedListIsEmpty");
            return;
        }
        else if(head.next==null)
        {
            head=null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        temp.next=null;
    }
    public void deletionAtPos(int pos)
    {
        if(pos==1 || head==null)
        {
            deletionAtBegin();
            return;
        }
        Node temp=head;
        for (int i = 1; i < pos-1; i++)
        {
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }
    public void iterativeTraverse()
    {
        if(head==null)
        {
            System.out.println("LinkedList Is Empty");
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }
    public void recursiveTraverse(Node node)
    {
        if(node==null)
        {
            return;
        }
        System.out.println(node.data+" ");
        recursiveTraverse(node.next);
    }
    public Node getHead()
    {
        return head;
    }
    public int iterativeSearch(int data)
    {
        if(head==null)
            return -1;
        int pos=1;
        Node temp=head;
        while(temp!=null)
        {
            if(temp.data==data)
                return pos;
            pos++;
            temp=temp.next;
        }
        return -1;
    }
    public int recursiveSearch(int data, Node node)
    {
        if(node==null)
            return -1;
        if(node.data==data)
            return 1;
        else
        {
            int res= recursiveSearch(data,node.next);
            if(res==-1)
                return -1;
            else
                return res+1;
        }
    }

}
public class BasicOperationsInSinglyLinkedList
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        SinglyLinkedList sl=new SinglyLinkedList();
        while(true)
        {
            System.out.println();
            System.out.println("Menu");
            System.out.println(".....................................");
            System.out.println("1.Insertion At Beginning \n2. Insertion At Ending \n3.Insertion At Position \n" +
                    "4. Count Number Of Nodes \n5. Deletion At Beginning \n6.Deletion At End \n7.Deletion At Position \n" +
                    "8. Iterative Traverse \n9. Recursive Traverse \n10. Get Head \n11. Iterative Search \n12. Recursive Search \n" +
                    "13. Exit");
            System.out.println(".....................................");
            System.out.println();
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Enter the data");
                    sl.insertionAtBegin(new Node(sc.nextInt()));
                    System.out.println("Inserting the Element at start..");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 2:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Enter the data");
                    sl.insertionAtEnd(new Node(sc.nextInt()));
                    System.out.println("Inserting the Element at end..");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 3:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Enter the data and position");
                    sl.insertionAtPos(new Node(sc.nextInt()),sc.nextInt());
                    System.out.println("Inserting the Element at position..");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 4:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Total Number of Nodes are.."+sl.countOfNodes());
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 5:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Deleting the First Element..");
                    sl.deletionAtBegin();
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 6:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Deleting the Last Element..");
                    sl.deletionAtEnd();
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 7:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Enter the Position to Delete");
                    sl.deletionAtPos(sc.nextInt());
                    System.out.println("Deleting the Element at Position..");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 8:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Iteratievely Traversing and Printing..");
                    sl.iterativeTraverse();
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 9:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Recursively Traversing and Printing..");
                    sl.recursiveTraverse(sl.getHead());
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 10:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Printing the head Node.."+sl.getHead().data);
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                    break;
                }
                case 11:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Enter the Element to search Iteratively");
                    int x=sc.nextInt();
                    if(sl.iterativeSearch(x)==-1)
                    {
                        System.out.println("Iteratively Searching the Element..");
                        System.out.println("Element not Present in the LinkedList");
                    }
                    else
                    {
                        System.out.println("Iteratively Searching the Element..");
                        System.out.println("Element Present in the LinkedList at Position "+sl.iterativeSearch(x));
                    }
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 12:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Enter the Element to search Recursively");
                    int x1=sc.nextInt();
                    if(sl.recursiveSearch(x1,sl.getHead())==-1)
                    {
                        System.out.println("Recursively Searching the Element..");
                        System.out.println("Element not Present in the LinkedList");
                    }
                    else
                    {
                        System.out.println("Recursively Searching the Element..");
                        System.out.println("Element Present in the LinkedList at Position "+sl.recursiveSearch(x1,sl.getHead()));
                    }
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                case 13:
                {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Exiting the Program..");
                    System.out.println("Thank You And Come Again :) \uD83D\uDE01");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.exit(0);
                }
            }
        }
    }
}