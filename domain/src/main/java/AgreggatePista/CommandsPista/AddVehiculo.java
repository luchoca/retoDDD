package AgreggatePista.CommandsPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.VehiculoID;
import co.com.sofka.domain.generic.Command;

public class AddVehiculo extends Command {
    private final Nombre nombre;
    private final VehiculoID vehiculoID;

    public AddVehiculo(Nombre nombre, VehiculoID vehiculoID) {
        this.nombre = nombre;
        this.vehiculoID = vehiculoID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }
}
