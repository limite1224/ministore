<#include "../template/template_listPage.ftl"/>
<@header title="产品信息管理">
<script>
		function deleteProduct(id,name){
			var msg = "你确定删除产品"+name+"吗？";
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
							url: "${web_base}/business/product_info!delete.htm",
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
		<@messageModal message="${message!}"/>
		<div class="page-content">
			<div class="page-header">
				<h1 style="float: left;">
					产品信息
					<small>
						产品信息管理
					</small>
				</h1>
				<div class="align-right">
					<a href="${web_base}/business/product_info!form.htm"  class="btn btn-success no-border icon-only"><i class="icon-plus icon-1x icon-only"></i>新增产品</a>&nbsp;
	            </div>
			</div>
			<div class="row" style="padding-left:20px;padding-right:20px">
			<@pageList page=(page!) id="listForm" action="${web_base}/business/product_info!list.htm" query="entity" isEmpty=true>
					<!--条件插查询-->
				<div class="row" style="padding-left:20px;">
					<div class="row">
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="productName">产品名称</label>
									<input type="text" class="form-control required" id="productName" name = "entity.productName" value="${entity.productName!}" placeholder="产品名称" >
							</div>
						</div>
						<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="productKey">产品型号</label>
									<input type="text" class="form-control required" id="productKey" name = "entity.productKey" value="${entity.productKey!}" placeholder="产品型号" >
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-9">
						<button  type="submit" class="btn btn-sm btn-primary no-border"><i class="icon-search icon-1x icon-only"></i>查询</button>&nbsp;
			            <!--<button  type="button" id="batchDelete" class="btn btn-sm btn-danger  no-border"><i class="icon-trash icon-1x icon-only"></i>删除</button>&nbsp;-->
	                 	</div>
	                 </div>
                 </div>
                 <hr>
				<div class="row">
					<div class="col-xs-12">
						<div class="table-header">
							产品信息表管理
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
											</th>-->
											<!--<th>产品编号</th>-->
											<th>序号</th>
											<th>产品名称</th>
											<th>产品型号</th>
											<th>最新操作者</th>
											<th>最新操作时间</th>
											<th>描        述</th>
											<th class="operation-leshun"></th>
										</tr>
									</thead>
								<tbody class="center">
								<#if page?? && page.list??>
									<#list  page.list as obj>
										<tr>
											<!--<td>
												<label>
													<input type="checkbox" class="ace" name="ids" value="${obj.id!}"/>
													<span class="lbl"></span>
												</label>
											</td>-->
											<td>
												<span>${obj_index+1}</span>
											</td>
											<!--<td>
												<span>${obj.id!}</span>
											</td>-->
											<td>
												<span>${obj.productName!}</span>
											</td>
											<td>
												<span>${obj.productKey!}</span>
											</td>
											<td>
											<#if obj.updateBy?exists>
												<span>${obj.updateBy!}</span>
											<#else>
												<span>${obj.createBy!}</span>
											</#if>
											</td>
											<td>
												<#if obj.updateTime?exists&&obj.updateTime?is_date>
													<span>${obj.updateTime?string('yyyy-MM-dd HH:mm:dd')!}</span>
												<#else>
													<#if obj.createTime?exists&&obj.createTime?is_date>
													<span>${obj.createTime?string('yyyy-MM-dd HH:mm:dd')!}</span>
													</#if>
												</#if>
											</td>
											<td>
												<span>
													${obj.remark!}
												</span>
											</td>
											<td>
												<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="blue" href="${web_base}/business/product_info!detail.htm?id=${(obj.id)!}"  title="详情" >
														<i class="icon-zoom-in bigger-120"></i>
													</a>
			
													<a class="green" href="${web_base}/business/product_info!form.htm?id=${obj.id}" title="编辑">
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
	<script>
	jQuery(function(){
		$("#batchDelete").on("click",function(){
		console.log(1);
			if(!checkBoxIsNull("ids")){
				alert_leshun("danger", "未选中相关产品", false);
			}else{
				var msg = "确定删除已选择的产品吗？"
				var idss= [];
				$('input[name="ids"]:checked').each(function(){ 
					idss.push($(this).val()); 
				}); 
				var data={
					ids:idss
				}
				console.log(data);
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
							type: "get",
							url: "${web_base}/business/product_info!batchDelete.htm",
							async: true,
							data:data,
							dataType:'json',
							traditional: true,
							success: function(res) {
								var code = res.code;
								var msg = res.msg;
								if('0'==code){
									alert_leshun("danger", "操作失败："+msg, true);
								}else if('1'==code){
									alert_leshun("success", "批量删除操作成功", true);
								}
							},
							error: function() {
								alert_leshun("danger", "操作异常：", true);
							}
						});
					}
				}
			});
			}
		})
		})
	</script>
</body>
</html>