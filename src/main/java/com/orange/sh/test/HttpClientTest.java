package com.orange.sh.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HttpClientTest {

	public static void main(String[] args) {
		String url = "http://gzjjwx.gzjd.gov.cn/sandbox/GzjjPingAnXcxApiServer/PA/UploadPDF";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		//String fileLocal="D:\\pdf\\Helloworld.PDF";
		
		File fileLocal = getFile();
		
		FileSystemResource resource = new FileSystemResource(fileLocal);
		
		
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String,Object>();
		params.add("caseNo", "54321");
		params.add("file", resource);
		params.add("id", "1552971812");
		params.add("timestamp", "1552971812");
		params.add("signature", "9935ab0dea0595ab8f5cf1fdf646c2e6");
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(params,headers);
		ResponseEntity<Object> response = restTemplate.postForEntity(url, entity, Object.class);
		System.out.println(response.getBody());
	}
	
	
	
	public static File getFile() {
		File file = new File("D:/pdf/123.pdf");
		try {
			File target = new File("D:/pdf/Helloworld.PDF");
			byte[] bytes = FileUtils.readFileToByteArray(target);
			FileUtils.writeByteArrayToFile(file, bytes);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return file;
	}
	
}
