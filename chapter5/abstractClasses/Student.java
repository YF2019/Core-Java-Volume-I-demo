package abstractClasses;

public class Student extends Person{
    private String major;

    /**
     * @param name the student's name
     * @param major the student's major
     */
    public Student(String name, String major)
    {
        // pass n to superclass constructor
        super(name);
        this.major = major;
    }

    public String getDescription()
    {
        return String.format("a student majoring in %s", major);
        //return "a student majoring in " + major;
    }

}