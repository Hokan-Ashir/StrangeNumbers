/**
 * @author Ачкасов Антон
 */
public class BruteForceProcessor implements StrangeNumberProcessor {

    public void run(int highNumberNumbersBorder) {
        long highBorder = (long) Math.pow(10.0, highNumberNumbersBorder);
        long lowBorder = (long) Math.pow(10.0, highNumberNumbersBorder - 1);
        for(long i = lowBorder; i < highBorder; ++i) {
            boolean suitable = true;
            for (int j = 1; j <= highNumberNumbersBorder; ++j) {
                int part = (int)(i / Math.pow(10.0, (int)Math.log10(i) - j));
                if (part == 0 || part % (j + 1) != 0) {
                    suitable = false;
                    break;
                }
            }

            if (suitable) {
                System.out.println(i);
            }
        }
    }
}
