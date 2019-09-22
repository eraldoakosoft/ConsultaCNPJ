/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultacnpj;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;



/**
 *
 * @author erald
 */
public class CoonsumidorAPI {
    
    
    
    private static String URL = "https://www.receitaws.com.br/v1/cnpj/";
    
    private static CoonsumidorAPI instance;
    
 
    private CloseableHttpClient clienteHTTP;
    
    private CoonsumidorAPI(){
        this.clienteHTTP = HttpClients.createDefault();
    }
    
    public static CoonsumidorAPI getInstance(){
        if(instance == null){
            instance = new CoonsumidorAPI();
        }
        return instance;
    }
    
    
    public String request(String p){
        String responseBody = null;
        try{
            HttpGet httpget = new HttpGet(CoonsumidorAPI.URL+p);
            
            
            ResponseHandler<String> response = new ResponseHandler<String>() {
                @Override
                public String handleResponse(HttpResponse hr) throws ClientProtocolException, IOException {
                    int status = hr.getStatusLine().getStatusCode();
                    if(status >= 200 && status < 300){
                        HttpEntity entity = hr.getEntity();
                        
                        return entity != null ? EntityUtils.toString(entity) : null;
                    }else{
                        throw  new ClientProtocolException("status: "+status);
                    }
                    
                }
            };
            responseBody = this.clienteHTTP.execute(httpget, response);
            
            
            
            
        }catch (IOException ex){
            System.out.println("Exeption: " + ex);
        }
        return responseBody;
        
    }
    
}
