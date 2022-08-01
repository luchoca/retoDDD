package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.RemovePistero;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class RemovePisteroUseCase extends UseCase<RequestCommand<RemovePistero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemovePistero> removePisteroRequestCommand) {
        var command = removePisteroRequestCommand.getCommand();
        var pista = Pista.from(command.getPistaID(), repository().getEventsBy(command.getPistaID().value()));
        pista.removePistero(command.getPisteroID(), command.getNombre(), command.getPistaID());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}