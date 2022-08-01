package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.AddVehiculo;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AddVehiculoUseCase extends UseCase<RequestCommand<AddVehiculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddVehiculo> addVehiculoRequestCommand) {
        var command = addVehiculoRequestCommand.getCommand();
        var pista = Pista.from(command.getPistaID(),repository().getEventsBy(command.getPistaID().value()));
        pista.addVehiculo(command.getVehiculoID(),command.getTipoVehiculo());
        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }
}