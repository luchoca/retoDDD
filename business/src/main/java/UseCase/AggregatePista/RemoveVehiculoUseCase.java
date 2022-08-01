package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.RemoveVehiculo;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class RemoveVehiculoUseCase extends UseCase<RequestCommand<RemoveVehiculo>, ResponseEvents>{
    @Override
    public void executeUseCase(RequestCommand<RemoveVehiculo> removeVehiculoRequestCommand) {
        var command = removeVehiculoRequestCommand.getCommand();
        var pista = Pista.from(command.getPistaID(), repository().getEventsBy(command.getPistaID().value()));
        pista.removeVehiculo(command.getVehiculoID(), command.getTipoVehiculo(),command.getPistaID());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}
