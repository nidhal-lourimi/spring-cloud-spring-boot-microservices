package com.nidhallourimi.app.ws.data;

import com.nidhallourimi.app.ws.model.response.AlbumResponseModel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "albums-ws")
public interface AlbumsServiceClient {
    @GetMapping("/users/{id}/albums")
    @Retry(name = "albums-ws")
    @CircuitBreaker ( name = "albums-ws",fallbackMethod ="getAlbumsFallBack" )
    public List<AlbumResponseModel> getAlbums(@PathVariable String id);
    default List<AlbumResponseModel> getAlbumsFallBack(String id,Throwable exception){
        System.out.println("Param"+id);
        System.out.println("exception took place: "+ exception.getMessage());
        return new ArrayList<>();

    }

}
