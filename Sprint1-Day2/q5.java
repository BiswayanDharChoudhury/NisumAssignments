import java.util.*;

class UserDetails {
    public String name;
    public String id;
    public String email;

    private String password;
    private String creditCard;
    private double creditCardBalance;

    public UserDetails(String name, String id, String email, String password, String creditCard, double creditCardBalance) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.creditCardBalance = creditCardBalance;
    }

    public String getCreditCardMasked() {
        return "XXXX-XXXX-XXXX-" + creditCard.substring(creditCard.length() - 4);
    }

    public double getCreditCardBalance() {
        return creditCardBalance;
    }

    public void setCreditCardBalance(double amount) {
        this.creditCardBalance = amount;
    }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void displayPublicInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
    }
}

class Codechef {
    public static void main (String[] args){
        // Creating a user
        UserDetails user = new UserDetails(
            "Biswayan Dhar Choudhury",
            "U12345",
            "biswayan@example.com",
            "securePass123",
            "1234567812345678",
            20000.50
        );

        // Displaying public info
        user.displayPublicInfo();

        // Accessing private data securely
        System.out.println("Masked Credit Card: " + user.getCreditCardMasked());
        System.out.println("Credit Card Balance: " + user.getCreditCardBalance());

        // Verifying password
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password to verify: ");
        String inputPass = sc.nextLine();

        if(user.verifyPassword(inputPass)) {
            System.out.println("Password matched.");
        } else {
            System.out.println("Incorrect password.");
        }
    }
}

