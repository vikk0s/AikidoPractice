package org.example;

import java.time.LocalDate;

public class PracticeSession {
    private LocalDate date;
    private int duration;

    public PracticeSession(LocalDate date, int duration) {
        this.date = date;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}
