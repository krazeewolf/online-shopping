<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
  <div class="container-fluid">
    <div class="navbar-header">
      <span style="font-size:26px; color:white;cursor:pointer" onclick="openNav()">&#9776;  TechAtHome</span>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a class="nav-link" href="${contextRoot}/home">Home</a></li>
      <li><a href="${contextRoot}/show/all/products" id="listproducts">View Products</a></li>
	  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">More <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a class="nav-link" href="${contextRoot}/about" id="about">About Us</a></li>
          <li><a class="nav-link" href="${contextRoot}/contact" id="contact">Contact Us</a></li>
          <li><a href="#"></a></li>
        </ul>
      </li>
	  <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>Search</button>
    </form>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
