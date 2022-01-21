package com.company;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {1, 0, 3, 1, 3, 1};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {//najde nejmenší a nejvyšší hodnotu v poli
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        int[] array = new int[max - min + 1];//pole hodnot indexů
        for (int i = 0; i < numbers.length; i++) {//urci pocet kolikrat se tam objevuje ta hodnota
            array[numbers[i] - min]++;
        }
        for (int i = 0; i < array.length; i++) {//výpis
            System.out.print(array[i] + " ");
        }

        int[] cumulative = new int[max - min + 1];// pole které je stejně velké jako array
        cumulative[0] = array[0];//zadává první stejnou hodnotu
        for (int i = 1; i < array.length; i++) {
            cumulative[i] = cumulative[i - 1] + array[i];//další hodnoty jsou cumu.
        }
        System.out.println();//výpis
        for (int i = 0; i < cumulative.length; i++) {
            System.out.print(cumulative[i] + " ");
        }
        for (int i = cumulative.length - 1; i > 0; i--) {//posun o 1 index doprava
            cumulative[i] = cumulative[i - 1];
        }
        cumulative[0] = 0;//nastavení prvního indexu 0
        System.out.println();//výpis
        System.out.println("cumulative");
        for (int i = 0; i < cumulative.length; i++) {
            System.out.print(cumulative[i] + " ");
        }
        int[] sorted = new int[numbers.length];//nové pole které je stejně velké jako numbers
        System.out.println();
        System.out.println("sorting");
        for (int i = 0; i < numbers.length; i++) {//prochází v poli numbers hod.
            sorted[cumulative[numbers[i] - min]] = numbers[i];//vkládá hodnotu na správnou pozici v poli
            cumulative[numbers[i] - min]++;//zvýšuje index pro danou hodnotu
        }
        System.out.println();//výpis
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
    }
}



