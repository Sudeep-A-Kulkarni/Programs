
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.io.*;

class program900
{
    public static void main(String[] args)
    {
        Scanner sobj = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("--------Welcome to Marvellous Study Tracker---------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        
        StudyTracker stobj = new StudyTracker();

        int iChoice = 0;

        do{
            System.out.println("Please select appropriate option :");

            System.out.println(" 1    :    Insert a study log");
            System.out.println(" 2    :    view study log");
            System.out.println(" 3    :    Export");
            System.out.println(" 4    :    Summary by date");
            System.out.println(" 5    :    Summary by subject");
            System.out.println(" 6    :    exit");

            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                case 1:
                    stobj.InsertLog();

                    break;
                case 2:
                    stobj.DisplayLog();
                    break;
                case 3:
                    stobj.ExportCSV();
                    break;
                case 4:
                    stobj.SummarybyData();
                    break;
                case 5:
                    stobj.SummarybySubject();
                    break;
                case 6:
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("Thank you for using Study Tracker");
                    System.out.println("----------------------------------------------------------------------------------");
                    break;
                default:
                    System.out.println("Enter valid input");
            }



        }while(iChoice != 6);
    }
}

class StudyTracker
{
    public ArrayList<StudyLog>database = new ArrayList<StudyLog>();

    public void InsertLog()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("------------------- Enter valid details of your study : --------------------------");
        System.out.println("----------------------------------------------------------------------------------");

        LocalDate date_obj = LocalDate.now();

        System.out.println("Please enter the name of subject : ");
        String sub = sobj.nextLine();

        System.out.println("Enter the duration of your study(in hours) : ");
        double dur = sobj.nextDouble();

        sobj.nextLine();

        System.out.println("Description of the Study : ");
        String des = sobj.nextLine();

        StudyLog study_obj = new StudyLog(date_obj, sub, dur, des);

        database.addLast(study_obj);

        System.out.println("Study log gets stored successfully.");

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void DisplayLog()
    {

        System.out.println("----------------------------------------------------------------------------------");
        if (database.isEmpty())
        {
            System.out.println("database is empty.");
            return;
        }
        System.out.println("------------- Log Report of Marvellous Study Tracker -----------------------------");
        System.out.println("----------------------------------------------------------------------------------");


        for (StudyLog s : database)
        {
            System.out.println(s);
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");
    
    }

    public void ExportCSV()
    {
        System.out.println("----------------------------------------------------------------------------------");
        if (database.isEmpty())
        {
            System.out.println("no data to export");
            return;
        }

        String Filename = "marvellous_study_tracker.csv";

        try (FileWriter fwobj = new FileWriter(Filename)){

            fwobj.write("Date,Subject,Duration,Description\n");

            for (StudyLog s : database)
            {
                fwobj.write(
                           s.getDate() + "," 
                           + s.getSubject().replace(","," ") + "," 
                           + s.getDuration() + "," + 
                           s.getDescription().replace(","," ") 
                           +"\n"
                        );
                
            }

            System.out.println("Data gets exported successfully.\n");

        }catch(Exception e){

            System.out.println("Exception occurred in csv handling.\n");

        }

    }

    public void SummarybyData()
    {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------");

       
    }
    
    public void SummarybySubject()
    {
        System.out.println("----------------------------------------------------------------------------------");
        if (database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("----------------------------------------------------------------------------------");
            return ;
        }

        System.out.println("Summary by Subject from study tracker : ");

        TreeMap <String,Double>tobj = new TreeMap<String,Double>();         

        String s = null;
        double d = 0.0, old = 0.0;

        for (StudyLog sobj : database)
        {
            s = sobj.getSubject();
            d = sobj.getDuration();
        

            if (tobj.containsKey(s))
            {
                tobj.get(s);
                tobj.put(s,d+old);
            }
            else
            {
                tobj.put(s,d);
            }
        }

        // display the details as per subject for string ster
    
        for (String str : tobj.keySet())
        {
            System.out.println("Subject : " + str + "total study duration : " + tobj.get(str));
        }
        System.out.println("----------------------------------------------------------------------------------");
        
    }

}

//Done
class StudyLog
{
    private LocalDate Date;
    private String Subject;
    private double Duration;
    private String Description;
    
    public StudyLog(LocalDate A, String B, double C, String D)
    {
        this.Date = A;
        this.Subject = B;
        this.Duration = C;
        this.Description = D;
    }

    public LocalDate getDate()
    {
        return this.Date;
    }

    public String getSubject()
    {
        return this.Subject;
    }

    public double getDuration()
    {
        return this.Duration;
    }

    public String getDescription()
    {
        return this.Description;
    }

    @Override
    public String toString()
    {
        return Date + " | " + Subject + " | " + Duration + " | " + Description + "\n";
    }
}


