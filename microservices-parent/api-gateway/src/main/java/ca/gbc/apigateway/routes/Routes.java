package ca.gbc.apigateway.routes;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.server.RequestPredicates;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.servlet.function.*;

@Configuration
@Slf4j
public class Routes {

    @Value("${services.product-url}")
    private String productServiceUrl;

    @Value("${services.order-url}")
    private String orderServiceUrl;


    @Bean
    public RouterFunction<ServerResponse> productServiceRoute() {

        log.info("initializing product service route with URL: {}", productServiceUrl);

        return GatewayRouterFunctions.route("product-service")
                .route(RequestPredicates.path("/api/product"), request -> {

                    log.info("recieved request for product-service: {}", request.uri());

                    try {
                        ServerResponse response = HandlerFunctions.http(productServiceUrl).handle(request);
                        log.info("Response status: {}", response.statusCode());
                        return response;
                    } catch (Exception e) {
                        log.error("error occurred while routing to: {}", e.getMessage(), e);
                        return ServerResponse.status(500).body("error occurred when routing to product-service");
                    }
                })
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        log.info("initializing order service route with URL: {}", orderServiceUrl);

        return GatewayRouterFunctions.route("order-service")
                .route(RequestPredicates.path("/api/order"), request -> {

                    log.info("recieved request for ordert-service: {}", request.uri());

                    try {
                        ServerResponse response = HandlerFunctions.http(orderServiceUrl).handle(request);
                        log.info("Response status: {}", response.statusCode());
                        return response;
                    } catch (Exception e) {
                        log.error("error occurred while routing to: {}", e.getMessage(), e);
                        return ServerResponse.status(500).body("error occurred when routing to order-service");
                    }
                })
                .build();

    }

}

