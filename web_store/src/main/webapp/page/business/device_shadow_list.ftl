<#include "../template/template_listPage.ftl"/>
<@header title="设备影子信息">
</@header>
<body>
	<div class="main-content">
		<div class="page-content">
			<div class="page-header">
				<h1>
					设备影子信息
					<small>
						设备影子信息管理
					</small>
				</h1>
			</div>
			<div class="row" style="padding-left:20px;padding-right:20px">
			<@pageList page=(page!) id="listForm" action="${web_base}/business/p_device_shadow!list.htm" query="entity" isEmpty=true>
					<!--条件查询-->
				<div class="row" style="padding-left:20px;">
				
				<div class="row">
					<div class="col-xs-2">
						<div class="form-group">
							<label class="col-xs-12 control-label no-padding-right" for="id-1">设备编号</label>
								<input type="text" id="id-1" placeholder="设备编号" class="form-control required"
								 		name="entity.deviceId" value="${(entity.deviceId)!}" />
						</div>
					</div>
					<div class="col-xs-2">
						<div class="form-group">
							<label class="col-xs-12 control-label no-padding-right" for="id-2">设备名称</label>
								<input type="text" id="id-2" placeholder="设备名称" class="form-control required"
								 		name="entity.deviceName" value="${(entity.deviceName)!}" />
						</div>
					</div>
				</div>
				
				<div class="row" style="margin-left: 0px;">
					<button  type="submit" class="btn btn-sm btn-primary no-border"><i class="icon-search icon-1x icon-only"></i>查询</button>
				</div>

                 </div>
                 <hr>
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">
							设备影子
						</div>
							<div class="table-responsive">
								<table id="userTable" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center">
												<label>
													<input type="checkbox" class="ace"/>
													<span class="lbl"></span>
												</label>
											</th>
											<th>设备编号</th>
											<th>设备名称</th>
											<th>mac地址</th>
											<th>最新数据</th>
											<th>更新时间</th>
											<th>备注</th>
											<th></th>
										</tr>
									</thead>
								<tbody class="center">
								<#if page?? && page.list??>
									<#list  page.list as obj>
										<tr>
											<td class="center">
												<label>
													<input type="checkbox" class="ace"   name="ids" value="${(obj.deviceId)!}" />
													<span class="lbl"></span>
												</label>
											</td>
											<td>
												<span>${(obj.deviceId)!}</span>
											</td>
											<td>
												<span>${(obj.deviceName)!}</span>
											</td>
											<td>
												<span>${(obj.deviceMac)!}</span>
											</td>
											<td>
												<#if obj.customPropertyMap??>
													<#list obj.customPropertyMap?keys as key>
														${key!}：${obj.customPropertyMap["${key!}"]!}</br>
													</#list>
												</#if>
											</td>
											<td>
												<span><#if obj.modifyTime??>${(obj.modifyTime?string("yyyy-MM-dd HH:mm:ss"))!}</#if></span>
											</td>	
											<td>
												<span>${(obj.remark)!}</span>
											</td>																				
											<td>
												<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="blue" href="${web_base}/business/device_shadow!detail.htm?id=${(obj.deviceId)!}" title="详情">
														<i class="icon-zoom-in bigger-130"></i>
													</a>
												</div>
			
											</td>
										</tr>
									</#list>
								</#if>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</@pageList>
			</div>
		</div>
	</div>
	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
	</div>
		
</body>
</html>