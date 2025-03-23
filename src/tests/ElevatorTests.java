package tests;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.*;

public class ElevatorTests {

    @Test
    public void givenTestCase() {
        Elevator elevator = new Elevator(1, null); // Default start floor
        
        List<Integer> floorsToVisit = Elevator.readInputFromFile("input.txt", elevator);
        
        int travelTime = elevator.calcTravel(floorsToVisit);
        
        assertEquals(560, travelTime); // Expected travel time from the input file example
    }
    
    @Test
    public void edgeCases() {
        Elevator elevator = new Elevator(1, null);
        
        List<Integer> floorsToVisit = Elevator.readInputFromFile("emptyInput.txt", elevator); // File with just a start floor
        
        int travelTime = elevator.calcTravel(floorsToVisit);
        
        assertEquals(0, travelTime); // Empty list, should return 0
 
       
    }
    
    @Test
    public void singleFloorTest() {
        Elevator elevator = new Elevator(1, CallType.UP_DOWN);
        List<Integer> floorsToVisit = Elevator.readInputFromFile("singleFloorInput.txt", elevator); // File with start=5, floor=5
        
        int travelTime = elevator.calcTravel(floorsToVisit);
        
        assertEquals(0, travelTime); // No movement, should return 0 travel time
        
        floorsToVisit = Elevator.readInputFromFile("dontMove.txt", elevator); // file with same floor repeated
        
        travelTime = elevator.calcTravel(floorsToVisit);
        
        assertEquals(0, travelTime); // 0, doesn't move from floor 1
    }
    
    @Test
    public void largeTest() {
        Elevator elevator = new Elevator(1, CallType.UP_DOWN);
        List<Integer> floorsToVisit = Elevator.readInputFromFile("large.txt", elevator); // File with start=1, floor=100
        
        int travelTime = elevator.calcTravel(floorsToVisit);
        
        assertEquals(990, travelTime); // (100 - 1) * 10
    }
}
