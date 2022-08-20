# restapi-springboot-rabbitmq-publisher
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

- create simple rest-api  just for testing send messsage to rabbit and write json response into client

#
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    UserPublishService userPublishService;


    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Response> publishUser(@RequestBody UserMessageDto request) {
        UserMessageDto userMessageDto = userPublishService.getByUsername(request.getUsername());
        if (userMessageDto != null) {
            // publish message to rabbit mq
            rabbitTemplate.convertAndSend(
                    UserMessageConfig.EXCHANGE_GET_USER,
                    UserMessageConfig.ROUTE_GET_USER,
                    new UserMessageResponseDto(userMessageDto, "PROCESS", "User successfully publish " + userMessageDto.getUsername()));

            // write response
            Response statusResponse = new Response(HttpStatus.OK.toString(), "User successfully publish", userMessageDto);
            return new ResponseEntity<>(statusResponse, HttpStatus.OK);
        } else {
            Response statusResponse = new Response(HttpStatus.NOT_FOUND.toString(), "User not found", "");
            return new ResponseEntity<>(statusResponse, HttpStatus.NOT_FOUND);
        }
    }
#

- create class for rabbitMq configuration, in this case we will config for userMesssage with message queue = queue_get_user
#
    @Bean // this function for get message from rabbitmq with key queue = QUEUE_GET_USER
    public Queue queue() {
        return new Queue(QUEUE_GET_USER);
    }

    @Bean // this function for get message from rabbitmq with key queue = QUEUE_GET_USER
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_GET_USER);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTE_GET_USER);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;

    }
#
