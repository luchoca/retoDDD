package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.PistaCreated;
import AgreggatePista.Pista;
import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PistaID;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PistaCreatedUseCaseTest {
    @InjectMocks
    private PistaCreatedUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void executeUseCase() {
        Nombre nombre = new Nombre("Petrobras");
        PistaID pistaID = PistaID.of("fakePistaID");
        Pista pista = new Pista(pistaID, nombre);
        var event = new PistaCreated(nombre);
        event.setAggregateRootId("fakePistaID");

        when(repository.getEventsBy("fakePistaID")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.aggregateRootId())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var evento = (PistaCreated) events.get(0);

        assertEquals("Petrobras", evento.getNombre().value());

    }

}