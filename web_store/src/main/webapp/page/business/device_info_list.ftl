<#include "../template/template_listPage.ftl"/>
<@header title="设备信息">
<script>
	function deleteDevice(id,name){
			var msg = "你确定删除设备"+name+"吗？";
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
							url: "${web_base}/business/device_info!delete.htm",
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
				<h1 style="float: left;">
					设备信息
					<small>
						设备信息管理
					</small>
				</h1>
				<div class="align-right">
					<button type="button" class="btn btn-primary"data-target="#importModal" data-toggle="modal">导入设备</button>
					<a href="${web_base}/business/device_info!form.htm" class="btn btn-success">
						<i class="icon-plus icon-1x icon-only"></i>新增设备</button>&nbsp;
	                </a>
				</div>
			</div>
			<div class="row" style="padding-left:20px;padding-right:20px">
			<@pageList page=(page!) id="listForm" action="${web_base}/business/device_info!list.htm" query="entity" isEmpty=true>
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
						<!--<div class="col-xs-2">
							<div class="form-group">
								<label class="col-xs-12 control-label no-padding-right" for="deviceSecret">定        位</label>
									<select class="width-90 link-height-1">
										<option value="浙江省 杭州市">-请选择地名-</option>
										<option value="浙江省 杭州市">浙江省 杭州市</option>
									</select>
							</div>
						</div>-->
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
											<!--<th class="center">
												<label>
													<input type="checkbox" class="ace"/>
													<span class="lbl"></span>
												</label>
											</th>
											<th>设备编号</th>-->
											<th>序号</th>
											<th>设备名称</th>
											<th>SN编码</th>
											<th>产品名称</th>
											<th>产品型号</th>
											<th>定        位</th>
											<th>设备状态</th>
											<!--<th>解析类型</th>-->
											<th>创建时间</th>
											<th>修改时间</th>
											<th class="operation-leshun"></th>
										</tr>
									</thead>
								<tbody class="center">
								<#if page?? && page.list??>
									<#list  page.list as obj>
										<tr>
											<!--<td class="center">
												<label>
													<input type="checkbox" class="ace"   name="ids" value="${(obj.deviceId)!}" />
													<span class="lbl"></span>
												</label>
											</td>
											<td>
												<span>${(obj.deviceId)!}</span>
											</td>-->
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
											<!--<td>
												<#if obj?? && obj.msgType?? && obj.msgType=="1" > 
													根据产品规则
						           	    		<#elseif obj?? && obj.msgType?? && obj.msgType=="2" >
						           	    	 		根据设备规则
												</#if>
											</td>-->
											<td>
												<span> ${(obj.createTime?string("yyyy-MM-dd HH:mm:ss"))!}</span>
											</td>
											<td>
												<span> ${(obj.modifyTime?string("yyyy-MM-dd HH:mm:ss"))!}</span>
											</td>																					
											<td>
												<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
													<a class="blue" href="${web_base}/business/device_info!detail.htm?id=${(obj.deviceId)!}"  title="详情" >
														<i class="icon-zoom-in bigger-120"></i>
													</a>
			
													<a class="green" href="${web_base}/business/device_info!form.htm?id=${(obj.deviceId)!}"  title="编辑" >
														<i class="icon-pencil bigger-120"></i>
													</a>
			
													<a class="red" href="javascript:void(0);" onclick="deleteDevice('${obj.deviceId!}','${obj.deviceName!}');" title="删除">
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
	<div id="importModal" class="modal fade" tabindex="-1" aria-labelledby="importModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="importModalLabel">导入设备</h4>
		      	</div>
				<div class="modal-body">
			        <form id="importForm" action="${web_base}/business/device_info!import.htm" method="post" style="text-align:center;" onsubmit="$('.jbox-body').hide();loading('正在导入，请稍等...');"><br/>
			           <div class="form-group">
			           	<label class="col-sm-3 control-label no-padding-right" for="productKey">产品名</label>
				           	<div class="col-sm-9">
					           	<select class="col-sm-10" id="productKey">
					           		<option value="">请选择产品</option>
									<#if productList??>
										<#list productList as productInfo>
											<option value="${productInfo.productKey!}">${productInfo.productName!}</option>
										</#list>
									</#if>
					            </select>
				            </div>
			           </div>
			           <div class="row">
			           	<label class="col-sm-3 control-label no-padding-right" for="deviceFile"></label>
			           		 <div class="col-sm-7">
								<div class="space"></div>
			           			<input type="file" id="deviceFile" />
							</div>
			           </div>
			        </form>
			    </div>
		         <div class="modal-footer">
			        <span style="color:red;">请严格按照模板格式导入，否则会数据错乱！</span>
		         	 <button id="btnImportSubmit" class="btn btn-sm btn-primary" type="submit">
		            	<i class="icon-cloud-upload bigger-130"></i>导入
		            </button>
		            <a href="${web_base}/business/device_info!template.htm">下载模板</a>
      			</div>
      		</div>
      	</div>
    </div>
    <script>
    $(function(){
    	$('#deviceFile').ace_file_input({
			style:'well',
			btn_choose:'请选择.xlsx文件',
			btn_change:null,
			no_icon:'icon-cloud-upload',
			droppable:true,
			thumbnail:'small',
			preview_error : function(filename, error_code) {
			}
	
		});
	})
    </script>
</body>
</html>