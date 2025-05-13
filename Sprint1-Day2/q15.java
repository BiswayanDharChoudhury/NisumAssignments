// Class to store college-related details
class Institution {
    private String name;
    private String city;

    public Institution(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void showInstitutionDetails() {
        System.out.println("Institution: " + name);
        System.out.println("Located in: " + city);
    }
}

// Class to handle student and their secured marks
class Learner {
    private String studentName;
    private int id;
    private int mark1, mark2, mark3;

    public Learner(String studentName, int id, int mark1, int mark2, int mark3) {
        this.studentName = studentName;
        this.id = id;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    // This method prints basic student info and derived mark details
    public void showLearnerDetails() {
        System.out.println("Name of Student: " + studentName);
        System.out.println("Student ID: " + id);
        System.out.println("Total Score: " + computeTotal());
        System.out.println("Average Score: " + computeAverage());
    }

    // Private methods to encapsulate individual subject marks
    private int getMark1() { return mark1; }
    private int getMark2() { return mark2; }
    private int getMark3() { return mark3; }

    // Only computed results are exposed outside
    public int computeTotal() {
        return mark1 + mark2 + mark3;
    }

    public double computeAverage() {
        return computeTotal() / 3.0;
    }
}

// Driver class to demonstrate the program
public class q15{
    public static void main(String[] args) {
        Institution inst = new Institution("InnovateTech Institute", "Bhubaneswar");

        Learner learner = new Learner("Biswayan", 2025101, 82, 89, 91);

        System.out.println("=== Institution Information ===");
        inst.showInstitutionDetails();

        System.out.println("\n=== Student Performance ===");
        learner.showLearnerDetails();
    }
}
