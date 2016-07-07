package ru.hokan.strange.numbers;

/**
 * @author Ачкасов Антон
 */
public class BruteForceProcessor implements StrangeNumberProcessor {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(int highNumberNumbersBorder) {
        long highBorder = (long) Math.pow(10.0, highNumberNumbersBorder);
        long lowBorder = (long) Math.pow(10.0, highNumberNumbersBorder - 1);
        for(long i = lowBorder; i < highBorder; ++i) {
            boolean suitable = true;
            for (int j = 1; j <= highNumberNumbersBorder; ++j) {
                long part = (long)(i / Math.pow(10.0, (int)Math.log10(i) - j));
                if (part == 0 || part % (j + 1) != 0) {
                    suitable = false;
                    break;
                }
            }

            if (suitable /*&& filter(i)*/) {
                System.out.println(i);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean filter(long value) {
        String stringValue = String.valueOf(value);
        int checker = 0;
        for (int i = 0; i < stringValue.length(); i++) {
            int val = stringValue.charAt(i) - '0';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
}
