package manufacture.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import manufacture.StoreApplication;
import org.springframework.context.ApplicationContext;

@Entity
@Table(name = "Store_table")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    public static StoreRepository repository() {
        StoreRepository storeRepository = applicationContext()
            .getBean(StoreRepository.class);
        return storeRepository;
    }

    public static ApplicationContext applicationContext() {
        return StoreApplication.applicationContext;
    }
}
