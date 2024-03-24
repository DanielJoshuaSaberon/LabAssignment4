package LabAssignment4;
import java.util.*;

public class LogIn {
    public static void main (String [] args) {
        String originalPass = "password";
        int maxAttempts = 3;
        int attempts = 0;
        //
        Scanner input = new Scanner(System.in);
        //
        System.out.print("Hi welcome to this app! please enter your password!! ");
        //
        while (attempts < maxAttempts) {
            System.out.print("\nEnter Password: ");
            String newPassword = input.next();
            //
            if (newPassword.equals(originalPass)) {
                System.out.println("Password correct. Access granted.");
                break;
            }
            //
            else {
                //
                try{
                    throw new InvalidException("Invalid password");
                }
                //
                catch (InvalidException e){
                    attempts++;
                    System.out.println(e.getMessage() + " Attempts left: "  + (maxAttempts - attempts));
                }
            }
        }
        //
        if (attempts == maxAttempts) {
            try {
                throw new AttemptsException("Maximum attempts exceeded. ");

            }
            //
            catch (AttemptsException e) {
                System.out.println("\n"+e.getMessage());
            }
            //
            System.out.print("\nWould you like to try again? (yes/no): ");
            String choice = input.next();
            System.out.println();
            //
            if (choice.equalsIgnoreCase("yes")) {
                main(args);
            }
            else {
                System.out.println("Exit App");
            }
        }
    }
}
