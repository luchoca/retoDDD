package AgreggatePista.EventsDomainPista.CommandsPista;

import AgreggatePista.ValueObjetPista.*;
import co.com.sofka.domain.generic.Command;


public class UpdateNombrePistero extends Command {
    private final PistaID pistaID ;
    private final PisteroID pisteroID;
    private final Nombre nombre;

    public UpdateNombrePistero(PisteroID pisteroID, Nombre nombre,PistaID pistaID) {
        this.pistaID = pistaID;
        this.pisteroID = pisteroID;
        this.nombre = nombre;

    }

    public PisteroID getPisteroID() {
        return pisteroID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public PistaID getPistaID() {
        return pistaID;
    }
}