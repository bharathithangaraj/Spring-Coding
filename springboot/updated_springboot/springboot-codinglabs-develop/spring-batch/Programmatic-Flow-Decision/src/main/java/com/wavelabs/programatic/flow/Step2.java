package com.wavelabs.programatic.flow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
 
public class Step2 implements Tasklet{
 
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		logger.info("STEP 2 processing!");
		return RepeatStatus.FINISHED;
	}
	
}