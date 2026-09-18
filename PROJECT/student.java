                                                                        // Student Manangement System
import java.util.Scanner;
class person
{
    
    private String name ; // read and write
    private int age; // read only

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    person(String name, int age)
    {
        //L.I
        setName(name);
        this.age = age;
    }
}

class student extends person
{
    static Scanner sc = new Scanner(System.in);
    private int id ; // read
    private long contact; // read and write
    private address addRef ;
    private static student[] students = new student[10];
    
    public void setContact(long contact)
    {
        this.contact = contact;
    }

    public long getContact()
    {
        return contact;
    }

    public int getId()
    {
        return id;
    }

    student(int id, long contact, String name, int age,String city, String state)
    {
        super(name, age);
        this.id = id;
        this.contact = contact;

        address add = new address(city, state); // has a relation --> composition
        this.addRef = add;
    }

    public static void addStudent(student s)
    {
        for(int i = 0; i<students.length; i++)
        {
            if(students[i] == null)
            {
                students[i] = s;
                System.out.println("student added successfully..");
                return;
            }
        }
        System.out.println("student list is full..");
    }

    public static void removeStudent(int id)
    {
        for(int i = 0; i<students.length; i++)
        {
            if(students[i] != null){
                if(students[i].id == id)
            {
                students[i] = null;
                System.out.println("student removed...");
                return ;
            }
        }
    }
        System.out.println("student is not present...");
    }

    public static void searchStudent(int id)
    {
        for(int i = 0; i<students.length; i++)
        {
            if(students[i] != null)
            {
                if(students[i].id == id)
                {
                    System.out.println("student found..");
                    return ;
                }
            }
        }
       
        System.out.println("student not found..");
        

    }

    public static void updateDetails(int id)
    {
        student s = null;
        for(int i = 0; i<students.length; i++)
        {
            if(students[i] != null)
            {
                if(students[i].id == id)
                s = students[i];
            }
        }
        System.out.println("press 1 to update name");
        System.out.println("press 2 to update contact");
        System.out.println("press 3 to update state");
        System.out.println("press 4 to update city");

        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice)
        {
            case 1 :
                System.out.println("enter the name");
                String Name = sc.nextLine();
                s.setName(Name);
                System.out.println("name updated");
                break;
            
            case 2 :
                System.out.println("enter the contact : ");
                long contact_no = sc.nextLong();
                s.setContact(contact_no);
                System.out.println("contact updated..");
                break;

            case 3 :
                System.out.println("enter the state : ");
                String State = sc.nextLine();
                s.addRef.setState(State);
                System.out.println("State updated..");
                break;
            
            case 4 :
                System.out.println("enter the city : ");
                String City = sc.nextLine();
                s.addRef.setCity(City);
                System.out.println("city updated..");
                break;
            
            default : 
                System.out.println("invalid option selected");
        }

    }

    public static void deleteStudent()
    {
        for(int i = 0; i<students.length; i++){
        if(students[i] != null){
        students[i] = null;
       }
    }
    System.out.println("all the students record deleted successfully");
    }
    public static void displayStudents()
    {
        for(int i = 0; i<students.length; i++)
        {
            if(students[i] != null){
            students[i].details();
            }
        }
    }

    public void details()
    {
        System.out.println("student name : " + getName());
        System.out.println("student age : " + getAge());
        System.out.println("student id : " + id);
        System.out.println("student contact : " + contact);
        System.out.println("student address , state : " +addRef.getState() + " city: "+ addRef.getCity());
        System.out.println("----------------------------------------------------------------------");
        
    }
}

class address
{
    private String city ; // read and write
    private String state ; // read and write

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    address(String city, String state)
    {
        this.city = city;
        this.state = state;
    }
}

class main
{
    public static void main(String[]args)
    {
        // create an object for student

        student s1 = new student(100, 987654321,"subhasree",22,"chennai", "TamilNadu");
        student s2 = new student(101, 123456789,"charumathi", 23, "housing board", "TamilNadu");
        student s3 = new student(102, 543216789,"balaji",21,"whitefiled","Karnataka");
        student s4 = new student(103, 678954321,"Ghanath", 24,"kadapa","Andhrapradesh");

        /* to test :
        
        // add all the students
        student.addStudent(s1);
        student.addStudent(s2);
        student.addStudent(s3);
        student.addStudent(s4);

        //remove one student
        student.removeStudent(s4.getId());

        //search student
        student.searchStudent(s1.getId());
        
        //search student with incorrect id
        student.searchStudent(500);

        //update details
        student.updateDetails(s2.getId());

        //display students
        student.displayStudents();*/
    }
}