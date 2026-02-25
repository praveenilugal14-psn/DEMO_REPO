import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

 class profile {
    String name;
    long mob;
    String mail,pass3;
    String[] sq = new String[3];
} 
public class car {
    String model,ID;
    int rent;
    public static void bookmyCar(String name,int age,int DL,String t3,String n2,String t4,int tr,String M,String I,int R){
        System.out.println("******************************************************************************************************");
        System.out.println("*                                   PSN CAR RENTAL AGENCY                                            *");
        System.out.printf("*    Name : %-20s                                                 Date : %-9s   *\n",name,t3);
        System.out.printf("*    Age : %-19d                                              Time : %-18s*\n",age,n2);
        System.out.printf("*    Model : %-10s     ID : %-10s     Rent : %-10d                                    *\n",M,I,R);
        System.out.printf("*    Total Rent : %-80d   *\n",tr);
        System.out.printf("*    Car should be returned on or before : %-10s     %-35s        *\n",t4,n2);
        System.out.printf("*                                        THANK YOU                                                   *\n");
        System.out.println("******************************************************************************************************");
        try{
            File f = new File("Car.txt");
            List<String> cars = Files.readAllLines(Paths.get("Car.txt"));
            FileWriter w = new FileWriter("Car.txt", false);
            String[] a = cars.toArray(new String[0]);
            for(int i=0;i<a.length;i++){
                String[] b = a[i].split("\\s+");
                for(int j=0;j<b.length;j++){
                    if(b[j].equals(I)){
                        b[3] = "N/A";
                    }
                    w.write(b[j]+"\t\t");
                }
                w.write("\n");
            }
            w.close();
        }catch(IOException e){
            System.out.println("An error has occured in reading or updating the file");
            e.printStackTrace();
        }
    }
    public static void EditCar(Scanner in,int b){
        if(b==1){
            System.out.print("Enter number of cars you want to add : ");
                    int n = in.nextInt();
                    in.nextLine();
                    car[] mycars = new car[n];
                    System.out.println("Enter car details:");
                    for(int i=0;i<n;i++){
                        mycars[i] = new car();
                        System.out.print("Model : ");
                        mycars[i].model = in.nextLine();
                        System.out.print("ID : ");
                        mycars[i].ID = in.nextLine();
                        System.out.print("rent per day : ");
                        mycars[i].rent = in.nextInt();
                        in.nextLine();
                    }
                    try{
                        FileWriter f1 = new FileWriter("Car.txt",true);
                
                        for(int i=0;i<n;i++){
                            f1.write(mycars[i].model+"\t\t"+mycars[i].ID+"\t\t"+mycars[i].rent+"\t\tAvailable\n");
                        }
                        f1.close();
                        System.out.println("Car details are added");
                    }catch(IOException e){
                        System.out.print("Error in adding cars");
                        e.printStackTrace();
                    }}
        else{
            String id = new String();
            int x = -1;
            System.out.print("Enter 0 to Remove car or 1 to Return car: ");
            int d = in.nextInt();
            in.nextLine();
            if(d==1){
                System.out.print("Enter the car id to be returned: ");
                 id = in.nextLine();}
            else{
                System.out.print("Enter the car id to be removed: ");
                id = in.nextLine();
            }
            try{
            File f = new File("Car.txt");
            List<String> cars = Files.readAllLines(Paths.get("Car.txt"));
            FileWriter w = new FileWriter("Car.txt", false);
            String[] a = cars.toArray(new String[0]);
            for(int i=0;i<a.length;i++){
                String[] c = a[i].split("\\s+");
                for(int k=0;k<c.length;k++){
                    if(d==0){
                        if(c[k].equals(id)){
                            x=i;
                        }
                    }
                }
                if(i==x){
                    continue;
                }
                else{
                for(int j=0;j<c.length;j++){
                    if(d==1){
                    if(c[j].equals(id)){
                        c[3] = "Available";
                    }
                  }
                     w.write(c[j]+"\t\t");
                }}
                w.write("\n");
            }
            w.close();
            System.out.println("Updated successfully...");
        }catch(IOException e){
            System.out.println("An error has occured in reading or updating the file");
            e.printStackTrace();
        }
        }
    }
    public static void ShowCar(){
                     try{
                        File f1 = new File("Car.txt");
                        Scanner show = new Scanner(f1);
                        while(show.hasNextLine()){
                            String cars = show.nextLine();
                            System.out.println(cars);
                            
                        }
                    }catch(FileNotFoundException e){
                        System.out.println("An error has occured in accessing the file!!!");
                        e.printStackTrace();
                    }
    }
    public static void main(String[] args) {
        File f = new File("Car.txt");
        File y = new File("prof.txt");
        Scanner in = new Scanner(System.in);
        int a,b,j=0,x=0,count=0,limit=3;
        String pass = "pass";
        String found = "false";
        String[] arr1 = new String[3];
        String[] arr2 = new String[3];
        String obj = new String();
        String p1 = new String();
        System.out.println("Enter 1 if you are owner or 0 ");
        a = in.nextInt();
        in.nextLine();
        if(a==1){
            System.out.println("Enter login if you already have an account OR Enter sign up to create new account");
            String s = in.nextLine();
            if(s.equals("login")){ 
                    try{
                    File y2 = new File("prof.txt");
                    List<String> get1 = Files.readAllLines(Paths.get("prof.txt"));
                    String[] get2 = get1.toArray(new String[0]);                                                                
                    for(int i=0;i<3;i++){
                        arr1[i] = get2[i+4];
                    }      
                    obj = get2[3];                              
                }catch(IOException e){
                        System.out.println("An error has occured in reading the file!!!");
                        e.printStackTrace();
                    }                   
                System.out.print("Enter the password:");
            do{
                if(count == limit){
                System.out.println("Your school name");
                arr2[0] = in.nextLine();
                System.out.println("Your PU colloge name");
                arr2[1] = in.nextLine();
                System.out.println("You are graduated at");
                arr2[2] = in.nextLine();
                }
                else{
                    pass = in.nextLine();}                
                if(pass.equals(obj) || Arrays.equals(arr1,arr2)){
                System.out.println("Enter 1 to add cars or Enter 2 to Return or Edit car list or 0 to exit");
                b = in.nextInt();
                in.nextLine();
                if(b==1){
                    EditCar(in,b);
                }
                else if(b==2){
                    EditCar(in,b);}
                else{
                    System.out.println("Do you want to see the car list?\nEnter 1 if yes or 0 to exit");
                    int c = in.nextInt();
                    if(c==1){
                        ShowCar();
                    }
                    else{
                    System.out.println("Thank You");}
                }
            }
            else{
                if(count<limit-1){
                System.out.println("Incorrect Password!!!");
                System.out.println("Enter the password again");}
                else if(count<limit){
                    System.out.println("Again you have entered wrong password!!!\nAnswer the security qustions...");
                }
                else{
                    System.out.println("Try again later....");
                }
                count++;
            }}while(!pass.equals(obj) && count<=limit);
        }
            if(s.equals("sign up")){
                 profile p = new profile();
            System.out.print("Enter Name: ");
            p.name = in.nextLine();
            System.out.print("Enter Mobile Number: ");
            p.mob = in.nextLong();
            in.nextLine();
            System.out.print("Enter e-mail id: ");
            in.nextLine();
            System.out.print("Create a password: ");
            String pass1 = in.nextLine();
            System.out.print("Re-enter your password to confirm: ");
            String pass2 = in.nextLine();
            if(pass1.equals(pass2)){
                p.pass3 = pass1;
            }
            System.out.println("Answer the following security questions: ");
            System.out.print("Your school name: ");
            p.sq[0] = in.nextLine();
            System.out.print("Your PU college name: ");
            p.sq[1] = in.nextLine();
            System.out.print("You are graduated from: ");
            p.sq[2] = in.nextLine();
            try{
                FileWriter y1 = new FileWriter("prof.txt");
                y1.write(p.name+"\n"+p.mob+"\n"+p.mail+"\n"+p.pass3+"\n"+p.sq[0]+"\n"+p.sq[1]+"\n"+p.sq[2]);
                System.out.println("Your profile creation is complited...");
                y1.close();
            }catch(IOException e){
                System.out.println("An error has occured in adding/updating information!!!!!");
                e.printStackTrace();
            }
            }
        }
        else{
            System.out.println("Enter open to see the cars details");
            String c = in.nextLine();
            if(c.equals("open")){
                car[] myCars2 = new car[100];
                ShowCar();
                System.out.println("Do you want any car for rent ? \n Enter yes if you want or no");
                String d = in.nextLine();
                try{
                    File f3 = new File("Car.txt");
                    Scanner list = new Scanner(f3);
                if(d.equals("yes")){
                     while (list.hasNextLine()) {
                    String details = list.nextLine().trim();
                    if(details.isEmpty() || details.contains("RENT")){
                    continue;}
                    String[] parts = details.split("\\s+");
                    if(parts.length>=3){
                            myCars2[j] = new car();
                            myCars2[j].model = parts[0];
                            myCars2[j].ID = parts[1];
                            myCars2[j].rent = Integer.parseInt(parts[2]);
                        j++;
                    }
                    }
                    list.close();
                    System.out.println("Please enter the car Id you want : ");
                    do{String E = in.nextLine();
                    for(int i=0;i<j;i++){
                        if( myCars2[i].ID.equals(E)){
                            found = "true";
                            x=i;
                        }}
                    if(found.equals("true")){
                        System.out.print("Enter number of days you want the car for rent : ");
                        int g = in.nextInt();
                        in.nextLine();
                        String M = myCars2[x].model;
                        String I = myCars2[x].ID;
                        int R = myCars2[x].rent;
                        int tr = myCars2[x].rent*g;
                        System.out.println("Total rent for "+g+" days = "+tr);
                        System.out.println("Do you want to book the car ? \nEnter yes if you want or no");
                        String book = in.nextLine();
                        if(book.equals("yes")){
                            System.out.print("Name : ");
                            String name = in.nextLine();
                            System.out.print("Age : ");
                            int age = in.nextInt();
                            in.nextLine();
                            System.out.println("DL No : ");
                            int DL =  in.nextInt();
                            in.nextLine();
                            LocalDate today = LocalDate.now();
                            DateTimeFormatter t1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            String t3 = today.format(t1);
                            LocalTime now = LocalTime.now();
                            DateTimeFormatter n1 = DateTimeFormatter.ofPattern("hh:mm:ss a");
                            String n2 = now.format(n1);
                            LocalDate date = today.plusDays(g);
                            DateTimeFormatter t2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            String t4 = date.format(t2);
                            bookmyCar(name,age,DL,t3,n2,t4,tr,M,I,R);
                        }
                    }else{
                    System.out.println("Please enter the correct ID");
                    }}while(!found.equals("true"));
                }
            
                
                else {
                    System.out.println("Thank you, Come again..");
                }
            }catch(FileNotFoundException e){
                    System.out.println("An error has occured");
                    e.printStackTrace();
                    }
                }
            else{
                System.out.println("Thank You,Come again");
            

            }
        }
    }
}
