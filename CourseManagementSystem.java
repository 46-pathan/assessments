//importing necessary libaries
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class to creat object of course
class Course{
    //course attributes
    private int id;
    private String name;
    private int fees;
    private int duration;
    private String detail;

    //parametraised construtor for course object initialzing while creating
    public Course(int id, String name,int fees, int duration, String detail){
        this.id=id;
        this.name=name;
        this.fees=fees;
        this.duration=duration;
        this.detail=detail;
    }

    //getter for id
    public int getId() {
        return id;
    }
    //setter for name
    public void setName(String name) {
        this.name = name;
    }
    //setter for fees
    public void setFees(int fees) {
        this.fees = fees;
    }
    //setter for duration
    public void setDuration(int duration) {
        this.duration = duration;
    }
    //setter for detail
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    //override toString for display data as we want
    @Override
    public String toString() {
        return "Course ID:" + id + "\nCourse Name=" + name + "\nCourse Fees=" + fees + "\nCourse Duration=" + duration + "\nCourse Detail="
                + detail;
    }
     
}

//main class
public class CourseManagementSystem{

    //list for storing course object
    static List<Course> courses_list=new ArrayList<>();

    //scanner for taking user input from keyboard
    static Scanner sc=new Scanner(System.in);

    //main method
    public static void main(String[] args) {
        //loop for repetaion for asking user till no need
        while(true){
            //menu for user action
            System.out.println("\nCourse Management System:");
            System.out.println("1.Add Course");
            System.out.println("2.View Course");
            System.out.println("3.Search Course");
            System.out.println("4.Edit Course");
            System.out.println("5.Delete Course");
            System.out.println("6.Exit");
            System.out.println("Select number for your action:");

            //take user input
            int num=sc.nextInt();
            sc.nextLine();//nextline
            
            //perform action as user input
            switch(num){
                case 1:
                    addCourse();
                    break;
                case 2:
                    viewCourse();
                    break;
                case 3:
                    searchCourse();
                    break;
                case 4:
                    editCourse();
                    break;
                case 5:
                    deleteCourse();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Not valid input\n");
            }
        }
    }

    //add new course and take course details from user
    static void addCourse(){
        System.out.println("Enter course id:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter course name:");
        String name=sc.nextLine();
        System.out.println("Enter course fees:");
        int fees=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter course duration:");
        int duration=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter course detail:");
        String detail=sc.nextLine();
        
        //create and initialize new course object with given info
        courses_list.add(new Course(id, name, fees, duration, detail));
        System.out.println("New course added\n");
    }

    //list all courses
    static void viewCourse(){
        if(courses_list.isEmpty()){
            System.out.println("Empty\n");
        }else{
            //for-each loop for displaying all course object in list
            for(Course c:courses_list){
                System.out.println(c);
            }
        }
    }

    //search course with id
    static void searchCourse(){
        System.out.println("Enter course id:");
        int id=sc.nextInt();
        sc.nextLine();
        Course c=findCourse(id);

        //display course if it is there
        if(c!=null){
            System.out.println(c);
        }else{
            System.out.println("course not found\n");
        }
    }

    //change course data using id
    static void editCourse(){
        System.out.println("Enter course id:");
        int id=sc.nextInt();
        sc.nextLine();
        Course c=findCourse(id);
        
        //if exists then ask for new data from user
        if(c!=null){
            System.out.println("Enter new course name:");
            String new_name=sc.nextLine();
            System.out.println("Enter new course fees:");
            int new_fees=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter new course duration:");
            int new_duration=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter new course detail:");
            String new_detail=sc.nextLine();

            //update new data using setter method of course class in existed course
            c.setName(new_name);
            c.setFees(new_fees);
            c.setDuration(new_duration);
            c.setDetail(new_detail);

            System.out.println("Course updated\n");
        }else{
            System.out.println("Not found\n");
        }
    }

    //delete course from list using id
    static void deleteCourse(){
        System.out.println("Enter course id:");
        int id=sc.nextInt();
        sc.nextLine();
        Course c=findCourse(id);
        //if course exists
        if(c!=null){
            courses_list.remove(c);
            System.out.println("Course deleted\n");
        }else{
            System.out.println("Not found\n");
        }
    }

    //find course with id and not repeating code for seach,edit,delete
    static Course findCourse(int id){
        for(Course c:courses_list){
            //get course with id match
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }

}