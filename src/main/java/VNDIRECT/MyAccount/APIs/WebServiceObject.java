package VNDIRECT.MyAccount.APIs;
import java.util.Map;

public class WebServiceObject {
    private String url;
    private String type;
    private String requestOption; // GET,POST,PUT,... for REST and SOAP,SOAP12 for SOAP
    private Map<String, String> headerMap;
    private String body;

    public WebServiceObject(String url, String type, String requestOption, Map<String, String> headerMap) {
        this.url = url;
        this.type = type;
        this.requestOption = requestOption;
        this.headerMap = headerMap;
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequestOption() {
        return requestOption;
    }

    public void setRequestOption(String requestOption) {
        this.requestOption = requestOption;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public void setHeaderMap(Map<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
