package tech.stenger.kafkaProducerDemo;

import static java.lang.Thread.sleep;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.stenger.kafkaProducerDemo.kafka.KafkaService;

@SpringBootApplication
public class KafkaProducerDemoApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(KafkaProducerDemoApplication.class, args);

		kafkaDemo();
	}


	public static void kafkaDemo() throws InterruptedException {
		KafkaService kafkaService = new KafkaService();

		Scanner input = new Scanner(System.in);

		sleep(1000);

		System.out.println("Demo Application for sending messages via Kafka");

		while(true) {
			System.out.print("Write Message: ");
			kafkaService.sendMessage("testTopic", input.nextLine());
		}

	}

}
