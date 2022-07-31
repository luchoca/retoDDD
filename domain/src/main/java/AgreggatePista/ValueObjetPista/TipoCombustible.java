package AgreggatePista.ValueObjetPista;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoCombustible implements ValueObject<String> {
    private final String value;

    public TipoCombustible(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("TIENE QUE TENER UN TipoCombustible");
        }
        if(this.value.length()<=1){
            throw new IllegalArgumentException(("Debe tener mas de 5 caracteres!!!!"));
        }
        if(!value.matches("[nafta],[gasoil]")){
            throw new IllegalArgumentException("Debe decir un combustible valido (nafta o gasoil");
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
        TipoCombustible that = (TipoCombustible) o;
        return super.equals(o);
        ///raul tiene return Objets.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
