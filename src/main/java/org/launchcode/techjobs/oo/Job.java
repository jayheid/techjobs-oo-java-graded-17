package org.launchcode.techjobs.oo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString(){

        ArrayList <String> jobAttributes = new ArrayList();

        jobAttributes.add(name);
        jobAttributes.add(employer.toString());
        jobAttributes.add(location.toString());
        jobAttributes.add(positionType.toString());
        jobAttributes.add(coreCompetency.toString());

        ArrayList <String> outputArray = new ArrayList();

        for (String item : jobAttributes){
            if (item.isBlank()){
                outputArray.add("Data not available");
            }
            else{
                outputArray.add(item);
            }
        }

        String formattedOutput =
            System.lineSeparator() +
            "ID: " + id + System.lineSeparator() +
            "Name: " + outputArray.get(0) + System.lineSeparator() +
            "Employer: " + outputArray.get(1) + System.lineSeparator() +
            "Location: " + outputArray.get(2) + System.lineSeparator() +
            "Position Type: " + outputArray.get(3) + System.lineSeparator() +
            "Core Competency: " + outputArray.get(4) +
            System.lineSeparator();

        return formattedOutput;

    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
