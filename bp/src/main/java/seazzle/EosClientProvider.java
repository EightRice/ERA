package seazzle;

import java.util.Collections;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class EosClientProvider {
	
	public EosClient getEosCLient() {
		
		 Client.Default client = new OkHttpClient.Default(getSessionFactory(), getHostNameVerifier());
	        return Feign.builder()
	            .client(client)
	            .encoder(new JacksonEncoder())
	            .decoder(new JacksonDecoder(Collections.singletonList(new JavaTimeModule())))
	            .logger(new Slf4jLogger(EosClient.class))
	            .logLevel(Logger.Level.FULL)
	            .target(EosClient.class, "https://api.eosnewyork.io");
		
	}

	   private HostnameVerifier getHostNameVerifier()
	    {
	        return (s, sslSession) -> true;
	    }

	    private SSLSocketFactory getSessionFactory()
	    {
	        try
	        {
	            // Create a trust manager that does not validate certificate chains
	            final TrustManager[] trustAllCerts = new TrustManager[]{
	                new X509TrustManager()
	                {
	                    @Override
	                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
	                    {
	                    }

	                    @Override
	                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
	                    {
	                    }

	                    @Override
	                    public java.security.cert.X509Certificate[] getAcceptedIssuers()
	                    {
	                        return null;
	                    }
	                }
	            };

	            // Install the all-trusting trust manager
	            final SSLContext sslContext = SSLContext.getInstance("SSL");
	            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
	            // Create an ssl socket factory with our all-trusting manager
	            return sslContext.getSocketFactory();

	        }
	        catch (Exception e)
	        {
	            throw new RuntimeException(e);
	        }
	    }
	
}
