SpringBoot Project to perform SchedularTasks

Scheduling is a process of executing the tasks for the specific time period.

@EnableScheduling enables the spring’s scheduled task execution capability. 
All bean methods annotated with @scheduled will be registered for scheduling.

-we have a class SchedulerTasks
In this class we have declared methods with @Scheduled annotation 

which are performed by given properties in the @Schedule annotation 

  we have following properties:
  
  fixedRate: executes the method with a fixed period of milliseconds between invocations.
  
  fixedDelay:  executes the method with a fixed period of milliseconds between the end of one invocation and the start of the next.
  
  InitialDelay: delays the invocation at the start of execution
  
  cron:  uses cron-like expressions to determine when to execute the method