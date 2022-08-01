package AgreggatePista.EntitiesPista;

import AgreggatePista.ValueObjetPista.TipoVehiculo;
import AgreggatePista.ValueObjetPista.VehiculoID;
import AgreggatePista.ValueObjetPista.isAtendido;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Vehiculo extends Entity<VehiculoID> {
    public static VehiculoID vehiculoID;
    public static TipoVehiculo tipoVehiculo;

    public static isAtendido IsAtendido;

    public Vehiculo(VehiculoID vehiculoID, TipoVehiculo tipoVehiculo) {
        super(vehiculoID);
        this.vehiculoID = vehiculoID;
        this.tipoVehiculo = tipoVehiculo;
    }

    public void AddVehiculo(VehiculoID vehiculoID, TipoVehiculo tipoVehiculo) {
        this.vehiculoID = Objects.requireNonNull(vehiculoID);
        this.tipoVehiculo = Objects.requireNonNull(tipoVehiculo);
    }
    public static VehiculoID getVehiculoID() {
        return vehiculoID;
    }
    public static TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void updateVehiculoisAtendido(isAtendido isAtendido) {
    }
}