package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.TipoVehiculo;
import AgreggatePista.ValueObjetPista.VehiculoID;
import co.com.sofka.domain.generic.DomainEvent;

public class VehiculoRemoved extends DomainEvent {
    private final VehiculoID vehiculoID;
    private final TipoVehiculo tipoVehiculo;

    public VehiculoRemoved(VehiculoID vehiculoID, TipoVehiculo tipoVehiculo) {
        super("sofka.vehiculo.vehiculoremoved");
        this.vehiculoID = vehiculoID;
        this.tipoVehiculo = tipoVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }
}