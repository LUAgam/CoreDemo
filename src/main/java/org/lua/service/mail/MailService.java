/**
 * (c) 2006 JOVEN
 * 
 * http://www.joven.com.cn
 */
package org.lua.service.mail;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.lua.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @author onkyo
 * 
 */
@Component
@Transactional(readOnly = true)
public class MailService {

	final Logger logger = LoggerFactory.getLogger(MailService.class);

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Autowired
    private TaskExecutor taskExecutor;

	private String encoding = "UTF-8";

	public void send(String from, String to, String subject,	String templateName, Map model) throws Exception {
		send(from, to, subject, templateName, model, new File[0]);
	}

    public void send(String from, String to, String subject, String templateName, Map model, File file, String fileName) throws Exception{
        String content = generateEmailContent(templateName, model);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true, encoding);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            try {
                helper.addAttachment(MimeUtility.encodeWord(
                        fileName, encoding, null), file);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                helper.addAttachment(file.getName(), file);
            }
        } catch (MessagingException e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage());
        }
        mailSender.send(message);
    }

	public void send(String from, String to, String subject, String templateName, Map model, File... attachementFiles)
			throws Exception {
		String content = generateEmailContent(templateName, model);
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, encoding);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);

			if (attachementFiles != null && attachementFiles.length > 0) {
				for (File f : attachementFiles) {

					try {
						helper.addAttachment(MimeUtility.encodeWord(
								f.getName(), encoding, null), f);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						helper.addAttachment(f.getName(), f);
					}
				}
			}
		} catch (MessagingException e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}
		mailSender.send(message);

	}

	public void sendBatchEmail(String from, List<String> to, String subject, String templateName, Map model) throws Exception {
		sendBatchEmail(from, to, subject, templateName, model, new File[0]);
	}

	public void sendBatchEmail(String from, List<String> to, String subject, String templateName, Map model, File... attachementFiles)
			throws Exception {
		String content = generateEmailContent(templateName, model);
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, encoding);
			helper.setFrom(from);
			String toList = getMailList(to);
			InternetAddress[] iaToList = new InternetAddress().parse(toList);
			message.setRecipients(Message.RecipientType.TO, iaToList);
			helper.setSubject(subject);
			helper.setText(content, true);

			if (attachementFiles != null && attachementFiles.length > 0) {
				for (File f : attachementFiles) {

					try {
						helper.addAttachment(MimeUtility.encodeWord(
								f.getName(), encoding, null), f);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
						helper.addAttachment(f.getName(), f);
					}
				}
			}
		} catch (MessagingException e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e.getMessage());
		}
		mailSender.send(message);

	}

    public void sendAsync(final String from, final String to, final String subject, final String templateName, final Map model) throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "begin ...");
                    send(from, to, subject, templateName, model);
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "success ...");
                } catch (Exception e) {
                    logger.error(Constant.SEND_MAIL + "from: " + from + "to:" + to + "failed");
                    e.printStackTrace();
                }
            }
        });
        taskExecutor.execute(t);
    }

    public void sendAsync(final String from, final String to, final String subject, final String templateName, final Map model, final File... attachementFiles) throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "begin ...");
                    send(from,to,subject,templateName,model,attachementFiles);
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "success ...");
                } catch (Exception e) {
                    logger.error(Constant.SEND_MAIL + "from: " + from + "to:" + to + "failed");
                    e.printStackTrace();
                }
            }
        });
        taskExecutor.execute(t);

    }

    public void sendAsync(final String from, final String to, final String subject, final String templateName, final Map model, final File file, final String fileName) throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "begin ...");
                    send(from,to,subject,templateName,model,file,fileName);
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "success ...");
                } catch (Exception e) {
                    logger.error(Constant.SEND_MAIL + "from: " + from + "to:" + to + "failed");
                    e.printStackTrace();
                }
            }
        });
        taskExecutor.execute(t);
    }

    public void sendBatchEmailAsync(final String from, final List<String> to, final String subject, final String templateName, final Map model) throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "begin ...");
                    sendBatchEmail(from, to, subject, templateName, model);
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "success ...");
                } catch (Exception e) {
                    logger.error(Constant.SEND_MAIL + "from: " + from + "to:" + to + "failed");
                    e.printStackTrace();
                }
            }
        });
        taskExecutor.execute(t);
    }

    public void sendBatchEmailAsync(final String from, final List<String> to, final String subject, final String templateName, final Map model, final File... attachementFiles) throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "begin ...");
                    sendBatchEmail(from, to, subject, templateName, model, attachementFiles);
                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "success ...");
                } catch (Exception e) {
                    logger.error(Constant.SEND_MAIL + "from: " + from + "to:" + to + "failed");
                    e.printStackTrace();
                }
            }
        });
        taskExecutor.execute(t);
    }

    /**
	 * 集合转换字符串
	 */
	private String getMailList(List<String> to) {
		StringBuffer toList = new StringBuffer();
		int length = to.size();
		if (to != null && length < 2) {
			toList.append(to.get(0));
		} else {
			for (int i = 0; i < length; i++) {
				toList.append(to.get(i));
				if (i != (length - 1)) {
					toList.append(",");
				}
			}
		}
		return toList.toString();
	}

	private String generateEmailContent(String templateName, Map map) {
		try {
			Template t = freeMarkerConfigurer.getConfiguration().getTemplate(
					templateName);
			return FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
		} catch (TemplateException e) {
			logger.error("Error while processing FreeMarker template ", e);
		} catch (FileNotFoundException e) {
			logger.error("Error while open template file ", e);
		} catch (IOException e) {
			logger.error("Error while generate Email Content ", e);
		}
		return null;
	}

	 public void sendListEmailAsync(final String from, final List<String> to, final String subject, final String templateName, final Map model, final File... attachementFiles) throws Exception {
		 Thread t = new Thread(new Runnable() {
	            @Override
	            public void run() {
	            
	                try {
	                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "begin ...");
	                    String content = generateEmailContent(templateName, model);
	            		MimeMessage message = mailSender.createMimeMessage();
	            		MimeMessageHelper helper;
	            		for(String iato : to){
	            		try {
	            			helper = new MimeMessageHelper(message, true, encoding);
	            			helper.setFrom(from);
	            				InternetAddress address = new InternetAddress(iato);
	            				message.setRecipient(Message.RecipientType.TO,address);
		            			helper.setSubject(subject);
		            			helper.setText(content, true);
		            			if (attachementFiles != null && attachementFiles.length > 0) {
		            				for (File f : attachementFiles) {
		            					try {
		            						helper.addAttachment(MimeUtility.encodeWord(
		            								f.getName(), encoding, null), f);
		            					} catch (UnsupportedEncodingException e) {
		            						e.printStackTrace();
		            						helper.addAttachment(f.getName(), f);
		            					}
		            				}
		            			}
		            		} catch (MessagingException e) {
		            			logger.error(e.getMessage(), e);
		            			continue;
		            		}
		            		mailSender.send(message);
	            			}
	                    sendBatchEmail(from, to, subject, templateName, model, attachementFiles);
	                    logger.info(Constant.SEND_MAIL + "from: " + from + "to:" + to + "success ...");
	                } catch (Exception e) {
	                    logger.error(Constant.SEND_MAIL + "from: " + from + "to:" + to + "failed");
	                    e.printStackTrace();
	                }
	            }
	        });
	        taskExecutor.execute(t);
	    }
	 
}
