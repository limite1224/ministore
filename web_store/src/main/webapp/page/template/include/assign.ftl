<#setting number_format="#">
<#setting date_format="yyyy-MM-dd">
<#setting datetime_format="yyyy-MM-dd">
<#setting time_format="yyyy-MM-dd">

<#assign mail = "jilm@ekhui.com">
<#assign date = "2017-2018">
<#assign companyName="杭州乐舜信息科技有限公司">
<#assign productName="乐舜物联网服务管理平台">
<#assign version="1.0">
<#if (id)??>
	<#assign isAdd = false />
<#else>
	<#assign isAdd = true />
</#if>

<#if account?? && account="admin">
	<#assign isAdmin = true/>
<#else>
	<#assign isAdmin = false/>
</#if>
<#macro copyright date=""> 
	<p>Copyright ©${date} ${companyName} All Rights Reserved 浙ICP备 18013318号Email: ${mail}</p>
</#macro> 