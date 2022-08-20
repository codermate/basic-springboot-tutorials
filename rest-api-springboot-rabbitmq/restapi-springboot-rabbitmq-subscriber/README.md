# restapi-springboot-rabbitmq-consumer
  How to send message (publish) via api to rabbitMQ
#

#### 1. download & install erlang otp and rabbit mq
you must download & install erlang opt and rabbitmq, go to the parent rapo for see the document

#### 2. create new spring project and configure rabbit
- add dependecy for rabbit mq
#
<!-- https://mvnrepository.com/artifact/org.springframework.amqp/spring-rabbit -->
		<dependency>
			<groupId>org.springframework.amqp</groupId>
			<artifactId>spring-rabbit</artifactId>
			<version>2.4.6</version>
</dependency>

- create class rabbitMq configuration for receive message from rabbitmq, in this case we will config for userMesssage with message queue = queue_get_user
#
    @Component
    public class UserMessageConsume {

       // function for get message from spesific queue, that function always listen when app firttime starting
       @RabbitListener(queues = MessageConstant.QUEUE_GET_USER)
       public void consumeMessageFromQueue(UserMessageResponseDto userMessageResponseDto) {
           System.out.println("Message received from Queue Rabbit :");
           System.out.println("id :" + userMessageResponseDto.getUser().getId());
           System.out.println("username :" + userMessageResponseDto.getUser().getUsername());
           System.out.println("password :" + userMessageResponseDto.getUser().getPassword());

    }
   }
#
