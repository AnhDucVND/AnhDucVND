package VNDIRECT.MyAccount.APIs;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class ResponseObject {
    private int statusCode;
    private String reasonPhrase;
    private Map<String, String> responseHeaders;
    private String responseBody;
    private int responseBodySize;
    private long requestTime;

    public ResponseObject(ClassicHttpResponse response, long requestTime) throws IOException, ProtocolException {
        this.statusCode = response.getCode();
        this.reasonPhrase = response.getReasonPhrase();

        if (response.getEntity() != null) {
            byte[] byteArr = EntityUtils.toByteArray(response.getEntity());
            ContentType ct = ContentType.parse(response.getEntity().getContentType());
            Charset charset = null;
            if (ct != null) charset = ct.getCharset();
            if (charset == null) charset = Charset.defaultCharset();
            this.responseBody = new String(byteArr, charset);
            this.responseBodySize = byteArr.length;
        } else {
            this.responseBody = "";
            this.responseBodySize = 0;
        }

        this.requestTime = requestTime;
        this.responseHeaders = new HashMap<String, String>();
        for (Header header: response.getHeaders()) {
            this.responseHeaders.put(header.getName(), header.getValue());
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Map<String, String> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public int getResponseBodySize() {
        return responseBodySize;
    }

    public void setResponseBodySize(int responseBodySize) {
        this.responseBodySize = responseBodySize;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }
}
