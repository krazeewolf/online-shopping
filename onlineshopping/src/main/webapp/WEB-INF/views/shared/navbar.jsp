<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <span style="font-size:26px; color:white;cursor:pointer" onclick="openNav()">&#9776;  TechAtHome</span>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a class="nav-link" href="${contextRoot}/home">Home</a></li>
      <li><a href="${contextRoot}/show/all/products" id="listproducts">View Products</a></li>
       <security:authorize access="hasAuthority('ADMIN')">
       <li><a href="${contextRoot}/manage/products" id="manageproducts">Manage Products</a></li></security:authorize>
	  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">More <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a class="nav-link" href="${contextRoot}/about" id="about">About Us</a></li>
          <li><a class="nav-link" href="${contextRoot}/contact" id="contact">Contact Us</a></li>
          <li><a href="#"></a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <security:authorize access="isAnonymous()">
      <li><a href="${contextRoot}/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${contextRoot}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
    <li class="dropdown">
    <a href="javascript:void(0)" class="tah-btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">${userModel.fullName}
    <span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
    <security:authorize access="hasAuthority('USER')">
    <li>
    <a href="${contextRoot}/cart/show">
    <span class="glyphicon glyphicon-shopping-cart"></span>
    <span class="badge">${userModel.cart.cartLines}</span>
    - &#8377; ${userModel.cart.grandTotal}
    </a>
    </li>
    <li class="divider" role="seperator"></li>
    </security:authorize>
    <li>
    <a href="${contextRoot}/perform-logout">Logout</a>
    </li>
    </ul>
    </li>
    </security:authorize>
    </ul>
  </div>
</nav>
<script>
window.userRole = '${userModel.role}';
</script>