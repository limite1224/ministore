<#-- 导入模版定义文件-->
<#include "template/template_login.ftl">
<@login title=t?default("登录")>
	<body>
		<div class="main-container">
			<@messageModal message="${login_error!}"/>
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<DIV class="middle-box text-center loginscreen animated fadeInDown">
								<DIV>
									<h1 class="logo-name">
									<img src="${web_static}/images/leshun1.png"/>
									</h1>
								</DIV>
								
								<H3>欢迎进入乐舜智能管理系统</H3>
								<P>
									<!--说明文字-->&nbsp;</P>
								<FORM class="m-t" role="form" method="post" action="${web_base}/login!login.htm">
									<DIV class="form-group">
										<INPUT class="form-control" name="operator.account" type="text" required="" placeholder="用户名">
									</DIV>
									<DIV class="form-group">
										<INPUT class="form-control" name="operator.pwd" type="password" required="" placeholder="密码">
									</DIV>
									<BUTTON class="btn btn-primary block full-width m-b" 
										type="submit" style="border: none; width: 375px;" >登录</BUTTON>
								</FORM>
							</DIV>
							<DIV style='width: 100%; text-align: left; right: 0px; bottom: 0px; color: rgb(0, 0, 0); font-family: "微软雅黑"; font-size: 14px; position: fixed; z-index: 999999;' id="think_page_trace">
								<DIV style="background: white; margin: 0px; height: 250px; display: none;" id="think_page_trace_tab">
								</div>
							</div>
							<!-- /.col -->
						</div>
						<!-- /.row -->
					</div>
				</div>
	<script type="text/javascript">
			// 登录页面若在框架内，则跳出框架
			if (self != top) {
				top.location = self.location;
			};
	</script>
	</body>
</@login>