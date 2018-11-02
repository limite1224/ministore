<#-- 导入模版定义文件-->
<#include "../template/template_editPage.ftl">
<@edit title="设备信息">
<body>
	<div class="main-content">
		<@messageModal message="${message!}"/>
		<div class="page-content">
			<div class="page-header">
				<h1>
					设备信息管理
					<small>
					信息${isAdd?string("添加","修改")!}
					</small>
				</h1>
			</div>
			
     <form class="form-horizontal" action="${web_base}/business/device_info!save.htm" onsubmit= "return checkParams()"  method="post">	 
				<input type="hidden" id="deviceId" name="entity.deviceId" 
					value="${(entity!).deviceId!}" 	readonly="readonly" />
    	 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="productKey">产品名称</label>
			<div class="col-sm-9">
				<select class="col-xs-10 col-sm-5" id="productKey" name= "entity.productKey" <#if !isAdd>disabled="true"</#if>>
					<option value="">
                    -请选择产品-
                	</option>
                    <#if productList?? && (productList?size gt 0)>
                        <#list productList as record>
                            <option value="${(record.productKey)!}" <#if entity?? && entity.productName?? && entity.productName=record.productName>selected</#if>>
                            ${(record.productName)!}
                            </option>
                        </#list>
                    </#if>
				</select>
				<span class="help-inline col-xs-12 col-sm-7">
					<span class="middle red">* 必选项</span>
				</span>
			</div>
		</div>
		<input type="hidden" id="productName" name="entity.productName"/>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceName">设备名称</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="deviceName" name="entity.deviceName" 
					value="${(entity!).deviceName!}" 	/>
				<span class="help-inline col-xs-12 col-sm-7">
					<span class="middle red">* 必填项</span>
				</span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceMac">SN编码</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="deviceMac" name="entity.deviceMac" 
				value="${(entity!).deviceMac!}"  />
				<span class="help-inline col-xs-12 col-sm-7">
					<span class="middle red">* 必填项</span>
				</span>
			</div>
		</div>
		
		<!--<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceSecret">设备秘钥</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="deviceSecret" name="entity.deviceSecret" 
					value="${(entity!).deviceSecret!}" />
			</div>
		</div>-->
		<!--<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="status">设备状态</label>
			<div class="col-sm-9">
				<select class="col-xs-10 col-sm-5"  id="status" name= "entity.status">
                	<option value="1" <#if entity?? && entity.status?? && entity.status="1">selected</#if>>
                		在线
                	</option>
                	<option value="0" <#if entity?? && entity.status?? && entity.status="0">selected</#if>>
                		离线
                	</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="msgType">解析类型</label>
			<div class="col-sm-9">
				<select class="col-xs-10 col-sm-5"  id="msgType" name= "entity.msgType">
                	<option value="1" <#if entity?? && entity.msgType?? && entity.msgType="1">selected</#if>>
                		根据产品规则
                	</option>
                	<option value="2" <#if entity?? && entity.msgType?? && entity.msgType="2">selected</#if>>
                		根据设备规则
                	</option>
				</select>
			</div>
		</div>-->
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="remark">备注 </label>
			<div class="col-sm-9">
				 <textarea class="col-xs-10 col-sm-5" name="entity.remark" >${(entity!).remark!}</textarea>
			</div>
		</div>
		
		<div class="space-4"></div>
        <div class="center">
	        <button type="submit" class="btn btn-info btn-sm"><i class="icon-print  align-top bigger-125 icon-on-right"></i>
	        	保存
	        </button>
	        <button type="button" class="btn btn-sm" onclick="window.history.back(); return false;"><i class="icon-pencil align-top bigger-125"></i>
				返回
			</button>
        </div>
    </form>
</div>
</div>
<script type="text/javascript">
	$("#productKey").on("change",function(){
		$("#productName").val($("#productKey option:selected").text());
	})
	<#--校验参数-->
	function checkParams(){
       	
       	var deviceName= $('#deviceName').val();
        if(deviceName==""){
          alert("设备名称不能为空");
          return false;
       }
       
       var productName= $('#productKey').val();
        if(productKey==""){
          alert("产品名称不能为空");
          return false;
       }
       
       var groupId= $('#groupId').val();
        if(groupId==""){
          alert("设备分组不能为空");
          return false;
       }
       
       var deviceMac=$('#deviceMac').val();
       if(deviceMac==""){
          alert("mac地址，模块地址不能为空");
          return false;
       }  
       
       var comProtocol= $('#comProtocol').val();
        if(comProtocol==""){
          alert("通讯协议不能为空");
          return false;
       }    
       
    	var version= $('#version').val();
        if(version==""){
          alert("版本不能为空");
          return false;
       }	
    	return true;
    }
			
</script>
</body>
</@edit>
