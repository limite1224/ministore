<#-- 导入模版定义文件-->
<#include "../template/template_editPage.ftl">
<@detail title="设备详情">
<style>
    pre {outline: 1px solid #ccc; padding: 5px; margin: 5px; }
    .string { color: green; }
    .number { color: darkorange; }
    .boolean { color: blue; }
    .null { color: magenta; }
    .key { color: red; }
</style>
<body>
	<div class="main-content">
		<div class="page-content">
			<div class="page-header">
				<h1>
					设备信息管理
					<small>
					设备详情
					</small>
				</h1>
			</div>
			
     <form class="form-horizontal" action=""   method="post">	 
    	 <div class="form-group">
			<h4 class="col-sm-3 center" >基础信息</h4>
		</div>
    	<!--<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="id">设备编号：</label>
			<div class="col-sm-9">
				${(entity!).deviceId!}
			</div>
		</div>
    	 <div class="space-4"></div>-->
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="productName">产品名称：</label>
			<div class="col-sm-9">
				${(entity.productName)!}
			</div>
		</div>
    	 <div class="space-4"></div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceName">设备名称：</label>
			<div class="col-sm-9">
				${(entity!).deviceName!}
			</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceMac">SN编码：</label>
			<div class="col-sm-9">
				${(entity!).deviceMac!}
			</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceSecret">设备秘钥：</label>
			<div class="col-sm-9">
				${(entity!).deviceSecret!}
			</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="status">设备状态：</label>
			<div class="col-sm-9">
				<#if entity?? && entity.status?? && entity.status="1">
                		在线
             	<#elseif entity?? && entity.status?? && entity.status="0">
             			离线
             	</#if>
			</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="remark">备注： </label>
			<div class="col-sm-9">
				 ${(entity!).remark!}
		</div>
		</div>
		<hr/>
		<div class="form-group">
			<h4 class="col-sm-3 center">实时数据
			</h4>
		</div>
		<#if entity?? && entity.customPropertyMap??>
			<#list entity.customPropertyMap?keys as key>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">${key!}： </label>
					<div class="col-sm-9">
						${entity.customPropertyMap['${key!}']!}
					</div>
				</div>
			</#list>
		<#elseif entity?? && entity.customPropertyList??>
			<#list entity.customPropertyList as property>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right">${property.productMsgName!}(${property.productMsgKey!})： </label>
					<div class="col-sm-9">
						--
					</div>
				</div>
			</#list>
		</#if>
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="remark"></label>
				<div class="col-sm-9">
					<a href="#modal-form" role="button" class="blue historyQuery" data-toggle="modal"><b>历史记录</b></a>
				</div>
			</div>
		<hr/>
		<div class="form-group">
			<h4 class="col-sm-3 center">操作记录</h4>
		</div>
		<div class="space-4"></div><div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="createBy">创建人：</label>
			<div class="col-sm-9">
				${(entity!).createBy!}
			</div>
		</div>
    	 <div class="space-4"></div><div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="createTime">创建时间：</label>
			<div class="col-sm-9">
				<#if entity?? && entity.createTime??>${(entity!).createTime?string('yyyy-dd-MM HH:mm:ss')!}</#if>
			</div>
		</div>
    	 <div class="space-4"></div><div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="updateBy">最新修改人：</label>
			<div class="col-sm-9">
				${(entity!).updateBy!}
			</div>
		</div>
    	 <div class="space-4"></div>
    	 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="modifyTime">修改时间：</label>
			<div class="col-sm-9">
				<#if entity?? && entity.modifyTime??>${(entity!).modifyTime?string('yyyy-dd-MM HH:mm:ss')!}</#if>
			</div>
		</div>
    	 <div class="space-4"></div>
        <div class="form-group">
			<label class="col-sm-5 control-label no-padding-right"></label>
			<button type="button" class="btn btn-sm btn-danger"><i class="icon-lock align-top bigger-125"></i>
				一键上锁
			</button>&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-sm" onclick="window.history.back(); return false;"><i class="icon-arrow-left align-top bigger-125"></i>
				返回
			</button>
		</div>
    </form>
</div>
</div>
<div id="modal-form" class="modal" tabindex="-1">
	<div class="modal-dialog" style="width:800px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="blue bigger">历史数据</h4>
			</div>
			<div id="warnDiv" style="display:none">
				<p>查询错误。</p>
			</div>
			<div class="modal-body overflow-visible">
				<div class="row">
					<div class="col-sm-4">
						<div class="form-group">
							<label class="col-xs-12 control-label no-padding-right" for="dateRangePicker">日期范围</label>
							<div class="input-group">
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
								<input class="form-control date-range-picker-leshun" type="text" name="date-range-picker" id="dateRangePicker" />
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="form-group">
							<label class="col-xs-12 control-label no-padding-right">&nbsp;</label>
							<button type="button"  class="btn btn-app btn-xs btn-info historyQuery">查询</button>
						</div>
					</div>
				</div>
				<div class="row" style="overflow:auto;max-height:320px;">
					<!--<div class="col-sm-12" id="historyDiv">
						
					</div>-->
					<div class="table-responsive">
						<table id="historyTable" class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>时间</th>
									<th>数据</th>
								</tr>
							</thead>
							<tbody class="center" id="historyTbody">
							</tbody>
						</table>
						<p id="noneHistory" class="center orange" style="display:none;">没有找到任何记录!</p>
					</div>
				</div>
			<div class="modal-footer">
				<button class="btn btn-sm" data-dismiss="modal">
					<i class="icon-remove"></i>
					关闭
				</button>
			</div>
		</div>
	</div>
</div>
<script>
	$(function($){
		$(".historyQuery").on("click",function(){
			getHistoryData();
		})
	})
	function getHistoryData(){
		var data = {
				date:$("#dateRangePicker").val(),
				id:'${id!}'
			};
			$.ajax({
				type:'post',
				data:data,
				url:'${web_base}/business/device_info!history.htm',
				dataType:'text',
				success:function(message){
					//var historyUl = $("<ul></ul>");
					var historyTbody = $("#historyTbody");
					var historyMap = eval(message);
					if(historyMap.length>0){
						for(var i = 0; i< historyMap.length;i++){
							console.log(historyMap[i].message);
							//var li = "<li style='list-style-type:none'><span>"+historyMap[i].createTime+"</span><pre><code>"+syntaxHighlight(eval(historyMap[i].message))+"</code></pre></li>";
							//var li = "<li style='list-style-type:none'><span>"+historyMap[i].createTime+"</span><code>"+syntaxHighlight(historyMap[i].message)+"</code></li>";
							var td = "<tr><td>"+(i+1)+"</td><td>"+historyMap[i].outPushTime+"</td><td>"+syntaxHighlight(historyMap[i].message)+"</td></tr>";
							historyTbody.append(td);
						}
					}else{
						$("#noneHistory").attr("style","display:''");
					}
				//$("#historyDiv").html(historyUl);
				},
				error:function(message){
					
				}
			})
	}
	function syntaxHighlight(json) {
	    if (typeof json != 'string') {
	        json = JSON.stringify(json, undefined, 2);
	    }
	    json = json.replace(/&/g, '&').replace(/</g, '<').replace(/>/g, '>');
	    return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function(match) {
	        var cls = 'number';
	        if (/^"/.test(match)) {
	            if (/:$/.test(match)) {
	                cls = 'key';
	            } else {
	                cls = 'string';
	            }
	        } else if (/true|false/.test(match)) {
	            cls = 'boolean';
	        } else if (/null/.test(match)) {
	            cls = 'null';
	        }
	        return '<span class="' + cls + '">' + match + '</span>';
	    });
	}
</script>
</body>
</@detail>
