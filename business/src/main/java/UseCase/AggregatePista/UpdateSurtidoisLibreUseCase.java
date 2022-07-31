package UseCase.AggregatePista;

import AgreggatePista.CommandsPista.UpdateSurtidorisLibre;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class UpdateSurtidoisLibreUseCase extends UseCase<RequestCommand<UpdateSurtidorisLibre>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateSurtidorisLibre> updateSurtidorisLibreRequestCommand) {
        var command = updateSurtidorisLibreRequestCommand.getCommand();
        Pista pista = Pista.from(command.getPistaID(), repository().getEventsBy(command.getPistaID().value()));
        pista.updateSurtidorisLibre(command.getSurtidorID(), command.getIsLibre());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}