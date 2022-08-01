package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.PisteroAdded;
import AgreggatePista.Pista;
import AgreggatePista.ValueObjetPista.PistaID;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class PisteroAddedUseCase extends UseCase<TriggeredEvent<PisteroAdded>, ResponseEvents>{
    @Override
    public void executeUseCase(TriggeredEvent<PisteroAdded> pisteroAddedTriggeredEvent) {
        var event = pisteroAddedTriggeredEvent.getDomainEvent();
        var pista = Pista.from(PistaID.of(event.aggregateRootId()),repository().getEventsBy(event.aggregateRootId()));
        pista.PisteroCreatedMessage("Se creo un Pistero");
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}