<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<script type="text/javascript">
	$(document).ready(() => {   
	    modalLogout = new bootstrap.Modal(document.getElementById('modalLogout'), {
	        backdrop: 'static',
	        keyboard: false
	    })
	    formLogout = document.getElementById("logout-form");
	    
	    $("#logout").on("click", (event) => {        
	        event.preventDefault();
	        modalLogout.show();
	    });
	    
	    $("#logout-form-submit").on("click", () => {        
	        formLogout.submit(); // submit form
	        modalLogout.dismiss(); // hide modal window
		});
	});

</script>
   
<!-- Modal with form: confirm to logout -->
<div id="modalLogout" class="modal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false" >
 	<div class="modal-dialog">
    	<div class="modal-content">
      		<div class="modal-header">
        		<h5 class="modal-title">Confirm Logout</h5>
        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      		</div>
      		<div class="modal-body">
        		<p id="modal-message">Are you sure you want to exit?</p>
       			<form id="logout-form" method="post">
       				<input type="hidden" name="logout" value="true">
       			</form>
	        </div>
    	  	<div class="modal-footer">
            	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="logout-form-submit" >
					Confirm Logout
       			</button>
      		</div>
		</div>
	</div>
</div>
