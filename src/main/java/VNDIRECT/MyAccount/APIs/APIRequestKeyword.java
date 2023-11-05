package VNDIRECT.MyAccount.APIs;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.message.BasicClassicHttpRequest;

import java.io.IOException;

public class APIRequestKeyword {

    public ResponseObject sendAPIRequest(WebServiceObject request) throws IOException {
        try (
                CloseableHttpClient client = APIUtilities.buildHttpClient();
        ) {
            BasicClassicHttpRequest requestor = APIUtilities.buildRequest(request);
            HttpClientResponseHandler<ResponseObject> responseHandler = APIUtilities.getResponseHandler(System.currentTimeMillis());
            return client.execute(requestor, responseHandler);
        }
    }

    public String getResponseHeader(ResponseObject response, String header) {
        return response.getResponseHeaders().get(header);
    }

    public Integer getResponseStatusCode(ResponseObject response) {
        return response.getStatusCode();
    }

    public String getResponseBody(ResponseObject response) {
        return response.getResponseBody();
    }
}
