import java.util.Arrays;
import java.util.Scanner;

class main {
    static String[][] studentList = new String[50][6];
    static String[][] tempList = new String[50][6];

    public static void dashboard() {
        Scanner s = new Scanner(System.in);

        System.out.println("*********************************************************");
        System.out.println("| Welcome to Developer Stack Student Management System  |");
        System.out.println("*********************************************************");
        System.out.println("********************");
        System.out.println("* 1. Save New Student  *");
        System.out.println("* 2. Edit Student      *");
        System.out.println("* 3. View All Students *");
        System.out.println("* 4. Search Student    *");
        System.out.println("* 5. Remove Student    *");
        System.out.println("* 6. Log Out           *");
        System.out.println("********************");
        System.out.print("Enter Your Choice: ");
        int choice = s.nextInt();

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
                searchStudent();
                break;
            case 5:
                removeStudent();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                dashboard();
                break;
        }
    }

    public static void saveStudent() {
        System.out.print("\033[H\033[2J");

        System.out.println("*********************************************************");
        System.out.println("| Welcome to Developer Stack Student Management System  |");
        System.out.println("*********************************************************");
        System.out.println("********************");
        System.out.println("* Save Student      *");
        System.out.println("********************");

        Scanner s = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = s.nextLine();
        System.out.print("Enter Student NIC: ");
        String nic = s.nextLine();
        System.out.print("Enter Student Age: ");
        String age = s.nextLine();
        System.out.print("Enter Student Contact Number: ");
        String contactNumber = s.nextLine();
        System.out.print("Enter Student Gender: ");
        String gender = s.nextLine();
        System.out.print("Enter Student DOB: ");
        String dob = s.nextLine();

        int index = 0;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i][0] == null) {
                index = i;
                break;
            }
        }

        studentList[index][0] = name;
        studentList[index][1] = nic;
        studentList[index][2] = age;
        studentList[index][3] = contactNumber;
        studentList[index][4] = gender;
        studentList[index][5] = dob;

        System.out.println("Successfully Done! \n" + Arrays.toString(studentList[index]));
        System.out.println("\nDo you want to save another student? Press \"y\" or any other key to go to the dashboard.");
        String selection = s.nextLine();
        if (selection.equalsIgnoreCase("Y")) {
            saveStudent();
        } else {
            dashboard();
        }
    }

    public static void editStudent() {
        System.out.print("\033[H\033[2J");

        System.out.println("*********************************************************");
        System.out.println("| Welcome to Developer Stack Student Management System  |");
        System.out.println("*********************************************************");
        System.out.println("********************");
        System.out.println("* Edit Student      *");
        System.out.println("********************");

        Scanner s = new Scanner(System.in);

        System.out.print("Enter Student NIC Number: ");
        String nic = s.nextLine();
        int index = -1;

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i][1] != null && studentList[i][1].equals(nic)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Student with NIC " + nic + " not found.");
            System.out.println("\nPress any key to go to the dashboard.");
            s.nextLine();
            dashboard();
            return;
        }

        System.out.println(Arrays.toString(studentList[index]) + "\n");

        System.out.println("Which field do you want to edit?");
        System.out.println("********************");
        System.out.println("* 0 - Name         *");
        System.out.println("* 1 - NIC          *");
        System.out.println("* 2 - Age          *");
        System.out.println("* 3 - Contact Number *");
        System.out.println("* 4 - Date of Birth*");
        System.out.println("* 5 - Gender       *");
        System.out.println("********************");

        int choice = s.nextInt();
        s.nextLine(); 

        switch (choice) {
            case 0:
                System.out.print("Enter new name: ");
                studentList[index][0] = s.nextLine();
                break;
            case 1:
                System.out.print("Enter new NIC: ");
                studentList[index][1] = s.nextLine();
                break;
            case 2:
                System.out.print("Enter new age: ");
                studentList[index][2] = s.nextLine();
                break;
            case 3:
                System.out.print("Enter new contact number: ");
                studentList[index][3] = s.nextLine();
                break;
            case 4:
                System.out.print("Enter new date of birth: ");
                studentList[index][4] = s.nextLine();
                break;
            case 5:
                System.out.print("Enter new gender: ");
                studentList[index][5] = s.nextLine();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        System.out.println("\nPress any key to go to the dashboard.");
        s.nextLine();
        dashboard();
    }

    public static void viewAllStudent() {
        Scanner s = new Scanner(System.in);

        System.out.print("\033[H\033[2J");
        System.out.println("*********************************************************");
        System.out.println("| Welcome to Developer Stack Student Management System  |");
        System.out.println("*********************************************************");
        System.out.println("********************");
        System.out.println("* View All Students *");
        System.out.println("********************");

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i][0] == null) {
                break;
            }
            System.out.println(Arrays.toString(studentList[i]));
        }

        System.out.println("\nPress any key to go to the dashboard.");
        s.nextLine();
        dashboard();
    }

    public static void searchStudent() {
        System.out.print("\033[H\033[2J");
        Scanner s = new Scanner(System.in);

        System.out.println("*********************************************************");
        System.out.println("| Welcome to Developer Stack Student Management System  |");
        System.out.println("*********************************************************");
        System.out.println("********************");
        System.out.println("* Search Student    *");
        System.out.println("********************");

        System.out.print("Enter Student NIC Number: ");
        String nic = s.nextLine();

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i][1] != null && studentList[i][1].equals(nic)) {
                System.out.println("\n" + Arrays.toString(studentList[i]));
                break;
            }
        }

        System.out.println("\nPress any key to go to the dashboard.");
        s.nextLine();
        dashboard();
    }

    public static void removeStudent() {
        System.out.print("\033[H\033[2J");
        Scanner s = new Scanner(System.in);

        System.out.println("*********************************************************");
        System.out.println("| Welcome to Developer Stack Student Management System  |");
        System.out.println("*********************************************************");
        System.out.println("********************");
        System.out.println("* Remove Student    *");
        System.out.println("********************");

        System.out.print("Enter Student NIC Number: ");
        String nic = s.nextLine();
        int index = -1;

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i][1] != null && studentList[i][1].equals(nic)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Student with NIC " + nic + " not found.");
            System.out.println("\nPress any key to go to the dashboard.");
            s.nextLine();
            dashboard();
            return;
        }

        int x = 0;
        for (int k = 0; k < studentList.length; k++) {
            if (k == index) {
                continue;
            }
            tempList[x] = studentList[k];
            x++;
        }

        studentList = tempList;
        System.out.println("Student with NIC " + nic + " has been removed.");

        System.out.println("\nPress any key to go to the dashboard.");
        s.nextLine();
        dashboard();
    }

    public static void main(String[] args) {
        dashboard();
    }
}
