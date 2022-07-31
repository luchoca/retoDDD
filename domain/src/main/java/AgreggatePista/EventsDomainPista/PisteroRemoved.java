package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PisteroID;
import co.com.sofka.domain.generic.DomainEvent;

public class PisteroRemoved extends DomainEvent {
    private final PisteroID pisteroID;
    private final Nombre nombre;

    public PisteroRemoved(PisteroID pisteroID, Nombre nombre) {
        super("sofka.pistero.pisteroremoved");
        this.pisteroID = pisteroID;
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public PisteroID getPisteroID() {
        return pisteroID;
    }
}