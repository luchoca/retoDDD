package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.VehiculoID;
import AgreggatePista.ValueObjetPista.isAtendido;
import co.com.sofka.domain.generic.DomainEvent;

public class VehiculoisAtendidoUpdated extends DomainEvent {
    private final VehiculoID vehiculoID;
    private final isAtendido IsAtendido;

    public VehiculoisAtendidoUpdated(VehiculoID vehiculoID, isAtendido IsAtendido) {
        super("sofka.vehiculo.vehiculoisAtendidoUpdated");
        this.IsAtendido = IsAtendido;
        this.vehiculoID = vehiculoID;
    }

    public isAtendido getIsAtendido() {
        return IsAtendido;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }
}
