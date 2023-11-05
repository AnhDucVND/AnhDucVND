package VNDIRECT.MyAccount.APIs;

import VNDIRECT.MyAccount.APIs.*;


import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicClassicHttpRequest;
import org.apache.hc.core5.http.message.BasicHeader;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class APIUtilities {
    public static CloseableHttpClient buildHttpClient() {
        HttpClientBuilder builder = HttpClientBuilder.create();
        return builder.build();
    }

    public static BasicClassicHttpRequest buildRequest(WebServiceObject request) {
        return buildRequest(request.getUrl(), request.getHeaderMap(), request.getRequestOption(), request.getBody());
    }

    public static BasicClassicHttpRequest buildRequest(String url, Map<String, String> headerMap, String requestType, String body) {
        Method method = Method.valueOf(requestType);

//        String contentTypeHeader = headerMap.get("Content-Type");
//        if (contentTypeHeader == null) contentTypeHeader = "";
//        ContentType type = ContentType.parse(contentTypeHeader);
        BasicClassicHttpRequest request = new BasicClassicHttpRequest(method, URI.create(url));
//        List<Header> headerList = new ArrayList<>();
//        headerMap.entrySet().forEach(entry -> {
//            headerList.add(new BasicHeader(entry.getKey(), entry.getValue()));
//        });
//        request.setHeaders(headerList.toArray(new Header[0]));
//        request.setEntity(new StringEntity(body, type));
        return request;
    }
    public static HttpClientResponseHandler<ResponseObject> getResponseHandler(long startRequestTimestamp) {
        return new HttpClientResponseHandler<ResponseObject>(){

            @Override
            public ResponseObject handleResponse(ClassicHttpResponse response) throws HttpException, IOException {
                return new ResponseObject(response, System.currentTimeMillis() - startRequestTimestamp);
            }

        };
    }

}
