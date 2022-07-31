package AgreggatePista.CommandsPista;

import AgreggatePista.ValueObjetPista.PistaID;
import AgreggatePista.ValueObjetPista.SurtidorID;
import AgreggatePista.ValueObjetPista.isLibre;
import co.com.sofka.domain.generic.Command;

public class UpdateSurtidorisLibre extends Command {
    private final PistaID pistaID;
    private final SurtidorID surtidorID;
    private final isLibre IsLibre;

    public UpdateSurtidorisLibre(PistaID pistaID, SurtidorID surtidorID, isLibre IsLibre) {
        this.pistaID = pistaID;
        this.surtidorID = surtidorID;
        this.IsLibre = IsLibre;
    }


    public SurtidorID getSurtidorID() {
        return surtidorID;
    }

    public isLibre getIsLibre() {
        return IsLibre;
    }

    public PistaID getPistaID() {
        return null;
    }
}