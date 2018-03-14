<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglibs.jsp"%>

<spring:message code="forget.username.placeholder" var="i18n_usernamePlaceholder"/>
<spring:message code="forget.email.placeholder" var="i18n_emailPlaceholder"/>
<spring:message code="forget.login" var="i18n_login"/>
<spring:message code="widget.form.newpass" var="i18n_newpass"/>
<spring:message code="widget.form.reset" var="i18n_reset"/>
<spring:message code="forget.pass" var="i18n_forgetPass"/>
<spring:message code="forget.username" var="i18n_forgetUserName"/>
<spring:message code="forget.email" var="i18n_forgetEmail"/>

<div class="login-layout">
  <div class="login-wrap">
    <div class="login-hd"><span>${i18n_forgetPass}</span></div>
    <div class="login-con">
		
      <form action="<c:url value='/forget'/>" method="post">
        <div class="login-username">
          <label>${i18n_forgetUserName}</label>
          <input name="userName" type="text" class="inputtext" placeholder="${i18n_usernamePlaceholder}"  value="${user.userName}"/>
        </div>
        <div class="login-password">
          <label>${i18n_forgetEmail}</label>
          <input name="email" type="text" class="inputtext"  placeholder="${i18n_emailPlaceholder}"  value="${user.email}"/>
        </div>
        <div class="login-error">
         <font style="color:red;"> ${message} </font>
         </div>
         
        <div class="login-role">

          <a href="<c:url value='/login'/>" class="forgot">${i18n_login}</a> </div>
         
        <div class="login-btns">
          <input name="" type="submit" value="${i18n_newpass}" class="btn-submit"  />
          <input name="" type="reset" value="${i18n_reset}" class="btn-reset" />
        </div>
      </form>
    </div>
  </div>
</div>