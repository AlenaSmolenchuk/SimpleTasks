package CROC;

import java.util.*;
 
public class Task3 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
       
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        int r = scanner.nextInt();

        List<Group> groups = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int arrivalTime = scanner.nextInt();
            int groupSize = scanner.nextInt();
            groups.add(new Group(arrivalTime, groupSize));
        }

        Collections.sort(groups);

        double totalTime = 0;
        int currentFloor = 1;
        PriorityQueue<Elevator> elevators = new PriorityQueue<>(Comparator.comparingInt(e -> e.endTime));

        for (int i = 0; i < n; i++) {
            elevators.add(new Elevator(0, currentFloor));
        }

        int totalPassengers = 0; 
        int remainingGroups = m; 

        for (Group group : groups) {
            int arrivalTime = group.arrivalTime;
            int groupSize = group.groupSize;

            Elevator elevator = elevators.poll();
            int elevatorArrivalTime = Math.max(currentFloor, arrivalTime);
            int elevatorTravelTime = Math.abs(elevatorArrivalTime - currentFloor) * r;
            currentFloor = elevatorArrivalTime;

            int trips = (int) Math.ceil((double) groupSize / d);

            int groupTime = trips * r;
            int groupEndTime = currentFloor + groupTime;

            totalTime += elevatorTravelTime + groupTime;

            elevator.endTime = groupEndTime;
            elevators.add(elevator);

            currentFloor = Math.max(currentFloor + 1, groupEndTime);

            totalPassengers += groupSize;
            remainingGroups--; 

            if (remainingGroups > 0 && elevators.isEmpty()) {
                
                totalTime += arrivalTime - currentFloor;
                currentFloor = arrivalTime;
            }
        }

        double averageTime = totalTime / totalPassengers; 

        System.out.printf("%.10f%n", averageTime);
    }

    static class Group implements Comparable<Group> {
     
        int arrivalTime;
        int groupSize;

        public Group(int arrivalTime, int groupSize) {
            this.arrivalTime = arrivalTime;
            this.groupSize = groupSize;
        }

        @Override
        public int compareTo(Group other) {
            return Integer.compare(this.arrivalTime, other.arrivalTime);
        }
    }

    static class Elevator {
        int endTime;
        int currentFloor;

        public Elevator(int endTime, int currentFloor) {
            this.endTime = endTime;
            this.currentFloor = currentFloor;
        }
    }
}
