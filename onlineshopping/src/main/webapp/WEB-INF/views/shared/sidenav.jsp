
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <h1>Categories</h1>
  <div class="list-group">
  <c:forEach items="${categories}" var="category">
<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name }</a>
</c:forEach>
</div>