package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        String message = "IDs of two Job objects are distinct";
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId(), message);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job1.getName() instanceof String, "Job Name is instance of String Class");
        assertTrue(job1.getEmployer() instanceof Employer, "Job Employer is instance of Employer Class");
        assertTrue(job1.getLocation() instanceof Location, "Job Location is instance of Location Class");
        assertTrue(job1.getPositionType() instanceof PositionType, "Job PositionType is instance of PositionType Class");
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency, "Job CoreCompentency is instance of CoreCompentency Class");

        assertEquals(job1.getName(), "Product tester", "Job Name value initialized correctly");
        assertEquals(job1.getEmployer().toString(), "ACME", "Job Employer value initialized correctly");
        assertEquals(job1.getLocation().toString(), "Desert", "Job Location value initialized correctly");
        assertEquals(job1.getPositionType().toString(), "Quality control", "Job PositionType value initialized correctly");
        assertEquals(job1.getCoreCompetency().toString(), "Persistence", "Job CoreCompetency value initialized correctly");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2), "Two Job objects with identical fields are NOT equal if id values differ");
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        boolean conditionOne = job1.toString().startsWith(System.lineSeparator());
        boolean conditionTwo = job1.toString().endsWith(System.lineSeparator());

        String message = "toString method begins and ends with new line";

        assertTrue(conditionOne && conditionTwo, message);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String expectedOuput =
            System.lineSeparator() +
            "ID: " + job1.getId() + System.lineSeparator() +
            "Name: " + job1.getName() + System.lineSeparator() +
            "Employer: " + job1.getEmployer() + System.lineSeparator() +
            "Location: " + job1.getLocation() + System.lineSeparator() +
            "Position Type: " + job1.getPositionType() + System.lineSeparator() +
            "Core Competency: " + job1.getCoreCompetency() +
            System.lineSeparator();

        String message = "toString method returns correct labels and values";

        assertEquals(job1.toString(), expectedOuput, message);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("Product tester",
                new Employer(""),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String notAvailable = "Data not available";

        String expectedOuput =
                System.lineSeparator() +
                        "ID: " + job1.getId() + System.lineSeparator() +
                        "Name: " + job1.getName() + System.lineSeparator() +
                        "Employer: " + notAvailable + System.lineSeparator() +
                        "Location: " + job1.getLocation() + System.lineSeparator() +
                        "Position Type: " + job1.getPositionType() + System.lineSeparator() +
                        "Core Competency: " + job1.getCoreCompetency() +
                        System.lineSeparator();

        String message = "Correctly handles missing value for field";

        assertEquals(job1.toString(), expectedOuput, message);
    }

}
