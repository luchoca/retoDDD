package AgreggatePista.CommandsPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PistaID;
import co.com.sofka.domain.generic.Command;


public class RemovePista extends Command {
    private final PistaID pistaID;
    private final Nombre nombre;

    public RemovePista(PistaID pistaID, Nombre nombre) {
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