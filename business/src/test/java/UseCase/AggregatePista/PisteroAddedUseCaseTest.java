package UseCase.AggregatePista;

import AgreggatePista.EntitiesPista.Pistero;
import AgreggatePista.EventsDomainPista.PisteroAdded;
import AgreggatePista.EventsDomainPista.PisteroCreatedMessage;
import AgreggatePista.ValueObjetPista.Nombre;
import AgreggatePista.ValueObjetPista.PisteroID;
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
    class PisteroAddedUseCaseTest{
        @InjectMocks
        private PisteroAddedUseCase useCase;

        @Mock
        private DomainEventRepository repository;

        @Test
        void executeUseCase() {
            PisteroID pisteroID = PisteroID.of("fakePisteroID");
            Nombre nombre = new Nombre("NombrePistero");
            Pistero pistero = new Pistero(pisteroID);


            var event = new PisteroAdded(nombre);
            event.setAggregateRootId(pisteroID.value());

            when(repository.getEventsBy("fakePisteroID")).thenReturn(List.of(event));
            useCase.addRepository(repository);

            var events = UseCaseHandler.getInstance()
                    .setIdentifyExecutor(pisteroID.value())
                    .syncExecutor(useCase, new TriggeredEvent<>(event))
                    .orElseThrow()
                    .getDomainEvents();

            var pisterocreado = (PisteroCreatedMessage) events.get(0);

            assertEquals("Se creo un Pistero", pisterocreado.getMessage());

        }

    }





