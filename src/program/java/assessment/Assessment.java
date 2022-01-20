package program.java.assessment;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Assessment {

    public void greetings(){
        System.out.println("In the main content you have the next options");
        System.out.println("1.Display all the name of the current files in ascending order;");
        System.out.println("2.More user actions;");
        System.out.println("3.QUIT app");
        System.out.println();
        System.out.println("What is your choice? Please insert the number of a desired option");
    }

    public void userActions(){
        System.out.println("The following actions are permited in user content:");
        System.out.println("4.Add a specified file to the path;");
        System.out.println("5.Delete a specified file from the path");
        System.out.println("6.Search for a specified file in path");
        System.out.println("7.Back");
        System.out.println();
        System.out.println("What is your choice? Please insert the number of a desired option");
    }

    public void displayFileName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the path? Insert without double or single quotes. Ex: C\\Users\\...");
        String path = sc.nextLine();
        File directoryPath = new File(path);
        if(directoryPath.exists()){
            String contents[] = directoryPath.list();
            System.out.println("List of files and directories in the specified directory:");
            for(int j=0; j<contents.length-1;j++){
                for(int i=0; i<contents.length-1;i++){
                    if(contents[i].equals(contents[i+1])){
                        String temp = contents[i];
                        contents[i] = contents[i+1];
                        contents[i+1] = temp;
                    }
                }
            }
            for (String val:contents)
                System.out.println(val);
        }
        else
            System.out.println("The specified path doesn`t exists");
    }

    public void addFileName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the path where the file should be added? Insert without double or single quotes. Ex: C\\Users\\...");
        String path = sc.nextLine();
        System.out.println("What is the name of the file you want to add? Also, insert with specific extension. Ex: test.txt");
        String name = sc.nextLine();
        File f1 = new File(path);
        if(f1.exists()){
            File f = new File(path+"\\"+name);
            try{
                boolean result = f.createNewFile();
                if(result)
                    System.out.println("File added to the path");
                else
                    System.out.println("The file already exists in this path");
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("The path doesn`t exist");
        }
    }

    public void deleteFileName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the path to the desired file? Insert without double or single quotes. Ex: C\\Users\\test.txt");
        String path = sc.nextLine();
        File f1 = new File(path);
        if(f1.exists()){
            f1.delete();
            System.out.println("File deleted");
        }
        else
            System.out.println("The file doesn`t exists");


    }

    public void searchFileName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the path where you want to find the file? Insert without double or single quotes. Ex: C\\Users\\...");
        String path = sc.nextLine();
        System.out.println("What is the name of the file you want to search for? Also, insert with specific extension. Ex: test.txt");
        String name = sc.nextLine();
        File directoryPath = new File(path);
        if(directoryPath.exists()){
            String contents[] = directoryPath.list();
            int counter = 0;
            for(int j=0; j<contents.length-1;j++){
                if(contents[j].equals(name))
                    counter++;
            }
            if(counter == 0)
                System.out.println("The file doesn`t exist in the path");
            else
                System.out.println("The file exist in the specified path");
        }
        else
            System.out.println("The specified path doesn`t exists");
    }

    public void back(){
        System.out.println("Back to main content");
        greetings();
    }

    public static void main(String[] args){
        System.out.println(".......Welcome to the Application........");
        System.out.println("Developed by Oniga Madalin");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Assessment a1 = new Assessment();
        a1.greetings();

        String response = sc.nextLine();
        while(!response.equals("3")){
            if(response.equals("1")){
                a1.displayFileName();
                System.out.println("What is your next choice? Valid options:1,2,3");
            }
            else if(response.equals("2")){
                a1.userActions();
                String response1 = sc.nextLine();
                while(!response1.equals("7")){
                    if(response1.equals("4")){
                        a1.addFileName();
                        System.out.println("What is your next choice? Valid options:4,5,6,7");
                    }

                    else if(response1.equals("5")){
                        a1.deleteFileName();
                        System.out.println("What is your next choice? Valid options:4,5,6,7");
                    }
                    else if(response1.equals("6")){
                        a1.searchFileName();
                        System.out.println("What is your next choice? Valid options:4,5,6,7");
                    }
                    else
                        System.out.println("Invalid option.Try again. Valid options:4,5,6,7");
                    response1 = sc.nextLine();
                }
                a1.back();
            }
            else
                System.out.println("Invalid option.Try again. Valid options:1,2,3");
            response = sc.nextLine();
        }

        System.out.println("You closed the application");

    }
}
