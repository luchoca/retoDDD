package AgreggatePista.EventsDomainPista.CommandsPista;

import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.TipoVehiculo;
import AgreggatePista.ValueObjetPista.VehiculoID;
import co.com.sofka.domain.generic.Command;

public class AddVehiculo extends Command {
    private final PistaID pistaID;
    private final VehiculoID vehiculoID;
    private final TipoVehiculo tipoVehiculo;
    public AddVehiculo(PistaID pistaID, VehiculoID vehiculoID, TipoVehiculo tipoVehiculo) {
        this.pistaID = pistaID;
//        this.nombre = nombre;
        this.vehiculoID = vehiculoID;
        this.tipoVehiculo = tipoVehiculo;
    }

    public PistaID getPistaID() {
        return pistaID;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }
}