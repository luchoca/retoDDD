package AgreggatePista.ValueObjetPista;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
public class TipoAccion implements ValueObject<String> {
    private final String value;

    public TipoAccion(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("Agregar una accion para el pistero");
        }
        if(this.value.length()<=1){
            throw new IllegalArgumentException(("Debe tener mas de 5 caracteres!!!!"));
        }
        if(!value.matches("[inflar],[lavar],[mecanica]")){
            throw new IllegalArgumentException("Debe escribir un tipo de accion valido ejemplo:(inflar, lavar o mecanica");
        }
    }

    @Override
    public String value() {
        return value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoAccion that = (TipoAccion) o;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}