<#include "../template/template_listPage.ftl"/>
<@header title="设备信息">
</@header>
<body>
	<div class="main-content">
		<div class="page-content">
			<div class="page-header">
				<h1>
					设备信息
					<small>
						设备信息管理
					</small>
				</h1>
			</div>
			<div class="row" style="padding-left:20px;padding-right:20px">
			<@pageList page=(page!) id="listForm" action="${web_base}/user/device_info!list.htm" query="entity" isEmpty=true>
					<!--条件查询-->
				<div class="row" style="padding-left:20px;">
					<div class="row">
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="deviceName">设备名称</label>
									<input type="text" id="deviceName" placeholder="设备名称" class="form-control required"
									 		name="entity.deviceName" value="${(entity.deviceName)!}" />
							</div>
						</div>
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="deviceMac">SN编码</label>
									<input type="text" id="deviceMac" placeholder="SN编码" class="form-control required"
									 		name="entity.deviceMac" value="${(entity.deviceMac)!}" />
							</div>
						</div>
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="form-field-select-2">设备状态</label>
								<select class="width-90 link-height-1"  id="form-field-select-2" name="entity.status" value="${(entity.status)!}" >
									<option value="">
				                   	 全部
				                	</option>
				                	<option value="0" <#if entity?? && entity.status?? && entity.status="0">selected</#if>>
				                		离线
				                	</option>
				                	<option value="1" <#if entity?? && entity.status?? && entity.status="1">selected</#if>>
				                		在线
				                	</option>
								</select>
							</div>
						</div>
					</div>
				
					<div class="row" style="margin-left:0px;">
						<button  type="submit" class="btn btn-sm btn-primary no-border"><i class="icon-search icon-1x icon-only"></i>查询</button>&nbsp;
					</div>
                 </div>
                 <hr>
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">
							设备列表
						</div>
							<div class="table-responsive">
								<table id="userTable" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>序号</th>
											<th>设备名称</th>
											<th>SN编码</th>
											<th>产品名称</th>
											<th>产品型号</th>
											<th>定        位</th>
											<th>设备状态</th>
											<th>创建时间</th>
											<th>修改时间</th>
											<th class="operation-leshun"></th>
										</tr>
									</thead>
								<tbody class="center">
								<#if page?? && page.list??>
									<#list  page.list as obj>
										<tr>
											<td>${obj_index+1!}</td>
											<td>
												<span>${(obj.deviceName)!}</span>
											</td>
											<td>
												<span>${(obj.deviceMac)!}</span>
											</td>
											<td>
												<span>${(obj.productName)!}</span>
											</td>
											<td>
												<span>${(obj.productKey)!}</span>
											</td>
											<td>浙江 温州</td>
											<td>
												<#if obj?? && obj.status?? && obj.status=="0" > 
													离线
						           	    		<#elseif obj?? && obj.status?? && obj.status=="1" >
						           	    	 		在线
												</#if>
											</td>
											<td>
												<span> ${(obj.createTime?string("yyyy-MM-dd HH:mm:ss"))!}</span>
											</td>
											<td>
												<span> ${(obj.modifyTime?string("yyyy-MM-dd HH:mm:ss"))!}</span>
											</td>																					
											<td>
												<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="blue" href="${web_base}/user/device_info!detail.htm?id=${(obj.deviceId)!}"  title="详情" >
														<i class="icon-zoom-in bigger-120"></i>
													</a>
												</div>
			
											</td>
										</tr>
									</#list>
								</#if>
								</tbody>
							</table>
						</div>
						<#if page?? && page.list?? && (page.list?size <= 0)>
					    	<p class="center orange">没有找到任何记录!</p>
						</#if>
					</div>
				</div>
			</@pageList>
			</div>
		</div>
	</div>
</body>
</html>