package AggregateMostrador;

import AggregateMostrador.ValueObjetsMostrador.MostradorID;
import co.com.sofka.domain.generic.AggregateEvent;

public class Mostrador extends AggregateEvent<MostradorID> {
    public Mostrador(MostradorID entityId) {
        super(entityId);
    }
}
