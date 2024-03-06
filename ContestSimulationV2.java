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
        System.out.println(this.name + " - Round " + round + ": Position " + currentPosition);
    }

    double calculateAveragePosition(int totalRounds) {
        return (double) this.totalPosition / totalRounds;
    }
}

public class ContestSimulationV2 {
    public static void main(String[] args) {
        int numContestants = 8;
        int numRounds = 12;

        ArrayList<Contestant> contestants = new ArrayList<>();
        for (int i = 0; i < numContestants; i++) {
            contestants.add(new Contestant("Contestant " + i));
        }

        Random random = new Random();

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

            System.out.println();
        }

        System.out.println("Average positions after " + numRounds + " rounds:");
        for (Contestant contestant : contestants) {
            System.out.println(contestant.name + ": " + contestant.calculateAveragePosition(numRounds));
        }
    }
}
