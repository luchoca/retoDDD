package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PisteroID;
import co.com.sofka.domain.generic.DomainEvent;


public class NombrePisteroUpdated extends DomainEvent {
    private final PisteroID pisteroID;
    private final Nombre nombre;


    public NombrePisteroUpdated(PisteroID pisteroID, Nombre nombre) {
        super("sofka.pistero.nombrePisteroUpdated");
        this.pisteroID = pisteroID;
        this.nombre = nombre;
    }

    public PisteroID getPisteroID() {
        return pisteroID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}