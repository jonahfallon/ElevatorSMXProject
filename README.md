# ElevatorSMXProject

**Assumptions:** - Only one elevator is operating.
- Does not account for stop time at each floor.
- Constant travel time between floors. Does not account for larger travel distances being comparatively faster due to acceleration.
- Assuming valid numerical inputs in input files
- Elevator travels to floors in the order given. There is no optimization
- Write results to output.txt

**Unimplemented Features:** - Opitmization of floor visits
- Since the number of floors isn't stated at the beginning, it is impractical to implement the call type since we don't know how many floors there are. If this was given, we could create a floor object for each floor and give it an instance variable of type CallType.
- Basic elevator functions like opening and closing the door or emergency buttons that could change the functionality of the elvator. 

**Call Button Type:** A floor has a SINGLE call button on the bottom and top floor, UP_DOWN otherwise. This allows for travel up or down for intermediate floors. The call button can assume the direction on the top and bottom floor. 

  
