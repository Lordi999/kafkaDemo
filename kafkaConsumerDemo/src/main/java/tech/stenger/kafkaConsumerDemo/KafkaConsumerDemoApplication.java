package tech.stenger.kafkaConsumerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.stenger.kafkaConsumerDemo.kafka.KafkaService;

@SpringBootApplication
public class KafkaConsumerDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(KafkaConsumerDemoApplication.class, args);

		kafkaDemo();
	}

	public static void kafkaDemo()	{
		var service = new KafkaService();

		service.init();

		service.readMessages();
	}

}
