package mxcx.com.orange.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import mxcx.com.orange.vo.JsonConvertVo;
import mxcx.com.orange.vo.OpenApiResult;
import mxcx.com.orange.vo.UserDto;

public class HttpClientTest {

	@Test
	public void test() {

		String url = "http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/SynNotSimpleCase";
		long in = System.currentTimeMillis()/1000;
		System.out.println(in);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("bjr", "vich");
		params.add("bjrdh", "152567899911");
		params.add("jqdz", "string");
		params.add("jqnr", "1");
		params.add("jqsj", "2019-03-06 14:47:00");
		params.add("mapx", "string");
		params.add("mapy", "string");
		params.add("signature", "9f58206f17c015ea8ef94309b59d4d7e");
		params.add("ssdd", "44011518");
		params.add("timestamp", "1553661702");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
		String json = response.getBody();
		System.out.println(json);
		JsonConvertVo<String> vo = JSON.parseObject(json,new TypeReference<JsonConvertVo<String>>(){});
		System.out.println(vo.toString());
	}

	@Test
	public void test1() {
		try {
			String url = "http://www.baidu.com";
			RestTemplate restTemplate = new RestTemplate();
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.TEXT_PLAIN);
//			restTemplate.getForObject(url, String.class);
//			HttpEntity entity = new HttpEntity<>(headers);
//			restTemplate.postForEntity(url,entity,String.class);
			ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class, "111111");
			System.out.println(forEntity.getBody());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void test2() {
		try {
			URL url = new URL("http://www.baidu.com");
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader bufr = new BufferedReader(isr);
			String str;
			while ((str = bufr.readLine()) != null) {
				System.out.println(str);
			}
			bufr.close();
			isr.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test33() {
		try {
			URL url = new URL("http://www.baidu.com?key=1");
			URLConnection URLconnection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
			int responseCode = httpConnection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				System.err.println("成功");
				InputStream in = httpConnection.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader bufr = new BufferedReader(isr);
				String str;
				while ((str = bufr.readLine()) != null) {
					System.out.println(str);
				}
				bufr.close();
			} else {
				System.err.println("失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String url = "http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/UploadPDF";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		File fileLocal = getFile();

		FileSystemResource resource = new FileSystemResource(fileLocal);
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("caseNo", "54321");
		params.add("file", resource);
		params.add("id", "1552979099");
		params.add("timestamp", "1552979099");
		params.add("signature", "fdcfe6e9803f95721da9e1e7a9dd8fd5");
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(params, headers);
		ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
		System.out.println(response.getBody());
		while (true) {

		}
	}

	public static File getFile() {
		File file = new File("D:/pdf/11.pdf");
		byte[] bytes = null;
		try {
			File target = new File("D:/pdf/J2EE.pdf");
			bytes = FileUtils.readFileToByteArray(target);
			FileUtils.writeByteArrayToFile(file, bytes);

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return file;
	}

	@Test
	public void testAsss() {

		Map<String, String> params = new HashMap<>();
		String timestap = String.valueOf(System.currentTimeMillis() / 1000);
		System.out.println("时间戳。。。" + timestap);
		params.put("caseNo", "54321");
		params.put("id", "1552976905");
		params.put("timestamp", "1552976905");
		params.put("signature", "3c1725f82d805aedbcbd31179b513fdb");
		File flie = new File("D:/pdf/Helloworld.PDF");
		try {
			org.apache.http.HttpEntity entity = upload("file", flie, params);
			System.out.println(entity.toString());

			InputStream content = entity.getContent();
			StringBuilder sb = new StringBuilder();
			String line;

			BufferedReader br = new BufferedReader(new InputStreamReader(content));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			String str = sb.toString();
			System.out.println("********打印： " + str);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public org.apache.http.HttpEntity upload(String file, File target, Map<String, String> params)
			throws ClientProtocolException, IOException {
		String serverUrl = "http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/UploadPDF";
		HttpPost httpPost = new HttpPost(serverUrl);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000000)
				.build();
		httpPost.setConfig(requestConfig);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		// 上传的文件
		builder.addBinaryBody(file, target, ContentType.create("application/octet-stream"), target.getName());
		// 设置其他参数
		for (Entry<String, String> entry : params.entrySet()) {
			builder.addTextBody(entry.getKey(), entry.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
		}
		org.apache.http.HttpEntity httpEntity = builder.build();
		httpPost.setEntity(httpEntity);
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response = httpClient.execute(httpPost);
		/*
		 * if (null == response || response.getStatusLine() == null) { return null; }
		 * else if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
		 * response.getStatusLine().getStatusCode()); return null; }
		 */
		return response.getEntity();

	}

	@Test
	public void testMap() {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("zt", "G");
		map.put("hphm", "Y8393");
		System.out.println(map);
		System.out.println(JSON.toJSONString(map));
	}

	public void testBean() {
		UserDto dto = new UserDto();
		dto.setDel(true);
		dto.setPassword("12345");
		dto.setUsername("vich");
		Map<String, String> map = new HashMap<>();
//	BeansUtils.(dto, map);
		System.out.println(map);
	}

	
	
	@Test
	public void testOpenApi() {
		RestTemplate restTempalte = new RestTemplate();
		String url ="https://test-api.pingan.com.cn:20443/open/appsvr/property/marketOpenApi/getCreditAccountAndCheckBlacklist";
		Map<String, Object> params = new HashMap<>();
		params.put("access_token", "7B7757BCB6584DF79BB1ED01B1EB2575");
		params.put("request_id", 123566);
		params.put("vin", "1");
		params.put("certificateNo", "44030119806062026");
		params.put("carMark", "湘APX001");
		HttpHeaders headers = new HttpHeaders();
		/*List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(acceptableMediaTypes);*/
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<>(null,headers);
		ResponseEntity<String> exchange = restTempalte.exchange(url+"?access_token={access_token}&request_id={request_id}&certificateNo={certificateNo}&carMark={carMark}", HttpMethod.GET, entity, String.class,params);
//		ResponseEntity<String> exchange = restTempalte.getForEntity(url+"?access_token={access_token}&request_id={request_id}&vin={vin}&certificateNo={certificateNo}", String.class,params);&vin={vin}
		String json = exchange.getBody();
		System.out.println(json);
		OpenApiResult reuslt = JSON.parseObject(json, OpenApiResult.class);
//		JSONObject jsonObject = JSONObject.parseObject(json);
//		System.out.println(jsonObject.getString("data"));
		
		
	}

	@Test
	public void test99() {
BigDecimal b=new BigDecimal("100.01");
		
		BigDecimal a=b.multiply(new BigDecimal(100));//乘以100(单位：分)
		System.out.println(b.intValue());
		System.out.println(b);
		
		System.out.println(a.intValue());
		System.out.println(a);

	}
}
