import java.util.LinkedList;
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

public class ContestSimulationV5 {
    public static void main(String[] args) {
        int numContestants = 45000;
        int numRounds = 10000;

        LinkedList<Contestant> contestants = new LinkedList<>();
        for (int i = 0; i < numContestants; i++) {
            contestants.add(new Contestant("Contestant " + i));
        }

        Random random = new Random();

        long startTime = System.currentTimeMillis();

        for (int round = 1; round <= numRounds; round++) {
            LinkedList<Contestant> newPositions = new LinkedList<>();

            for (Contestant contestant : contestants) {
                boolean isCorrect = random.nextBoolean();

                if (isCorrect) {
                    newPositions.addFirst(contestant);
                } else {
                    newPositions.addLast(contestant);
                }
            }

            contestants.clear();
            contestants.addAll(newPositions);

            for (int i = 0; i < numContestants; i++) {
                contestants.get(i).recordPosition(round, i + 1);
            }
        }

        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;
        System.out.println("Time taken: " + elapsedTime + " milliseconds");
    }
}
