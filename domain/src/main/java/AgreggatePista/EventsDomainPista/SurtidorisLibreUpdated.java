package AgreggatePista.EventsDomainPista;

import AgreggatePista.ValueObjetPista.SurtidorID;
import AgreggatePista.ValueObjetPista.isLibre;
import co.com.sofka.domain.generic.DomainEvent;


public class SurtidorisLibreUpdated extends DomainEvent {
    private final isLibre IsLibre;
    public SurtidorisLibreUpdated (SurtidorID surtidorID, isLibre IsLibre){
        super ("sofka.surtidor.suritdorisLibreUpdated");
        this.IsLibre = IsLibre;
    }

    public isLibre getIsLibre() {
        return IsLibre;
    }
}