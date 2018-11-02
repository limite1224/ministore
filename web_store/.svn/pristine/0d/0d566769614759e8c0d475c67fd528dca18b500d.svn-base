<#-- 导入模版定义文件-->
<#include "../template/template_editPage.ftl">
<@detail title="消息记录详情">
<body>
	<div class="main-content">
		<div class="page-content">
			<div class="page-header">
				<h1>
					消息记录信息
					<small>
						消息记录详情
					</small>
				</h1>
			</div>
    <form class="form-horizontal" action="" method="post">
      <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="id"> 记录编号 </label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="id" value="${(entity!).id!}" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="deviceId"> 设备编号 </label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="deviceId" value="${(entity!).deviceId!}" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="accessDeviceId"> 第三方设备编号 </label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="accessDeviceId" value="${(entity!).accessDeviceId!}" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="messageId"> 消息编号 </label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="messageId" value="${(entity!).messageId!}" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="message"> 消息内容 </label>
			<div class="col-sm-9">
				<textarea class="col-xs-10 col-sm-5"  id="message">${(entity!).message?string!}</textarea>
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="outPushTime">推送时间</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="outPushTime" value="<#if entity?? && entity.outPushTime??>${(entity!).outPushTime?string('yyyy-MM-dd HH:mm:ss')!}</#if>" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="messageType"> 消息类型 </label>
			<div class="col-sm-9">
				<select class="col-xs-10 col-sm-5" disabled="true" id="messageType">
					<option value="0" <#if entity?? && entity.messageType?? && entity.messageType=='0'></#if>>短消息</option>
					<option value="1" <#if entity?? && entity.messageType?? && entity.messageType=='1'></#if>>长消息</option>
				</select>
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="remark">备注</label>
			<div class="col-sm-9">
				<textarea class="col-xs-10 col-sm-5" name="entity.remark" id="remark"></textarea>
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="createTime">创建时间</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="createTime" value="<#if entity?? && entity.createTime??>${(entity!).createTime?string('yyyy-MM-dd HH:mm:ss')!}</#if>" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="createBy">创建人</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="createBy" value="${(entity!).createBy!}" />
			</div>
		</div>
		
		
		<div class="space-4"></div>
        <div class="center">
	        <button type="button" class="btn btn-sm" style="margin-left:100px;" onclick="window.history.back(); return false;"><i class="icon-arrow-left align-top bigger-125"></i>
				返回
			</button>
        </div>
    </form>
</div>
</div>
</body>
</@detail>
