package CROC;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task {
        public static void main(String[] args) {
                
            Scanner scanner = new Scanner(System.in);
                
            int n = scanner.nextInt();
            int[] calls = new int[n];
                
            for (int i = 0; i < n; i++) {
                calls[i] = scanner.nextInt();
            }

            Map<Integer, Integer> callParticipants = new HashMap<>();
                
            for (int i = 0; i < n; i++) {
                int callId = calls[i];
                if (callParticipants.containsKey(callId)) {
                    int participant = callParticipants.get(callId);
                    System.out.println((i + 1) + " " + (participant + 1));
                    callParticipants.remove(callId);
                } else {
                    callParticipants.put(callId, i);
                }
            }
        }
}
