package UseCase.AggregatePista;

import AgreggatePista.CommandsPista.AddVehiculo;
import AgreggatePista.EventsDomainPista.PistaCreated;
import AgreggatePista.EventsDomainPista.VehiculoAdded;
import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.TipoVehiculo;
import AgreggatePista.ValueObjetPista.VehiculoID;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class AddVehiculoUseCaseTest {

    @InjectMocks
    private AddVehiculoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addVehiculoToPistaSuccessfully() {
        PistaID pistaID = PistaID.of("fakePistaID");
        TipoVehiculo tipoVehiculo = new TipoVehiculo("camioneta");
        VehiculoID vehiculoID = VehiculoID.of("fakeSurtidorID");
        var command = new AddVehiculo(pistaID, vehiculoID, tipoVehiculo);

        when(repository.getEventsBy("fakePistaID")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPistaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (VehiculoAdded) events.get(0);
        assertEquals("camioneta", event.getTipoVehiculo().value());
        assertEquals("fakeSurtidorID", event.getVehiculoID().value());
        Mockito.verify(repository).getEventsBy("fakePistaID");
    }

    private List<DomainEvent> history() {
        PistaID pistaID = PistaID.of("fakePistaID");
        Nombre nombre = new Nombre("Petrobras");
        var event = new PistaCreated(nombre);
        event.setAggregateRootId(pistaID.value());
        return List.of(event);
    }

}