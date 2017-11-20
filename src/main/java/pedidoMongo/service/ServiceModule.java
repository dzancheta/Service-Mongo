package pedidoMongo.service;

import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daniel on 18/08/17.
 */
@Configuration
public class ServiceModule {

    @Bean
    ItemService itemService(MongoDatabase mongoDatabase){
        return new ItemService(mongoDatabase);
    }
    @Bean
    PedidoService pedidoService(MongoDatabase mongoDatabase){
        return new PedidoService(mongoDatabase);
    }
    @Bean
    public ClientService clientService(MongoDatabase mongoDatabase){
        return new ClientService(mongoDatabase);
    }

}
