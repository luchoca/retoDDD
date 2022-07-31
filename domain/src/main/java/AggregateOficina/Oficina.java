package AggregateOficina;

import AggregateOficina.ValueObjetsOficina.OficinaID;
import co.com.sofka.domain.generic.AggregateEvent;

public class Oficina extends AggregateEvent<OficinaID> {
    public Oficina(OficinaID entityId) {
        super(entityId);
    }
}
