package AgreggatePista.CommandsPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.PisteroID;
import co.com.sofka.domain.generic.Command;

public class AddPistero extends Command {
    private final Nombre nombre;
    private final PisteroID pisteroID;
    private final PistaID pistaID;
    public AddPistero(Nombre nombre, PisteroID pisteroID, PistaID pistaID) {
        this.nombre = nombre;
        this.pisteroID = pisteroID;
        this.pistaID = pistaID;
    }
    public Nombre getNombre() {
        return nombre;
    }
    public PisteroID getPisteroID() {
        return pisteroID;
    }
    public PistaID getPistaID() {
        return pistaID;
    }
}
