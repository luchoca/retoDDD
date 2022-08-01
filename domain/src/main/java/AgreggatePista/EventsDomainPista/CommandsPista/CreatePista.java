package AgreggatePista.EventsDomainPista.CommandsPista;

import AgreggatePista.ValueObjetPista.*;
import co.com.sofka.domain.generic.Command;

public class CreatePista extends Command {
    private final PistaID pistaID;
    private final Nombre nombre;

    public CreatePista(PistaID pistaID, Nombre nombre) {
        this.pistaID = pistaID;
        this.nombre = nombre;
    }
    public PistaID getPistaID() {
        return pistaID;
    }

    public Nombre getNombre() {
        return nombre;
    }

}
