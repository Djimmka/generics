import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class Annnimalism {



    class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        int length = 0;



        Animal[] animal = new Animal[length];

        return animal;
    }

    public static void main(String[] args) {

    }
}
