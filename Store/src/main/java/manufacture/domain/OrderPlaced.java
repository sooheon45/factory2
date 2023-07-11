package manufacture.domain;

import java.util.*;
import lombok.*;
import manufacture.domain.*;
import manufacture.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;

    public OrderPlaced(Store aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
