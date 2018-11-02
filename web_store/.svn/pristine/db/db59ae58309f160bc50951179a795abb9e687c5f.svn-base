<#-- 导入模版定义文件-->
<#include "../template/template_editPage.ftl">
<@detail title="产品详情">
<body>
	<div class="main-content">
		<div class="page-content">
			<div class="page-header">
				<h1>
					产品信息
					<small>
						产品详情
					</small>
				</h1>
			</div>
    <form class="form-horizontal" action="" method="post">
    	<div class="form-group">
			<h4 class="col-sm-3 center" >基础信息</h4>
		</div>
       <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="productName"> 产品名称： </label>
			<div class="col-sm-9">
				${(entity!).productName!}
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="productKey">产品型号：</label>
			<div class="col-sm-9">
				${(entity!).productKey!}
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="comMode">通讯：</label>
			<div class="col-sm-9">
				<#if entity?? && entity.comMode?? && entity.comMode="1">wifi</#if>
				<#if entity?? && entity.comMode?? && entity.comMode="2">rfid</#if>
				<#if entity?? && entity.comMode?? && entity.comMode="3">gprs</#if>
				<#if entity?? && entity.comMode?? && entity.comMode="4">buletooth</#if>
				<#if entity?? && entity.comMode?? && entity.comMode="5">其他</#if>
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="remark">备注：</label>
			<div class="col-sm-9">
				${entity.remark!}
			</div>
		</div>
		<hr/>
		<div class="form-group">
			<h4 class="col-sm-3 center">数据点表
			</h4>
			<div class="col-sm-2 center">
			</div>
		</div>
			<#if pmml??>
				<#list pmml as pmm>
				<div class="space-4"></div>
				<div class="form-group">
					<label class="col-sm-3 control-label no-padding-right" for="createTime">${pmm.productMsgKey!}：</label>
					<div class="col-sm-9">
						${pmm.productMsgName!}
					</div>
				</div>
				</#list>
			</#if>
		<hr/>
		<div class="form-group">
			<h4 class="col-sm-3 center">操作记录</h4>
		</div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="createTime">创建时间：</label>
			<div class="col-sm-9">
				<#if entity?? &&entity.createTime??>${(entity!).createTime?string('yyyy-MM-dd HH:mm:dd')!}</#if>
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="createBy">创建人：</label>
			<div class="col-sm-9">
				${(entity!).createBy!}
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="modifyTime">最新修改时间：</label>
			<div class="col-sm-9">
				<#if entity?? &&entity.createTime??>${(entity!).modifyTime?string('yyyy-MM-dd HH:mm:dd')!}</#if>
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="updateBy">修改人：</label>
			<div class="col-sm-9">
				${(entity!).updateBy!}
			</div>
		</div>
		<div class="space-4"></div>
         <div class="form-group">
			<label class="col-sm-5 control-label no-padding-right"></label>
			<button type="button" class="btn btn-sm" onclick="window.history.back(); return false;"><i class="icon-arrow-left align-top bigger-125"></i>
				返回
			</button>
		</div>
    </form>
</div>
</div>
</body>
</@detail>
