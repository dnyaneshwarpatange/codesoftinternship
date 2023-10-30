import java.util.Scanner;

public class StudentC {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int numSubjects = 5;

    int[] marks = new int[numSubjects];

    int totalMarks = 0;
    double averagePercentage = 0.0;

    char grade = 'F';

    System.out.println("Enter the marks obtained (out of 100) in each subject:");
    for (int i = 0; i < numSubjects; i++) {
      System.out.print("Subject " + (i + 1) + ": ");
      marks[i] = scanner.nextInt();
    }

    for (int mark : marks) {
      totalMarks += mark;
    }

    averagePercentage = (double) totalMarks / numSubjects;

    if (averagePercentage >= 95) {
      grade = 'A';
    } else if (averagePercentage >= 85) {
      grade = 'B';
    } else if (averagePercentage >= 75) {
      grade = 'C';
    } else if (averagePercentage >= 55) {
      grade = 'D';
    } else {
      grade = 'F';
    }

    System.out.println("results are:");
    System.out.println("Total Marks: " + totalMarks);
    System.out.println("Average Percentage: " + averagePercentage + "%");
    System.out.println("Grade: " + grade);

    scanner.close();
  }
}