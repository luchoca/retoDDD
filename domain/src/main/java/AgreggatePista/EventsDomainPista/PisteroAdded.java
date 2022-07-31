package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PisteroID;
import co.com.sofka.domain.generic.DomainEvent;

public class PisteroAdded extends DomainEvent {
    private final Nombre nombre;
    //CONSTRUCTOR
    public PisteroAdded(Nombre nombre) {
        super("sofka.pistero.pisteroadded");
        this.nombre = nombre;
    }
    public Nombre getNombre() {
        return nombre;
    }
    public PisteroID getPisteroID() {
        return null;
    }
}
