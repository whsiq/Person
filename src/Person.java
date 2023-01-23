import java.util.Calendar;

public class Person {
    
    Calendar calendar = Calendar.getInstance();
    
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }
    
    public String fullName() {
        return firstName + " " + lastName;
    }
    
    public String formalName() {
        return title + " " + fullName();
    }
    
    public String getAge() {
        return String.valueOf(calendar.get(Calendar.YEAR) - YOB);
    }
    
    public String getAge(int year) {
        return String.valueOf(calendar.get(Calendar.YEAR) - year);
    }
    
    public String toCSVDataRecord() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }
}
