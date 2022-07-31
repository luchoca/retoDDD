package AgreggatePista.ValueObjetPista;

import co.com.sofka.domain.generic.Identity;

public class VehiculoID extends Identity {
    public VehiculoID() {
    }

    private VehiculoID(String id) {
        super(id);
    }

    public static VehiculoID of(String id) { //con base a un string
        return new VehiculoID(id);
    }
}
