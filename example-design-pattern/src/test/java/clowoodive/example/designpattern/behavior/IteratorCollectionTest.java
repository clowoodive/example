package clowoodive.example.designpattern.behavior;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class IteratorCollectionTest {

    @Test
    void iterator() {
        EvenNumberCollection evenNumberCollection = new EvenNumberCollection(Arrays.asList(4, 8, 6, 2, 10));
        NumberIterator evenAscIterator = evenNumberCollection.createAscendingNumberIterator();
        NumberIterator evenDescIterator = evenNumberCollection.createDescendingNumberIterator();

        System.out.println("-------  EvenCollection ascending -------");
        while (evenAscIterator.hasMore()) {
            System.out.println(evenAscIterator.getNext());
        }

        System.out.println("-------  EvenCollection descending -------");
        while (evenDescIterator.hasMore()) {
            System.out.println(evenDescIterator.getNext());
        }

        OddNumberCollection oddNumberCollection = new OddNumberCollection(Arrays.asList(7, 1, 3, 9, 5));
        NumberIterator oddAscIterator = oddNumberCollection.getIterator();

        System.out.println("-------  OddCollection ascending -------");
        while (oddAscIterator.hasMore()) {
            System.out.println(oddAscIterator.getNext());
        }
    }
}