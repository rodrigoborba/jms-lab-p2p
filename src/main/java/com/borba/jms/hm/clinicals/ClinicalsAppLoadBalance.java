package com.borba.jms.hm.clinicals;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import com.borba.jms.hm.model.Patient;

public class ClinicalsAppLoadBalance {

	public static void main(String[] args) throws NamingException, JMSException {

		InitialContext initialContext = new InitialContext();
		Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");

		try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext()) {

			JMSProducer producer = jmsContext.createProducer();

			ObjectMessage objectMessage = jmsContext.createObjectMessage();
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("Bob");
			patient.setInsuranceProvider("Blue Cross Blue Shield");
			patient.setCopay(100d);
			patient.setAmountToBePayed(500d);
			objectMessage.setObject(patient);

			producer.send(requestQueue, objectMessage);
			
			for (int i = 1; i <= 10; i++) {
				producer.send(requestQueue, objectMessage);
			}


		}

		;

	}

}
