package AgreggatePista.CommandsPista;

import AgreggatePista.ValueObjetPista.Numero;
import AgreggatePista.ValueObjetPista.SurtidorID;
import co.com.sofka.domain.generic.Command;

public class RemoveSurtidor extends Command {
    private final SurtidorID surtidorID;
    private final Numero numero;

    public RemoveSurtidor(SurtidorID surtidorID, Numero numero) {
        this.surtidorID = surtidorID;
        this.numero = numero;
    }

    public SurtidorID getSurtidorID() {
        return surtidorID;
    }

    public Numero getNumero() {
        return numero;
    }
}