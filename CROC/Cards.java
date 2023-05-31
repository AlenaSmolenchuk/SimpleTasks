package CROC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n < 1  n > 100) {
            System.out.println("Неверное количество карт в колоде.");
            return;
        }

        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int card = scanner.nextInt();

            if (card < 1  card > 100) {
                System.out.println("Неверное значение карты.");
                return;
            }

            cards.add(card);
        }

        int count = 0;

        while (!cards.isEmpty()) {
            int minCard = Integer.MAX_VALUE;
            for (int card : cards) {
                if (card < minCard) {
                    minCard = card;
                }
            }
            
            count++;


            if (cards.get(0) == minCard) {
                cards.remove(0);
            } else {
                
                int topCard = cards.get(0);
                cards.remove(0);
                cards.add(topCard);
            }
        }

        System.out.println(count); 
    }
}
