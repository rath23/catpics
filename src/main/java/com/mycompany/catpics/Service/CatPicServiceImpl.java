package com.mycompany.catpics.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mycompany.catpics.Data.CatPicData;

@Service
public class CatPicServiceImpl implements CatPicService  {

    private final RestTemplate restTemplate;

    private final String apiKey = "Your api key";

    private final String url = "https://api.thecatapi.com/v1/images/search?api_key="+apiKey;

    public CatPicServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    


    @Override
    public String CapPicUrl() {
        ResponseEntity<CatPicData[]> responseEntity = restTemplate.getForEntity(url, CatPicData[].class);
        CatPicData[] catPicDataArray = responseEntity.getBody();
        
        if (responseEntity.getStatusCode().is2xxSuccessful() && catPicDataArray != null && catPicDataArray.length > 0) {
            return catPicDataArray[0].getUrl();
        } else {
            throw new RuntimeException("Failed to fetch image: " + responseEntity.getStatusCode());
        }
    }
    
}
