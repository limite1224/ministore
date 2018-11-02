<#include "../template/template_listPage.ftl"/>
<@header title="产品信息管理">
</@header>
<body>
	<div class="main-content">
		<@messageModal message="${message!}"/>
		<div class="page-content">
			<div class="page-header">
				<h1>
					产品信息
					<small>
						产品信息管理
					</small>
				</h1>
			</div>
			<div class="row" style="padding-left:20px;padding-right:20px">
			<@pageList page=(page!) id="listForm" action="${web_base}/user/product_info!list.htm" query="entity" isEmpty=true>
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
											
											<td>
												<span>${obj_index+1}</span>
											</td>
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
													<a class="blue" href="${web_base}/user/product_info!detail.htm?id=${(obj.id)!}"  title="详情" >
														<i class="icon-zoom-in bigger-120"></i>
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
</body>
</html>