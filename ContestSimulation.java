import java.util.ArrayList;
import java.util.Random;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

class Contestant extends Person {
    Contestant(String name) {
        super(name);
    }
}

public class ContestSimulation {
    public static void main(String[] args) {
        int n = 10;

        ArrayList<Contestant> contestants = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            contestants.add(new Contestant("Contestant " + i));
        }

        Random random = new Random();

        ArrayList<Contestant> newPositions = new ArrayList<>();

        for (Contestant contestant : contestants) {
            boolean isCorrect = random.nextBoolean();

            if (isCorrect) {
                newPositions.add(0, contestant);
                System.out.println(contestant.name + " answered correctly and moved to the front.");
            } else {
                newPositions.add(contestant);
                System.out.println(contestant.name + " answered incorrectly and moved to the back.");
            }
        }

        contestants.clear();
        contestants.addAll(newPositions);

        System.out.println("\nFinal order of contestants:");
        for (Contestant contestant : contestants) {
            System.out.println(contestant.name);
        }
    }
}
