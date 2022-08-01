package AgreggatePista.EventsDomainPista.CommandsPista;

import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.TipoVehiculo;
import AgreggatePista.ValueObjetPista.VehiculoID;
import co.com.sofka.domain.generic.Command;

public class RemoveVehiculo extends Command {
    private final VehiculoID vehiculoID;
    private final TipoVehiculo tipoVehiculo;
    private final PistaID pistaID;

    public RemoveVehiculo(VehiculoID vehiculoID, TipoVehiculo tipoVehiculo,PistaID pistaID) {
        this.vehiculoID = vehiculoID;
        this.tipoVehiculo = tipoVehiculo;
        this.pistaID = pistaID;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public PistaID getPistaID() {
        return pistaID;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
}