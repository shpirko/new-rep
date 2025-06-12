package ShakedShpirkoAndNoaSchwarz;
// Shaked Shpirko 315142372 & Noa Schwarz 212840516
import java.util.Scanner;

import ShakedShpirkoAndNoaSchwarz.Lecturer.DegreeLevel;
public class Main {
    private static final String[] MENU = {
        "Exit",
        "Add Lecturer",
        "Add Committee",
        "Add Department",
        "Update Chair of Committee",
        "Remove Lecturer from Committee",
        "Assign Lecturer to Committee",
        "Assign Lecturer to Department",
        "Show Average Salary of All Lecturers",
        "Show Average Salary of Lecturers in Department",
        "Show All Lecturers Info",
        "Show All Committees Info",
        "Compare Lecturers by Papers",
        "Compare Committees", 
        "Duplicate Committee",
        "Test System"
    };
    
    private static Scanner s;
    private static int userChosenNum;
    private static Manager manager;


    private static int showMenu(Scanner s) {
        System.out.println("\n====== Menu =======");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ". " + MENU[i]);
        }
        System.out.println("Please select an action : ");
        return s.nextInt();
        
    }

    private static void run() {
        do {
            userChosenNum = showMenu(s);
            s.nextLine(); // Consume the newline character left by nextInt()
            switch (userChosenNum) {
                case 0 -> System.out.println("Exiting program");
                case 1 -> addLecturer();
                case 2 -> addCommittee();
                case 3 -> addDepartment();
                case 4 -> updateChairOfCommittee();
                case 5 -> removeLecturerFromCommittee();
                case 6 -> asignLecturerToCommittee();
                case 7 -> asignLecturerToDepartment();
                case 8 -> showAverageSalaryOfAllLecturers();
                case 9 -> showAverageSalaryOfLecturersInDepartment();
                case 10 -> showAllLecturersInfo();
                case 11 -> showAllCommitteesInfo();
                case 12 -> CompareLecturersbyPapers();
                case 13 -> compareCommittee();
                case 14 -> duplicateCommittee();
                case 15 -> testSystem();
                default -> System.out.println("Incorrect input, please try again");
            }
        } while (userChosenNum != 0);
    }
    public static void main(String[] args) {
        // Noa Schwarz 212840516 & Shaked Shpirko 315142372
        s = new Scanner(System.in);
        System.out.println("Welcome to the system! please enter a college name: ");
        Main.manager = new Manager(s.nextLine());
        run();
        s.close();
    }

    private static void testSystem() {
    System.out.println("=== Running Automated Tests ===");

    // Add Departments
    manager.createDepartment("Computer Science");
    manager.createDepartment("Mathematics");

    // Add Lecturers
    manager.createLecturer("Alice", "111", "CS", DegreeLevel.BACHELOR, 10000);
    manager.createLecturer("Bob", "222", "Math", DegreeLevel.PHD, 12000);
    manager.createLecturer("Carol", "333", "CS", DegreeLevel.PROFESSOR, 15000);

    // Assign Lecturers to Departments
    manager.asignLecturerToDepartment(manager.getLecturerByName("Alice"), manager.getDepartmentByName("Computer Science"));
    manager.asignLecturerToDepartment(manager.getLecturerByName("Bob"), manager.getDepartmentByName("Mathematics"));
    manager.asignLecturerToDepartment(manager.getLecturerByName("Carol"), manager.getDepartmentByName("Computer Science"));

    // Add Committees
    manager.createCommittee("Research", manager.getLecturerByName("Bob"));
    manager.createCommittee("Events", manager.getLecturerByName("Carol"));

    // Assign Lecturers to Committees
    manager.asignLecturerToCommittee(manager.getLecturerByName("Alice"), manager.getCommitteeByName("Research"));
    manager.asignLecturerToCommittee(manager.getLecturerByName("Carol"), manager.getCommitteeByName("Research"));
    manager.asignLecturerToCommittee(manager.getLecturerByName("Bob"), manager.getCommitteeByName("Events"));

    // Add published papers to Doctor/Professor
    Doctor bob = (Doctor) manager.getLecturerByName("Bob");
    bob.addPublishedPaper("Paper 1");
    bob.addPublishedPaper("Paper 2");
    Professor carol = (Professor) manager.getLecturerByName("Carol");
    carol.addPublishedPaper("Paper A");

    // Show all lecturers
    showAllLecturersInfo();

    // Show all committees
    showAllCommitteesInfo();

    // Show average salary
    showAverageSalaryOfAllLecturers();

    // Show average salary in department
    System.out.println(manager.calcAvgDep(manager.getDepartmentByName("Computer Science")));

    // Compare lecturers by papers
    System.out.println(manager.CompareDoctorsbyPapers(bob, carol));

    // Compare committees by members
    System.out.println(manager.compareByMembers(manager.getCommitteeByName("Research"), manager.getCommitteeByName("Events")));

    // Duplicate a committee
    try {
        manager.duplicateCommittee(manager.getCommitteeByName("Research"));
        System.out.println("Duplicated committee info:");
        System.out.println(manager.getCommitteeByName("Research-new"));
    } catch (Exception e) {
        System.out.println("Error duplicating committee: " + e.getMessage());
    }

    System.out.println("=== Automated Tests Complete ===");
}

    

    private static void addLecturer() {
        try{
            System.out.println("Enter lecturer name: ");
            String name = s.nextLine();
            manager.isExistLecturer(name);
            System.out.println("Enter lecturer ID: ");
            String id = s.nextLine();
            System.out.println("Enter degree name: ");
            String degreename = s.nextLine();
            System.out.println("Choose degree level by number: 1. Bachelor 2. Master 3. PhD 4. Professor");
            int degreeLevel = s.nextInt();
            s.nextLine();
            DegreeLevel elevel;
            switch (degreeLevel) {
                case 1 -> elevel = DegreeLevel.BACHELOR;
                case 2 -> elevel = DegreeLevel.MASTER;
                case 3 -> elevel = DegreeLevel.PHD;
                case 4 -> elevel = DegreeLevel.PROFESSOR;
                default -> {System.out.println("Invalid number"); 
                return;}
            }
            System.out.println("Enter salary: ");
            int salary = s.nextInt();
            s.nextLine();
            manager.createLecturer(name, id, degreename, elevel, salary);
            System.out.println("Lucturer added successfully!");
        }
        catch (LecturrerExistException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to change the Lecturer name or 2 to return to menu");
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer (); 
            }
        }
    }

   private static void addDepartment() {
        try{
            System.out.println("Enter department name: ");
            String name = s.nextLine();
            manager.isExistDepartment(name);
            manager.createDepartment(name);
            System.out.println("Department added successfully!");
        }
        catch(DepartmentExistException e)
        {
            System.out.println(e.getMessage());
            System.out.println("press 1 to change the Department name or 2 to return to menu");
            if (s.nextInt() == 1) {   
              s.nextLine(); 
             addDepartment ();   
            }  
        } 
    }

    private static void addCommittee(){
        try {
            System.out.println("Enter committee name: ");
            String name = s.nextLine();
            manager.isExistCommittee(name);
            System.out.println("Enter chairman name: ");
            String chairName = s.nextLine();
            manager.isNotExistLecturer(chairName);
            Lecturer chair = manager.getLecturerByName(chairName);
            manager.notDoc(chair);
            manager.createCommittee(name, chair);
            System.out.println("Committee added successfully!");
        }
        catch (CommitteeExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
            }  
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();   
            }
        }
        catch (notDoctorException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                addCommittee();
            }
        }
    }
            
    private static void updateChairOfCommittee(){
        try {
            System.out.println("Enter committee name: ");
            String comName = s.nextLine();
            manager.isNotExistCommittee(comName);
            Committee com = manager.getCommitteeByName(comName);
            System.out.println("Enter new chairman name: ");
            String chairName = s.nextLine();
            manager.isNotExistLecturer(chairName);
            Lecturer chair = manager.getLecturerByName(chairName);
            manager.notDoc(chair);
            manager.isLecturrerInCommittee(chair, com);
            manager.isChairAlreadyChairOfCommittee(chair, com);
            manager.updateChairOfCommittee(com, chair);
            System.out.println("Chairman updated successfully!");
        }
        catch (CommitteeNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();
            }
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();  
            }
        }
        catch (notDoctorException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                updateChairOfCommittee();
            }
        }
        catch (LecturrerAlreadyCairException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                updateChairOfCommittee();
            }
        }
        catch (LecturrerInCommitteeException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                updateChairOfCommittee();
            }
        }
    }

    private static void asignLecturerToCommittee()
    {
        try{
            System.out.println("Enter committee name: ");
            String comName = s.nextLine();
            manager.isNotExistCommittee(comName);
            Committee commmittee = manager.getCommitteeByName(comName);
            System.out.println("Enter lecturer name: ");
            String lectName = s.nextLine();
            manager.isNotExistLecturer(lectName);
            Lecturer lect = manager.getLecturerByName(lectName);
            manager.isLecturrerInCommittee(lect, commmittee);
            manager.isChairAlreadyChairOfCommittee(lect, commmittee);
            manager.asignLecturerToCommittee(lect, commmittee);
            System.out.println("Lecturer added to committee successfully!");
        }
        catch (CommitteeNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();  
            }
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer (); 
            }
        }
        catch (LecturrerAlreadyCairException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                asignLecturerToCommittee();
            }
        }
        catch (LecturrerInCommitteeException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                asignLecturerToCommittee();
            }
        }
    }
   
    private static void asignLecturerToDepartment(){
        try {
            System.out.println("Enter lecturer name: ");
            String lectName = s.nextLine();
            manager.isNotExistLecturer(lectName);
            Lecturer lect = manager.getLecturerByName(lectName);
            System.out.println("Enter department name: ");
            String depName = s.nextLine();
            manager.isNotExistDepartment(depName);
            Department dep = manager.getDepartmentByName(depName);
            manager.isLecturerInDepartment(lect, dep);
            manager.asignLecturerToDepartment(lect, dep);
            System.out.println("Lecturer assigned to department successfully!");
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();   
            }
        }
        catch (DepartmentNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Department to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addDepartment ();    
            }
        }
        catch (LecturrerInDepartmentException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to asign a diffrent lecturer to the department or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                asignLecturerToDepartment();
            }
        } 
    }
   
    private static void removeLecturerFromCommittee() {
        try {
            System.out.println("Enter committee name: ");
            String comName = s.nextLine();
            manager.isNotExistCommittee(comName);
            Committee com = manager.getCommitteeByName(comName);
            System.out.println("Enter lecturer name: ");
            String lectName = s.nextLine();
            manager.isNotExistLecturer(lectName);
            Lecturer lect = manager.getLecturerByName(lectName);
            manager.isLecturrerNotInCommittee(lect, com);
            manager.removeLecturerFromCommittee(lect, com);
            System.out.println("Lecturer removed from committee successfully!");
        }
        catch (CommitteeNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee (); 
            }
        }
        catch (LecturerNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer (); 
            }
        }
        catch (LecturrerNotInCommitteeException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                removeLecturerFromCommittee();
            }
        }
    }
   
    private static void showAverageSalaryOfAllLecturers(){
        System.out.println(manager.calcAvgSalary());
    }

    private static void showAverageSalaryOfLecturersInDepartment(){
        try {
            System.out.println("Enter department name: ");
            String depName = s.nextLine();
            manager.isNotExistDepartment(depName);
            Department dep = manager.getDepartmentByName(depName);
            System.out.println(manager.calcAvgDep(dep));
        }
        catch (DepartmentNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Department to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addDepartment ();  
            }
        }
    }

    private static void CompareLecturersbyPapers(){
            try{
            System.out.println("Enter first Doctor / Professor name: ");
            String firstname = s.nextLine();
            manager.isNotExistLecturer(firstname);
            manager.notDoc(manager.getLecturerByName(firstname));
            System.out.println("Enter first Doctor / Professor name: ");
            String secondname = s.nextLine();
            manager.isNotExistLecturer(secondname);
            manager.notDoc(manager.getLecturerByName(secondname));
            Doctor firstLecturer = (Doctor) manager.getLecturerByName(firstname);
            Doctor secondLecturer = (Doctor) manager.getLecturerByName(secondname);
            System.out.println(manager.CompareDoctorsbyPapers(firstLecturer, secondLecturer));

            
        }
        catch(LecturerNotExistException e)
        {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add lecturrer to do system or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addLecturer ();  
            }
        }
        catch (notDoctorException e){
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry or 2 to return to menu");  
            if (s.nextInt() == 1) {
                s.nextLine();
                CompareLecturersbyPapers();
            }
        }       
    }

    private static void compareCommittee(){
        try{
        System.out.println("Enter committee name: ");
        String comName1 = s.nextLine();
        manager.isNotExistCommittee(comName1);
        Committee com1 = manager.getCommitteeByName(comName1);
        System.out.println("Enter another committee name: ");
        String comName2 = s.nextLine();
        manager.isNotExistCommittee(comName2);
        Committee com2 = manager.getCommitteeByName(comName2);
        System.out.println("To compare based on member count, press 1 and to compare by paper count, press 2: ");
        int choice = s.nextInt();
        s.nextLine();
        if (choice == 1) {
            System.out.println(manager.compareByMembers(com1, com2));
        } else if (choice == 2) {
            System.out.println(manager.compareByPapers(com1, com2));
        } else {
            System.out.println("Invalid choice");
        }
        }
        
        catch(CommitteeNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();   
            }
        }
    }

    private static void duplicateCommittee(){
        try{
        System.out.println("Enter the name of the committee you want to duplicate: ");
        String committee = s.nextLine();
        manager.isNotExistCommittee(committee);
        manager.isExistCommittee(committee + "-new");
        manager.duplicateCommittee(manager.getCommitteeByName(committee));
        System.out.println("Duplicate committee " + committee + "-new" + " has been created succssfully");
        }
        catch(CommitteeNotExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to add Committee or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                addCommittee ();   
            }
        }
        catch(CommitteeExistException e) {
            System.out.println(e.getMessage());
            System.out.println("press 1 to retry with a diffrent one or 2 to return to menu");;
            if (s.nextInt() == 1) {
                s.nextLine(); 
                duplicateCommittee();  
            }
        }
        catch (CloneNotSupportedException e) {
            System.out.println("Cannot clone committee, returning to menu");
        }
    }

    private static void showAllLecturersInfo(){
        System.out.println("--------------------------------------------------");
        System.out.println("Presenting all lecturers info: ");
        System.out.println(manager.LecturersInfo());
    }

    private static void showAllCommitteesInfo(){
        System.out.println("--------------------------------------------------");
        System.out.println("Presenting all committies info: ");
        System.out.println(manager.committeesInfo());

    }

    

}
