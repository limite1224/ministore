<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>提示信息 - Powered By </title>
		<link rel="icon" href="${web_static}/favicon.ico" type="image/x-icon" sizes="16x16" />
		<#include "../template/include/source.ftl"/>
	</head>

	<body>
		<div class="main-content">
			<div class="page-content">
				<div class="row" style="margin-top:100px ;">
					<div class="col-xs-3"></div>
					<div class="col-xs-6">
						<div class="well">
							<button type="button" class="close" data-dismiss="alert">
								<i class="icon-remove"></i>
							</button>
							<p>
								<#if flag>
									<h4 class="green smaller lighter"><i class="icon-ok"></i>操作成功
									<small>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您的操作已成功.
									</small>
									</h4>
								<#else>
									<h4 class="red smaller lighter"><i class="icon-remove"></i>操作错误
									<small>
									<#if actionErrors?? && (actionErrors?size> 0)>
										<#list errorMessages as list>${list!}<br></#list>
									</#if>
									</small>
									</h4>
								</#if>
								
							</p>
							<p class="center">
								<input type="button" class="btn btn-sm btn-success" <#if flag && redirectionUrl??>onclick="window.location.href='${redirectionUrl}'"
								<#else>onclick="window.history.back(); return false;"</#if> value="O K!" hidefocus="true" />
							</p>
						</div>
						<div class="col-xs-3"></div>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>