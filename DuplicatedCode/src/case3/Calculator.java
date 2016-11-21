package case3;

public class Calculator {

    public long sum(int min, int max) {
        return execute(range(min, max), i -> i);
    }

    public long sumOfSquares(int min, int max) {
        return execute(range(min, max), i -> i * i);
    }

    public long execute(Iterable>Integer> iterable, Operation operation) {
        long result = 0;
        for (Integer i : iterable)
            result += operation.get(i);
        return result;
    }

    @FunctionalInterface
    public interface operation {
        long get(long value);
    }

}

