package mxcx.com.orange.test;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HttpClientTest {

	@Test
	public void test() {
		
		String url = "http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/SynNotSimpleCase";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String,String>();
		params.add("bjr", "vich");
		params.add("bjrdh", "152567899911");
		params.add("jqdz", "string");
		params.add("jqnr", "1");
		params.add("jqsj", "2019-03-06 14:47:00");
		params.add("mapx", "string");
		params.add("mapy", "string");
		params.add("signature", "0509b85ebb1a7272dbcac7fa78662d32");
		params.add("ssdd", "深圳市公安局交通警察支队南山大队");
		params.add("timestamp", "1552040662");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,headers);
		ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
		System.out.println(response.getBody());
	}
	
}
