package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.UpdateNombrePistero;
import AgreggatePista.EventsDomainPista.NombrePisteroUpdated;
import AgreggatePista.EventsDomainPista.PistaCreated;
import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.PisteroID;
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
class UpdateNombrePisteroUseCaseTest {
    @InjectMocks
    private UpdateNombrePisteroUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void updateNombrePisteroSuccessfully() {
        PisteroID pisteroID = PisteroID.of("fakePisteroID");
        Nombre nombre = new Nombre("NuevoNombrePistero");
        PistaID pistaID = PistaID.of("fakePistaID");
        var command = new UpdateNombrePistero(pisteroID, nombre,pistaID);

        when(repository.getEventsBy("fakePistaID")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPistaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (NombrePisteroUpdated)events.get(0);
        assertEquals("NuevoNombrePistero", event.getNombre().value());
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