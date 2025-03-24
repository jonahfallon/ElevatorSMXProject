package main;
import java.io.*;
import java.util.*;

/*
 * Class: Elevator
 * 
 * Description: This class holds information of an elevator and simulates the time it would take to visit
 * floors, given a list.
 */
public class Elevator {
    
    private int currFloor; // tracks the floor the elevator is left that
    private static final int FLOOR_TRAVEL_TIME = 10; // constant time for travel between floors
    private CallType buttonType; // UNIMPLEMENTED: would represent the type of call button on a floor

    /**
     * Constructor
     * @param startFloor for elevator
     */
    public Elevator(int startFloor) {
        this.currFloor = startFloor;
    }

    /**
     * Calculates the travel time for the elevator to visit all floors in order
     * @param floors - list of floors to visit
     * @return returns the travel time to visit all floors and writes to output.txt
     */
    public int calcTravel(List<Integer> floors) {
        int totalTravelTime = 0;
        List<Integer> visitedFloors = new ArrayList<>();
        visitedFloors.add(currFloor);

        for (int floor : floors) {
            totalTravelTime += Math.abs(currFloor - floor) * FLOOR_TRAVEL_TIME;
            currFloor = floor;
            visitedFloors.add(currFloor);
        }

        String output = totalTravelTime + "\n" + visitedFloors.toString().replaceAll("[\\[\\] ]", "");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/output.txt"))) {
            writer.write(output);
        } catch (IOException e) {
            System.err.println("Error writing to output file.");
        }

        return totalTravelTime;
    }

    public int getFloor() {
        return currFloor;
    }

    /**
     * Reads elevator input from a file and updates the starting floor.
     * @param filename The name of the input file.
     * @param elevator The Elevator object whose starting floor will be updated.
     * @return A list of floors to visit.
     */
    
    public static List<Integer> readInputFromFile(String filename, Elevator elevator) {
        List<Integer> floorsToVisit = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File(filename))) {
            elevator.currFloor = Integer.parseInt(scanner.nextLine().trim()); // Update elevator's current floor
            
            for (String s : scanner.nextLine().split(",")) {
                floorsToVisit.add(Integer.parseInt(s.trim()));
            }
        } catch (FileNotFoundException e) {
        	
            System.err.println("Error: Input file not found");
            
        } catch (Exception e) {
        	
            System.err.println("Error reading input file: " + e.getMessage());
        }

        return floorsToVisit;
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator(1); // Default start at floor 1
        
        List<Integer> floorsToVisit = readInputFromFile("files/input.txt", elevator);
        
        if (!floorsToVisit.isEmpty()) {
            elevator.calcTravel(floorsToVisit);
        }
    }
}