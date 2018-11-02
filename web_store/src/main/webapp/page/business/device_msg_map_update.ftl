<#-- 导入模版定义文件-->
<#include "../template/template_editPage.ftl">
<@edit title="设备映射">
<body>
	<div class="main-content">
		<@messageModal message="${message!}"/>
		<div class="page-content">
			<div class="page-header">
				<h1>
					设备映射信息
					<small>
						设备修改
					</small>
				</h1>
			</div>
    <form class="form-horizontal" action="${web_base}/business/device_msg_map!save.htm" method="post">
       <input id="id" name="entity.id" type="hidden" value="${(entity!).id!}"/>
       <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="diviceName"> 设备名称 </label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="diviceName" value="${(entity!).diviceName!}" readonly="true"/>
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="diviceId">设备标识</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="diviceKey" value="${(entity!).diviceId!}" readonly="true"/>
			</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="diviceMsgKey"> 标签名称</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="diviceMsgKey"name="entity.diviceMsgKey" value="${(entity!).diviceMsgKey!}" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="diviceMsgName">设备属性</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="diviceMsgName"name="entity.diviceMsgName" value="${(entity!).diviceMsgName!}" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="diviceRemark">备注</label>
			<div class="col-sm-9">
				<textarea class="col-xs-10 col-sm-5" name="entity.diviceRemark" id="diviceRemark" value="${entity.diviceRemark!}"></textarea>
			</div>
		</div>
		
		<div class="space-4"></div>
        <div class="center">
	        <button type="submit" class="btn btn-info btn-sm"><i class="icon-print  align-top bigger-125 icon-on-right"></i>
	        	保存
	        </button>
	        <button type="button" class="btn btn-sm" onclick="window.history.back(); return false;"><i class="icon-arrow-left align-top bigger-125"></i>
				返回
			</button>
        </div>
    </form>
</div>
</div>
</body>
</@edit>
