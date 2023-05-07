package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    public static Job jobA = new Job("Ghostbuster", new Employer("The City of New York"), new Location("New York City"), new PositionType("Pest control"),new CoreCompetency("Good aim"));
    public static Job jobB = new Job("Assistant to the Super Villain", new Employer("Super Villains' Super Temp Agency"), new Location("Secret Lair"), new PositionType(""), new CoreCompetency(""));

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1,job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job5.getName(),"Product tester");
        assertEquals(job5.getEmployer().getValue(), "ACME");
        assertEquals(job5.getLocation().getValue(), "Desert");
        assertEquals(job5.getPositionType().getValue(), "Quality control");
        assertEquals(job5.getCoreCompetency().getValue(), "Persistence");

        assertTrue(job5 instanceof Job);
        assertTrue(job5.getEmployer() instanceof Employer);
        assertTrue(job5.getLocation() instanceof Location);
        assertTrue(job5.getPositionType() instanceof PositionType);
        assertTrue(job5.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job job3 = new Job("Big Cheese", new Employer("MoneyMaker, Inc."), new Location("Big City"), new PositionType("Decision maker"), new CoreCompetency("Shifting Paradigms"));
        Job job4 = new Job("Big Cheese", new Employer("MoneyMaker, Inc."), new Location("Big City"), new PositionType("Decision maker"), new CoreCompetency("Shifting Paradigms"));

        assertFalse(job3.equals(job4));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String jobTemplate = "\n"+"ID: " + jobA.getId() + "\n";

        assertEquals(jobA.toString().charAt(0), jobTemplate.toString().charAt(0));
        assertEquals(jobA.toString().charAt(jobA.toString().length()-1), jobTemplate.charAt(jobTemplate.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String jobBTemplate = "\nID: "+ jobB.getId()+"\n" +
                "Name: Assistant to the Super Villain\n"+
                "Employer: Super Villains' Super Temp Agency\n"+
                "Location: Secret Lair\n" +
                "Position Type: Data not available\n"+
                "Core Competency: Data not available\n";

        assertEquals(jobB.toString(), jobBTemplate);
    }
    @Test
    public void testToStringHandlesEmptyField(){
        String jobBTemplate = "\nID: "+ jobB.getId()+"\n" +
                "Name: Assistant to the Super Villain\n"+
                "Employer: Super Villains' Super Temp Agency\n"+
                "Location: Secret Lair\n" +
                "Position Type: Data not available\n"+
                "Core Competency: Data not available\n";

        assertEquals(jobB.toString(), jobBTemplate);
    }

}
