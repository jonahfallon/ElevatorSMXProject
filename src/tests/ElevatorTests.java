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
        
        assertEquals(0, travelTime); // No floors to visit, travel time should be 0
    }
    
    @Test
    public void singleFloorTest() {
        Elevator elevator = new Elevator(1, CallType.UP_DOWN);
        List<Integer> floorsToVisit = Elevator.readInputFromFile("single_floor_input.txt", elevator); // File with start=5, floor=5
        
        int travelTime = elevator.calcTravel(floorsToVisit);
        
        assertEquals(0, travelTime); // No movement, should return 0 travel time
    }
    
    @Test
    public void largeJumpTest() {
        Elevator elevator = new Elevator(1, CallType.UP_DOWN);
        List<Integer> floorsToVisit = Elevator.readInputFromFile("large_jump_input.txt", elevator); // File with start=1, floor=100
        
        int travelTime = elevator.calcTravel(floorsToVisit);
        
        assertEquals(990, travelTime); // (100 - 1) * 10
    }
}
