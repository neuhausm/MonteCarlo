import java.lang.Math;
import java.util.Random;
public class MonteCarlo {
    Random rn = new Random();
    int getDiceRoll() {
        return this.rn.nextInt(6) + 1;
    }
    void rollTwoDice(int threshold, int numberTrials){
        int counter = 0;
        for(int i = 0; i < numberTrials; i++) {
            int dice1 = getDiceRoll();
            int dice2 = getDiceRoll();
            if (dice1 + dice2 >= threshold) {
                counter += 1;
            }
        }
        double probability = counter / (double) numberTrials;
        System.out.printf("The probability that two dice are at least %d is %f",
                threshold, probability);
        System.out.println();
    }
    double getRandomValueZeroToOne() {
        // returns a random value between 0 and 1
        return this.rn.nextDouble();
    }
    double evaluateFunctionAtX(double x) {
        return Math.pow(Math.sin(10 * Math.pow(x, 2)), 2) * Math.sin(x) * x + 0.1;
    }
    double evaluateIntegral(int numberTrials) {
        double blueCounter = 0;
        double allCounter = 0;
        for (int i = 0; i < numberTrials; i++) {
            double randomX = getRandomValueZeroToOne();
            double randomY = getRandomValueZeroToOne();
            double functionY = evaluateFunctionAtX(randomX);
            if(functionY>randomY) {
                blueCounter++;
            }
            allCounter++;
        }
        return (blueCounter/allCounter) * 1 ;

    }
    public static void main(String[] args) {
        MonteCarlo mc = new MonteCarlo();
        mc.rollTwoDice(12, 10000);
        System.out.println(mc.evaluateIntegral(100));
    }
}