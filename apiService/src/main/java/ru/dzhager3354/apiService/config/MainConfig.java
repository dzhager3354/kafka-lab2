package ru.dzhager3354.apiService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import ru.dzhager3354.apiService.client.PlayerDataClient;
import ru.dzhager3354.apiService.client.PlayerClient;

@Configuration
public class MainConfig {
    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory() {
        RestClient restClient = RestClient.builder().baseUrl("back-service:8090").build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        return HttpServiceProxyFactory.builderFor(adapter).build();
    }

    @Bean
    public PlayerClient playerRepository() {
        return httpServiceProxyFactory().createClient(PlayerClient.class);
    }

    @Bean
    public PlayerDataClient playerDataRepository() {
        return httpServiceProxyFactory().createClient(PlayerDataClient.class);
    }
}
