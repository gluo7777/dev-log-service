Service component of Logger

structure of our future projects under the directory /com.loggerproject.logservice:
- /config  where all the beans/configurations will be stored
- /controller where @Controller/@RestController beans are located. can only autowire @Service  
- /service where @Service beans are located. only talks to the @Repository
- /data where @Repository and data models are located
