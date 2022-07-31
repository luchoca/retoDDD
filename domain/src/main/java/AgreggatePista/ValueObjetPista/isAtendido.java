package AgreggatePista.ValueObjetPista;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class isAtendido implements ValueObject<Boolean> {
    private final Boolean value;

    public isAtendido(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        isAtendido that = (isAtendido) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

