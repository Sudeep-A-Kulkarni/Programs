
class program1000
{
    public static void main(String[] args)
    {        
        Demo dobj = new Demo();

        dobj.Display(5);
    }
}

class Demo
{
    public void Display(int no)
    {        
        if (no == 0)
        {
            return;
        }

        System.out.println(no);
        Display(no-1);
        System.out.println(no);

    }
}
