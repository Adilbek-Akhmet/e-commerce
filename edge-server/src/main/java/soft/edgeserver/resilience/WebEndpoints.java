package soft.edgeserver.resilience;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class WebEndpoints {

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/fallback", request ->
                        ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body(Mono.just("Service is unavailable"), String.class))
                .POST("/fallback", request ->
                        ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build())
                .build();
    }

}
