package VNDIRECT.MyAccount.APIs;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;


public class DemoAPI {
    public static void main(String[] args) {
        try {
            // Tạo một phiên bản của CloseableHttpClient
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Tạo yêu cầu HTTP GET
            HttpGet httpGet = new HttpGet("https://pokeapi.co/api/v2/version/1/");

            // Tạo yêu cầu HTTP GET
            HttpPost httpPost = new HttpPost("https://api.example.com/data");




            // Thực hiện yêu cầu và lấy phản hồi
            HttpResponse response = httpClient.execute(httpGet);

            // Trích xuất nội dung phản hồi dưới dạng chuỗi
            String responseContent = EntityUtils.toString(((CloseableHttpResponse) response).getEntity());

            // Xử lý dữ liệu phản hồi
            System.out.println("Mã phản hồi: " + response.getCode());
            System.out.println("Nội dung phản hồi:\n" + responseContent);

            // Đóng HttpClient
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
