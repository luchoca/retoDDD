package UseCase.AggregatePista;

import AgreggatePista.EventsDomainPista.CommandsPista.CreatePista;
import AgreggatePista.EventsDomainPista.PistaCreated;
import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PistaID;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatePistaUseCaseTest {
    CreatePistaUseCase useCase;
    @BeforeEach
    public void setUp() {
        useCase = new CreatePistaUseCase();
    }

    @Test
    public void CreatePistaSuccessfully() {

        PistaID pistaID = PistaID.of("fakePistaID");
        Nombre nombre = new Nombre("holaquetal");
        CreatePista command = new CreatePista(pistaID, nombre);
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        PistaCreated pistaCreated = (PistaCreated) domainEvents.get(0);
        assertEquals("fakePistaID", pistaCreated.aggregateRootId());
        assertEquals("holaquetal", pistaCreated.getNombre().value());

    }

}