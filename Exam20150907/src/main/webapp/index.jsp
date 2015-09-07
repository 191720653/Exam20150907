<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.css">
<!--<link rel="stylesheet" href="bootstrap.min.css">-->
<script src="jquery.min.js"></script>
<!--<script src="http://code.jquery.com/jquery.js"></script>-->
<script src="http://cdn.bootcss.com/bootstrap/3.3.1/js/bootstrap.js"></script>
<script src="bootstrap-paginator.js"></script>
<title>template</title>
<!-- data-toggle='modal' data-target='#exampleModal'  -->
<script>
	$(document).ready(
			function() {
				var arr;
				
				function ajaxForData() {
					$.ajax({
						method : "Post",
						url : "/Exam20150907/getAll",
						async : true,
						data : "",
						dataType : 'json',
						success : function(data) {
							//alert("Data Getted: " + data);
							arr = data;
							var tr = '';
			                for(var index=0;index<10;index++){
			                    tr = "<tr><td height='80px' width='80px'>" + 
			                    "<a href='Delete_delete?id="+arr[index].customerId
			                    		+"' onclick='return confirm()'>删除</a>"
			                    		+" || <a href='javascript:void(0)' onclick='update(this);'>编辑</a>"
			                    		+ "</td><td>"
			                            + arr[index].customerId + "</td><td>"
			                            + arr[index].firstName + "</td><td>"
			                            + arr[index].lastName + "</td><td>"
			                            + arr[index].address + "</td><td>"
			                            + arr[index].email + "</td><td>"
			                            + arr[index].lastUpdate.toString().substring(0,9) + "</td></tr>";
			                    $("#table").append(tr);
			                }
			                var sign = false;
			                var pages = arr.length/10;
			                var num = arr.length%10;
			                if(num!=0){
			                	sign = true;
			                	pages = pages + 1;
			                }
							var options = {
						            bootstrapMajorVersion:3,
						            size:"normal",
						            alignment:"center",
						            currentPage: 1,
						            totalPages: pages,
						            numberOfPages:5,
						            itemTexts: function (type, page, current) {
						                switch (type) {
						                    case "first":
						                        return "首页";
						                    case "prev":
						                        return "上一页";
						                    case "next":
						                        return "下一页";
						                    case "last":
						                        return "末页";
						                    case "page":
						                        return page;
						                }
						            },
						            useBootstrapTooltip:true,
						            itemContainerClass: function (type, page, current) {
						                return (page === current) ? "active" : "pointer-cursor";
						            },
						            useBootstrapTooltip:true,
						            bootstrapTooltipOptions: {
						                html: true,
						                placement: 'bottom'
						            },
						            onPageClicked: function(e,originalEvent,type,page){
						                $("#table").empty();
						                var tr = '';
						                var temp = page*10;
						                if(sign&&page==pages){
						                	temp = num;
						                }
						                for(var index=(page-1)*10;index<page*10;index++){
						                    tr = "<tr><td height='80px' width='80px'>" + "<a href='Delete_delete?id="+arr[index].customerId+"' onclick='return confirm()'>删除</a>" 
						                    +" || <a href='javascript:void(0)' onclick='update(this);'>编辑</a>"
						                    		+ "</td><td>"
						                    		+ arr[index].customerId + "</td><td>"
						                            + arr[index].firstName + "</td><td>"
						                            + arr[index].lastName + "</td><td>"
						                            + arr[index].address + "</td><td>"
						                            + arr[index].email + "</td><td>"
						                            + arr[index].lastUpdate.toString().substring(0,9) + "</td></tr>";
						                    $("#table").append(tr);
						                }
						            }
						        }
						        $('#page').bootstrapPaginator(options);
						},
						timeout : 800,
						error : function(info, status, error) {
							alert('Error: ' + info.status + ' - ' + error);
						}
					});
				}
				;
				<%
				if(session.getAttribute("user")!=null){
					%>
					ajaxForData();
					<%
				}
				%>
				
			});
	function ajaxForAddressData() {
		$.ajax({
			method : "Post",
			url : "/Exam20150907/getAddress",
			async : true,
			data : "",
			dataType : 'json',
			success : function(data) {
				//alert("Data Getted: " + data);
				//arr = data;
				var op = '';
                for(var index=0;index<data.length;index++){
                    op = "<option>"+ data[index] + "</option>";
                    $("#input_fours").append(op);
                }
			},
			timeout : 800,
			error : function(info, status, error) {
				alert('Error: ' + info.status + ' - ' + error);
			}
		});
	}
	
	function update(obj){
		ajaxForAddressData();
		var tds=$(obj).parent().parent().find('td');
		$('#input_o').val(tds.eq(1).text());
		$('#input_ones').val(tds.eq(2).text());
		$('#input_twos').val(tds.eq(3).text());
		$('#input_threes').val(tds.eq(5).text());
		$('#exampleModal').modal('show');
	}
</script>
</head>
<body>
	<!--头部-->
	<div class="container">
		<div class="row btn-info">
			<div class="col-lg-10">
				<h1>ManagerSystem</h1>
			</div>
			<div class="col-lg-2" onclick="logout()">
				<h1>
					<span class="glyphicon glyphicon-user"></span> <a href="Logout_logout"><%=session.getAttribute("user") %></a>
				</h1>
			</div>
		</div>
	</div>
	<!--主要内容-->
	<div class="container">
		<div class="row table-bordered">
			<!--左侧菜单栏-->
			<div class="col-lg-2">
				<div class="row">
					<div class="list-group">
						<a href="#" class="list-group-item"> Film Manager <span
							class="glyphicon glyphicon-chevron-right pull-right"></span>
						</a> <a href="#" class="list-group-item"> Customer Manager <span
							class="glyphicon glyphicon-chevron-right pull-right"></span>
						</a>
					</div>
				</div>
			</div>
			<!--右侧主界面-->
			<div class="col-lg-10 table-bordered">
				<!--客户列表-->
				<div class="row">
					<div class="col-lg-9">
						<h3>
							<strong>客户管理</strong>
						</h3>
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-lg-4">
						<h4>客户列表</h4>
					</div>
					<div class="col-lg-5">
						<a class="btn btn-info btn-sm" href="add.jsp">新建</a>
					</div>
				</div>
				<div class="row">
					<table class="table table-bordered table-striped table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>customerId</th>
								<th>first name</th>
								<th>last name</th>
								<th>address</th>
								<th>email</th>
								<th>lastUpdate</th>
							</tr>
						</thead>
						<tbody id="table"></tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-lg-9 text-center">
						<ul id="page" class="pagination"></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">Edit</h4>
            </div>
            <div class="modal-body">

                <div class="col-lg-10">
                    <!--创建客户-->
                    <div class="row">
                        <div class="col-lg-9">
                            <br/>
                            <br/>
                            <p>基本信息</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-9">
                            <form class="form-horizontal col-lg-9" name="LoginForm" method="POST" action="Edit_edit">
                                <div class="form-group form-group-md hide">
                                    <label class="col-md-2 control-label" for="input_o">CustomerId<span
                                            style="color: red">*</span></label>
                                    <div class="col-md-8 col-md-offset-2">
                                        <input class="form-control" type="text" id="input_o" name="customerId"
                                               placeholder="CustomerId">
                                    </div>
                                </div>
                                <div class="form-group form-group-md">
                                    <label class="col-md-2 control-label" for="input_ones">FirstName<span
                                            style="color: red">*</span></label>
                                    <div class="col-md-8 col-md-offset-2">
                                        <input class="form-control" type="text" id="input_ones" name="firstName"
                                               placeholder="FirstName">
                                    </div>
                                </div>
                                <div class="form-group form-group-md">
                                    <label class="col-md-2 control-label" for="input_twos">LastName<span
                                            style="color: red">*</span></label>
                                    <div class="col-md-8 col-md-offset-2">
                                        <input class="form-control" type="text" id="input_twos" name="lastName"
                                               placeholder="LastName">
                                    </div>
                                </div>
                                <div class="form-group form-group-md">
                                    <label class="col-md-2 control-label" for="input_threes">Email</label>
                                    <div class="col-md-8 col-md-offset-2">
                                        <input class="form-control" type="email" id="input_threes" name="email"
                                               placeholder="Email">
                                    </div>
                                </div>
                                <div class="form-group form-group-md">
                                    <label class="col-md-2 control-label" for="input_fours">Address<span
                                            style="color: red">*</span></label>
                                    <div class="col-md-8 col-md-offset-2">
                                        <select class="form-control input-lg" id="input_fours" name="address">
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group form-group-md">
                                    <div class="col-md-10 text-center">
                                        <button class="btn btn-info" onclick="check()">提交</button>
                                        <button type="reset" class="btn">取消</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <hr/>
                <!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
                <!--<button type="button" class="btn btn-primary">Send message</button>-->
            </div>
        </div>
    </div>
</div>
</body>
</html>