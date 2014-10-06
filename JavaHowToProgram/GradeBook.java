public class GradeBook
{
    private String courseName;
    
    public GradeBook( String name )//Constructor has same name "GradeBook" as class
    {
        courseName = name;
    }

    public void setCourseName( String name)
    {
        courseName = name;
    }
    public String getCourseName()
    {
        return courseName;
    }
    public void displayMessage()
    {
        System.out.printf( "Welcome to the grade book for \n%s!\n", getCourseName());
    }
}


