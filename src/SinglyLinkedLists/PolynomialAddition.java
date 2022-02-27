package SinglyLinkedLists;

class PolyNode
{
    int coeff;
    int pow;
    PolyNode next;

    public PolyNode(int coeff, int pow)
    {
        this.coeff = coeff;
        this.pow = pow;
    }
}

class LinkedList
{
    PolyNode head;
    public void insertionAtEnd(PolyNode node)
    {
        if (head == null) {
            head = node;
            return;
        }
        PolyNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public PolyNode getHead()
    {
        return head;
    }

    public void traverse(PolyNode head)
    {
        if(head == null)
        {
            System.out.println("Empty Polynomial ");
        }
        PolyNode temp = head;
        while (temp!=null)
        {
            System.out.print(temp.coeff+"x"+temp.pow);
            if(temp.next !=null)
            {
                System.out.print("+");
            }
            temp = temp.next;

        }
    }

}


class PolyAddition
{


    public PolyNode add(PolyNode p1 , PolyNode p2 ,PolyNode head)
    {


        while (p1 != null || p2 !=null)
        {
            int temp_coeff = 0;
            int temp_pow = 0;


            if(p1.pow == p2.pow)
            {
                temp_coeff = p1.coeff + p2.coeff;
                temp_pow = p1.pow;

                p1=p1.next;
                p2=p2.next;
            }
            else if(p1.pow > p2.pow)
            {
                temp_coeff = p1.coeff;
                temp_pow = p1.pow;

                p1=p1.next;
            }
            else
            {
                temp_coeff = p2.coeff;
                temp_pow = p2.pow;

                p2=p2.next;
            }

            if(head == null)
            {
                head = new PolyNode(temp_coeff, temp_pow);

            }
            else
            {
                PolyNode curr = head;
                while (curr.next != null)
                {
                    curr = curr.next;
                }
                curr.next = new PolyNode(temp_coeff, temp_pow);

                if(p1 == null )
                {
                    curr.next.next=p2;
                    return head;
                }
                else if(p2==null)
                {
                    curr.next.next=p1;
                    return head;
                }
            }



        }

        return head;

    }
}

public class PolynomialAddition
{
    public static void main(String[] args)
    {

        LinkedList p1 = new LinkedList();
        p1.insertionAtEnd(new PolyNode(5,2));
        p1.insertionAtEnd(new PolyNode(3,1));
        p1.insertionAtEnd(new PolyNode(2,0));

        LinkedList p2 = new LinkedList();
        p2.insertionAtEnd(new PolyNode(10,2));
        p2.insertionAtEnd(new PolyNode(5,1));
        p2.insertionAtEnd(new PolyNode(2,0));

        LinkedList p3 = new LinkedList();


        PolyAddition ad = new PolyAddition();
        PolyNode p3_head = ad.add(p1.getHead(),p2.getHead(), p3.getHead());

        p3.traverse(p3_head);


    }



}