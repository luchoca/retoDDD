package AgreggatePista.EventsDomainPista.CommandsPista;

import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.VehiculoID;
import AgreggatePista.ValueObjetPista.isAtendido;
import co.com.sofka.domain.generic.Command;

public class UpdateVehiculoisAtendido extends Command {
    private final PistaID pistaID;
    private final VehiculoID vehiculoID;
    private final isAtendido IsAtendido;

    public UpdateVehiculoisAtendido(VehiculoID vehiculoID, isAtendido isAtendido, PistaID pistaID) {
        this.vehiculoID = vehiculoID;
        IsAtendido = isAtendido;
        this.pistaID = pistaID;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public isAtendido getIsAtendido() {
        return IsAtendido;
    }

    public PistaID getPistaID() {
        return pistaID;
    }
}
