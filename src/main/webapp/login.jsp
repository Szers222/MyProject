<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<style type="text/css">

@import url("https://fonts.googleapis.com/css?family=Fira+Sans");

html,body {
	position: relative;
	min-height: 100vh;
	background-color: #E1E8EE;
	display: flex;
	align-items: center;
	justify-content: center;
	font-family: "Fira Sans", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.form-structor {
	background-color: #222;
	border-radius: 15px;
	height: 550px;
	width: 350px;
	position: relative;
	overflow: hidden;
	
	&::after {
		content: '';
		opacity: .8;
		position: absolute;
		top: 0;right:0;bottom:0;left:0;
		background-repeat: no-repeat;
		background-position: left bottom;
		background-size: 500px;
		background-image: url('https://images.unsplash.com/photo-1503602642458-232111445657?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=bf884ad570b50659c5fa2dc2cfb20ecf&auto=format&fit=crop&w=1000&q=100');
	}
	
	.signup {
		position: absolute;
		top: 50%;
		left: 50%;
		-webkit-transform: translate(-50%, -50%);
		width: 65%;
		z-index: 5;
		-webkit-transition: all .3s ease;
		
		
		&.slide-up {
			top: 5%;
			-webkit-transform: translate(-50%, 0%);
			-webkit-transition: all .3s ease;
		}
		
		&.slide-up .form-holder,
		&.slide-up .submit-btn {
			opacity: 0;
			visibility: hidden;
		}
		
		&.slide-up .form-title {
			font-size: 1em;
			cursor: pointer;
		}
		
		&.slide-up .form-title span {
			margin-right: 5px;
			opacity: 1;
			visibility: visible;
			-webkit-transition: all .3s ease;
		}
		
		.form-title {
			color: #fff;
			font-size: 1.7em;
			text-align: center;
			
			span {
				color: rgba(0,0,0,0.4);
				opacity: 0;
				visibility: hidden;
				-webkit-transition: all .3s ease;
			}
		}
		
		.form-holder {
			border-radius: 15px;
			background-color: #fff;
			overflow: hidden;
			margin-top: 50px;
			opacity: 1;
			visibility: visible;
			-webkit-transition: all .3s ease;
			
			.input {
				border: 0;
				outline: none;
				box-shadow: none;
				display: block;
				height: 30px;
				line-height: 30px;
				padding: 8px 15px;
				border-bottom: 1px solid #eee;
				width: 100%;
				font-size: 12px;
				
				&:last-child {
					border-bottom: 0;
				}
				&::-webkit-input-placeholder {
					color: rgba(0,0,0,0.4);
				}
			}
		}
		
		.submit-btn {
			background-color: rgba(0,0,0,0.4);
			color: rgba(256,256,256,0.7);
			border:0;
			border-radius: 15px;
			display: block;
			margin: 15px auto; 
			padding: 15px 45px;
			width: 100%;
			font-size: 13px;
			font-weight: bold;
			cursor: pointer;
			opacity: 1;
			visibility: visible;
			-webkit-transition: all .3s ease;
			
			&:hover {
				transition: all .3s ease;
				background-color: rgba(0,0,0,0.8);
			}
		}
	}
	
	.login {
		position: absolute;
		top: 20%;
		left: 0;
		right: 0;
		bottom: 0;
		background-color: #fff;
		z-index: 5;
		-webkit-transition: all .3s ease;
		
		&::before {
			content: '';
			position: absolute;
			left: 50%;
			top: -20px;
			-webkit-transform: translate(-50%, 0);
			background-color: #fff;
			width: 200%;
			height: 250px;
			border-radius: 50%;
			z-index: 4;
			-webkit-transition: all .3s ease;
		}
		
		.center {
			position: absolute;
			top: calc(50% - 10%);
			left: 50%;
			-webkit-transform: translate(-50%, -50%);
			width: 65%;
			z-index: 5;
			-webkit-transition: all .3s ease;
			
			.form-title {
				color: #000;
				font-size: 1.7em;
				text-align: center;

				span {
					color: rgba(0,0,0,0.4);
					opacity: 0;
			    visibility: hidden;
				  -webkit-transition: all .3s ease;
				}
			}

			.form-holder {
				border-radius: 15px;
				background-color: #fff;
				border: 1px solid #eee;
				overflow: hidden;
				margin-top: 50px;
				opacity: 1;
				visibility: visible;
				-webkit-transition: all .3s ease;

				.input {
					border: 0;
					outline: none;
					box-shadow: none;
					display: block;
					height: 30px;
					line-height: 30px;
					padding: 8px 15px;
					border-bottom: 1px solid #eee;
					width: 100%;
					font-size: 12px;

					&:last-child {
						border-bottom: 0;
					}
					&::-webkit-input-placeholder {
						color: rgba(0,0,0,0.4);
					}
				}
			}

			.submit-btn {
				background-color: #6B92A4;
				color: rgba(256,256,256,0.7);
				border:0;
				border-radius: 15px;
				display: block;
				margin: 15px auto; 
				padding: 15px 45px;
				width: 100%;
				font-size: 13px;
				font-weight: bold;
				cursor: pointer;
				opacity: 1;
				visibility: visible;
				-webkit-transition: all .3s ease;

				&:hover {
					transition: all .3s ease;
					background-color: rgba(0,0,0,0.8);
				}
			}
		}
		
		&.slide-up {
			top: 90%;
			-webkit-transition: all .3s ease;
		}
		
		&.slide-up .center {
			top: 10%;
			-webkit-transform: translate(-50%, 0%);
			-webkit-transition: all .3s ease;
		}
		
		&.slide-up .form-holder,
		&.slide-up .submit-btn {
			opacity: 0;
			visibility: hidden;
			-webkit-transition: all .3s ease;
		}
		
		&.slide-up .form-title {
			font-size: 1em;
			margin: 0;
			padding: 0;
			cursor: pointer;
			-webkit-transition: all .3s ease;
		}
		
		&.slide-up .form-title span {
			margin-right: 5px;
			opacity: 1;
			visibility: visible;
			-webkit-transition: all .3s ease;
		}
	}
}
.alert-success {
      color: #155724;
      background-color: #d4edda;
      border-color: #c3e6cb;
      opacity: 1;
      transition: opacity 2s ease-out;
    }
</style>
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oL2XCRpXwe4WuZla22/Q2fIlxzO4w3qjnIHEt3GQnB8=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59D1E1iKT6Lh5oIM6jKZ5DfF" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<% 
Integer statusAttribute = (Integer) request.getAttribute("status");
int status = (statusAttribute != null) ? statusAttribute : 0;
%>
<body style="min-height: 50vh; border-radius: 100px">
  <div class="form-structor">
    <form action="LoginServlet" method="post">
      <div class="signup">
        <h2 class="form-title" id="signup">Sign up</h2>
        <div class="form-holder">
          <input type="text" class="input" placeholder="Name" name="name" />
          <input type="text" class="input" placeholder="Username" name="username" />
          <input type="password" class="input" placeholder="Password" name="password" />
        </div>
        <button type="submit" class="submit-btn" id="signupBtn">Sign up</button>
        <a href="ShowAllProductServlet" type="submit" class="submit-btn" id="signupBtn" style="text-align: center; text-decoration: none;" >Back</a>
      </div>
    </form>
    
    <form action="LoginServlet" method="post">
      <div class="login slide-up">
        <div class="center">
          <h2 class="form-title" id="login">Log in</h2>
          <div class="form-holder">
            <input type="text" class="input" placeholder="Username" name="username" />
            <input type="password" class="input" placeholder="Password" name="password" />
          </div>
          <input class="submit-btn" type="submit" value="Login">
          <a href="ShowAllProductServlet" type="submit" class="submit-btn" id="signupBtn" style="text-align: center; text-decoration: none;" >Back</a>
        </div>
      </div>
    </form>
  </div>

  <script type="text/javascript">
    console.clear();

    const loginBtn = document.getElementById('login');
    const signupBtn = document.getElementById('signup');
    const signupForm = document.querySelector('.signup');
    const loginForm = document.querySelector('.login');

    signupBtn.addEventListener('click', () => {
        signupForm.classList.remove('slide-up');
        loginForm.classList.add('slide-up');
      });

      loginBtn.addEventListener('click', () => {
        loginForm.classList.remove('slide-up');
        signupForm.classList.add('slide-up');
      });

    function showSuccessAlert() {
        var alertDiv = document.createElement("div");
        alertDiv.className = "alert alert-success";
        alertDiv.innerHTML = "Registration successful!";

        // Thêm thông báo trước thẻ h2 "Signup"
        var signupTitle = document.getElementById('signup');
        signupTitle.parentNode.insertBefore(alertDiv, signupTitle);

        // Tự động đặt lại opacity sau 2 giây
        setTimeout(function() {
            alertDiv.style.opacity = "0";
            setTimeout(function() {
                alertDiv.remove(); // Xóa thông báo sau khi biến mất
            }, 1000);
        }, 2000);
    }
    function showFailAlert() {
        var alertDiv = document.createElement("div");
        alertDiv.className = "alert alert-danger";
        alertDiv.innerHTML = "Your Action Fails!";

        // Thêm thông báo trước thẻ h2 "Signup"
        var signupTitle = document.getElementById('signup');
        signupTitle.parentNode.insertBefore(alertDiv, signupTitle);

        // Tự động đặt lại opacity sau 2 giây
        setTimeout(function() {
            alertDiv.style.opacity = "0";
            setTimeout(function() {
                alertDiv.remove(); // Xóa thông báo sau khi biến mất
            }, 1000);
        }, 2000);
    }
    function showLogoutAlert() {
        var alertDiv = document.createElement("div");
        alertDiv.className = "alert alert-success";
        alertDiv.innerHTML = "Logout successful!";

        // Thêm thông báo trước thẻ h2 "Signup"
        var signupTitle = document.getElementById('signup');
        signupTitle.parentNode.insertBefore(alertDiv, signupTitle);

        // Tự động đặt lại opacity sau 2 giây
        setTimeout(function() {
            alertDiv.style.opacity = "0";
            setTimeout(function() {
                alertDiv.remove(); // Xóa thông báo sau khi biến mất
            }, 1000);
        }, 2000);
    }
    function resetAlert() {
        var alertDiv = document.querySelector(".alert");
        if (alertDiv) {
            alertDiv.remove(); // Xóa thông báo nếu tồn tại
        }
    }

    // Kiểm tra giá trị status
    <% if(status == 1){ %>
        showSuccessAlert();
    <% }else if(status == -1){ %>
    showLogoutAlert();
    <% }else if(status == -2){ %>
    showFailAlert();
    <%  } %>
    
    
</script>

</body>
</html>