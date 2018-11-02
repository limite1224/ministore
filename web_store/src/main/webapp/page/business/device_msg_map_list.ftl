<#include "../template/template_listPage.ftl"/>
<@header title="设备映射信息管理">
<script>
		function deleteDMM(id,name){
			var msg = "你确定删除映射"+name+"吗？";
			var data = {
				id:id
			}
			bootbox.confirm({
				message: msg,
				buttons: {
					cancel: {
						label: '取消',
					},
					confirm: {
						label: '确定',
						className: 'btn btn-info'
					}
				},
				callback: function(result) {
					if(result) {
						$.ajax({
							type: "post",
							url: "${web_base}/business/device_msg_map!delete.htm",
							data: data,
							async: true,
							dataType:'json',
							success: function(res) {
								var code = res.code;
								var msg = res.msg;
								console.log(res);
								if('0'==code){
									alert_leshun("danger", "操作失败："+msg, true);
								}else if('1'==code){
									alert_leshun("success", "删除操作成功", true);
								}
							},
							error: function(message) {
								alert_leshun("danger", "操作异常："+message, true);
							}
						});
					}
				}
			});
		}
	</script>
</@header>
<body>
	<div class="main-content">
		<@messageModal message="${message!}"/>
		<div class="page-content">
			<div class="page-header">
				<h1>
					设备信息
					<small>
						设备映射信息管理
					</small>
				</h1>
			</div>
			<div class="row" style="padding-left:20px;padding-right:20px">
			<@pageList page=(page!) id="listForm" action="${web_base}/business/device_msg_map!list.htm" query="entity" isEmpty=true>
					<!--条件插查询-->
				<div class="row" style="padding-left:20px;">
					<div class="row">
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="id">映射编号</label>
									<input type="text" class="form-control required" id="id" name = "entity.id" value="${entity.id!}" placeholder="映射编号" >
							</div>
						</div>
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="diviceName">设备名称</label>
									<input type="text" class="form-control required" id="diviceName" name = "entity.diviceName" value="${entity.diviceName!}" placeholder="设备名称" >
							</div>
						</div>
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="diviceId">设备标识</label>
									<input type="text" class="form-control required" id="diviceId" name = "entity.diviceId" value="${entity.diviceId!}" placeholder="设备标识" >
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-9">
						<button  type="submit" class="btn btn-sm btn-primary no-border"><i class="icon-search icon-1x icon-only"></i>查询</button>&nbsp;
						<button  type="button" class="btn btn-sm btn-success no-border icon-only modal-leshun insert-leshun"><i class="icon-plus icon-1x icon-only"></i>新增</a>&nbsp;
	                 	</div>
	                 </div>
                 </div>
                 <hr>
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">
							设备映射信息管理
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
											<th>映射编号</th>
											<th>设备名称</th>
											<th>设备编号</th>
											<th>标签名</th>
											<th>设备属性</th>
											<th>备注</th>
											<th class="operation-leshun"></th>
										</tr>
									</thead>
								<tbody class = "center">
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
												<span>${obj.id!}</span>
											</td>
											<td>
												<span>${obj.diviceName!}</span>
											</td>
											<td>
												<span>${obj.diviceId!}</span>
											</td>
											<td>
												<span>${obj.diviceMsgKey!}</span>
											</td>
											<td>
												<span>${obj.diviceMsgName!}</span>
											</td>
											<td>
												<span>${obj.diviceRemark!}</span>
											</td>
											<td>
												<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="green" href="${web_base}/business/device_msg_map!form.htm?id=${obj.id}" title="编辑">
														<i class="icon-pencil bigger-120"></i>
													</a>
													<a class="red" href="javascript:void(0);" onclick="deleteDMM('${obj.id!}','${obj.diviceName!}')" title="删除">
														<i class="icon-trash bigger-120"></i>
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
	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
	</div>
	<div id="insertModal" class="modal" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="blue bigger">
						设备映射新增
						<small>&nbsp;${deviceName!}</small>
					</h4>
				</div>
				<div id="warnDiv" class="alert alert-danger" style="display:none">
					<p></p>
				<br>
			</div>
				<div class="modal-body overflow-visible">
					<form class="form-horizontal" action="${web_base}/business/device_msg_map!save.htm" onsubmit= "return checkParams();" method="post">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="deviceIdModal">设备名称</label>
							<div class="col-sm-9">
								<select class="col-sm-10" id="deviceIdModal" name="entity.diviceId">
									<option value="">-选择设备-</option>
									<#if deviceList??>
										<#list deviceList as obj>
											<option value="${obj.deviceId!}">${obj.deviceName!}</option>
										</#list>
									</#if>
								</select>
								<input type="hidden" id="deviceNameModal"  name="entity.diviceName" />
							</div>
						</div>
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="deviceMsgKeyModal">标签名称</label>
							<div class="col-sm-9">
								<input type="text" id="deviceMsgKeyModal" name="entity.diviceMsgKey" class="col-sm-10" />
							</div>
						</div>
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="deviceMsgNameModal">设备属性</label>
							<div class="col-sm-9">
								<input type="text" id="deviceMsgNameModal" name="entity.diviceMsgName" class="col-sm-10" />
							</div>
						</div>
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="deviceRemarkModal">备注 </label>
							<div class="col-sm-9">
								<textarea class="col-sm-10" name="entity.diviceRemark" id="deviceRemarkModal"></textarea>
							</div>
						</div>
						<div class="space-4"></div>
						
						<div class="center">
							<button type="submit" class="btn btn-sm btn-info icon-only">
								<i class="icon-print align-top">保存</i>
							</button>
							<button type="button" class="btn btn-sm icon-only" data-dismiss="modal" aria-label="Close">
								<i class="icon-arrow-left align-top">取消</i>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		function checkParams(){
			var deviceIdModal = $("#deviceIdModal").val();
			if(deviceIdModal==''){
				$("#warnDiv p").html("请先选择一个设备");
				$("#warnDiv").attr("style","height:35px;display:''");
				setInterval(function(){$("#warnDiv").attr("style","display:none")},1000);
				return false;
			}
			var deviceMsgKeyModal = $("#deviceMsgKeyModal").val();
			if(deviceMsgKeyModal==''){
				$("#warnDiv p").html("标签名不能为空");
				$("#warnDiv").attr("style","height:35px;display:''");
				setInterval(function(){$("#warnDiv").attr("style","display:none")},1000);
				return false;
			}
			var deviceMsgNameModal = $("#deviceMsgNameModal").val();
			if(deviceMsgNameModal==''){
				$("#warnDiv p").html("设备属性不能为空");
				$("#warnDiv").attr("style","display:''");
				$("#warnDiv").attr("style","height:35px;display:''");
				setInterval(function(){$("#warnDiv").attr("style","display:none")},1000);
				return false;
			}
		}
		$("#deviceIdModal").on("change",function(){
			$("#deviceNameModal").val($("#deviceIdModal option:selected").text());
		})
	</script>
</body>