package UseCase.AggregatePista;

import AgreggatePista.CommandsPista.CreatePista;
import AgreggatePista.Pista;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CreatePistaUseCase extends UseCase<RequestCommand<CreatePista>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreatePista> createPistaRequestCommand) {
        var command = createPistaRequestCommand.getCommand();

        var pista = new Pista(command.getPistaID(), command.getNombre());

        emit().onResponse(new ResponseEvents(pista.getUncommittedChanges()));
    }

}
