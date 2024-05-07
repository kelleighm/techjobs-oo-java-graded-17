package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //Test for name
        assertTrue(job.getName() instanceof String);
        assertEquals("Product tester", job.getName());

        //Test for employer
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        //Test for location
        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        //Test for position type
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        //Test for core competency
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //Testing that it returns 'false' - all fields are same EXCEPT for ID. Two jobs are equal if same ID
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        String jobString = job.toString();

        String expectedString =
                System.lineSeparator() +
                        "ID: " + job.getId() + System.lineSeparator() +
                        "Name: " + (job.getName() != null ? job.getName() : "Data not available") + System.lineSeparator() +
                        "Employer: " + (job.getEmployer() != null ? job.getEmployer().getValue() : "Data not available") + System.lineSeparator() +
                        "Location: " + (job.getLocation() != null ? job.getLocation().getValue() : "Data not available") + System.lineSeparator() +
                        "Position Type: " + (job.getPositionType() != null ? job.getPositionType().getValue() : "Data not available") + System.lineSeparator() +
                        "Core Competency: " + (job.getCoreCompetency() != null ? job.getCoreCompetency().getValue() : "Data not available") + System.lineSeparator() +
                        System.lineSeparator();

        assertEquals(expectedString, jobString);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();
        assertTrue(jobString.contains("ID: " + job.getId()));
        assertTrue(jobString.contains("Name: " + job.getName()));
        assertTrue(jobString.contains("Employer: " + job.getEmployer().getValue()));
        assertTrue(jobString.contains("Location: " + job.getLocation().getValue()));
        assertTrue(jobString.contains("Position Type: " + job.getPositionType().getValue()));
        assertTrue(jobString.contains("Core Competency: " + job.getCoreCompetency().getValue()));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job();
        String jobString = job.toString();
        assertTrue(jobString.contains("ID: " + job.getId()));
        assertTrue(jobString.contains("Name: Data not available"));
        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
    }

}