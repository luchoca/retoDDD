package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.AddSurtidor;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AddSurtidorUseCase extends UseCase<RequestCommand<AddSurtidor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddSurtidor> addSurtidorRequestCommand) {
        var command = addSurtidorRequestCommand.getCommand();
        var pista = Pista.from(command.getPistaID(),repository().getEventsBy(command.getPistaID().value()));
        pista.addSurtidor(command.getSurtidorID(),command.getNumero());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}
