package tech.stenger.kafkaProducerDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.stenger.kafkaProducerDemo.controller.dto.KafkaMessageDto;
import tech.stenger.kafkaProducerDemo.kafka.KafkaService;

@RestController
@RequestMapping("/Producer")
public class ProducerController {

  private KafkaService kafkaService = new KafkaService();

  @PostMapping("/sendMessage")
  @ResponseStatus(HttpStatus.CREATED)
  public void sendMessage(@RequestBody KafkaMessageDto body) {
    kafkaService.sendMessage(body.getTopic(), body.getMessage());
  }

}
