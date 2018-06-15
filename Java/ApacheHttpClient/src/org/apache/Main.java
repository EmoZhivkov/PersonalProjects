package org.apache;

import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //easy way
        String oop = Request.Get("http://10.27.116.84:3000").execute().returnContent().asString();
        System.out.println(oop);

        String oopa = Request.Post("https://passport.abv.bg/app/profiles/login")
                .bodyForm(Form.form().add("username", "vip")
                        .add("password", "secret").build()).execute().returnContent().asString();
        //System.out.println(oopa);

        //the better method
        CloseableHttpClient closableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.google.com/");
        CloseableHttpResponse response = closableHttpClient.execute(httpGet);
        try {
            System.out.println(response.toString());
            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

    }
}
