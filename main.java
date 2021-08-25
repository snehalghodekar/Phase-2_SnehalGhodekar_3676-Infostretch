import java.io.*;
import java.io.File;
import java.util.*;
import java.util.Arrays;
import java.util.regex.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.lang.*;
import java.nio.file.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class LockerApp {
    public static void main( String []args ) throws IOException {
        boolean valid = false;
        System.out.println( "=============================================================================" );
        System.out.println( "" );
        System.out.println("                             Lockers Pvt.Ltd.");
        System.out.println("                         Welcome to LockedMe.com");
        System.out.println( "" );
        System.out.println( "=============================================================================" );
        System.out.printf("%-30s%30s%n", "        Application Name","          Developer Name" );
        System.out.println( "-----------------------------------------------------------------------------" );
        System.out.printf("%-30s%30s%n", "          LockedMe.com"," Snehal Ghodekar" );
        System.out.println( "=============================================================================" );
        System.out.println( "" );
        System.out.println( "Hello User, In this application following options are available: " );
        System.out.println( "" );
        System.out.printf( "%-4s%40s%n","  1:","Display all file in the main directory");
        System.out.printf( "%-4s%49s%n","  2:","Add a file to the existing directory in the App");
        System.out.printf( "%-4s%50s%n","  3:","Delete a user specified file from existing files");
        System.out.printf( "%-4s%54s%n","  4:","Search a user specified file from the main directory");        
        System.out.printf( "%-4s%15s%n","  5:","Close the App");
        System.out.println( "" );
        
        //input: Accepting Choice from user
    do{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select 1 option from the following:");            
        System.out.print("1. Display all files \n2. Add a file \n3. Delete File  \n4. Search File  \n5. Close the App \n Enter your choice: ");
        int choice = Integer.parseInt(reader.readLine());
        
        switch(choice){
            case 1 :
                System.out.println( "All files in the App" );
                String[] Filenames;
                File f = new File("D:/javaproject/AppData");
                Filenames = f.list();
                for (String Filename : Filenames) {
                     System.out.println(Filename);
                }      
                System.out.println( "" ); 
                valid = true;
            break; 
            
            
   
            case 2 :
                //Add a File to the existing directory 
           
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a file name: ");
                System.out.flush();
                String filename = scanner.nextLine();
                System.out.println( "Adding file to the Application..." );
                File file = new File("D:/javaproject/AppData/"+filename);
                System.out.println(file);             
            
         
                boolean flag = file.createNewFile();
                if (flag) {
                    System.out.println("File has been created successfully at the specified location.");
                }
                else {
                    System.out.println("File already present at the specified location.");
                }
                }
                catch(IOException e) {
                    System.out.println("Exception Occurred:");
                    e.printStackTrace();
                }            
            valid = true;
            System.out.println( "" );
            break; 
                

            case 3 :   
                //Delete a user specified file from existing files
                try
                {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter a file name: ");
                    System.out.flush();
                    String filename = scanner.nextLine();
                    Files.deleteIfExists(Paths.get("D:/javaproject/AppData/"+filename));
                }
                catch(NoSuchFileException e)
                {
                    System.out.println("No such file/directory exists");
                }
                catch(DirectoryNotEmptyException e)
                {
                    System.out.println("Directory is not empty.");
                }
                    catch(IOException e)
                {
                    System.out.println("Invalid permissions.");
                }
                System.out.println( "Deleting file from the Application..." );  
                //Display the result upon successful operation        
                System.out.println("Deletion successful.");
                System.out.println( "" );
                valid = true;
            break; 
               
                

            case 4 :
                FindFile ff = new FindFile();
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the file to be searched.. " );
                String name = scan.next();
                System.out.println( "Searching file..." );
                ff.findFile(name,new File("D:/javaproject/AppData/"));
                System.out.println( "" );
                valid = true;
            break;                 

   
            case 5 :
            //close the application
                System.out.println( "Closing the App..." );
                System.out.println( "Thank you for visiting us! Please visit again :)" );
                System.out.println( "" );
                valid = false;
            break; 

            
            default:
            //When user select/Entered Invalid Choice
                System.out.println("Invalid Choice.");
                System.out.println("Please select the appropriate option.");
                System.out.println( "" );
                valid = true;
            break;
            
       }
    }while(valid == true);
       
    
       System.out.println( "=============================================================================" );   
    }
    

        
}
class FindFile 
{   
    //int notfound=0;
    public void findFile(String name,File file)
    {
        
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                findFile(name,fil);
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
                //Display the result upon successful operation
                System.out.println("Yes File is present in "+fil.getParentFile());
                break;
            }
            //else{
                // notfound = 1;
                 
                //System.out.println("File Not Found in "+fil.getParentFile());
            //}
        }
       //if(notfound == 1){
           // System.out.println("File Not Found");}
    }
    //public static void main(String[] args) 
    //{
    //    FindFile ff = new FindFile();
    //    Scanner scan = new Scanner(System.in);
    //    System.out.println("Enter the file to be searched.. " );
    //    String name = scan.next();
        //System.out.println("Enter the directory where to search ");
        //String directory = scan.next();
        //ff.findFile(name,new File(directory));
      //  ff.findFile(name,new File("D:/javaproject/AppData/"));
    //}
}
