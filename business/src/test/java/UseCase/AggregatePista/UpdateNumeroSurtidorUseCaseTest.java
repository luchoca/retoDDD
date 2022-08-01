package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.UpdateNumeroSurtidor;
import AgreggatePista.EventsDomainPista.NumeroSurtidorUpdated;
import AgreggatePista.EventsDomainPista.PistaCreated;
import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.Numero;
import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.SurtidorID;
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
class UpdateNumeroSurtidorUseCaseTest {
    @InjectMocks
    private UpdateNumeroSurtidorUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void updateNumeroSurtidorSuccessfully() {
        SurtidorID surtidorID = SurtidorID.of("fakeSurtidorID");
        Numero numero = new Numero(15);
        PistaID pistaID = PistaID.of("fakePistaID");
        var command = new UpdateNumeroSurtidor(pistaID, surtidorID, numero);

        when(repository.getEventsBy("fakePistaID")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPistaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (NumeroSurtidorUpdated)events.get(0);
        assertEquals(15, event.getNumero().value());
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