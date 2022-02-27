package Covid19;

import java.util.LinkedList;
import java.util.Scanner;

class Employee
{
    private String name;
    private boolean workingFromHome;
    Employee next;
    Employee(String name,boolean workingFromHome)
    {
        this.name=name;
        this.workingFromHome = workingFromHome;
    }

    public String getName()
    {
        return name;
    }

    public boolean isWorkingFromHome()
    {
        return workingFromHome;
    }
}
class Queue
{
     Employee front,rear;
     public void enqueue(Employee newemployee)
     {
         if(front ==null && rear==null)
         {
             front=rear=newemployee;
         }
         else
         {
             rear.next=newemployee;
             rear=newemployee;
         }
     }

    public void traverse()
    {
        if(front == null)
        {
            System.out.println("Queue is empty ");
            return;
        }

        Employee curr = front;
        while(curr != null)
        {
            System.out.println(curr.getName());
            curr = curr.next;
        }
    }
}
public class WorkFromHome
{
    public Queue allotWorkFromHome(LinkedList employees,int k)
    {
        Queue qu=new Queue();
        for (int i = 0; i < k; i++)
        {
            Employee e1= (Employee) employees.get(i);
            if(e1.isWorkingFromHome()==true)
            {
                qu.enqueue(e1);
            }
        }
        return qu;
    }
}
class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        LinkedList<Employee> ll=new LinkedList();
        ll.add(new Employee("etisha",true));
        ll.add(new Employee("abc",true));
        ll.add(new Employee("xyz",true));
        ll.add(new Employee("vivek",false));
        ll.add(new Employee("vis",true));
        ll.add(new Employee("vish",false));
        ll.add(new Employee("anq",true));
        System.out.print("Enter the k : " );
        int k=sc.nextInt();
        WorkFromHome wh=new WorkFromHome();
        Queue q = wh.allotWorkFromHome(ll,k);
        q.traverse();
    }
}