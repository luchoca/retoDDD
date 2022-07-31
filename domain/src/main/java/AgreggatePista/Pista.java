package AgreggatePista;

import AgreggatePista.EventsDomainPista.*;
import AgreggatePista.ValueObjetPista.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Pista extends AggregateEvent<PistaID> {
    protected static Numero numero;
    protected static PistaID pistaID;
    protected static PisteroID pisteroID;
    protected static SurtidorID surtidorID;
    protected static VehiculoID vehiculoID;
    protected static Nombre nombre;

    public Pista(PistaID pistaID, Nombre nombre) {
        super(pistaID);
        appendChange(new PistaCreated(nombre)).apply();
    }
    private Pista(PistaID pistaID) {
        super(pistaID);
        subscribe(new PistaChange(this));
    }
    public static Pista from(PistaID pistaID, List<DomainEvent> events) {
        var pista = new Pista(pistaID);
        events.forEach(pista::applyEvent);
        return pista;
    }
    public void addPistero(PisteroID pisteroID, Nombre nombre) {
        this.pisteroID = Objects.requireNonNull(pisteroID);
        this.nombre = Objects.requireNonNull(nombre);
        appendChange(new PisteroAdded(nombre)).apply();
    }
    public void addVehiculo(VehiculoID vehiculoID, TipoVehiculo tipoVehiculo) {
        this.vehiculoID = Objects.requireNonNull(vehiculoID);
        appendChange(new VehiculoAdded(vehiculoID, tipoVehiculo)).apply();

    }
    public void addSurtidor(SurtidorID surtidorID, Numero numero) {
        this.surtidorID = Objects.requireNonNull(surtidorID);
        appendChange(new SurtidorAdded(surtidorID, numero)).apply();
    }
    public void PistaCreated(Nombre nombre) {
        appendChange(new PistaCreated(nombre)).apply();
    }
    public void updateVehiculoisAtendido(VehiculoID vehiculoID, isAtendido IsAtendido) {
        this.vehiculoID = Objects.requireNonNull(vehiculoID);
        appendChange(new VehiculoisAtendidoUpdated(vehiculoID, IsAtendido)).apply();
    }
    public void updateSurtidorisLibre(SurtidorID surtidorID, isLibre IsLibre) {
        this.surtidorID = Objects.requireNonNull(surtidorID);
        appendChange(new SurtidorisLibreUpdated(surtidorID,IsLibre)).apply();
    }
    public void updateNumeroSurtidor(SurtidorID surtidorID, Numero numero) {
        this.surtidorID = Objects.requireNonNull(surtidorID);
        appendChange(new NumeroSurtidorUpdated(surtidorID, numero)).apply();
    }
    public void updateNombrePistero(PisteroID pisteroID, Nombre nombre) {
        this.pisteroID = Objects.requireNonNull(pisteroID);
        appendChange(new NombrePisteroUpdated(pisteroID,nombre)).apply();
    }
    public void removePista(PistaID pistaID, Nombre nombre) {
        this.pistaID = Objects.requireNonNull(pistaID);
        appendChange(new PistaRemoved(pistaID, nombre)).apply();
    }
    public void removePistero() {
        this.pisteroID = Objects.requireNonNull(pisteroID());
        appendChange(new PisteroRemoved(pisteroID, nombre)).apply();
    }
    public void removeSurtidor(SurtidorID surtidorID, Numero numero) {
        this.surtidorID = Objects.requireNonNull(surtidorID);
        appendChange(new SurtidorRemoved(surtidorID, numero)).apply();
    }
    public void removeVehiculo(VehiculoID vehiculoID, TipoVehiculo tipoVehiculo) {
        this.vehiculoID = Objects.requireNonNull(vehiculoID);
        appendChange(new VehiculoRemoved(vehiculoID, tipoVehiculo)).apply();
    }
    public PisteroID pisteroID() {
        return pisteroID;
    }

    public SurtidorID surtidorID() {
        return surtidorID;
    }

    public VehiculoID vehiculoID() {
        return vehiculoID;
    }

    public Nombre nombre() {
        return nombre;
    }

}
