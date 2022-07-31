package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.*;
import co.com.sofka.domain.generic.DomainEvent;

public class  PistaCreated extends DomainEvent {
    private final Nombre nombre;
    public PistaCreated(Nombre nombre) {
        super("sofka.pista.pistacreated");
        this.nombre = nombre;
    }
    public Nombre getNombre() {
        return nombre;
    }

}
