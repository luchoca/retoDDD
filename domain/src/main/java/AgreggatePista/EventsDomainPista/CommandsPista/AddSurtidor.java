package AgreggatePista.EventsDomainPista.CommandsPista;

import AgreggatePista.ValueObjetPista.Numero;
import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.SurtidorID;
import co.com.sofka.domain.generic.Command;

public class AddSurtidor extends Command {
    private final Numero numero;
    private final SurtidorID surtidorID;
    private final PistaID pistaID;


    public AddSurtidor(Numero numero, SurtidorID surtidorID, PistaID pistaID) {
        this.numero = numero;
        this.surtidorID = surtidorID;
        this.pistaID = pistaID;
    }

    public PistaID getPistaID() {
        return pistaID;
    }

    public Numero getNumero() {
        return numero;
    }

    public SurtidorID getSurtidorID() {
        return surtidorID;
    }
}