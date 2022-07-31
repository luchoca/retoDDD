package AgreggatePista.CommandsPista;

import AgreggatePista.ValueObjetPista.Numero;
import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.SurtidorID;
import co.com.sofka.domain.generic.Command;

public class UpdateNumeroSurtidor extends Command {
    private final PistaID pistaID;
    private final SurtidorID surtidorID;
    private final Numero numero;

    public UpdateNumeroSurtidor(PistaID pistaID, SurtidorID surtidorID, Numero numero) {
        this.pistaID = pistaID;
        this.surtidorID = surtidorID;
        this.numero = numero;
    }

    public SurtidorID getSurtidorID() {
        return surtidorID;
    }

    public Numero getNumero() {
        return numero;
    }
    public PistaID getPistaID() {
        return null;
    }
}