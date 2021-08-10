import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private String email;
    private String company = "thecompany.com";
    private int mailboxCapacity = 500;
    private int defaultLength = 10;

    //Constructor to get the data to make the email:
    public Email(String firstName, String lastName) {
        //Get the first and last name:
        this.firstName = firstName;
        this.lastName = lastName;
        //Ask for department:
        this.department = setDepartment();
        System.out.println("Department: " + department);
        //Return a random password:
        this.password= setPassword(defaultLength);
        System.out.println("Your password is: " + password);
        //Combine elements to generate email:
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + company;
    }

    //Ask for department: return department
    private String setDepartment() {
        System.out.println("Hi " + firstName + " " + lastName + "! Choose you department code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none.\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }
        //Generate random password
        private String setPassword(int length) {
            String randomPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@*$&";
            char[] password = new char[length];
            for (int i=0; i<length; i++) {
                //We create a random number within the scope of the String randomPassword
                int random= (int) (Math.random() * randomPassword.length());
                //Then we pass it into our array one at a time
                password[i]= randomPassword.charAt(random);
            }
            return new String(password);

        }

    //Set and get mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity=capacity;
    }
    public int getMailboxCapacity() {return mailboxCapacity;}

    //Set and get alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail =altEmail;
    }
    public String getAlternateEmail() {
        return alternateEmail;}

    //Set and get a NEW password
    public void changePassword(String password){
        this.password=password;
    }
    public String getPassword() {
        return password;
    }
    public String showInfo() {
        return "Name: " + firstName + " " + lastName + ". \n" +
                "Company Email: " + email + ". \n" +
                "Mailbox capacity: " + mailboxCapacity;
    }



}
