<#-- 定义登录页面模版 -->
<#macro edit title>
	<#-- 导入变量定义文件 -->
	<#include "include/assign.ftl">
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>${isAdd?string("添加","修改")!}${title!}</title>
	<#-- 导入meta定义文件 -->
	<#include "include/meta.ftl">
	<#-- 导入静态资源文件 -->
	<#include "include/source.ftl">
	<link rel="icon" href="${web_static}/favicon.ico" type="image/x-icon" sizes="16x16"/>
	</head>
		<#nested>
	</html>
</#macro>
<#-- 定义登录页面模版 -->
<#macro detail title>
	<#-- 导入变量定义文件 -->
	<#include "include/assign.ftl">
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>${title!}</title>
	<#-- 导入meta定义文件 -->
	<#include "include/meta.ftl">
	<#-- 导入静态资源文件 -->
	<#include "include/source.ftl">
	<link rel="icon" href="${web_static}/favicon.ico" type="image/x-icon" sizes="16x16"/>
	</head>
		<#nested>
	</html>
</#macro>

<#macro messageModal message>
	<div id="alert-danger" class="alert alert-danger"	style="display:none;">
		<button type="button" class="close" data-dismiss="alert">
			<i class="icon-remove"></i>
		</button>
		<p>${message!}</p>
	</div>
	<script>
		setInterval(function(){$("#alert-danger").attr("style","display:none")},2000);
	</script>
</#macro>