import java.util.Scanner;

class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the name of the student:");
	    String name = scanner.next();
        System.out.println("Enter total number of subjects:");
        int subjects = scanner.nextInt();
        int[] markArr = new int[subjects];
        int totalMarks = 0;
        for (int i = 0; i < subjects; i++) {
            System.out.println("Enter the name of the subject:");
            String subj = scanner.next();
            System.out.println("Enter the marks for subject (out of 100) " + subj + ":");
            markArr[i] = scanner.nextInt();
            totalMarks += markArr[i];
        }

        double averagePercentage = (double) totalMarks / subjects;
        char grade;

        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80 && averagePercentage < 90) {
            grade = 'B';
        } else if (averagePercentage >= 70 && averagePercentage < 80) {
            grade = 'C';
        } else if (averagePercentage >= 60 && averagePercentage < 70) {
            grade = 'D';
        } else if (averagePercentage >= 50 && averagePercentage < 60) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
