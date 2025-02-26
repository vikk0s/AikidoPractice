package org.example;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class AikidoPracticeTracker {
    private List<PracticeSession> sessions;
    private LocalDate firstSessionDate;

    public AikidoPracticeTracker() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(String date, int duration) {
        LocalDate sessionDate = LocalDate.parse(date);

        PracticeSession newSession = new PracticeSession(sessionDate, duration);

        sessions.add(newSession);
        if (firstSessionDate == null || sessionDate.isBefore(firstSessionDate)) {
            firstSessionDate = sessionDate;
        }
    }

    public int getTotalPracticeTime() {
        int totalPracticeTime = 0;
        for (PracticeSession session : sessions) {
            totalPracticeTime += session.getDuration();
        }
        return totalPracticeTime;
    }

    public boolean isEligibleForGraduation() {
        if (sessions.size() >= 100) {
            return true;
        }

        if (firstSessionDate == null) {
            return false;
        }

        LocalDate now = LocalDate.now();
        return firstSessionDate.plusMonths(6).isBefore(now);
    }

    public static void main(String[] args) {
        AikidoPracticeTracker tracker = new AikidoPracticeTracker();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Aikido Practice Tracker, choose an option:");
            System.out.println("1. Add practice session");
            System.out.println("2. Get total practice time");
            System.out.println("3. Check graduation eligibility");
            System.out.println("4. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter the date of the practice session (yyyy-MM-dd): ");
                    String date = scanner.nextLine();
                    System.out.println("Enter the duration of the practice session in minutes: ");
                    int duration = scanner.nextInt();
                    tracker.addSession(date, duration);
                    break;
                case 2:
                    System.out.println("Total practice time: " + tracker.getTotalPracticeTime() + " minutes");
                    break;
                case 3:
                    if (tracker.isEligibleForGraduation()) {
                        System.out.println("You are eligible for graduation!");
                    } else {
                        System.out.println("You are not eligible for graduation yet.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
