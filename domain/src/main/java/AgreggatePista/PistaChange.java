package AgreggatePista;

import AgreggatePista.EntitiesPista.Pistero;
import AgreggatePista.EntitiesPista.Surtidor;
import AgreggatePista.EntitiesPista.Vehiculo;
import AgreggatePista.EventsDomainPista.*;
import co.com.sofka.domain.generic.EventChange;

public class PistaChange extends EventChange {
    public PistaChange(Pista pista) {

        //aca aplicamos todos los eventos de dominio que estan en el agregado
        apply((PistaCreated event) -> {
            pista.nombre = event.getNombre();
        });
        apply((PisteroAdded event) -> {
            Pistero.pisteroID = event.getPisteroID();
            Pistero.nombre = event.getNombre();

        });
        apply((SurtidorAdded event) -> {
            Surtidor.surtidorID = event.getSurtidorID();
            Surtidor.numero = event.getNumero();
            Pista.surtidorID = event.getSurtidorID();

        });
        apply((VehiculoAdded event) -> {
            Vehiculo.vehiculoID = event.getVehiculoID();
            Vehiculo.tipoVehiculo = event.getTipoVehiculo();
        });
        apply((PistaRemoved event) -> {
//            Pista.pistaID = event.getPistaID();
//            Pista.nombre = event.getNombre();
            Pista.pistaID = null;
            Pista.nombre = null;
        });
        apply((PisteroRemoved event) -> {
//            Pista.pisteroID = event.getPisteroID();
//            Pistero.nombre = event.getNombre();
            Pista.pisteroID = null;
            Pistero.nombre = null;
        });
        apply((SurtidorRemoved event) -> {
//            Pista.surtidorID = event.getSurtidorID();
//            Surtidor.numero = event.getNumero();
            Pista.surtidorID = null;
            Surtidor.numero = null;
        });
        apply((VehiculoRemoved event) -> {
//            Pista.vehiculoID = event.getVehiculoID();
//            Vehiculo.tipoVehiculo = event.getTipoVehiculo();
            Pista.vehiculoID = null;
            Vehiculo.tipoVehiculo = null;
        });
    }
}

