package AgreggatePista.ValueObjetPista;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class isLibre implements ValueObject<Boolean> {
    private final Boolean value;

    public isLibre(Boolean value) {
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
        isLibre that = (isLibre) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}