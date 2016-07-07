package ru.hokan.strange.numbers;

/**
 * @author Ачкасов Антон
 */
public class Main {
    public static void main(String[] args) {
        StrangeNumberProcessor processor = new TreeProcessor();
        processor.run(9);
    }
}
