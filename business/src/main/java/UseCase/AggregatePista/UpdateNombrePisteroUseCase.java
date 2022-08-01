package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.UpdateNombrePistero;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;


public class UpdateNombrePisteroUseCase extends UseCase<RequestCommand<UpdateNombrePistero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateNombrePistero> updateNombrePisteroRequestCommand) {
        var command = updateNombrePisteroRequestCommand.getCommand();
        var pista = Pista.from(command.getPistaID(), repository().getEventsBy(command.getPistaID().value()));
        pista.updateNombrePistero(command.getPisteroID(), command.getNombre(), command.getPistaID());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}