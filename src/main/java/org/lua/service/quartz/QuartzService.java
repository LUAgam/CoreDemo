///**
// *
// */
//package org.lua.service.quartz;
//
//import com.schickit.utils.ThreadUtils;
//import org.lua.entity.QuartzJob;
//import org.lua.repository.QuartzJobDao;
//import org.quartz.JobKey;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.impl.StdSchedulerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author onkyo
// *
// */
//@Component
//@Transactional(readOnly = true)
//public class QuartzService {
//
//	/**
//	 * The Logger
//	 */
//	final Logger logger = LoggerFactory.getLogger(QuartzService.class);
//
//	/**
//	 * The scheduler. This class wraps the scheduler and all functions only work
//	 * on the data in this scheduler.
//	 */
//	private Scheduler scheduler;
//
//	@Autowired
//    QuartzJobDao quartzJobDao;
//
//	public final static long MILLIS_TO_WAIT_FOR_JOB_SHUTDOWN_AFTER_INTERRUPT = 10000;
//
//	private QuartzListener listener = new QuartzListener();
//
//	/**
//	 * Maps from simple class names (aka JobType) to the full class name.
//	 */
//	private Map<String, Class> jobTypeToClass = new HashMap<String, Class>();
//
//	private Map<String, String[]> jobTypeToParameterNames = new HashMap<String, String[]>();
//
//	/**
//	 * Registers a job type. This is used to configure the job types from our
//	 * modules.
//	 */
//	public void registerJobClass(String jobType, Class clazz) {
//		jobTypeToClass.put(jobType, clazz);
//	}
//
//	public synchronized void initialize() {
//		if (scheduler != null) {
//			return;
//		}
//		logger.info("Initializing Quartz job scheduler 2.");
//
//		// Configuring and starting the scheduler
//		try {
//			logger.info("Starting Quartz scheduler and scheduling jobs.");
//
//			scheduler = StdSchedulerFactory.getDefaultScheduler();
//			scheduler.getListenerManager().addJobListener(listener);
//			scheduler.start();
//			logger.info("Scheduler started successfully.");
//
//			configureAllJobs();
//
//		} catch (SchedulerException e) {
//			logger.error("Error during scheduler startup.", e);
//		}
//
//	}
//
//	public synchronized void configureAllJobs() {
//
//		List<QuartzJob> quartzJobs = quartzJobDao.findAll();
//		logger.info("Configuring " + quartzJobs.size() + " jobs...");
//		for (QuartzJob job : quartzJobs) {
//			configureJob(job);
//		}
//		logger.info("Configuring jobs done.");
//	}
//
//	/**
//	 * Updates the scheduler to reflect the information in this Job. This
//	 * function is called within an transaction, and updates to the job object
//	 * are reflected in the database after modifying the job.
//	 */
//	@SuppressWarnings("deprecation")
//	public synchronized void configureJob(QuartzJob job) {
//
//		// Make the job running according to its specs.
//		String name = job.getName();
//
//		//try {
//			// Check if a job with this database ID already exists in the
//			// scheduler.
//			// If not, we create one.
//			/*
//			JobDetail jobDetail = JobBuilder.newJob()
//				      .withIdentity(name, Scheduler.DEFAULT_GROUP)
//				      .build();
//			if (jobDetail != null) {
//				// Unscheduling job
//				for (Trigger trigger : scheduler.getTriggersOfJob(name, Scheduler.DEFAULT_GROUP)) {
//					scheduler.unscheduleJob(trigger.getName(), trigger.getGroup());
//				}
//			}
//			if (jobDetail == null) {
//				// Job does not exist yet. We have to create a new one.
//				jobDetail = new JobDetail();
//			}
//			jobDetail.setName(job.getName());
//			jobDetail.setGroup(Scheduler.DEFAULT_GROUP);
//			jobDetail.setJobClass(jobClass);
//			jobDetail.setDescription(job.getName());
//			jobDetail.setRequestsRecovery(false);
//			jobDetail.setVolatility(false);
//			jobDetail.setDurability(true);
//			JobDataMap map = jobDetail.getJobDataMap();
//			map.put("SSIT-ID", job.getId());
//			map.put("parameter1", job.getParameter1());
//			map.put("parameter2", job.getParameter2());
//			map.put("parameter3", job.getParameter3());
//			map.put("sendMessageOnFailure", job.isSendMessageOnFailure());
//			map.put("sendMessageOnSuccess", job.isSendMessageOnSuccess());
//			scheduler.addJob(jobDetail, true);
//			// Reschedule job
//			job.setNextExecutionStart(null);
//			if (!job.getRecordStatus().equals(RecordStatus.DELETED)) {
//				if (job.isActive()) {
//					if (job.getCronExpression() != null) {
//						CronTrigger trigger = new CronTrigger();
//						trigger.setName(job.getName() + "'s Trigger");
//						trigger.setDescription(job.getName() + "'s Trigger");
//						trigger.setJobName(job.getName());
//						trigger.setJobGroup(Scheduler.DEFAULT_GROUP);
//						try {
//							trigger.setCronExpression(job.getCronExpression());
//							logger.info("Scheduling job '" + job.getName() + "' with trigger expression '"
//									+ job.getCronExpression() + "'!");
//							scheduler.scheduleJob(trigger);
//						} catch (ParseException e) {
//							logger.error("Cron expression '" + job.getCronExpression() + "' defined "
//									+ "for QuartzJob " + job.getName() + " could not be parsed.", e);
//						}
//						job.setNextExecutionStart(trigger.getNextFireTime());
//					} else {
//						logger.info(
//								"Job '" + job.getName() + "' not scheduled because no trigger expression is set.");
//					}
//				} else {
//					logger.info("Job '" + job.getName() + "' not scheduled because its not active " + job.isActive()
//							+ ".");
//				}
//			} else {
//				logger.info("Job '" + job.getName() + "' not scheduled because it is deleted.");
//			}
//
//		*/
//		// We now have to set the non-hibernate-modifyable fields...
//		/*QuartzJobDAO quartzJobDAO = DAOFactory.getQuartzJobDAO();
//		quartzJobDAO.begin();
//		QuartzJob newJob = quartzJobDAO.findById(job.getId());
//		newJob.setStatus(job.getStatus());
//		newJob.setNextExecutionStart(job.getNextExecutionStart());
//		quartzJobDAO.persist(newJob);
//		quartzJobDAO.commit();*/
//	}
//
//	public synchronized void triggerJob(JobKey jobkey) {
//		try {
//			scheduler.triggerJob(jobkey);
//			ThreadUtils.sleep(1000);
//		} catch (SchedulerException e) {
//			throw new RuntimeException("不能启动该定时任务: " + e.getLocalizedMessage());
//		}
//	}
//
//	public synchronized void interruptJob(JobKey jobkey) {
//		try {
//			scheduler.interrupt(jobkey);
//			ThreadUtils.sleep(1000);
//		} catch (SchedulerException e) {
//			throw new RuntimeException("不能中断该定时任务: " + e.getLocalizedMessage());
//		}
//	}
//
//	/**
//	 * Stops the scheduler.
//	 */
//	@SuppressWarnings("unchecked")
//	public synchronized void kill() {
//		/*if (scheduler == null) {
//			logger.info("Scheduler not killed because it does not seem to be running.");
//			return;
//		}
//		try {
//			scheduler.shutdown(false);
//			logger.info("Quartz scheduler stopped.");
//
//			if (scheduler.getCurrentlyExecutingJobs().size() > 0) {
//				String s = "";
//				for (JobExecutionContext jobContext : (List<JobExecutionContext>) scheduler
//						.getCurrentlyExecutingJobs()) {
//					s = s + ", " + jobContext.getJobDetail().getKey().getName();
//				}
//				;
//				if (s.length() > 0) {
//					s = s.substring(2);
//				}
//				logger.info("We noticed there are still the following jobs running: " + s
//						+ ". Trying to interrupt them all.");
//				for (JobExecutionContext jobContext : (List<JobExecutionContext>) scheduler
//						.getCurrentlyExecutingJobs()) {
//					scheduler.interrupt(jobContext.getJobDetail().getKey());
//				}
//				;
//				long begin = System.currentTimeMillis();
//				long end = begin + MILLIS_TO_WAIT_FOR_JOB_SHUTDOWN_AFTER_INTERRUPT;
//				while (scheduler.getCurrentlyExecutingJobs().size() > 0 && System.currentTimeMillis() < end) {
//					ThreadUtils.sleep(40);
//				}
//				if (scheduler.getCurrentlyExecutingJobs().size() > 0) {
//					s = "";
//					for (JobExecutionContext jobContext : (List<JobExecutionContext>) scheduler
//							.getCurrentlyExecutingJobs()) {
//						s = s + ", " + jobContext.getJobDetail().getKey().getName();
//					}
//					;
//					if (s.length() > 0) {
//						s = s.substring(2);
//					}
//					logger.info("Some jobs don't seem to care for our interrupting. The insubordinate jobs are: " + s
//							+ ".");
//				}
//			}
//			scheduler = null;
//		} catch (SchedulerException e) {
//			logger.error("Exception during Quartz scheduler shutdown.", e);
//		}*/
//	}
//
//	public Scheduler getScheduler() {
//		return scheduler;
//	}
//
//	public Map<String, String[]> getJobTypeToParameterNames() {
//		return jobTypeToParameterNames;
//	}
//
//}
