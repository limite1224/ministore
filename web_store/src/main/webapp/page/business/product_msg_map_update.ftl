<#-- 导入模版定义文件-->
<#include "../template/template_editPage.ftl">
<@edit title="产品映射">
<body>
	<div class="main-content">
		<@messageModal message="${message!}"/>
		<div class="page-content">
			<div class="page-header">
				<h1>
					产品映射信息
					<small>
						产品修改
					</small>
				</h1>
			</div>
    <form class="form-horizontal" action="${web_base}/business/product_msg_map!save.htm"
    	 onsubmit= "return checkParams();"  method="post">
       <input id="id" name="entity.id" type="hidden" value="${(entity!).id!}"/>
       <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="productName"> 产品名称 </label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="productName"name="entity.productName" value="${(entity!).productName!}" readonly="true"/>
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="productKey">产品标识</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="productKey"name="entity.productKey" value="${(entity!).productKey!}" readonly="true"/>
			</div>
		</div>
		<div class="space-4"></div>
		<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="productMsgKey"> 标签名称</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="productMsgKey"name="entity.productMsgKey" value="${(entity!).productMsgKey!}" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="productMsgName">产品属性</label>
			<div class="col-sm-9">
				<input class="col-xs-10 col-sm-5" type="text" id="productMsgName"name="entity.productMsgName" value="${(entity!).productMsgName!}" />
			</div>
		</div>
		<div class="space-4"></div>
		 <div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="productRemark">备注</label>
			<div class="col-sm-9">
				<textarea class="col-xs-10 col-sm-5" name="entity.productRemark" id="productRemark" value="${(entity!).productRemark!}"></textarea>
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
