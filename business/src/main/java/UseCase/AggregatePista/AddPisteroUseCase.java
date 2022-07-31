package UseCase.AggregatePista;

import AgreggatePista.CommandsPista.AddPistero;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AddPisteroUseCase extends UseCase<RequestCommand<AddPistero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddPistero> addPisteroRequestCommand) {
        var command = addPisteroRequestCommand.getCommand();
        var pista = Pista.from(command.getPistaID(), repository().getEventsBy(command.getPistaID().value()));
        pista.addPistero(command.getPisteroID(), command.getNombre());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}
