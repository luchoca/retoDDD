package AgreggatePista.EntitiesPista;

import AgreggatePista.ValueObjetPista.Numero;
import AgreggatePista.ValueObjetPista.SurtidorID;
import AgreggatePista.ValueObjetPista.isLibre;
import co.com.sofka.domain.generic.Entity;

public class Surtidor extends Entity<SurtidorID> {
    public static SurtidorID surtidorID;
    public static Numero numero;
    public static isLibre IsLibre;

    public Surtidor(SurtidorID surtidorID, Numero numero) {
        super(surtidorID);
        this.surtidorID = surtidorID;
        this.numero = numero;
    }
//    public void AddSurtidor(SurtidorID surtidorID, Numero numero) {
//        this.surtidorID = Objects.requireNonNull(surtidorID);
//        this.numero = Objects.requireNonNull(numero);
//    }
    public  SurtidorID getSurtidorID() {
        return surtidorID;
    }
    public  Numero getNumero() {
        return numero;
    }
}