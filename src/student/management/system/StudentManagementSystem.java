package student.management.system;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class StudentManagementSystem {
    private static DbConfig dbconfig = DbConfig.getInstance();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // System.out.println("Enter student ID to delete:");
        // int stuID = scanner.nextInt();
        // scanner.nextLine();
        // deleteStudent(stuID);

        // insertStudent(scanner);

        // Uncomment and use as needed
        // batchProcessing();
        // rollBackPractice();
        // commitPractice();

        callGetAllStudent();

        scanner.close();
    }

    public static void insertStudent(Scanner scanner) {
        System.out.println("Enter your Name: ");
        String StuName = scanner.nextLine();

        System.out.println("Enter your Age: ");
        int StuAge = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.println("Enter your Department: ");
        String StuDepartment = scanner.nextLine();

        System.out.println("Enter your District: ");
        String StuDistrict = scanner.nextLine();

        System.out.println("Enter your NIC: ");
        String StuNIC = scanner.nextLine();

        System.out.println("Enter your Gender: ");
        String StuGender = scanner.nextLine();

        System.out.println("Enter your Performance: ");
        double StuPerformance = scanner.nextDouble();

        String sql = "INSERT INTO students (StuName, StuAge, StuDepartment, StuDistrict, StuNIC, StuGender, StuPerformance) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = dbconfig.dbConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, StuName);
            ps.setInt(2, StuAge);
            ps.setString(3, StuDepartment);
            ps.setString(4, StuDistrict);
            ps.setString(5, StuNIC);
            ps.setString(6, StuGender);
            ps.setDouble(7, StuPerformance);

            int row = ps.executeUpdate();
            System.out.println(row + " row(s) affected.");

        } catch (Exception e) {
            System.out.println("Error inserting student: " + e.getMessage());
        }
    }

    public static void getAllStudent() {
        String sql = "SELECT * FROM students";

        try (Connection con = dbconfig.dbConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int StuID = rs.getInt("StuID");
                String StuName = rs.getString("StuName");
                int StuAge = rs.getInt("StuAge");
                String StuDepartment = rs.getString("StuDepartment");
                String StuDistrict = rs.getString("StuDistrict");
                String StuNIC = rs.getString("StuNIC");
                String StuGender = rs.getString("StuGender");
                double StuPerformance = rs.getDouble("StuPerformance");

                System.out.println("Student ID: " + StuID);
                System.out.println("Student Name: " + StuName);
                System.out.println("Age: " + StuAge);
                System.out.println("Department: " + StuDepartment);
                System.out.println("District: " + StuDistrict);
                System.out.println("NIC: " + StuNIC);
                System.out.println("Gender: " + StuGender);
                System.out.println("Performance: " + StuPerformance);
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }

    public static void deleteStudent(int stuID) {
        String sql = "DELETE FROM students WHERE StuID = ?";

        try (Connection con = dbconfig.dbConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, stuID);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student with ID " + stuID + " deleted successfully.");
            } else {
                System.out.println("No student found with ID " + stuID);
            }

        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    public static void callGetAllStudent() {
        String sql = "{call GetAll()}";

        try (Connection con = dbconfig.dbConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            boolean hasResults = cs.execute();

            while (hasResults) {
                try (ResultSet rs = cs.getResultSet()) {
                    while (rs.next()) {
                        String StuName = rs.getString("StuName");
                        System.out.println("Student Name: " + StuName);
                    }
                }
                hasResults = cs.getMoreResults();
            }

        } catch (Exception e) {
            System.out.println("Error calling GetAll stored procedure: " + e.getMessage());
        }
    }

    public static void callGetById(Scanner scanner) {
        
        System.out.println("Enter student ID to fetch:");
        int stuID = scanner.nextInt();
        scanner.nextLine(); 

        String sql = "CALL GetByID(?)";

        try (Connection con = dbconfig.dbConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, stuID);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    String StuName = rs.getString("StuName");
                    int StuAge = rs.getInt("StuAge");
                    String StuDepartment = rs.getString("StuDepartment");
                    String StuDistrict = rs.getString("StuDistrict");
                    String StuNIC = rs.getString("StuNIC");
                    String StuGender = rs.getString("StuGender");
                    double StuPerformance = rs.getDouble("StuPerformance");

                    System.out.println("Student Name: " + StuName);
                    System.out.println("Age: " + StuAge);
                    System.out.println("Department: " + StuDepartment);
                    System.out.println("District: " + StuDistrict);
                    System.out.println("NIC: " + StuNIC);
                    System.out.println("Gender: " + StuGender);
                    System.out.println("Performance: " + StuPerformance);
                } else {
                    System.out.println("No student found with ID " + stuID);
            }
        }

        } catch (Exception e) {
            System.out.println("Error fetching student by ID: " + e.getMessage());
        }
    }

    
    public static void callGetNameById(Scanner scanner) {
        
        System.out.println("Enter student ID to fetch name:");
        int stuID = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        String sql = "CALL GetNameByID(?, ?)";

        try (Connection con = dbconfig.dbConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, stuID);
            cs.registerOutParameter(2, Types.VARCHAR);

            cs.execute();
            String studentName = cs.getString(2);

            if (studentName != null) {
                System.out.println("Student Name: " + studentName);
            } else {
                System.out.println("No student found with ID " + stuID);
            }

        } catch (Exception e) {
            System.out.println("Error fetching student name by ID: " + e.getMessage());
        }
    }


    public static void commitPractice() {
        try (Connection con = dbconfig.dbConnection()) {
            con.setAutoCommit(false);

            String query1 = "UPDATE students SET StuPerformance = 90 WHERE StuID = 4";
            String query2 = "UPDATE students SET StuPerformance = 80 WHERE StuID = 5";

            try (Statement st = con.createStatement()) {
                st.executeUpdate(query1);
                st.executeUpdate(query2);

                con.commit();
                System.out.println("Transaction committed successfully.");
            } catch (Exception e) {
                con.rollback();
                System.out.println("Error occurred. Transaction rolled back: " + e.getMessage());
            } finally {
                con.setAutoCommit(true);
            }
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    public static void batchProcessing() {
        try (Connection con = dbconfig.dbConnection()) {
            String query1 = "UPDATE students SET StuPerformance = 85 WHERE StuID=4";
            String query2 = "UPDATE students SET StuPerformance = 75 WHERE StuID=5";

            try (Statement st = con.createStatement()) {
                st.addBatch(query1);
                st.addBatch(query2);

                int[] results = st.executeBatch();
                System.out.println(Arrays.toString(results));
            }
        } catch (Exception e) {
            System.out.println("Error during batch processing: " + e.getMessage());
        }
    }

    public static void rollBackPractice() {
        try (Connection con = dbconfig.dbConnection()) {
            con.setAutoCommit(false);

            String query1 = "UPDATE students SET StuPerformance = 85 WHERE StuID=4";
            String query2 = "UPDATE students SET StuPerformance = 15 WHERE StuID=6";

            try (Statement st = con.createStatement()) {
                st.addBatch(query1);
                st.addBatch(query2);

                int[] results = st.executeBatch();
                boolean allSuccessful = true;

                for (int result : results) {
                    if (result <= 0) {
                        allSuccessful = false;
                        break;
                    }
                }

                if (allSuccessful) {
                    con.commit();
                    System.out.println("Batch executed successfully and committed.");
                } else {
                    con.rollback();
                    System.out.println("Batch execution failed. Rolled back.");
                }

                System.out.println(Arrays.toString(results));
            } catch (Exception e) {
                con.rollback();
                System.out.println("Error during batch processing. Rolled back: " + e.getMessage());
            } finally {
                con.setAutoCommit(true);
            }
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
}
