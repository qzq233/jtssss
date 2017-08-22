 <%@ page language="java"  pageEncoding="UTF-8"%>
<div class="modal fade" tabindex="-1" id = "my_modal"role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog ">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title">SmartOJ</h4>
      </div>
      <div class="modal-body">
        <div class="container">
          <form class="form-signin" action = "SmartOJ_loged.jsp" method = "post">
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputEmail" class="sr-only">Username</label>
            <input name = "username" type="text" id="username" class="form-control" placeholder="Username" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input name = "password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me"> Remember me
              </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
          </form>
        </div> <!-- /container -->

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>