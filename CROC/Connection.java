package CROC;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        Map<String, Queue<Integer>> connections = new HashMap<>();
        List<String> disconnections = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();
            if (line.startsWith("+")) {
                String user = line.substring(1);
                Queue<Integer> userConnections = connections.getOrDefault(user, new LinkedList<>());

                if (userConnections.size() == 4) {
                    int earliestConnection = userConnections.poll();
                    disconnections.add("Disconnected " + earliestConnection);
                }

                userConnections.offer(i);
                connections.put(user, userConnections);
            }
        }

        for (String disconnection : disconnections) {
            System.out.println(disconnection);
        }
    }
}
