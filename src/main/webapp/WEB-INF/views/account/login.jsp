<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglibs.jsp"%>
	
<spring:message code="NB.TITLE" var="i18n_NBTITLE"/>
<spring:message code="XT.TITLE" var="i18n_XTTITLE"/>
<spring:message code="login.name" var="i18n_loginName"/>
<spring:message code="login.pass" var="i18n_loginPass"/>
<spring:message code="login.remb" var="i18n_loginRemb"/>
<spring:message code="login.submit" var="i18n_loginSubmit"/>
	
<div class="container">
      
       		<div id="login-wraper">
       		
     				
						
	            <form  id="sign-in" action="<c:url value='/login'/>" method="post" class="form login-form">
	                <legend><font size="5">${i18n_NBTITLE}<span class="blue"> ${i18n_XTTITLE}</span></font></legend>
	                
	                
	            
	                <div class="body">
	                	<c:if test="${!empty message}">   
								<strong>
									<span style="color:red;">
									${message}
									</span>
								</strong>
								<br>
								<br>		
						</c:if>  
	                    <label>${i18n_loginName}</label>
	                    <c:if test="${errorUsername}"> 
							<div class="form-group has-error">
						</c:if>
	                   <input type="text" id="username" name="username" value="${username}"  />
	                    <c:if test="${errorUsername}"> 
							</div>
						</c:if>
	                    <label>${i18n_loginPass}</label>
	                    <input type="password" id="password" name="password" value="${password}" />
	                </div>
	            
	                <div class="footer">
	                    <label class="checkbox inline">
	                    	<input name="rememberme" type="checkbox" id="rememberme"/>
	                        ${i18n_loginRemb}
	                    </label>
	                                
	                    <button type="submit" class="btn btn-success"><b>${i18n_loginSubmit}</b></button>
	                </div>
	            
	            </form>
	        </div>

    </div>	
    
    <footer class="white navbar-fixed-bottom">
    <!--  &copy; 上海悦闻信息技术有限公司 -->
    </footer>