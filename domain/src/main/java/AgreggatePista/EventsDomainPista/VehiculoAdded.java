package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.TipoVehiculo;
import AgreggatePista.ValueObjetPista.VehiculoID;
import co.com.sofka.domain.generic.DomainEvent;

public class VehiculoAdded extends DomainEvent {
    private final VehiculoID vehiculoID;
    private final TipoVehiculo tipoVehiculo;



    public VehiculoAdded(VehiculoID vehiculoID, TipoVehiculo tipoVehiculo) {
        super("sofka.vehiculo.vehiculocreated");
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
