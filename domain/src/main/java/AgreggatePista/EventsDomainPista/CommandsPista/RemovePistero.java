package AgreggatePista.EventsDomainPista.CommandsPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.PisteroID;
import co.com.sofka.domain.generic.Command;


public class RemovePistero extends Command {
    private final PisteroID pisteroID;
    private final Nombre nombre;
    private final PistaID pistaID;
    public RemovePistero(PisteroID pisteroID, Nombre nombre, PistaID pistaID) {
        this.pisteroID = pisteroID;
        this.nombre = nombre;
        this.pistaID = pistaID;
    }

    public PisteroID getPisteroID() {
        return pisteroID;
    }

    public PistaID getPistaID() {
        return pistaID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}