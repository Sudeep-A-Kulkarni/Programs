
class program998
{
    public static void main(String[] args)
    {
        int iRet = 0;
        
        Demo dobj = new Demo();

        iRet = dobj.Factorial(5);

        System.out.println("The factorial is : " + iRet);
    }
}

class Demo
{
    public int Factorial(int no)
    {        
        if (no == 0)
        {
            return 1;
        }

        return no * Factorial(no-1);
    }
}
