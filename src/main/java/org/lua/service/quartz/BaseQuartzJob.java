/**
 * 
 */
package org.lua.service.quartz;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author onkyo
 *
 */
public abstract class BaseQuartzJob implements InterruptableJob {
	
	final Logger logger = LoggerFactory.getLogger(BaseQuartzJob.class);

    /**
     * If this job has been interrupted.
     */
    private boolean interrupted;

    /**
     * The number of jobs which have already been run
     */
    private static long runCount = 0;

    /**
     * The id of this job, unique within jobs of the same name
     */
    private long id;

    /**
     * Name of the job
     */
    protected String jobName;

    public BaseQuartzJob() {
        jobName = this.getClass().getSimpleName();
        id = ++runCount;
    }

    public final void execute(JobExecutionContext context) throws JobExecutionException {

        String oldThreadName = Thread.currentThread().getName();
        Thread.currentThread().setName(getFullName());
        
        try {
            interrupted = false;
            run(context);
        
        } catch ( Exception e ) {
            throw new RuntimeException(e);
        } finally {
            Thread.currentThread().setName(oldThreadName);
        }

    }

    /**
     * This is a simple wrapper for the other execute method to call this job
     * from other places than the QuartzScheduler.
     */
    public final void execute() {
        try {
            execute(null);
        } catch (JobExecutionException e) {
            logger.error("Execution of job '"+getFullName()+"' resulted in an exception.",e);
        }
    }

    /**
     * This method must be overridden by subclasses.
     * @param context
     * @throws JobInterruptedException
     */
    public abstract void run(JobExecutionContext context) throws InterruptedException;

    /**
     * Called by the QuartzScheduler or another external thread to mark this
     * job as being interrupted.
     */
    public void interrupt() throws UnableToInterruptJobException {
        interrupted = true;
    }

    /**
     * Returns, if this job has been interrupted. Jobs themselves should check
     * interruption by calling <code>checkIfInterrupted()</code>.
     * @return
     */
    public final boolean isInterrupted() {
        return interrupted;
    }

    /**
     * Returns the full name of the job, consisting of the jobname plus the
     * job id.
     * @return
     */
    public String getFullName() {
        return jobName+"-"+id;
    }

    @Override
    public String toString() {
        return getFullName();
    }

}
