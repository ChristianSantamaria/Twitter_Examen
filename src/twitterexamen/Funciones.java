package twitterexamen;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class Funciones {
    public Twitter twitter;
    


    
    /**
     * Constructor por defecto
     */
    public Funciones() {
    }

    /**
     * Aqui añadiendole la key, secret, accToken y la secretToken que las encontraremos en la pagina de twitter developer se conectara a la cuenta 
     * la cual es necesaria para los siguientes metodos
     */
    public void conectar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("x")
                .setOAuthConsumerSecret("x")
                .setOAuthAccessToken("x")
                .setOAuthAccessTokenSecret("x");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
        
        
    }
    
    /**
     * Este es el metodo que lee el fichero llamado twitter4j.properties y lo ejecuta
     * En dicho archivo tiene que contener exactamente los mismos parametros que el metodo conectar
     * Es lo mismo que el metodo conectar pero guardado en un fichero de texto
     */ 
     
    public void conectarViaProperties() {

        try {
            Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.verifyCredentials();
            List statuses = twitter.getHomeTimeline();
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }

    }
    
    

}
