package AgreggatePista.ValueObjetPista;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Numero implements ValueObject<Integer> {
    private final Integer value;

    public Numero(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (value <= 0) {
            throw new IllegalArgumentException("TIENE QUE SER UN NUMERO POSITIVO");
        }

    }


    @Override
    public Integer value() {
        return value;
    }

    //los OV se comparan a traves de sus valores

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numero that = (Numero) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}