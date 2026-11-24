import java.util.Scanner;
import java.util.Arrays;
import laboratory2.EvenIndexProcessor;

public class App {
    private static int[] currentArray = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            clearScreen();
            System.out.println("=== МЕНЮ ЛАБОРАТОРНОЇ №2 (ВАРІАНТ 6) ===");
            System.out.println("1. Ввести розмір та елементи масиву");
            System.out.println("2. Обчислити сер. арифм. індексів парних елементів");
            System.out.println("3. Вихід");
            System.out.print("Оберіть пункт: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("\n=== 1. ВВЕДЕННЯ МАСИВУ ===");
                    System.out.print("Введіть розмір масиву: ");
                    try {
                        int size = Integer.parseInt(scanner.nextLine());
                        if (size <= 0) {
                            System.out.println("\n[Помилка]: Розмір масиву має бути більшим за 0!");
                            waitForEnter(scanner);
                            break;
                        }

                        currentArray = new int[size];
                        System.out.println("Введіть " + size + " цілих чисел:");
                        for (int i = 0; i < size; i++) {
                            System.out.print("Елемент [" + i + "]: ");
                            currentArray[i] = Integer.parseInt(scanner.nextLine());
                        }
                        System.out.println("\n[Успішно]: Масив створено: " + Arrays.toString(currentArray));

                    } catch (NumberFormatException e) {
                        System.out.println("\n[Помилка]: Потрібно ввести ціле число, а не літери чи символи!");
                    }
                    waitForEnter(scanner);
                    break;

                case "2":
                    System.out.println("\n--- 2. ОБЧИСЛЕННЯ РЕЗУЛЬТАТУ ---");
                    if (currentArray == null) {
                        System.out.println("\n[Помилка]: Спочатку введіть масив (Пункт 1).");
                        waitForEnter(scanner);
                        break;
                    }

                    System.out.println("Поточний масив: " + Arrays.toString(currentArray));
                    double result = EvenIndexProcessor.calcAverageEvenIndices(currentArray);
                    
                    if (Double.isNaN(result)) {
                        System.out.println("\n[Результат]: Парних елементів у масиві немає (Double.NaN).");
                    } else {
                        System.out.printf("\n[Результат]: Середнє арифметичне індексів = %.2f%n", result);
                    }
                    waitForEnter(scanner);
                    break;

                case "3":
                    System.out.println("\nВихід з програми. Успішної здачі!");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nНекоректний вибір! Спробуйте ще раз.");
                    waitForEnter(scanner);
            }
        }
    }

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void waitForEnter(Scanner scanner) {
        System.out.println("\nНатисніть Enter для продовження...");
        scanner.nextLine();
    }
}