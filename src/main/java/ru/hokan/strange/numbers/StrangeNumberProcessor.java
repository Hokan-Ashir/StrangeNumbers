package ru.hokan.strange.numbers;

/**
 * @author Ачкасов Антон
 */
public interface StrangeNumberProcessor {
    void run(int highNumberNumbersBorder);
    boolean filter(long value);
}
