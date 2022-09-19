import java.util.Objects;
import java.util.Optional;

public class Pair<F,S> {
    private S second;
    private F first;

    private Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public static<F, S> Pair<F, S> of(F first, S second) {
        return new Pair<F , S>(first, second);
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object pair) {
        if (this == pair) {
            return true;
        }
        if (!(pair instanceof Pair)) {
            return false;
        }

        Pair<?,?> other = (Pair<?,?>) pair;
        return ((Objects.equals(first, other.first))&&(Objects.equals(second, other.second)));
    }


    public int hashCode(){
        return Integer.hashCode(Objects.hashCode(this.first) * 2 + Objects.hashCode(this.second)*3);
    }
}
