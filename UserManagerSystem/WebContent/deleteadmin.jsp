<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
 <base href="<%=basePath%>">
 <script src="js/clock.js" type="text/javascript"></script>
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TR height=28>
    <TD background=images/title_bg1.jpg>当前位置: </TD></TR>
  <TR>
    <TD bgColor=#b1ceef height=1></TD></TR>
  <TR height=20>
    <TD background=images/shadow_bg.jpg></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
  <TR height=100>
    <TD align=middle width=100><IMG height=100 src="images/admin_p.gif" 
      width=90></TD>
    <TD width=60>&nbsp;</TD>
    <TD>
      <TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>
        
        <TR>
          <TD>当前时间：<span id="myclock"></span></TD></TR>
        <TR>
          <TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px">${user.nic}</TD></TR>
        <TR>
          <TD>欢迎进入用户管理中心！</TD></TR></TABLE></TD></TR>
  <TR>
    <TD colSpan=3 height=10></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
  <TR height=20>
    <TD></TD></TR>
  <TR height=22>
    <TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff" 
    align=middle background=images/title_bg2.jpg>所有管理员信息列表如下</TD></TR>
  <TR bgColor=#ecf4fc height=12>
    <TD></TD></TR>
  <TR height=20>
    <TD></TD></TR></TABLE>
    
<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0 class="table">
  <TR>
    <TD align=center width=80>登录帐号</TD>
    <TD align=center width=80>昵称</TD>
    <TD align=center width=80>真实姓名</TD>
    <td align="center" width=80>查看详情</td>
    <td align="center" width=80>删除管理员</td>
  </TR>
 <s:iterator value="alladmin">
     <tr>
       <td  align=center width=80><s:property value="username"/></td>
       <td  align=center width=80><s:property value="nic"/></td>
       <td  align=center width=80><s:property value="name"/></td>
       <td  align=center width=80><a href="common/scan?id=${id}" target="main">查看详情</a></td> 
       <td  align=center width=80><a href="admin/deleteadmin?id=${id}" target="main">删除管理员</a></td> 
     </tr>
     </s:iterator>
    </TABLE>
    </BODY>
    </HTML>