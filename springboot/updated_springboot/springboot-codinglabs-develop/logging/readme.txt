LoggerLevels in Spring Boot:

There are 8 logging levels in Spring Boot:
        They are 1.OFF
                 2.FATAL
                 3.ERROR
                 4.WARN
                 5.INFO
                 6.DEBUG
                 7.TRACE
                 8.ALL
                 
When we are Setting the logging Levels then the levels which are on the top of that will also effect.


  example: 1. If we are using  ERROR then FATAL also shows the effects.
           2. If we are using  Info then FATAL,ERROR and WARN  levels also shows the effects.
           
           
Note: By Default SpringBoot uses Info level. 