package AgreggatePista.EventsDomainPista.CommandsPista;

import AgreggatePista.ValueObjetPista.Numero;
import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.SurtidorID;
import co.com.sofka.domain.generic.Command;

public class RemoveSurtidor extends Command {
    private final SurtidorID surtidorID;
    private final Numero numero;

    private final PistaID pistaID;

    public RemoveSurtidor(SurtidorID surtidorID, Numero numero, PistaID pistaID) {
        this.surtidorID = surtidorID;
        this.numero = numero;
        this.pistaID = pistaID;
    }

    public SurtidorID getSurtidorID() {
        return surtidorID;
    }

    public PistaID getPistaID() {
        return pistaID;
    }

    public Numero getNumero() {
        return numero;
    }
}