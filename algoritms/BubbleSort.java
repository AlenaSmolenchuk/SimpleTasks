public class BubbleSort {
    public static void main(String[] args) {
        int[] mas = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < mas.length - 1; i++) {
            for (int j = 0; j < mas.length - i - 1; j++) {
                if (mas[j] < mas[j + 1]) {
                    int temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                }
            }
        }
        for (int m : mas) {
            System.out.print(m + " ");
        }
    }
}
