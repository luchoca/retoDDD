package AgreggatePista.EntitiesPista;

import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PisteroID;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Pistero extends Entity<PisteroID> {
    public static PisteroID pisteroID;
    public static Nombre nombre;

    public Pistero(PisteroID pisteroID, Nombre nombre) {
        super(pisteroID);
        this.pisteroID = pisteroID;
        this.nombre = nombre;
    }
    public Pistero(PisteroID pisteroID) {
        super(pisteroID);
    }

    public void AddPistero(PisteroID pisteroID, Nombre nombre) {
        this.pisteroID = Objects.requireNonNull(pisteroID);
        this.nombre = Objects.requireNonNull(nombre);
    }
    public static PisteroID getPisteroID() {
        return pisteroID;
    }
    public static Nombre getNombre() {
        return nombre;
    }
}
