<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>乐舜物联网管理平台</title>
<#include "../template/include/source.ftl">
</head>

<body>
<div class="main-content">
			<div class="page-content">
				<div class="row">
					<div class="error-container">
						<div class="well">
							<h1 class="grey lighter smaller">
								<span class="blue bigger-125">
									<i class="icon-sitemap"></i>
									ERROR
								</span>
								请求发生中断：请联系重新刷新页面或联系我们
							</h1>

							<hr />
							<h3 class="lighter smaller">您可以以下操作:</h3>

							<div>
								<ul class="list-unstyled spaced inline bigger-110 margin-15">
									<li>
										<i class="icon-hand-right blue"></i> 重新检查输入错误的请求地址
									</li>

									<li>
										<i class="icon-hand-right blue"></i> 查看<a href="javascript:$('#detailMsg').attr('style','display:');">详情</a>
									</li>

									<li>
										<i class="icon-hand-right blue"></i> 提交<a href="javascript:alert('暂不支持');">反馈</a>
									</li>
								</ul>
							</div>
							<hr />
							<div class="space"></div>
							<div id="detailMsg" style="display:none;">
								<#if actionErrors??>
									<#list actionErrors as error>
										${error!}
									</#list>
								</#if>
							</div>
							<div class="center">
								<button type="button" class="btn btn-grey" onclick="window.history.back(); return false;"><i class="icon-arrow-left align-top bigger-125"></i>
												返回
											</button>
								<a href="${web_base}/main!main.htm" class="btn btn-primary">
									<i class="icon-dashboard"></i> 前台首页
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>