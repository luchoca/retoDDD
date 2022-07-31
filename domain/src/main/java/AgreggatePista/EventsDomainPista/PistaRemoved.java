package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PistaID;
import co.com.sofka.domain.generic.DomainEvent;


public class PistaRemoved extends DomainEvent {
    private final PistaID pistaID;
    private final Nombre nombre;


    public PistaRemoved(PistaID pistaID, Nombre nombre) {
        super("sofka.pista.pistaremoved");
        this.pistaID = pistaID;
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public PistaID getPistaID() {
        return pistaID;
    }
}