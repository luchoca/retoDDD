package AgreggatePista.CommandsPista;

import AgreggatePista.ValueObjetPista.TipoVehiculo;
import AgreggatePista.ValueObjetPista.VehiculoID;
import co.com.sofka.domain.generic.Command;

public class RemoveVehiculo extends Command {
    private final VehiculoID vehiculoID;
    private final TipoVehiculo tipoVehiculo;

    public RemoveVehiculo(VehiculoID vehiculoID, TipoVehiculo tipoVehiculo) {
        this.vehiculoID = vehiculoID;
        this.tipoVehiculo = tipoVehiculo;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
}