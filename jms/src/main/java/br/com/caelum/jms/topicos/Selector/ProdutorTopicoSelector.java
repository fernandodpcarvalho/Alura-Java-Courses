package br.com.caelum.jms.topicos.Selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ProdutorTopicoSelector {
	
	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext context = new InitialContext();
		
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination topico = (Destination) context.lookup("loja");
        MessageProducer producer = session.createProducer(topico);

        Message message = session.createTextMessage("Teste Produtor Topic Selector ebook=false");
        message.setBooleanProperty("ebook", false);
        producer.send(message);

        message = session.createTextMessage("Teste Produtor Topic Selector ebook=true");
        message.setBooleanProperty("ebook", true);
        producer.send(message);
        
        session.close();
        connection.close();
        context.close();
	}
		
}