package utils;

import java.util.Objects;

public class Mark implements Comparable<Mark> {
    private final String name;
    private final Integer amount;

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public Mark(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }


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

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + amount;
        result = 31 * result + name.hashCode();
        return result;
    }
}
