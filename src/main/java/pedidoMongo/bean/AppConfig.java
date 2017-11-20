package pedidoMongo.bean;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pedidoMongo.facade.FacadeItem;
import pedidoMongo.service.ItemService;
import pedidoMongo.service.PedidoService;

/**
 * Created by daniel on 14/08/17.
 */
@Configuration
public class AppConfig {
    @Bean
    public MongoDatabase mongoDatabase(){
        MongoClient mongoClient = new MongoClient();
        return mongoClient.getDatabase("test");
    }
    @Bean
    public FacadeItem facadeItem(PedidoService pedidoService,
                                 ItemService itemService){
        return new FacadeItem(pedidoService, itemService);
    }

}
