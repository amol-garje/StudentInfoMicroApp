package com.example.demo.DataBaseConnect;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.BindingDataHere.BindingData;
import com.example.demo.BindingDataHere.ResponceComeBindData;

@Service
public class ConnecToTheDataBase {

	@Value("${data_send_url_here}")
	String urlSendData;

	@Value("${data_fetch_url_here}")
	String displayData;

	@Value("${data_delete_url_here}")
	String deleteData;

	@Value("${data_update_url_here}")
	String updateData;

	
	@Value("${data_get_one_here}")
	String getOneData;

	RestTemplate tmp = new RestTemplate();

	// here is Code of Inserting Data By Using the RestTemplet
	public String InsertDataIntoDataBase(BindingData bnd) {
		ResponseEntity<String> postForEntity = tmp.postForEntity(urlSendData, bnd, String.class);
		String body = postForEntity.getBody();
		return body;
	}

	// here is Code of Display Data By Using the RestTemplet
	public List<ResponceComeBindData> DisplayData() {
        ResponseEntity<List<ResponceComeBindData>> exchange = tmp.exchange(displayData, HttpMethod.GET, null, new ParameterizedTypeReference<List<ResponceComeBindData>>(){});
        List<ResponceComeBindData> body = exchange.getBody();
        return body;
	}

	// here is Code of Display Data By Using the RestTemplet
	public String DeleteData(int id) {
          ResponseEntity<String> forEntity = tmp.getForEntity(deleteData,String.class,id);
          System.out.println("Delete date");
          return forEntity.getBody();
	}

	// here is Code of get One  Data By Using the RestTemplet
	public ResponceComeBindData getOneData(int id) {
           ResponseEntity<ResponceComeBindData> forEntity = tmp.getForEntity(getOneData,ResponceComeBindData.class,id);
           ResponceComeBindData body = forEntity.getBody();
           return body;
	}
	
	// Here we Update The Data 
	public String UpdateData(ResponceComeBindData dr) {
		  ResponseEntity<String> postForEntity = tmp.postForEntity(updateData,dr, String.class);
		  String body = postForEntity.getBody();
		  return body;
	}

}
