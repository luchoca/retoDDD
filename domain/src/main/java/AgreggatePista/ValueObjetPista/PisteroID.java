package AgreggatePista.ValueObjetPista;

import co.com.sofka.domain.generic.Identity;

public class PisteroID extends Identity {

    public PisteroID() {
    }

    public PisteroID(String id) {
        super(id);
    }

    public static PisteroID of(String id) { //con base a un string
        return new PisteroID(id);
    }
}
