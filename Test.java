import java.util.*;

// A class that handles the operations on the courses and students in a database
class DatabaseManager {
    // A list of courses in the database
    private List<Course> courses;
    // A list of students in the database
    private List<Student> students;

    // A constructor that initializes empty lists of courses and students
    public DatabaseManager() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    // A method that adds a course to the database
    public void addCourse(Course c) {
        courses.add(c);
    }

    // A method that adds a student to the database
    public void addStudent(Student s) {
        students.add(s);
    }

    // A method that returns a course with the given code, or null if not found
    public Course getCourse(String code) {
        for (Course c : courses) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    // A method that returns a student with the given id, or null if not found
    public Student getStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // A method that displays all the courses in the database
    public void displayCourses() {
        System.out.println("Courses in the database:");
        for (Course c : courses) {
            System.out.println(c);
        }
    }
}

// A class that represents a course with attributes such as code, name, description, capacity, and schedule
class Course {
    // The code of the course, such as "CS101"
    private String code;
    // The name of the course, such as "Introduction to Computer Science"
    private String name;
    // The description of the course, such as "A basic course on computer science concepts and programming"
    private String description;
    // The maximum number of students that can register for the course
    private int capacity;
    // The schedule of the course, such as "Mon 10:00-12:00"
    private String schedule;

    // A constructor that assigns values to the attributes of the course
    public Course(String code, String name, String description, int capacity, String schedule) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    // A getter method for the code attribute
    public String getCode() {
        return code;
    }

    // A setter method for the code attribute
    public void setCode(String code) {
        this.code = code;
    }

    // A getter method for the name attribute
    public String getName() {
        return name;
    }

    // A setter method for the name attribute
    public void setName(String name) {
        this.name = name;
    }

    // A getter method for the description attribute
    public String getDescription() {
        return description;
    }

    // A setter method for the description attribute
    public void setDescription(String description) {
        this.description = description;
    }

    // A getter method for the capacity attribute
    public int getCapacity() {
        return capacity;
    }

    // A setter method for the capacity attribute
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

     // A getter method for the schedule attribute
     public String getSchedule() {
         return schedule;
     }
 
     // A setter method for the schedule attribute
     public void setSchedule(String schedule) {
         this.schedule = schedule;
     }

     // A method that returns a string representation of the course
     public String toString() {
         return "Course Code: " + code + "\n" +
                "Course Name: " + name + "\n" +
                "Course Description: " + description + "\n" +
                "Course Capacity: " + capacity + "\n" +
                "Course Schedule: " + schedule + "\n";
     }
}

// A class that represents a student with attributes such as id, name, and courses
class Student {
     // The id of the student, such as 1001
     private int id;
     // The name of the student, such as "Alice"
     private String name;
     // The list of courses that the student is registered for
     private List<Course> courses;

     // A constructor that assigns values to the id and name attributes, and initializes an empty list of courses
     public Student(int id, String name) {
         this.id = id;
         this.name = name;
         courses = new ArrayList<>();
     }

     // A getter method for the id attribute
     public int getId() {
         return id;
     }

     // A setter method for the id attribute
     public void setId(int id) {
         this.id = id;
     }

     // A getter method for the name attribute
     public String getName() {
         return name;
     }

     // A setter method for the name attribute
     public void setName(String name) {
         this.name = name;
     }

     // A getter method for the courses attribute
     public List<Course> getCourses() {
         return courses;
     }

     // A setter method for the courses attribute
     public void setCourses(List<Course> courses) {
         this.courses = courses;
     }

     // A method that registers a course for the student, and returns true if successful, or false if the course is full or already registered
     public boolean registerCourse(Course c) {
         if (courses.contains(c)) {
             return false; // The student is already registered for the course
         }
         if (c.getCapacity() > 0) {
             courses.add(c); // Add the course to the student's list of courses
             c.setCapacity(c.getCapacity() - 1); // Decrease the capacity of the course by 1
             return true; // The registration is successful
         }
         return false; // The course is full
     }

     // A method that drops a course for the student, and returns true if successful, or false if the student is not registered for the course
     public boolean dropCourse(Course c) {
         if (courses.contains(c)) {
             courses.remove(c); // Remove the course from the student's list of courses
             c.setCapacity(c.getCapacity() + 1); // Increase the capacity of the course by 1
             return true; // The course drop is successful
         }
         return false; // The student is not registered for the course
     }
}

public class Test {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Scanner scanner = new Scanner(System.in);

        Course c1 = new Course("CS101", "Introduction to Computer Science", "A basic course on computer science concepts and programming", 50, "Mon 10:00-12:00");
        Course c2 = new Course("CS102", "Data Structures and Algorithms", "A course on fundamental data structures and algorithms for problem solving", 40, "Tue 14:00-16:00");
        Course c3 = new Course("CS103", "Object-Oriented Programming", "A course on object-oriented programming principles and design patterns", 30, "Wed 10:00-12:00");
    }
};

