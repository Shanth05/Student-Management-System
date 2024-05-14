import java.util.Scanner;

class main{
    static String[][] studentList = new String[50][6];

    public static void dashboard(){

        Scanner s = new Scanner(System.in);

        System.out.println("*********************************************************");
        System.out.println("| Welcome to Developer Stack Student Management System  |");
        System.out.println("*********************************************************");
        System.out.println("1 Save new student");
        System.out.println("2 Edit student");
        System.out.println("3 view all student");
        System.out.println("4 view student");
        System.out.println("5 Remove student");
        System.out.println("6 Log out \n");

        System.out.print("Enter Your Choice :  ");
        int choice = s.nextInt();
        System.out.println(choice);

        switch (choice) {
            case 1:
                saveStudent();
                break;
            case 2:
                editStudent();
                break;
            case 3:
                viewAllStudent();
                break;
            case 4:
                viewStudent();
                break;
            case 5:
                removeStudent();
                break;
            case 6:
                System.out.println("Logging out...");
                break;
            default:
            System.out.println("Invalid choice. Please try again.");
            System.out.print("\033[H\033[23"); 
                dashboard();
                break;
        }

    }

    public static void saveStudent(){
        System.out.print("\033[H\033[23"); 
        System.out.println("*********************************************************");
        System.out.println("| Welcome to Developer Stack Student Management System  |");
        System.out.println("*********************************************************");
        System.out.println("*****************");
        System.out.println("| Save Student |");
        System.out.println("*****************");
       
        Scanner s = new Scanner(System.in);

        System.out.print("Enter Student Name");
            String name = s.nextLine();

        System.out.print("Enter Student NIC");
            String nic = s.nextLine();

        System.out.print("Enter Student Age");
            String age = s.nextLine();

        System.out.print("Enter Student Contact Number");
            String contactNumber = s.nextLine();

        System.out.print("Enter Student Gender");
            String gender = s.nextLine();

        System.out.print("Enter Student DOB");
            String dob = s.nextLine();

            int index=0;

            for(int i=0; i<studentList.length; i++){
                if(studentList[i][0]==null){
                    index=i;
                    break;
                }
            }
            System.out.println(index);
    }

        public static void editStudent(){
            System.out.print("\033[H\033[23"); 
            System.out.println("*********************************************************");
            System.out.println("| Welcome to Developer Stack Student Management System  |");
            System.out.println("*********************************************************");
            System.out.println("*****************");
            System.out.println("| Save Student |");
            System.out.println("*****************");

            dashboard();
        }
        public static void viewAllStudent(){
            System.out.print("\033[H\033[23"); 
            System.out.println("*********************************************************");
            System.out.println("| Welcome to Developer Stack Student Management System  |");
            System.out.println("*********************************************************");
            System.out.println("*****************");
            System.out.println("| Save Student |");
            System.out.println("*****************");

            dashboard();
        }
    
        public static void viewStudent(){
            System.out.print("\033[H\033[23"); 
            System.out.println("*********************************************************");
            System.out.println("| Welcome to Developer Stack Student Management System  |");
            System.out.println("*********************************************************");
            System.out.println("*****************");
            System.out.println("| Save Student |");
            System.out.println("*****************");
        
            dashboard();
        }

         public static void removeStudent(){
            System.out.print("\033[H\033[23"); 
            System.out.println("*********************************************************");
            System.out.println("| Welcome to Developer Stack Student Management System  |");
            System.out.println("*********************************************************");
            System.out.println("*****************");
            System.out.println("| Save Student |");
            System.out.println("*****************");

            dashboard();
        }
    
    public static void main(String[] args) {
        dashboard();
    }    
}