package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.PistaCreated;
import AgreggatePista.Pista;
import AgreggatePista.ValueObjetPista.PistaID;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class PistaCreatedUseCase extends UseCase<TriggeredEvent<PistaCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PistaCreated> pistaCreatedTriggeredEvent) {
        var event = pistaCreatedTriggeredEvent.getDomainEvent();
        var pista = Pista.from(PistaID.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
//        Nombre nombre = new Nombre("Petrobras");
        pista.PistaCreated(event.getNombre());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}


//public class NotifyCinemaRoomCreatedUseCase extends UseCase<TriggeredEvent<CinemaRoomCreated>, ResponseEvents> {
//
//    @Override
//    public void executeUseCase(TriggeredEvent<CinemaRoomCreated> cinemaRoomTriggeredEvent) {
//        var event = cinemaRoomTriggeredEvent.getDomainEvent();
//        var cinemaRoom = CinemaRoom.from(CinemaRoomId.of(event.aggregateRootId()), repository().getEventsBy(event.aggregateRootId()));
//        cinemaRoom.notifyCinemaRoomCreated("Empezó la película");
//        emit().onResponse(new ResponseEvents(cinemaRoom.getUncommittedChanges()));
//    }
//}