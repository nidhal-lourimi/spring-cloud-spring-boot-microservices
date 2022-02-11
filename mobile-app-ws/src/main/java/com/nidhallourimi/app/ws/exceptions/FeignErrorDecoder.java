package com.nidhallourimi.app.ws.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder  implements ErrorDecoder  {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                //do something
                //return new BadRequestException();
                break;
            case 404: {
                if (methodKey.contains("getAlbums"))
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Users albums are not found");
                break;
            }
            default:
                return new Exception(response.reason());
        }
        return null;
    }
}
