package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.Numero;
import AgreggatePista.ValueObjetPista.SurtidorID;
import co.com.sofka.domain.generic.DomainEvent;

public class SurtidorAdded extends DomainEvent {

    private final Numero numero;
    private final SurtidorID surtidorID;

    public SurtidorAdded(SurtidorID surtidorID,Numero numero) {
        super("sofka.surtidor.surtidorcreated");
        this.surtidorID = surtidorID;
        this.numero = numero;
    }

    public SurtidorID getSurtidorID() {
        return surtidorID;
    }

    public Numero getNumero() {
        return numero;
    }
}

//
//    //    public PisteroID getPisteroID() {
////        return pisteroID;
////    }
//// es como un DTO para transportar objetos nada mas / objeto plano
//    public Nombre getNombre() {
//        return nombre;
//    }
//
//    public PisteroID getPisteroID() {
//        return null;
//    }
//}