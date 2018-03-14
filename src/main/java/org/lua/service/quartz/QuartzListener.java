///**
// *
// */
//package org.lua.service.quartz;
//
//import java.util.Date;
//
//import org.quartz.JobDataMap;
//import org.quartz.JobDetail;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.JobListener;
//import org.quartz.Scheduler;
//import org.quartz.Trigger;
//import org.quartz.Trigger.CompletedExecutionInstruction;
//import org.quartz.TriggerListener;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * @author onkyo
// *
// */
//public class QuartzListener implements JobListener,TriggerListener {
//
//	final Logger logger = LoggerFactory.getLogger(QuartzListener.class);
//
//	private static final String JOVEN_QUARTZ_ID = "JVCORE_JOB_ID";
//
//    // Functions defined in JobListener AND TriggerListener
//
//    @Override
//    public String getName() {
//        return "JVCore Quartz Listener";
//    }
//
//    // Functions defined in JobListener
//
//    @Override
//    public void jobExecutionVetoed(JobExecutionContext context) {
//        // Not used.
//    }
//
//    @Override
//    public void jobToBeExecuted(JobExecutionContext context) {
//        JobDetail jobDetail = context.getJobDetail();
//        Integer id = (Integer) jobDetail.getJobDataMap().get(JOVEN_QUARTZ_ID);
//        if( id == null ) {
//            // No job
//            return;
//        }
//
//        // Determine next automatic trigger time.
//        Date nextTriggerTime = null;
//        try {
//            for( Trigger t : context.getScheduler().getTriggersOfJob(context.getJobDetail().getKey())) {
//                Date triggersNextFireTime = t.getNextFireTime();
//                if( triggersNextFireTime != null ) {
//                    if( nextTriggerTime == null || nextTriggerTime.after(triggersNextFireTime)) {
//                        nextTriggerTime = triggersNextFireTime;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            logger.error("An error occured while to find out the next trigger "+
//                    "time of job '"+jobDetail.getKey().getName() +"'. The database will not contain a next trigger time now.",e);
//        }
//
//        //TODO Update next trigger time in the database.
//
//        /*// Update next trigger time in the database.
//
//        try {
//        	JDBCTemplate jdbc = Application.getJDBCService().getJDBCTemplate();
//        	Connection connection = jdbc.getConnection();
//
//
//            jdbc.execute(connection, "UPDATE tbl_quartzjob SET status = 'R'," +
//            		                       " lastexecutionstart=now(),"+
//            		                       " lastexecutionend=null,"+
//            		                       " nextexecutionstart='" + DateUtils.formatDateTime(nextTriggerTime)+"',"+
//            		                       " message=null"+
//            		   " WHERE id="+id);
//            jdbc.commitAndClose(connection);
//        } catch (Exception e) {
//            logger.error("An error occured while trying to update the status "+
//                    "of job '"+jobDetail.getName()+"' in the database on job start.",e);
//
//        } */
//    }
//
//    @Override
//    public void jobWasExecuted(JobExecutionContext context,
//            JobExecutionException jobException) {
//        JobDetail jobDetail = context.getJobDetail();
//        JobDataMap map = jobDetail.getJobDataMap();
//        Integer id = (Integer) map.get(JOVEN_QUARTZ_ID);
//        if( id == null ) {
//            // No job
//            return;
//        }
//
//
//        //TODO save job was executed in database
//
//        /*try {
//        	JDBCTemplate jdbc = Application.getJDBCService().getJDBCTemplate();
//            Connection connection = jdbc.getConnection();
//        	String message = jobException == null ? null : "ERROR: "+jobException.getMessage();
//            jdbc.execute(connection, "UPDATE tbl_quartzjob SET status = CASE WHEN active THEN 'A' ELSE 'I' END," +
//                                           " lastexecutionend=now(),"+
//                                           " message='"+message+"' WHERE id="+id);
//            jdbc.commitAndClose(connection);
//        } catch (Exception e) {
//            if( jobException != null ) {
//                logger.error("An error occured while trying to update the status "+
//                        "of job '"+jobDetail.getName()+"' in the database after failed execution.",e);
//            } else {
//                logger.error("An error occured while trying to update the status "+
//                        "of job '"+jobDetail.getName()+"' in the database after successful execution.",e);
//            }
//        } */
//
//    }
//
//
//    @Override
//    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
//        // TODO: Veto job executions if the server is about to shut down.
//        return false;
//    }
//
//	@Override
//	public void triggerComplete(Trigger arg0, JobExecutionContext arg1, CompletedExecutionInstruction arg2) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void triggerFired(Trigger arg0, JobExecutionContext arg1) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void triggerMisfired(Trigger arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//}
