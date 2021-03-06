<#macro fixedMenu>
	<div class="sidebar" id="sidebar" style="min-height:580px;">
			<ul class="nav nav-list">
				<li>
					<a href="${web_base}/main!main.htm" target="mainFrame">
						<i class="icon-dashboard"></i>
						<span class="menu-text"> 首页 </span>
					</a>
				</li>
				<#if isAdmin>
				<li>
					<a  href="javascript:void(0);" target="mainFrame" class="dropdown-toggle">
						<i class="icon-magnet"></i>
						<span class="menu-text">产品管理</span>
						<b class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="${web_base}/business/product_info!list.htm" target="mainFrame">
								<i class="icon-double-angle-right"></i>
								产品列表
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0);" target="mainFrame" class="dropdown-toggle">
						<i class="icon-desktop"></i>
						<span class="menu-text"> 设备管理 </span>
						<b class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="${web_base}/business/device_info!list.htm" target="mainFrame">
								<i class="icon-double-angle-right"></i>
								设备列表
							</a>
						</li>
						<!--<li>
							<a href="${web_base}/business/device_shadow!list.htm" target="mainFrame">
								<i class="icon-double-angle-right"></i>
								设备影子信息
							</a>
						</li>
						<li>
							<a href="${web_base}/business/device_msg_map!list.htm" target="mainFrame">
								<i class="icon-double-angle-right"></i>
								设备映射信息
							</a>
						</li>-->
					</ul>
				</li>
				
				<li>
					<a href="javascript:void(0);" target="mainFrame" class="dropdown-toggle">
						<i class="icon-comments"></i>
						<span class="menu-text"> 消息管理 </span>
						<b class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
							<a href="${web_base}/business/device_message!list.htm" target="mainFrame">
								<i class="icon-double-angle-right"></i>
								消息记录信息
							</a>
						</li>
					</ul>
				</li>
				<#else>
					<li>
						<a  href="javascript:void(0);" target="mainFrame" class="dropdown-toggle">
							<i class="icon-magnet"></i>
							<span class="menu-text">产品管理</span>
							<b class="arrow icon-angle-down"></b>
						</a>
						<ul class="submenu">
							<li>
								<a href="${web_base}/user/product_info!list.htm" target="mainFrame">
									<i class="icon-double-angle-right"></i>
									产品列表
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:void(0);" target="mainFrame" class="dropdown-toggle">
							<i class="icon-desktop"></i>
							<span class="menu-text"> 设备管理 </span>
							<b class="arrow icon-angle-down"></b>
						</a>
						<ul class="submenu">
							<li>
								<a href="${web_base}/user/device_info!list.htm" target="mainFrame">
									<i class="icon-double-angle-right"></i>
									设备列表
								</a>
							</li>
						</ul>
					</li>
				</#if>
				<li>
					<a href="${web_base}/logout!execute.htm">
						<i class="icon-off"></i>
						<span class="menu-text"> 退出 </span>
					</a>
				</li>
			</ul>
			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
			</div>

			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch(e) {}
			</script>
		</div>
</#macro>

<#macro menu menuList>
	<div class="sidebar" id="sidebar" style="min-height:580px;">
			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'fixed')
				} catch(e) {}
			</script>

			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="icon-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="icon-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="icon-group"></i>
					</button>

					<button class="btn btn-danger">
						<i class="icon-cogs"></i>
					</button>
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span>

					<span class="btn btn-info"></span>

					<span class="btn btn-warning"></span>

					<span class="btn btn-danger"></span>
				</div>
			</div>
			<!-- #sidebar-shortcuts -->

			<ul class="nav nav-list">
				<li>
					<a href="${web_base}/main!main.htm" target="mainFrame">
						<i class="icon-dashboard"></i>
						<span class="menu-text"> 控制台 </span>
					</a>
				</li>
			<#if menuList??>
				<#list menuList as first>
					<#if first??>
						<li>
							<a  href="${first.url!}" target="mainFrame" <#if first.list??>class="dropdown-toggle"</#if>>
								<i class="${first.icon!}"></i>
								<span class="menu-text"> ${first.name!} </span>
								<#if first.list?? && (first.list?size>0) >
									<b class="arrow icon-angle-down"></b>
								</#if>
							</a>
							<#if first.list?? && (first.list?size>0) >
								<ul class="submenu">
									<#list first.list as second>
										<li>
											<a  href="${second.url!}" target="mainFrame" <#if second.list??>class="dropdown-toggle"</#if>>
												<i class="${second.icon!}"></i>
												${second.name!}
												<#if second.list?? && (second.list?size>0)>
													<b class="arrow icon-angle-down"></b>
												</#if>
											</a>
												<#if second.list?? && (second.list?size>0)>
													<ul class="submenu">
														<#list second.list as third>
															<li>
																<a href="${third.url!}" target="mainFrame" <#if third.list??>class="dropdown-toggle"</#if>>
																	<i class="${third.icon!}"></i>
																	${third.name!}
																	<#if third.list?? && (third.list?size>0)>
																		<b class="arrow icon-angle-down"></b>
																	</#if>
																</a>
																<#if third.list?? && (third.list?size>0)>
																<ul class="submenu">
																	<#list third.list as fourth>
																		<li>
																			<a href="${fourth.url!}" target="mainFrame">
																				<i class="${fourth.icon!}"></i>
																				${fourth.name!}
																			</a>
																		</li>
																	</#list>
																</ul>
																</#if>
															</li>
														</#list>
													</ul>
												</#if>
										</li>
									</#list>
								</ul>
							</#if>
						</li>
					</#if>
				</#list>
			</#if>
			</ul>
			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
			</div>

			<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch(e) {}
			</script>
		</div>
</#macro>