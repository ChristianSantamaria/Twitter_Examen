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

        
        
    }
    
    /**
     * Aqui enviara un mensaje por twitter a una cuenta especificada
     * @param Destinatario Es la cuenta a la que queremos enviarle el mensaje
     * @param Mensaje Es el mensaje que queremos enviar
     */
    public void enviarMensaje(String Destinatario, String Mensaje) {
        DirectMessage message;
        try {
            message = twitter.sendDirectMessage(Destinatario, Mensaje);
            System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
        } catch (TwitterException ex) {
            System.out.println("Error al twittear");
        }
    }

    /**
     * Aqui nos mostrara todos los twitts me nosotros tenemos en el inicio de twitter
     */
    public void lineaTiempo() {
        try {
            Paging pagina = new Paging();
            pagina.setCount(40);
            ResponseList listado = twitter.getHomeTimeline(pagina);
            for (int i = 0; i < listado.size(); i++) {
                System.out.println(listado.get(i).toString());
            }
        } catch (TwitterException ex) {
            System.out.println("Error al ver la linea de tiempo");
        }
    }
    
    /**
     * Aqui podremos lanzar un mensaje por twitter
     * @param Mensaje Es el mensaje que queremos poner como estado
     */
    public void twittear(String Mensaje) {
        try {
            twitter.updateStatus(Mensaje);
        } catch (TwitterException ex) {
            System.out.println("Error post");
        }
    }
    
    /**
     * Aqui buscaremos por un twitt especificado  
     * @param Twit Es el twitt que queremos buscar siempre empieza por #
     */
    public void buscarTwit(String Twit) {
        try {
            Query query = new Query(Twit);
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException ex) {
            System.out.println("Error al buscar");
        }
    }

}