<#-- 定义登录页面模版 -->
<#macro login title>
	<#-- 导入变量定义文件 -->
	<#include "include/assign.ftl">
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>${title}</title>
	<#-- 导入meta定义文件 -->
	<link rel="icon" href="${web_static}/favicon.ico" type="image/x-icon" sizes="16x16"/>
	<#include "include/meta.ftl">
	<#include "include/source.ftl">
	</head>
	<#nested>
</#macro>
<#macro messageModal message="">
	<div id="errorDiv"class="alert alert-danger" <#if message=="">style="display:none;"</#if>>
		<button type="button" class="close" data-dismiss="alert">
			<i class="icon-remove"></i>
		</button>
		<strong>${message}</strong>
		<p></p>
		<br>
	</div>
	<script>
		setInterval(function(){$("#errorDiv").attr("style","display:none")},2000);
	</script>
</#macro>