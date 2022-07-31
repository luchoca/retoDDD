package AgreggatePista.CommandsPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PisteroID;
import co.com.sofka.domain.generic.Command;


public class RemovePistero extends Command {
    private final PisteroID pisteroID;
    private final Nombre nombre;

    public RemovePistero(PisteroID pisteroID, Nombre nombre) {
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