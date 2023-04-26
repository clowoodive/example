package clowoodive.example.designpattern.behavior;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

interface NumberIterator {

    int getNext();

    boolean hasMore();
}

class AscendingIterator implements NumberIterator {

    private List<Integer> numbers = new ArrayList<>();

    private int curPos = 0;

    public AscendingIterator(EvenNumberCollection collection) {
        this.numbers = collection.numList.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public int getNext() {
        if (!hasMore()) {
            return -1;
        }

        return this.numbers.get(curPos++);
    }

    @Override
    public boolean hasMore() {
        return curPos < numbers.size();
    }
}

class DescendingIterator implements NumberIterator {

    private List<Integer> numbers = new ArrayList<>();

    private int curPos = 0;

    public DescendingIterator(EvenNumberCollection collection) {
        this.numbers = collection.numList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    @Override
    public int getNext() {
        if (!hasMore()) {
            return -1;
        }

        return this.numbers.get(curPos++);
    }

    @Override
    public boolean hasMore() {
        return curPos < numbers.size();
    }
}

interface NumberCollection {

    NumberIterator createAscendingNumberIterator();

    NumberIterator createDescendingNumberIterator();
}

class EvenNumberCollection implements NumberCollection {

    List<Integer> numList;

    public EvenNumberCollection(List<Integer> intList) {
        this.numList = intList;
    }

    // 해당 컬렉션 구현 사항들
    public void addNum(int addNum) {
    }

    @Override
    public NumberIterator createAscendingNumberIterator() {
        return new AscendingIterator(this);
    }

    @Override
    public NumberIterator createDescendingNumberIterator() {
        return new DescendingIterator(this);
    }
}

// class 내부에 iterator 선언 방식
class OddNumberCollection {

    List<Integer> numList;

    public OddNumberCollection(List<Integer> intList) {
        this.numList = intList;
    }

    // 해당 컬렉션 구현 사항들
    public void addNum(int addNum) {
    }

    // 기본 오름차순 반복자
    NumberIterator getIterator() {
        return new DefaultIterator();
    }

    class DefaultIterator implements NumberIterator {

        private int curPos = 0;

        @Override
        public int getNext() {
            if(!hasMore()) {
                return -1;
            }

            List<Integer> cache = OddNumberCollection.this.numList.stream().sorted().collect(Collectors.toList());
            return cache.get(curPos++);
        }

        @Override
        public boolean hasMore() {
            return curPos < OddNumberCollection.this.numList.size();
        }
    }
}

