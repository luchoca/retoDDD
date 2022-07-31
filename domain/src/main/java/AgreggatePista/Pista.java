package AgreggatePista;

import AgreggatePista.EventsDomainPista.PistaCreated;
import AgreggatePista.EventsDomainPista.PisteroAdded;
import AgreggatePista.EventsDomainPista.SurtidorAdded;
import AgreggatePista.EventsDomainPista.VehiculoAdded;
import AgreggatePista.ValueObjetPista.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Pista extends AggregateEvent<PistaID> {
    protected static PistaID pistaID;
    protected static PisteroID pisteroID;
    protected static SurtidorID surtidorID;
    protected static VehiculoID vehiculoID;
    protected static Nombre nombre;

//aca creo el agregado
    public Pista(PistaID pistaID, Nombre nombre) {
        super(pistaID);
        appendChange(new PistaCreated(nombre)).apply();
    }

    private Pista(PistaID pistaID) {
        super(pistaID);
        subscribe(new PistaChange(this));
    }
// FACTORY:aca cosntruimos a la pista , tengo que ver si uso los id de todas las entidades o
// como hacer para q esa lista de eventos sea la creacion de el resto de las entidades
    public static Pista from(PistaID pistaID, List<DomainEvent> events) {
        var pista = new Pista(pistaID);
        events.forEach(pista::applyEvent);//aca le digo q a la pista le aplico eventos
        return pista;
    }

    public void addPistero(PisteroID pisteroID, Nombre nombre) {
        this.pisteroID = Objects.requireNonNull(pisteroID);
        this.nombre = Objects.requireNonNull(nombre);
        appendChange(new PisteroAdded(nombre)).apply();
    }

    public void addVehiculo(VehiculoID vehiculoID,TipoVehiculo tipoVehiculo) {
        this.vehiculoID = Objects.requireNonNull(vehiculoID);
        appendChange(new VehiculoAdded(vehiculoID,tipoVehiculo)).apply();

    }

    public void addSurtidor(SurtidorID surtidorID, Numero numero) {
//        this.surtidorID = Objects.requireNonNull(surtidorID);
        appendChange(new SurtidorAdded(surtidorID,numero)).apply();
    }

    public void PistaCreated(Nombre nombre){
        appendChange(new PistaCreated(nombre)).apply();
    }

    //PARA ENCAPSULAR LAS PROPIEDADES le sacas el get
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


//LO USA RAUL PARA OBETENER LAS FUNCIONES POR ID
///public Optional<Funcion>getFuncionPorId(FuncionId entityId){
//    return funciones()Set<Funcion>
//            .stream()Stream<Funcion>
//            .filter(funcion->funcion.identity().equals(entityId))
//            .findFirst();
//}
