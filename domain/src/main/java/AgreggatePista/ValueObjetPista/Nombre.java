package AgreggatePista.ValueObjetPista;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {

    private final String value;

    public Nombre(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("TIENE QUE TENER UN NOMBRE");
        }
        if(this.value.length()<=5){
            throw new IllegalArgumentException(("Debe tener mas de 5 caracteres!!!!"));
        }
    }


    @Override
    public String value() {
        return value;
    }

    //los OV se comparan a traves de sus valores

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre that = (Nombre) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
