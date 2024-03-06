import java.util.ArrayList;
import java.util.Random;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

class Contestant extends Person {
    int position;
    int totalPosition;

    Contestant(String name) {
        super(name);
        this.position = 0;
        this.totalPosition = 0;
    }

    void recordPosition(int round, int currentPosition) {
        this.position = currentPosition;
        this.totalPosition += currentPosition;
    }

    double calculateAveragePosition(int totalRounds) {
        return (double) this.totalPosition / totalRounds;
    }
}

public class ContestSimulationV4 {
    public static void main(String[] args) {
        int numContestants = 45000;
        int numRounds = 10000;

        ArrayList<Contestant> contestants = new ArrayList<>();
        for (int i = 0; i < numContestants; i++) {
            contestants.add(new Contestant("Contestant " + i));
        }

        Random random = new Random();

        // Record the start time
        long startTime = System.currentTimeMillis();

        for (int round = 1; round <= numRounds; round++) {
            ArrayList<Contestant> newPositions = new ArrayList<>();

            for (Contestant contestant : contestants) {
                boolean isCorrect = random.nextBoolean();

                if (isCorrect) {
                    newPositions.add(0, contestant);
                } else {
                    newPositions.add(contestant);
                }
            }

            contestants.clear();
            contestants.addAll(newPositions);

            for (int i = 0; i < numContestants; i++) {
                contestants.get(i).recordPosition(round, i + 1);
            }
        }

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate and print the time taken
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken: " + elapsedTime + " milliseconds");
    }
}
