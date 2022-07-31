package AgreggatePista.EntitiesPista;

import AgreggatePista.ValueObjetPista.*;
import AgreggatePista.VehiculoChange;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Vehiculo extends Entity<VehiculoID> {
    public static VehiculoID vehiculoID;
    public static TipoVehiculo tipoVehiculo;

    public Vehiculo(VehiculoID vehiculoID, TipoVehiculo tipoVehiculo) {
        super(vehiculoID);
        this.vehiculoID = vehiculoID;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Vehiculo(VehiculoID vehiculoID) {
        super(vehiculoID);

        subscribe(new VehiculoChange(vehiculoID));
    }
    private void subscribe(VehiculoChange vehiculoChange) {
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
}