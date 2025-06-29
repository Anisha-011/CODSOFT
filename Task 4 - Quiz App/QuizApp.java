package Internship;

import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] questions = {
            "Which keyword is used to inherit a class in Java?\nA. this\nB. super\nC. extends\nD. implements",
            "Which company developed Java?\nA. Microsoft\nB. Oracle\nC. Sun Microsystems\nD. Apple",
            "Which method is the entry point in a Java program?\nA. start()\nB. run()\nC. main()\nD. init()"
        };
        char[] answers = {'C', 'C', 'C'};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQ" + (i + 1) + ": " + questions[i]);
            System.out.print("Your answer: ");
            char userAnswer = sc.next().toUpperCase().charAt(0);
            if (userAnswer == answers[i]) {
                score++;
                System.out.println("✔ Correct!");
            } else {
                System.out.println("❌ Wrong! Correct answer: " + answers[i]);
            }
        }

        System.out.println("\nYour final score: " + score + "/" + questions.length);
        sc.close();
    }
}

