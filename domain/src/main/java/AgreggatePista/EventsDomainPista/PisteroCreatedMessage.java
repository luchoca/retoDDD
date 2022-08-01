package AgreggatePista.EventsDomainPista;

import co.com.sofka.domain.generic.DomainEvent;

public class PisteroCreatedMessage extends DomainEvent {
    private String message;
    public PisteroCreatedMessage(String message) {
        super("sofka.pistero.pisterocreatedmessage");
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
