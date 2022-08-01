package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.UpdateNumeroSurtidor;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;


public class UpdateNumeroSurtidorUseCase extends UseCase<RequestCommand<UpdateNumeroSurtidor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateNumeroSurtidor> updateNumeroSurtidorRequestCommand) {
        var command = updateNumeroSurtidorRequestCommand.getCommand();
        var pista = Pista.from(command.getPistaID(), repository().getEventsBy(command.getPistaID().value()));
        pista.updateNumeroSurtidor(command.getSurtidorID(), command.getNumero(), command.getPistaID());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}