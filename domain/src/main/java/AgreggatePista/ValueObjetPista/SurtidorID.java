package AgreggatePista.ValueObjetPista;

import co.com.sofka.domain.generic.Identity;

public class SurtidorID extends Identity {


    public SurtidorID() {
    }

    private SurtidorID(String id) {
        super(id);
    }

    public static SurtidorID of(String id) { //con base a un string
        return new SurtidorID(id);
    }
}
