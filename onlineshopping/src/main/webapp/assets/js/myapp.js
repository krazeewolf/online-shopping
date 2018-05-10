function openNav() {
	document.getElementById("mySidenav").style.width = "250px";
	document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
	document.getElementById("mySidenav").style.width = "0px";
	document.getElementById("main").style.marginLeft = "0px";
}
$(function() {
	// solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#more').addClass('active');
		break;
	case 'Contact Us':
		$('#more').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;
	default:
		if (menu == "Home")
			$('#Home').addClass('active')
			break;

	}
	//to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0){
		//set the token header for the ajax request
		$(document).ajaxSend(function(e,xhr,options){
			xhr.setRequestHeader(header,token);
		});
	}

	// code for jquery data table

	var $table = $('#productListTable');
	// execute the below code only where we have this table
	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';

		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({
					lengthMenu : [
							[ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records',
									'All Records' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>'
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out Of Stock</span>';
									}
									return data
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
									if(userRole=='ADMIN'){
										str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
									
									}
									else{
									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
									} else {
										
											
											str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										
									}
									}
									return str;
								}
							} ]

				});

	}

	// dismising the alert after 3 seconds
	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}



var $adminProductsTable = $('#adminProductsTable');
// execute the below code only where we have this table
if ($adminProductsTable.length) {
	// console.log('Inside the table!');

	var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

	$adminProductsTable
			.DataTable({
				lengthMenu : [
						[ 10, 30, 50, -1 ],
						[ '10 Records', '30 Records', '50 Records',
								'All Records' ] ],
				pageLength : 30,
				ajax : {
					url : jsonUrl,
					dataSrc : ''
				},
				columns : [
				           {
				        	   data:'id'
				           },
				           
						{
							data : 'code',
							mRender : function(data, type, row) {
								return '<img src="' + window.contextRoot
										+ '/resources/images/' + data
										+ '.jpg" class="adminDataTableImg"/>'
							}
						},
						{
							data : 'name'
						},
					
						{
							data : 'quantity',
							mRender : function(data, type, row) {
								if (data < 1) {
									return '<span style="color:red">Out Of Stock</span>';
								}
								return data;
							}
						},
						{
							data : 'unitPrice',
							mRender : function(data, type, row) {
								return '&#8377; ' + data;
							}
						},
						{
							data : 'active',
							bSortable: true,
							mRender: function(data,type,row){
								var str= '';
								str +='<label class="switch">'
									if(data){
										str+='<input  type="checkbox" checked="checked" value="'+row.id+'"/>';		
									}
									else{
										str+='<input  type="checkbox"  value="'+row.id+'"/>';
									}
								
								str+='<div class="slider"></div></label></td>';
							return str;
							}
						},
						{
							data: 'id',
							bSortable:false,
							mRender: function(data,type,row){
								var str= '';
								str+= '<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
								str+='<span class="glyphicon glyphicon-pencil"></span></a>';
								return str
							}
						}
							
					
						],
						initComplete:function(){
							var api=this.api();
							api.$('.switch input[type="checkbox"]').on('click',function() {
								var checkbox = $(this);
								var checked = checkbox.prop('checked');
								var dMsg = (checked)? 'You want to activate the Product?':
									                  'You want to deactivate the Product?';
								var value = checkbox.prop('value');
								bootbox.confirm({
											size: 'medium',
											title: 'Product Activation & Deactivation',
											message: dMsg,
											callback: function(confirmed) {
												if (confirmed) {
													console.log(value);
													var activationUrl=window.contextRoot+'/manage/product/'+ value +'/activation';
													$.post(activationUrl,function(data){
														bootbox.alert({ 
															size: 'medium',
															title: 'Information',
															message: data
														});
	
													});
													} else {
													checkbox.prop('checked', !checked); 
												}
											}
										});

							});
						}
				
			 
			}); 
	}
//validate code for category
var $categoryForm = $('#categoryForm');
if($categoryForm.length){
	$categoryForm.validate({
		rules: {
			name :{
				required:true,
				minlength:2
			},
			description: {
				required:true
			}
		},
		messages:{
			name:{
			required:'Please add the category name',
			minlength:'category name should not be less than 2 characters'
			},
			description:{
				required:'please add the category description'
			}
		},
		errorElement:'em',
		errorPlacement:function(error,element){
			//add the class of help-block
			error.addClass('help');
			//add the error element after the input element
			error.insertAfter(element);
		}
	});
}
	//---------------------------------------
	//validate code for category
	var $loginForm = $('#loginForm');
	if($loginForm.length){
		$loginForm.validate({
			rules: {
				username :{
					required:true,
					email:true
				},
				password: {
					required:true
				}
			},
			messages:{
				username:{
				required:'Please enter the username',
				email:'please enter valid email address'
				},
				password:{
					required:'please enter the password'
				}
			},
			errorElement:'em',
			errorPlacement:function(error,element){
				//add the class of help-block
				error.addClass('help');
				//add the error element after the input element
				error.insertAfter(element);
			}
		});
	}
	//-----------------------------
	//handling the click event of refresh cart
	$('button[name="refreshCart"]').click(function(){
		
		//fetch the cart line id
		var cartLineId= $(this).attr('value');
		var countElement=$('#count_'+ cartLineId);
		var originalCount = countElement.attr('value');
		var currentCount=countElement.val();
		//work only when the count is changed
		if(currentCount !== originalCount){
			if(currentCount <1 || currentCount >3){
				//reverting back to the original count
				//user has given value below 1 and above 3
				countElement.val(originalCount);
				bootbox.alert({
					size: 'medium',
					title: 'Error',
					message: 'Product count should be minimum 1 and maximum 3!'
				});
			}
			else{
				var updateUrl =window.contextRoot +'/cart/' +cartLineId +'/update?count=' +currentCount;
				//forward it to the controller
				window.location.href =updateUrl;
				
			}
		}
		
		
	});
	
	
	
	
	
	
	//-------------------------------
});