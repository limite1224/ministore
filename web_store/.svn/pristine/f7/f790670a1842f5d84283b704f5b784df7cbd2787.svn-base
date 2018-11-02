jQuery(function($){
  //全选、反选
	  $('table th input:checkbox').on('click', function() {
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
				.each(function() {
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
		});
		
		//日期
	$('.date-range-picker-leshun').daterangepicker().prev().on(ace.click_event, function() {
		$(this).next().focus();
	});
	$('.date-picker-leshun').datepicker({
		autoclose: true
	}).next().on(ace.click_event, function() {
		$(this).prev().focus();
	});
	//下拉框
	$(".chosen-select").chosen();
	//弹出表单
	$(".modal-leshun").click(function(){
		var $className = $(this).attr("class");
		var $modalName = $className.substring($className.lastIndexOf(" ")+1,$className.indexOf("-leshun",$className.lastIndexOf(" ")+1));
		$("#"+$modalName+"Modal").modal("show");
	})
	//导出
	$(".export-leshun").click(function(){
		var $listFormAction = $("#listForm").attr("action");
		var url = $listFormAction.substring(0,$listFormAction.lastIndexOf("!")+1)+"export.htm";
		$("#listForm").attr("action",url);
		$("#listForm").submit();
	})
	
	
	
	
	
})
//弹出框
	//类型：success、waring、dander、info
	//提示信息：msg
	//是否刷新页面 
function alert_leshun(type,msg,flag){
		if(msg.indexOf("异常")!=-1 || msg.indexOf("错误")!=-1){ 
			type = 'danger';
		}
		$("#message-leshun").attr("class", "alert alert-"+type);
		$("#message-leshun").attr("style", "display:''");
		$("#message-leshun p").html(msg);
		if("success"==type){
			if(flag){
				setTimeout(function() {
					window.location.reload();
				}, 1000);
			}else{
				setTimeout(function(){$("#message-leshun").attr("style","display:none")},2000);
			}
		}else{
			setTimeout(function(){$("#message-leshun").attr("style","display:none")},5000);
		}
	}

//---判断复选框是否选中
 function checkBoxIsNull(checkParamName){
	var flag = false;
	 var items = document.getElementsByName(checkParamName);  //获取name为checkParamName的一组元素(checkbox)
	for(i=0; i < items.length; i++){  //循环这组数据
		if(items[i].checked){      //判断是否选中
			flag = true;
			return flag;
		}
	}
	return false;
 }	

	
	