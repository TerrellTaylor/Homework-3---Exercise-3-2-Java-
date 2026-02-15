import java.text.NumberFormat;
import java.util.Scanner;

public class TestScoreApp {

    public static void main(String[] args) {
        // display operational messages
        System.out.println("Enter test scores that range from 0 to 100.");
        System.out.println("To end the program, enter 999.");
        System.out.println();  // print a blank line

        // initialize variables and create a Scanner object
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        int testScoreMin = 100;
        int testScoreMax = 0;
        int min = 0;
        int max = 0;
        Scanner sc = new Scanner(System.in);

        // get a series of test scores from the user
        while (testScore != 999) {
            // get the input from the user
            System.out.print("Enter score: ");
            String input = sc.nextLine();
            testScore = Integer.parseInt(input);

            // accumulate score count and score total
            if (testScore <= 100) {
                scoreCount++;
                scoreTotal += testScore;
                min = Math.min(testScoreMin, testScoreMax);
                max = Math.max(testScoreMin, testScoreMax);

            }
            else if (testScore != 999) {
                System.out.println("Invalid entry; not counted");
            }

            // record minimum and maximum test scores
            if (testScore <= 100 && testScore < testScoreMin) 
            {
                testScoreMin = testScore;
            }
            if (testScore <= 100 && testScore > testScoreMax)
            {
                testScoreMax = testScore;
            }
        }
        // display the score count, score total, and average score
        double averageScore = 0.0;
        if (scoreCount > 0) {
            averageScore = (double) scoreTotal / scoreCount;
        }
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMaximumFractionDigits(1);
        String averageScoreString = number.format(averageScore);
        String message = "\n"
                + "Score count:   " + scoreCount + "\n"
                + "Score total:   " + scoreTotal + "\n"
                + "Average score: " + averageScoreString + "\n"
                + "Minimum score: " + min + "\n"
                + "Maximum score: " + max + "\n";
        System.out.println(message);
    }
}