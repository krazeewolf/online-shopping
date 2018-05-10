<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>
<div class="content">
<div class="row">
			<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
			<div class="panel-heading">
			<h4>Sign up-Address</h4>
			</div>
			<div class="panel-body">
			<sf:form method="POST" class="form-horizontal" id="billingForm" modelAttribute="billing">
			<div class="form-group">
			<label class="control-label col-md-4" >Address Line One:</label>
			<div class="col-md-8">
			<sf:input type="text" path="addressLineOne" class="form-control" placeholder="Enter Address Line One" />
			<sf:errors path="addressLineOne" cssClass="help" element="em" />
			</div> 
			</div>
			<div class="form-group">
			<label class="control-label col-md-4" >Address Line Two:</label>
			<div class="col-md-8">
			<sf:input type="text" path="addressLineTwo" class="form-control" placeholder="Enter Address Line Two"/>
			<sf:errors path="addressLineTwo" cssClass="help" element="em" />
			</div> 
			</div>
			<div class="form-group">
			<label class="control-label col-md-4" >City:</label>
			<div class="col-md-8">
			<sf:input type="text" path="city" class="form-control" placeholder="Enter the City Name"/>
			<sf:errors path="city" cssClass="help" element="em" />
			</div> 
			</div>
			<div class="form-group">
			<label class="control-label col-md-4" >State:</label>
			<div class="col-md-8">
			<sf:input type="text" path="state" class="form-control" placeholder="Enter your State"/>
			<sf:errors path="state" cssClass="help" element="em" />
			</div> 
			</div>
			<div class="form-group">
			<label class="control-label col-md-4" >Postal Code:</label>
			<div class="col-md-8">
			<sf:input type="text" path="postalCode" class="form-control" placeholder="Enter the Postal Code"/>
			<sf:errors path="postalCode" cssClass="help" element="em" />
			</div> 
			</div>
			<div class="form-group">
			<label class="control-label col-md-4" >Country:</label>
			<div class="col-md-8">
			<sf:input type="text" path="country" class="form-control" placeholder="Enter your Country Name"/>
			<sf:errors path="country" cssClass="help" element="em" />
			</div> 
			</div>
			<div class="form-group">
			<div class="col-md-offset-4 col-md-8">
			<button type="submit" class="btn btn-primary" name="_eventId_personal">
			<span class="glyphicon glyphicon-chevron-left"></span>Previous - Personal </button>
			<button type="submit" class="btn btn-primary" name="_eventId_confirm">
			Next - Confirm<span class="glyphicon glyphicon-chevron-right"></span></button>
			</div> 
			</div>
			</sf:form>
			</div>
			</div>
			</div>
			</div>
			
</div>
<%@include file="../shared/flows-footer.jsp" %>	