package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.Numero;
import AgreggatePista.ValueObjetPista.SurtidorID;
import co.com.sofka.domain.generic.DomainEvent;


public class NumeroSurtidorUpdated extends DomainEvent {
    private final SurtidorID surtidorID;
    private final Numero numero;


    public NumeroSurtidorUpdated (SurtidorID surtidorID, Numero numero){
        super ("sofka.surtidor.numeroSurtidorUpdated");
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
