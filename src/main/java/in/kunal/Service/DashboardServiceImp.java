package in.kunal.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.kunal.Bindings.QuotesAPI;

@Service
public class DashboardServiceImp  implements DashboardService
{
	
	private String QUOTES_URL = "http://dummyjson.com/quotes/random";

	public QuotesAPI getQuotesApi() {
		RestTemplate rs = new RestTemplate();
		ResponseEntity<QuotesAPI> entity = rs.getForEntity(QUOTES_URL, QuotesAPI.class);
		QuotesAPI body = entity.getBody();
		return body;
	}

}
