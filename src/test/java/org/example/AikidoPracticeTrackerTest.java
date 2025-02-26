package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AikidoPracticeTrackerTest {
    private AikidoPracticeTracker aikidoPracticeTracker;

    @BeforeEach
    void initialize() {
        aikidoPracticeTracker = new AikidoPracticeTracker();
    }

    @Test
    void addSession() {
        aikidoPracticeTracker.addSession("2024-01-01", 60);
        assertEquals(60, aikidoPracticeTracker.getTotalPracticeTime());
    }

    @Test
    void getTotalPracticeTime() {
        aikidoPracticeTracker.addSession("2024-01-01", 60);
        assertEquals(60, aikidoPracticeTracker.getTotalPracticeTime());
    }

    @Test
    void isEligibleForGraduationByTimeTrue() {
        aikidoPracticeTracker.addSession("2024-01-01", 100);
        assertTrue(aikidoPracticeTracker.isEligibleForGraduation());
    }

    @Test
    void isEligibleForGraduationBySessionsTrue() {
        for (int i = 0; i < 100; i ++) {
            aikidoPracticeTracker.addSession("2025-01-01", 100);
        }
        assertTrue(aikidoPracticeTracker.isEligibleForGraduation());
    }

    @Test
    void isEligibleForGraduationFalse() {
        aikidoPracticeTracker.addSession("2025-01-01", 60);
        assertFalse(aikidoPracticeTracker.isEligibleForGraduation());
    }

    @Test
    void isEligibleForGraduationByDateNull() {
        assertFalse(aikidoPracticeTracker.isEligibleForGraduation());
    }
}