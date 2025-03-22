package in.kunal.Service;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.kunal.Bindings.QuotesAPI;

@Service
public class DashboardServiceImp  implements DashboardService
{
	
	private  String QUOTE_URl = "https://dummyjson.com/quotes/random";
	
	public QuotesAPI getQuotesApi() {
		RestTemplate rs = new RestTemplate();
		ResponseEntity<QuotesAPI> entity = rs.getForEntity(QUOTE_URl, QuotesAPI.class);
		QuotesAPI body = entity.getBody();
		System.out.println(body);
		return body;
	}

}
