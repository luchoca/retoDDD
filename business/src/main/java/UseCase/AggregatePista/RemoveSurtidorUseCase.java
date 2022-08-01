package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.RemoveSurtidor;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;



public class RemoveSurtidorUseCase extends UseCase<RequestCommand<RemoveSurtidor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemoveSurtidor> removeSurtidorRequestCommand) {
        var command = removeSurtidorRequestCommand.getCommand();
        var pista = Pista.from(command.getPistaID(), repository().getEventsBy(command.getPistaID().value()));
        pista.removeSurtidor(command.getSurtidorID(), command.getNumero(),command.getPistaID());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}