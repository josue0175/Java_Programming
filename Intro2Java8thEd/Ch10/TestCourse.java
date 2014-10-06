public class TestCourse {
    
    public static void main(String[] args) {
        Course course1 = new Course("DataStructures");
        Course course2 = new Course("Database Systems");

        course1.addStudent("Peter Jones");
        course1.addStudent("Brian Smith");
        course1.addStudent("Steve Smith");

        course2.addStudent("Peter Jones");
        course2.addStudent("Steve Smith");

        System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
        String[] students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++)
            System.out.print(students[i] +  ", ");
        System.out.println("Number of students in course2: " + course2.getNumberOfStudents());
        System.out.println("Number of All Students: " + course2.getNumberOfAllStudents());

    }
}
