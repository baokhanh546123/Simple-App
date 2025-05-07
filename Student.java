package LTGD;
import java.util.Date;

public class Student {
     String mssv;   
     String lastName;
     String firstName;
     Date birthDate; 

    
    public Student(String mssv, String lastName, String firstName, Date birthDate) {
        this.mssv = mssv;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    
    public String getMssv() {
        return mssv;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    
    @Override
    public String toString() {
        return "MSSV: " + mssv + ", Name: " + getFullName() + ", Date of Birth: " + birthDate;
    }
}
