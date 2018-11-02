<#include "../template/template_listPage.ftl"/>
<@header title="消息信息管理">
</@header>
<body>
	<div class="main-content">
		<@messageModal message="${message!}"/>
		<div class="page-content">
			<div class="page-header">
				<h1>
					消息管理
					<small>
						消息记录信息
					</small>
				</h1>
			</div>
			<div class="row" style="padding-left:20px;padding-right:20px">
			<@pageList page=(page!) id="listForm" action="${web_base}/business/device_message!list.htm" query="entity" isEmpty=true>
					<!--条件插查询-->
				<div class="row" style="padding-left:20px;">
					<div class="row">
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="deviceId">设备编号</label>
									<input type="text" class="form-control required" id="deviceId" name = "entity.deviceId" value="${entity.deviceId!}" placeholder="设备编号" >
							</div>
						</div>
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="messageId">消息编号</label>
									<input type="text" class="form-control required" id="messageId" name = "entity.messageId" value="${entity.messageId!}" placeholder="消息编号" >
							</div>
						</div>
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="messageType">消息类型</label>
									<select class="form-control" id="messageType" name = "entity.messageType">
										<option value="">全部</option>
										<option value="0" <#if entity?? && entity.messageType?? && entity.messageType=='0'>selected</#if>>短消息</option>
										<option value="1" <#if entity?? && entity.messageType?? && entity.messageType=='1'>selected</#if>>长消息</option>
									</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-9">
						<button  type="submit" class="btn btn-sm btn-primary no-border"><i class="icon-search icon-1x icon-only"></i>查询</button>&nbsp;
	                 	</div>
	                 </div>
                 </div>
                 <hr>
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">
							消息记录管理
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
											<th>第三方设备编号</th>
											<th>消息内容</th>
											<th>推送时间</th>
											<th>操  作  者</th>
											<th>插入时间</th>
											<th>描        述</th>
											<th></th>
										</tr>
									</thead>
								<tbody class="center">
								<#if page?? && page.list??>
									<#list  page.list as obj>
										<tr>
											<td class="center">
												<label>
													<input type="checkbox" class="ace" name="ids" value="${obj.id!}"/>
													<span class="lbl"></span>
												</label>
											</td>
											<td>
												<span>${obj.deviceId!}</span>
											</td>
											<td>
												<span>${obj.accessDeviceId!}</span>
											</td>
											<td title="${obj.messageId!}">
												<span>${obj.message!}</span>
											</td>
											<td>
												<span><#if obj.outPushTime??>${obj.outPushTime?string("yyyy-MM-dd HH:mm:ss")!}</#if></span>
											</td>
											<td>
												<span>${obj.createBy!}</span>
											</td>
											<td>
												<span>${obj.createTime?string('yyyy-MM-dd HH:mm:dd')!}</span>
											</td>
											<td>
												<span>
													${obj.remark!}
												</span>
											</td>
											<td>
												<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="blue" href="${web_base}/business/device_message!detail.htm?id=${(obj.id)!}"  title="详情" >
														<i class="icon-zoom-in bigger-120"></i>
													</a>
			
													<#--<a class="green" href="${web_base}/business/product_info!form.htm?entity.id=${obj.id}" title="编辑">
														<i class="icon-pencil bigger-120"></i>
													</a>
			
													<a class="red" href="javascript:void(0);" onclick="deleteProduct('${obj.id!}','${obj.productName}')" title="删除">
														<i class="icon-trash bigger-120"></i>
													</a>-->
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
	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
	</div>
</body>
</html>