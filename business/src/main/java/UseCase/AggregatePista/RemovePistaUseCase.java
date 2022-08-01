package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.RemovePista;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class RemovePistaUseCase extends UseCase<RequestCommand<RemovePista>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemovePista> removePistaRequestCommand) {
        var command = removePistaRequestCommand.getCommand();
        var pista = Pista.from(command.getPistaID(), repository().getEventsBy(command.getPistaID().value()));
        pista.removePista(command.getPistaID(), command.getNombre());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}