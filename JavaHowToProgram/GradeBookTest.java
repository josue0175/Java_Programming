import java.util.Scanner;

public class GradeBookTest 
{
    public static void main(String[] args)
    {
        GradeBook myGradeBook1 = new GradeBook(" CS101 Intro to Java Programming" );
        GradeBook myGradeBook2 = new GradeBook(" CS102 Data Strucutres in Java" );
        
        System.out.printf("Initial Course name is: %s\n\n", myGradeBook1.getCourseName() );
        System.out.printf("Initial Course name is: %s\n\n", myGradeBook2.getCourseName() );

    }
}
    
