package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.AddPistero;
import AgreggatePista.EventsDomainPista.PistaCreated;
import AgreggatePista.EventsDomainPista.PisteroAdded;
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
class AddPisteroUseCaseTest {

    @InjectMocks
    private AddPisteroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addPisteroToPistaSuccessfully() {
        PistaID pistaID = PistaID.of("fakePistaID");
        Nombre nombre = new Nombre("PisteroNombre");
        PisteroID pisteroID = PisteroID.of("fakePisteroID");
        var command = new AddPistero(nombre, pisteroID,pistaID);

        when(repository.getEventsBy("fakePistaID")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPistaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (PisteroAdded) events.get(0);
        assertEquals("PisteroNombre", event.getNombre().value());
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