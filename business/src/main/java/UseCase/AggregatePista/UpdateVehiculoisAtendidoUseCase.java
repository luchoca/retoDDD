package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.UpdateVehiculoisAtendido;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class UpdateVehiculoisAtendidoUseCase extends UseCase<RequestCommand<UpdateVehiculoisAtendido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateVehiculoisAtendido> updateVehiculoisAtendidoRequestCommand) {
        var command = updateVehiculoisAtendidoRequestCommand.getCommand();
        Pista pista = Pista.from(command.getPistaID(), repository().getEventsBy(command.getPistaID().value()));
        pista.updateVehiculoisAtendido(command.getVehiculoID(), command.getIsAtendido());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}
