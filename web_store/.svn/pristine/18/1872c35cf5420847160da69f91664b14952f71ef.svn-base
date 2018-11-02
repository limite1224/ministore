<#include "../template/template_listPage.ftl"/>
<@header title="产品数据点表列表">
<script>
		function deleteProduct(id,name){
			var msg = "你确定删除数据点表"+name+"吗？";
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
							url: "${web_base}/business/product_msg_map!delete.htm",
							data: data,
							async: true,
							dataType:'json',
							success: function(res) {
								var code = res.code;
								var msg = res.msg;
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
		<div class="page-content">
			<div class="page-header">
				<h1>
					产品信息
					<small>
						产品数据点表列表
					</small>
				</h1>
			</div>
			<div class="row" style="padding-left:20px;padding-right:20px">
			<@pageList page=(page!) id="listForm" action="" query="entity" isEmpty=true>
					<!--条件插查询-->
				<div class="row" style="padding-left:20px;">
					<div class="row">
						<div class="col-xs-9">
						<button type="button" class="btn btn-sm btn-success no-border icon-only modal-leshun insert-leshun"><i class="icon-plus icon-1x icon-only"></i>新增</a>&nbsp;
	                 	</div>
	                 </div>
                 </div>
                 <hr>
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">
							产品名称：${(productInfo!).productName!}
						</div>
							<div class="table-responsive">
								<table id="userTable" class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<!--<th class="center">
												<label>
													<input type="checkbox" class="ace"/>
													<span class="lbl"></span>
												</label>
											</th>
											<th>映射编号</th>
											<th>产品名称</th>-->
											<th>产品型号</th>
											<th>寄存器地址</th>
											<th>属性名称</th>
											<th>备注</th>
											<th class="operation-leshun"></th>
										</tr>
									</thead>
								<tbody class = "center">
								<#if list??>
									<#list list as obj>
										<tr>
											<!--<td class="center">
												<label>
													<input type="checkbox" class="ace" name="ids" value="${obj.id!}"/>
													<span class="lbl"></span>
												</label>
											</td>
											<td>
												<span>${obj.id!}</span>
											</td>
											<td>
												<span>${obj.productName!}</span>
											</td>-->
											<td>
												<span>${obj.productKey!}</span>
											</td>
											<td>
												<span>${obj.productMsgKey!}</span>
											</td>
											<td>
												<span>${obj.productMsgName!}</span>
											</td>
											<td>
												<span>${obj.productRemark!}</span>
											</td>
											<td>
												<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="green" href="${web_base}/business/product_msg_map!form.htm?id=${obj.id}" title="编辑">
														<i class="icon-pencil bigger-120"></i>
													</a>
													<a class="red" href="javascript:void(0);" onclick="deleteProduct('${obj.id!}','${obj.productName}')" title="删除">
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
						<#if list?? && (list?size <= 0)>
						    	<p class="center orange">没有找到任何记录，请点击新增!</p>
							</#if>
					</div>
				</div>
			</@pageList>
			</div>
		</div>
	</div>
	</div>
	<div id="insertModal" class="modal" tabindex="-1">
		<div class="modal-dialog" role="document">
			<div class="modal-content" id="content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="blue bigger">
						产品映射新增
						<small>&nbsp;${productName!}</small>
					</h4>
				</div>
				<div id="warnDiv" class="alert alert-danger" style="display:none">
					<p></p>
				<br>
			</div>
				<div class="modal-body overflow-visible">
					<form class="form-horizontal" action="${web_base}/business/product_msg_map!save.htm" onsubmit= "return checkParams();" method="post">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="productKeyModal">产品名称</label>
							<div class="col-sm-9">
								<input type="hidden" id="productNameModal"  name="entity.productKey" value="${(productInfo!).productKey!}" class="col-sm-10" />
								<input type="text" id="productNameModal" name="entity.productName"  value="${(productInfo!).productName!}" class="col-sm-10" readonly="true"/>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="productMsgKeyModal">寄存器地址</label>
							<div class="col-sm-9">
								<input type="text" id="productMsgKeyModal" name="entity.productMsgKey" class="col-sm-10" />
							</div>
						</div>
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="productMsgNameModal">参数名称</label>
							<div class="col-sm-9">
								<input type="text" id="productMsgNameModal" name="entity.productMsgName" class="col-sm-10" />
							</div>
						</div>
						<div class="space-4"></div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="productRemarkModal">备注 </label>
							<div class="col-sm-9">
								<textarea class="col-sm-10" name="entity.productRemark" id="productRemarkModal"></textarea>
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
			var productMsgKeyModal = $("#productMsgKeyModal").val();
			if(productMsgKeyModal==''){
				$("#warnDiv p").html("寄存器地址不能为空");
				$("#warnDiv").attr("style","height:35px;display:''");
				setInterval(function(){$("#warnDiv").attr("style","display:none")},1000);
				return false;
			}
			var productMsgNameModal = $("#productMsgNameModal").val();
			if(productMsgNameModal==''){
				$("#warnDiv p").html("参数名称不能为空");
				$("#warnDiv").attr("style","display:''");
				$("#warnDiv").attr("style","height:35px;display:''");
				setInterval(function(){$("#warnDiv").attr("style","display:none")},1000);
				return false;
			}
		}
	</script>
</body>
</html>