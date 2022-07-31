package AgreggatePista.ValueObjetPista;

import AgreggatePista.EntitiesPista.Pistero;
import co.com.sofka.domain.generic.Identity;

public class PistaID extends Identity {

    public PistaID() {
    }

    private PistaID(String id) {
        super(id);
    }

    public static PistaID of(String id) { //con base a un string
        return new PistaID(id);
    }
}
