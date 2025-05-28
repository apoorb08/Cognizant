// CoreJavaExercises.java
// Combined solutions to all 41 Core Java exercises
// This file contains implementations of various Java exercises, including basic syntax, OOP concepts, exception handling, file I/O, collections, multithreading, and more.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CoreJavaExercises {

    public static void helloWorld() {
        System.out.println("Hello, World!");
    }

    public static void calculator() {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble(), b = sc.nextDouble();
        char op = sc.next().charAt(0);
        double res = switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> b != 0 ? a / b : Double.NaN;
            default -> 0;
        };
        System.out.println("Result: " + res);
    }

    public static void evenOddChecker() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n % 2 == 0 ? "Even" : "Odd");
    }

    public static void leapYearChecker() {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        boolean leap = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        System.out.println(leap ? "Leap year" : "Not a leap year");
    }

    public static void multiplicationTable() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= 10; i++) System.out.println(num + " x " + i + " = " + (num * i));
    }

    public static void dataTypeDemo() {
        int i = 10; float f = 5.5f; double d = 9.99; char c = 'A'; boolean b = true;
        System.out.println(i + " " + f + " " + d + " " + c + " " + b);
    }

    public static void typeCasting() {
        double d = 9.7;
        int i = (int) d;
        int x = 5;
        double dx = x;
        System.out.println(i + " " + dx);
    }

    public static void operatorPrecedence() {
        int res = 10 + 5 * 2;
        System.out.println("Result: " + res); // 20
    }

    public static void gradeCalculator() {
        Scanner sc = new Scanner(System.in);
        int marks = sc.nextInt();
        char grade = marks >= 90 ? 'A' :
                     marks >= 80 ? 'B' :
                     marks >= 70 ? 'C' :
                     marks >= 60 ? 'D' : 'F';
        System.out.println("Grade: " + grade);
    }

    public static void numberGuessingGame() {
        Scanner sc = new Scanner(System.in);
        int number = new Random().nextInt(100) + 1, guess;
        do {
            guess = sc.nextInt();
            if (guess < number) System.out.println("Too low");
            else if (guess > number) System.out.println("Too high");
            else System.out.println("Correct!");
        } while (guess != number);
    }

    public static void factorial() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        System.out.println(fact);
    }

    public static int add(int a, int b) { return a + b; }
    public static double add(double a, double b) { return a + b; }
    public static int add(int a, int b, int c) { return a + b + c; }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void arraySumAverage() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) sum += (arr[i] = sc.nextInt());
        System.out.println("Sum: " + sum + ", Avg: " + (sum / (double)n));
    }

    public static void reverseString() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(new StringBuilder(input).reverse());
    }

    public static void palindromeChecker() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String rev = new StringBuilder(input).reverse().toString();
        System.out.println(input.equals(rev));
    }

    static class Car {
        String make, model; int year;
        Car(String make, String model, int year) {
            this.make = make; this.model = model; this.year = year;
        }
        void displayDetails() { System.out.println(year + " " + make + " " + model); }
    }

    static class Animal {
        void makeSound() { System.out.println("Some sound"); }
    }

    static class Dog extends Animal {
        void makeSound() { System.out.println("Bark"); }
    }

    interface Playable { void play(); }

    static class Guitar implements Playable {
        public void play() { System.out.println("Guitar playing"); }
    }

    static class Piano implements Playable {
        public void play() { System.out.println("Piano playing"); }
    }

    public static void tryCatchExample() {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }

    static class InvalidAgeException extends Exception {
        InvalidAgeException(String msg) { super(msg); }
    }

    public static void customException() {
        try {
            int age = 16;
            if (age < 18) throw new InvalidAgeException("Too young");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        FileWriter fw = new FileWriter("output.txt");
        fw.write(s);
        fw.close();
    }

    public static void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("output.txt"));
        String line;
        while ((line = br.readLine()) != null) System.out.println(line);
        br.close();
    }

    public static void arrayListExample() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        while (true) {
            String s = sc.nextLine();
            if (s.equals("stop")) break;
            names.add(s);
        }
        System.out.println(names);
    }

    public static void hashMapExample() {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Alice"); map.put(2, "Bob");
        int id = sc.nextInt();
        System.out.println(map.getOrDefault(id, "Not found"));
    }

    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++)
                System.out.println(Thread.currentThread().getName() + " running");
        }
    }

    public static void threadExample() {
        new MyThread().start();
        new MyThread().start();
    }

    public static void lambdaSort() {
        List<String> list = Arrays.asList("Zebra", "Apple", "Mango");
        list.sort((a, b) -> a.compareTo(b));
        System.out.println(list);
    }

    public static void streamEven() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evens = nums.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(evens);
    }

    record Person(String name, int age) {}

    public static void recordExample() {
        List<Person> people = List.of(new Person("Alice", 30), new Person("Bob", 17));
        people.stream().filter(p -> p.age() >= 18).forEach(System.out::println);
    }

    /**
     * @param obj
     */
    public static void patternSwitch(Object obj) {
        if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            System.out.println("Integer: " + i);
        } else if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("String: " + s);
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            System.out.println("Double: " + d);
        } else {
            System.out.println("Unknown type");
        }
    }

    public static void virtualThreads() {
        for (int i = 0; i < 1000; i++)
            new Thread(() -> System.out.println("Running thread")).start();
    }

    public static void executorCallable() throws Exception {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Callable<String> task = () -> "Done!";
        Future<String> result = ex.submit(task);
        System.out.println(result.get());
        ex.shutdown();
    }

    public static void main(String[] args) {
        // You can test each function here
        helloWorld();
    }
}
