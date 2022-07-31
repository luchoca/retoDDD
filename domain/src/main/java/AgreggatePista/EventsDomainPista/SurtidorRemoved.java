package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.Numero;
import AgreggatePista.ValueObjetPista.SurtidorID;
import co.com.sofka.domain.generic.DomainEvent;

public class SurtidorRemoved extends DomainEvent {
    private final SurtidorID surtidorID;
    private final Numero numero;

    public SurtidorRemoved(SurtidorID surtidorID, Numero numero) {
        super("sofka.surtidor.surtidorremoved");
        this.surtidorID = surtidorID;
//        this.wasDeleted = true;
        this.numero = numero;
    }

    public Numero getNumero() {
        return numero;
    }

    public SurtidorID getSurtidorID() {
        return surtidorID;
    }
}