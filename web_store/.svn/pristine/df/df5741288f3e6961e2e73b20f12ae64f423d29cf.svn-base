<#-- 导入模版定义文件-->
<#include "../template/template_editPage.ftl">
<@edit title="添加/更新设备影子信息">
	<#if (deviceId)??>
		<#assign isEdit = true />
	<#else>
		<#assign isAdd = true />
	</#if>
<body>
	<div class="main-content">
		<@messageModal message="${message!}"/>
		<div class="page-content">
			<div class="page-header">
				<h1>
					设备影子信息管理
					<small>
					信息
        					<#if isAdd?? && isAdd = true>添加<#else>修改</#if>
					</small>
				</h1>
			</div>
			
     <form class="form-horizontal"
    	<#if isAdd?? && isAdd = true>action="${web_base}/business/p_device_shadow!add.htm" 
        <#else>action="${web_base}/business/p_device_shadow!edit.htm" 
		</#if>  onsubmit= "return checkParams()"  method="post">	 
    	 
    	<#if isEdit??> 
    	<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="id">唯一标识编号(设备编号)</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="deviceId" name="deviceShadow.deviceId" 
					value="${(deviceShadow!).deviceId!}" 	readonly="readonly" />
			</div>
		</div>
    	</#if>

		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="location">定位地址</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="location" name="deviceShadow.location" 
				value="${(deviceShadow!).location!}"  />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="accessAddress">接入地址</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="accessAddress" name="deviceShadow.accessAddress" 
				value="${(deviceShadow!).accessAddress!}"  />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="status">设备状态</label>
			<div class="col-sm-9">
				<select class="col-xs-10 col-sm-5"  id="status" name= "deviceShadow.status">
                	<option value="1" <#if deviceShadow?? && deviceShadow.status?? && deviceShadow.status="1">selected</#if>>
                		启用
                	</option>
                	<option value="0" <#if deviceShadow?? && deviceShadow.status?? && deviceShadow.status="0">selected</#if>>
                		禁用
                	</option>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="comProtocol">通讯协议</label>
			<div class="col-sm-9">
				<select class="col-xs-10 col-sm-5"  id="comProtocol" name= "deviceShadow.comProtocol">
					<option value="">
                    -请选择通讯协议-
                	</option>
                	<option value="1"  <#if deviceShadow?? && deviceShadow.comProtocol?? && deviceShadow.comProtocol="1" > selected </#if>>
           				 mqtt
           			</option>
           			<option value="2"  <#if deviceShadow?? && deviceShadow.comProtocol?? && deviceShadow.comProtocol="2" > selected </#if>>
           				 http
           			</option>
				</select>
				<span class="help-inline col-xs-12 col-sm-7">
					<span class="middle red">* 必选项</span>
				</span>
			</div>
		</div>
		
    	<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="version">接口版本</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="version" name="deviceShadow.version" 
				value="${(deviceShadow!).version!}" 	 />
				<span class="help-inline col-xs-12 col-sm-7">
					<span class="middle red">* 必填项</span>
				</span>
			</div>
		</div> 
    	 
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceName">设备名称</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="deviceName" name="deviceShadow.deviceName" 
					value="${(deviceShadow!).deviceName!}" 	<#if isAdd?? && isAdd = true><#else>readonly="readonly"</#if> />
				<span class="help-inline col-xs-12 col-sm-7">
					<span class="middle red">* 必填项</span>
				</span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceMac">mac地址，模块地址</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="deviceMac" name="deviceShadow.deviceMac" 
				value="${(deviceShadow!).deviceMac!}"  />
			</div>
		</div>
		
		
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="ip">IP</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="ip" name="deviceShadow.ip" 
				value="${(deviceShadow!).ip!}" 	 />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="imei">imei</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="imei" name="deviceShadow.imei" 
				value="${(deviceShadow!).imei!}" 	 />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="imsi">imsi</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="imsi" name="deviceShadow.imsi" 
				value="${(deviceShadow!).imsi!}" 	 />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="bts">基站信息</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="bts" name="deviceShadow.bts" 
				value="${(deviceShadow!).bts!}" 	 />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceType">设备类型</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="deviceType" name="deviceShadow.deviceType" 
				value="${(deviceShadow!).deviceType!}" 	 />
				<span class="help-inline col-xs-12 col-sm-7">
					<span class="middle red">* 必填项</span>
				</span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="remark">备注 </label>
			<div class="col-sm-9">
				 <textarea class="form-control" name="deviceShadow.remark" >${(deviceShadow!).remark!}</textarea>
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

	<#--校验参数-->
	function checkParams(){
       	
       var deviceId= $('#deviceId').val();
       if(deviceId==""){
          alert("设备名称不能为空");
          return false;
       }
       	
       	var deviceName= $('#deviceName').val();
        if(deviceName==""){
          alert("设备名称不能为空");
          return false;
       }
      
    	var version= $('#version').val();
        if(version==""){
          alert("版本不能为空");
          return false;
       }	   
       
       var deviceType=$('#deviceType').val();
       if(deviceType==""){
          alert("设备类型不能为空");
          return false;
       }  
       <#---
       var status= $('#status').val();
        if(status==""){
          alert("设备状态不能为空");
          return false;
       }
       
       var comStatus= $('#comStatus').val();
        if(comStatus==""){
          alert("通讯状态不能为空");
          return false;
       }
     
    -->    
    }
			
</script>
</body>
</@edit>
