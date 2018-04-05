function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0px";
    document.getElementById("main").style.marginLeft= "0px";
}
$(function(){
	//solving the active menu problem	
	switch(menu){
	
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	default:
			$('#home').addClass('active');
	
	
	}
	
	
	
	//code for jquery data table
	 //create a data set
	var products= [['1','ABC'],
	['2','ABC'],
	['3','QWE'],
	['4','RTY'],
	['5','GHJ'],
	['6','BNM'],
	['7','BMW'],
	['8','OPI'],
	['9','OTP']
	               ];
	var $table=$('#productListTable');
	//execute the below code only where we have this table
	if($table.length){
		//console.log('Inside the table!');
		$table.DataTable({
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
		pageLength: 5,
		data:products
			
		});
		
	}
	
	
});