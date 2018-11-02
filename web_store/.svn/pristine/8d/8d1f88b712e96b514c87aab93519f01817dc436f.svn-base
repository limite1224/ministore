<#include "template/template_main.ftl">
<#include "template/template_menu.ftl">
	<@main>
		<style>
			#scrollBox {
				width: 600px;
				height: 40px;
				margin-top: 14px;
				margin-right: 300px;
				margin-bottom: 16px;
				margin-left: 300px;
				position: absolute;
				overflow: hidden;
			}
			#scrolls {
				position: absolute;
				list-style: none;
				width: 1000px;
			}
			#scrolls li {
				float: right;
				display: inline;
				width: 500px;
				height: 40px;
				margin: 0 5px;
				color: yellow;
			}
		</style>
		<script type="text/javascript">
			window.onload = function() {
				var scrolls = document.getElementById("scrolls");
				// 使scrolls里面的内容加倍，以便连续显示
				//scrolls.innerHTML += scrolls.innerHTML;
				// 初始化scrolls的水平位置
				scrolls.style.left = 0 + "px";
				// 启动定时器
				setInterval("Scroll()", 10);
			}

			function Scroll() {
				var scrolls = document.getElementById("scrolls");
				// 获取当前scrolls的水平位置left，并让其减少一个像素
				var left = parseInt(scrolls.style.left);
				left--;
				// 如果left当前的值与页面刚加载时ul里面内容的宽度相同，则left自动由当前值变成0，视觉上不会发生变化
				if(left == -1000) left = 0;
				// 重新设置scrolls的水平坐标
				scrolls.style.left = left + "px";
			}
		</script>
	</@main>

	<body>
	
	<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>
			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="/main!main.htm" class="navbar-brand" target="mainFrame" >
						<small>
							<img src="${web_static}/images/ic1.png" width="25" height="25"/>
							${productName}
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->
				<div id="scrollBox">
					<ul id="scrolls">
						<li>【${companyName}】将竭诚为你做好物联网联接服务！</li>
					</ul>
				</div>
				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${web_static}/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome</small>
									${(operator!).account!}
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="${web_base}/sys/operator!userInfo.htm" target="mainFrame">
										<i class="icon-user"></i>
										个人中心
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="${web_base}/logout!execute.htm">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>
			<script type="text/javascript">
				try {
					ace.settings.check('main-container', 'fixed')
				} catch(e) {}
			</script>

		<div class="main-container" id="main-container">
			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<@fixedMenu/>

				<div class="main-content" style="overflow:auto;">
					<iframe id="mainFrame" name="mainFrame"  src="${web_base}/main!main.htm" style="width:100%;min-height: 580px;overflow:auto;" scrolling="yes" frameborder="no"></iframe>
				</div>
				<div class="center" style="border-top:solid 2px #0663A2;margin-bottom:3px;">
					<@copyright date="2017-2018"/>
				</div>
			</div>
		</div>
		<!-- ./wrapper -->
	</body>
	</html>