import java.io.*;
import java.io.File;
import java.util.*;
import java.util.Arrays;
//import java.util.regex.*;
//import java.math.*;
import java.security.*;
import java.text.*;
import java.lang.*;
import java.lang.String;
import java.nio.file.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class LockerApp {
    public static void main( String [] args ) throws IOException {
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
                System.out.println( "All files in the App in sorted order are :" );
                //String[] Filenames;
                //File f = new File("D:/javaproject/AppData");
                //Filenames = f.list();
                //for (String Filename : Filenames) {
                 //    System.out.println(Filename);
                //} 
                Sortfiles ss = new Sortfiles();  
                String[] Filenames;
                File f = new File("D:/javaproject/AppData");
                Filenames = f.list();
                int n = Filenames.length;
                ss.sortStrings(Filenames, n);
                //System.out.println("Files in sorted order are : ");
                List<String> list=new ArrayList<String>();  
                for (int i = 0; i < n; i++)
                {
                    list.add(Filenames[i]);  
                }
                System.out.println(list);
    
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
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a file name: ");
                System.out.flush();
                String filename = scanner.nextLine();
                    
               Path pathOfFile
               = Paths.get("D:/javaproject/AppData/"+filename);
     
           // delete both File if file exists
           try {
     
               boolean result
                   = Files.deleteIfExists(pathOfFile);
                System.out.println( "Deleting file from the Application..." );
     
               if (result)
               //Display the result upon successful operation
                   System.out.println("File is deleted");
                 //Display the result upon unsuccessful operation
               else
                   System.out.println("File does not exists");
           }
           catch (IOException e) {   
               
               e.printStackTrace();
           }
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

class Sortfiles
{
  
    //static int MAX = 100;
  
    void sortStrings(String[] Filenames, int n) 
    {
        String temp;
  
        // Sorting filess using bubble sort
        for (int j = 0; j < n - 1; j++)
        {
            for (int i = j + 1; i < n; i++) 
            {
                if (Filenames[j].compareTo(Filenames[i]) > 0)
                {
                    temp = Filenames[j];
                    Filenames[j] = Filenames[i];
                    Filenames[i] = temp;
                }
            }
        }
    }
  
}

class FindFile 
{   
    
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
                
                if (name.equals(fil.getName()))
                {
                //Display the result upon case sensitive successful operation
                System.out.println("Exact matching file found in "+fil.getParentFile() +"\\"+ name);
                break;
                }
                //Display the (case insensitive) result upon successful operation
                System.out.println("Yes, similar File is present in "+fil.getParentFile());
                break;
            }
            
            else{
              
                 //Display the result upon unsuccessful operation
                System.out.println("File Not Found");
                break;
            }
        }
       
    }
    
}
