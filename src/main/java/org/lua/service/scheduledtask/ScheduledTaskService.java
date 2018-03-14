///**
// * 
// */
//package com.joven.jvcore.service.scheduledtask;
//
//import java.rmi.RemoteException;
//import java.text.ParseException;
//import java.util.List;
//
//import org.apache.axis.message.MessageElement;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import antlr.debug.Event;
//
//import com.joven.jvcore.entity.Person;
//import com.joven.jvcore.entity.lms.FaultInfo;
//import com.joven.jvcore.entity.lms.Lift;
//import com.joven.jvcore.entity.lms.LiftEvent;
//import com.joven.jvcore.repository.PersonDao;
//import com.joven.jvcore.repository.lms.FaultInfoDao;
//import com.joven.jvcore.repository.lms.LiftDao;
//import com.joven.jvcore.repository.lms.LiftEventDao;
//import com.joven.jvcore.repository.lms.LiftLocationDao;
//import com.joven.services.Get_GuZhangBaoXiu_BySbwtbhResponseGet_GuZhangBaoXiu_BySbwtbhResult;
//import com.joven.services.Get_ShiJianBaoGao_BySbwtbhResponseGet_ShiJianBaoGao_BySbwtbhResult;
//import com.joven.services.WebService1Soap;
//import com.joven.services.WebService1SoapProxy;
//import com.schickit.utils.DateUtils;
//import com.schickit.utils.StringUtils;
//
///**
// * @author WLL
// *
// */
//@Component
//@Transactional(readOnly = true)
//public class ScheduledTaskService {
//
//	@Autowired
//	PersonDao personDao;
//	
//	@Autowired
//	LiftLocationDao liftLocationDao;
//	
//	@Autowired
//	FaultInfoDao faultInfoDao;
//	
//	@Autowired
//	LiftDao liftDao;
//	
//	@Autowired
//	LiftEventDao liftEventDao;
//	
//	@Transactional
//	public void updatePersonData(){
//		List<Person> pList = personDao.findAll();
//		for (Person p : pList) {
//			p.setMetroLineLastMonth(p.getMetroLine());
//			p.setStationLastMonth(p.getStation());
//			p.setTitleLastMonth(p.getTitle());
//			p.setWorkGroupLastMonth(p.getWorkGroup());
//			personDao.save(p);
//		}
//	}
//	
//	@Transactional
//	public void webServiceData() throws RemoteException{
//		WebService1SoapProxy webservice1SoapStub = new WebService1SoapProxy();
//		WebService1Soap webservice1soap = webservice1SoapStub.getWebService1Soap();
//		List<String> wtList = liftLocationDao.findNumber();
//		for (String s : wtList) {
//			Get_GuZhangBaoXiu_BySbwtbhResponseGet_GuZhangBaoXiu_BySbwtbhResult result = webservice1soap.get_GuZhangBaoXiu_BySbwtbh(s);
//			Get_ShiJianBaoGao_BySbwtbhResponseGet_ShiJianBaoGao_BySbwtbhResult result2 = webservice1soap.get_ShiJianBaoGao_BySbwtbh(s);
//			MessageElement element[] = result.get_any();
//			for (MessageElement me : element) {
//				NodeList nodelist = me.getChildNodes();
//				for (int i=0; i<nodelist.getLength(); i++) {
//					Node node = nodelist.item(i);
//					if ("NewDataSet".equals(node.getNodeName())) {
//						NodeList dsList = node.getChildNodes();
//						for (int j=0;j<dsList.getLength();j++) {
//							Node ds = dsList.item(j);
//							if ("ds".equals(ds.getNodeName())) {
//								NodeList eList = ds.getChildNodes();
//								FaultInfo faultInfo = new FaultInfo();
//								String line = "";
//								String station = "";
//								for (int k=0;k<eList.getLength();k++) {
//									Node e = eList.item(k);
//									if (e != null && e.getFirstChild() != null && !StringUtils.isEmpty(e.getFirstChild().toString())) {
//										if ("gz_id".equals(e.getNodeName())) {
//											faultInfo.setGz_id(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("gz_time".equals(e.getNodeName())) {
//											try {
//												faultInfo.setGz_time(DateUtils.parseAnyString(e.getFirstChild().toString()));
//											} catch (ParseException e1) {
//												e1.printStackTrace();
//											}
//										}
//										if ("gz_zhuanye".equals(e.getNodeName())) {
//											faultInfo.setGz_zhuanye(e.getFirstChild().toString());
//										}
//										if ("gz_bxr".equals(e.getNodeName())) {
//											faultInfo.setGz_bxr(e.getFirstChild().toString());
//										}
//										if ("gz_tel".equals(e.getNodeName())) {
//											faultInfo.setGz_tel(e.getFirstChild().toString());
//										}
//										if ("gz_bianhao".equals(e.getNodeName())) {
//											faultInfo.setGz_bianhao(e.getFirstChild().toString());
//										}
//										if ("gz_coid".equals(e.getNodeName())) {
//											faultInfo.setGz_coid(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("gz_content".equals(e.getNodeName())) {
//											faultInfo.setGz_content(e.getFirstChild().toString());
//										}
//										if ("gz_adder".equals(e.getNodeName())) {
//											faultInfo.setGz_adder(e.getFirstChild().toString());
//										}
//										if ("gz_addtime".equals(e.getNodeName())) {
//											try {
//												faultInfo.setGz_addtime(DateUtils.parseAnyString(e.getFirstChild().toString()));
//											} catch (ParseException e1) {
//												e1.printStackTrace();
//											}
//										}
//										if ("gz_flag".equals(e.getNodeName())) {
//											faultInfo.setGz_flag(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("gz_ddren".equals(e.getNodeName())) {
//											faultInfo.setGz_ddren(e.getFirstChild().toString());
//										}
//										if ("gz_ddtime".equals(e.getNodeName())) {
//											try {
//												faultInfo.setGz_ddtime(DateUtils.parseAnyString(e.getFirstChild().toString()));
//											} catch (ParseException e1) {
//												e1.printStackTrace();
//											}
//										}
//										if ("gz_xfid".equals(e.getNodeName())) {
//											faultInfo.setGz_xfid(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("gz_clid".equals(e.getNodeName())) {
//											faultInfo.setGz_clid(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("gz_qrid".equals(e.getNodeName())) {
//											faultInfo.setGz_qrid(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("gz_dbren".equals(e.getNodeName())) {
//											faultInfo.setGz_dbren(e.getFirstChild().toString());
//										}
//										if ("gz_ifcoid".equals(e.getNodeName())) {
//											faultInfo.setGz_ifcoid(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("lx".equals(e.getNodeName())) {
//											line = e.getFirstChild().toString();
//										}
//										if ("zd".equals(e.getNodeName())) {
//											station = e.getFirstChild().toString();
//										}
//										if ("djName".equals(e.getNodeName())) {
//											faultInfo.setDjName(e.getFirstChild().toString());
//										}
//										if ("dj".equals(e.getNodeName())) {
//											faultInfo.setDj(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("yc_time".equals(e.getNodeName())) {
//											faultInfo.setYc_time(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("xy_time".equals(e.getNodeName())) {
//											faultInfo.setXy_time(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("red".equals(e.getNodeName())) {
//											faultInfo.setRed(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("jx_dw".equals(e.getNodeName())) {
//											faultInfo.setJx_dw(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("jx_flag".equals(e.getNodeName())) {
//											faultInfo.setJx_flag(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("lh".equals(e.getNodeName())) {
//											faultInfo.setLh(e.getFirstChild().toString());
//										}
//										if ("scdd".equals(e.getNodeName())) {
//											faultInfo.setScdd(e.getFirstChild().toString());
//										}
//										if ("jxr".equals(e.getNodeName())) {
//											faultInfo.setJxr(e.getFirstChild().toString());
//										}
//										if ("qrr".equals(e.getNodeName())) {
//											faultInfo.setQrr(e.getFirstChild().toString());
//										}
//										if ("jxdw".equals(e.getNodeName())) {
//											faultInfo.setJxdw(e.getFirstChild().toString());
//										}
//										if ("qrsj".equals(e.getNodeName())) {
//											try {
//												faultInfo.setQrsj(DateUtils.parseAnyString(e.getFirstChild().toString()));
//											} catch (ParseException e1) {
//												e1.printStackTrace();
//											}
//										}
//										if ("gzlx".equals(e.getNodeName())) {
//											faultInfo.setGzlx(e.getFirstChild().toString());
//										}
//									}
//								}
//								if (line.length() > 3) {
//									line = line.substring(0, 3);
//								}
//								if (!"".equals(line) && !"".equals(station)) {
//									Lift lift = liftDao.findByLineStationNumber(line,station,s);
//									faultInfo.setLift(lift);
//									List<FaultInfo> list = faultInfoDao.findByGzId(faultInfo.getGz_id());
//									if (list.isEmpty()) {
//										faultInfoDao.save(faultInfo);
//									}
//								}
//							}
//						}
//					}
//					
//				}
//			}
//			
//			MessageElement element2[] = result2.get_any();
//			for (MessageElement me : element2) {
//				NodeList nodelist = me.getChildNodes();
//				for (int i=0; i<nodelist.getLength(); i++) {
//					Node node = nodelist.item(i);
//					if ("NewDataSet".equals(node.getNodeName())) {
//						NodeList dsList = node.getChildNodes();
//						for (int j=0;j<dsList.getLength();j++) {
//							Node ds = dsList.item(j);
//							if ("ds".equals(ds.getNodeName())) {
//								NodeList eList = ds.getChildNodes();
//								LiftEvent event = new LiftEvent();
//								String line = "";
//								String station = "";
//								for (int k=0;k<eList.getLength();k++) {
//									Node e = eList.item(k);
//									if (e != null && e.getFirstChild() != null) {
//										if ("bg_id".equals(e.getNodeName())) {
//											event.setBg_id(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("bg_date".equals(e.getNodeName())) {
//											try {
//												event.setBg_date(DateUtils.parseAnyString(e.getFirstChild().toString()));
//											} catch (ParseException e1) {
//												e1.printStackTrace();
//											}
//										}
//										if ("bg_time".equals(e.getNodeName())) {
//											try {
//												event.setBg_time(DateUtils.parseAnyString(e.getFirstChild().toString()));
//											} catch (ParseException e1) {
//												e1.printStackTrace();
//											}
//										}
//										if ("bg_cc".equals(e.getNodeName())) {
//											event.setBg_cc(e.getFirstChild().toString());
//										}
//										if ("bg_ch".equals(e.getNodeName())) {
//											event.setBg_ch(e.getFirstChild().toString());
//										}
//										if ("bg_address".equals(e.getNodeName())) {
////											event.setAdd
//										}
//										if ("bg_ren".equals(e.getNodeName())) {
//											event.setBg_ren(e.getFirstChild().toString());
//										}
//										if ("bg_title".equals(e.getNodeName())) {
//											event.setBg_title(e.getFirstChild().toString());
//										}
//										if ("bg_content".equals(e.getNodeName())) {
//											event.setBg_content(e.getFirstChild().toString());
//										}
//										if ("bg_clfx".equals(e.getNodeName())) {
//											event.setBg_clfx(e.getFirstChild().toString());
//										}
//										if ("bg_tbrname".equals(e.getNodeName())) {
//											event.setBg_tbrname(e.getFirstChild().toString());
//										}
//										if ("bg_depname".equals(e.getNodeName())) {
//											event.setBg_depname(e.getFirstChild().toString());
//										}
//										if ("bg_zgname".equals(e.getNodeName())) {
//											event.setBg_zgname(e.getFirstChild().toString());
//										}
//										if ("adder".equals(e.getNodeName())) {
//											event.setAdder(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("addtime".equals(e.getNodeName())) {
//											try {
//												event.setAddtime(DateUtils.parseAnyString(e.getFirstChild().toString()));
//											} catch (ParseException e1) {
//												e1.printStackTrace();
//											}
//										}
//										if ("bg_depid".equals(e.getNodeName())) {
//											event.setBg_depid(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("bg_flag".equals(e.getNodeName())) {
//											event.setBg_flag(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("bg_shenheTime".equals(e.getNodeName())) {
//											try {
//												event.setBg_shenheTime(DateUtils.parseAnyString(e.getFirstChild().toString()));
//											} catch (ParseException e1) {
//												e1.printStackTrace();
//											}
//										}
//										if ("bg_isKan".equals(e.getNodeName())) {
//											event.setBg_isKan(Integer.valueOf(e.getFirstChild().toString()));
//										}
//										if ("bg_zdName".equals(e.getNodeName())) {
//											event.setBg_zdName(e.getFirstChild().toString());
//										}
//										if ("xlName".equals(e.getNodeName())) {
//											line = e.getFirstChild().toString();
//										}
//										if ("zdName".equals(e.getNodeName())) {
//											station = e.getFirstChild().toString();
//										}
//									}
//									if (line.length() > 3) {
//										line = line.substring(0, 3);
//									}
//									if (!"".equals(line) && !"".equals(station)) {
//										Lift lift = liftDao.findByLineStationNumber(line,station,s);
//										event.setLift(lift);
//										List<Event> list = liftEventDao.findByGzId(event.getBg_id());
//										if (list.isEmpty()) {
//											liftEventDao.save(event);
//										}
//									}
//									
//								}
//							}
//						}
//					}
//				}
//			}
//			
//			
//			
//		}
//	}
//}
