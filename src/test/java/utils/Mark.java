package utils;

import java.util.Objects;

public record Mark(String name, Integer amount) implements Comparable<Mark> {


    @Override
    public int compareTo(Mark o) {
        return Integer.compare(this.amount, o.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mark mark))
            return false;
        return Objects.equals(mark.name, name);
    }

}
