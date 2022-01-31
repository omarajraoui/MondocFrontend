<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/styles.css">
  <link rel="stylesheet" href="assets/css/doc.css">
 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="assets/css/rate.css">

  <title>Rate ton Doc</title>
</head>
<body>

<%
    String doctorName=request.getParameter("doctorName");
%>

 <jsp:include page="header.jsp" />  
 
  <div class="container py-5">
    <div class="row text-center text-white">
        <div class="col-lg-8 mx-auto">
            <h1 class="display-4">Rate le docteur qui vous a examiné!</h1>
            <br>
            <p class="lead">Rated by Patients . </p>
        </div>
    </div>
</div><!-- End -->


	<div class="container rate ">
           <!-- Team item -->
           
           <form   action="RateServlet" method="post">
            <div class="bg-white rounded shadow-sm py-5 px-4 mb-5" >
              <img src="https://bootstrapious.com/i/snippets/sn-team/teacher-2.jpg" alt="" width="100" class="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm m-4 ">
                <h5 class="m-1 " id="nomDoc"><%=doctorName%></h5><span id="specialiteDoc" class="small text-uppercase text-muted ">Dermatologue</span>
                <br>
				
				<input type="hidden" name="doctorName" value='<%=doctorName%>' />
				<input type="hidden" id="rating" name="rating" > 
                <span  onmouseover="starmark(this)" onclick="starmark(this)" id="1one" style="font-size:40px;cursor:pointer;"  class="fa fa-star checked mt-3 mb-3"></span>
                <span onmouseover="starmark(this)" onclick="starmark(this)" id="2one"  style="font-size:40px;cursor:pointer;" class="fa fa-star mt-3 mb-3"></span>
                <span onmouseover="starmark(this)" onclick="starmark(this)" id="3one"  style="font-size:40px;cursor:pointer;" class="fa fa-star mt-3 mb-3"></span>
                <span onmouseover="starmark(this)" onclick="starmark(this)" id="4one"  style="font-size:40px;cursor:pointer;" class="fa fa-star mt-3 mb-3"></span>
                <span onmouseover="starmark(this)" onclick="starmark(this)" id="5one"  style="font-size:40px;cursor:pointer;" class="fa fa-star mt-3 mb-3"></span>
                <br/>
                <textarea  name="review" style="margin-top:5px;" class="form-control mt-4 mb-4" rows="3" id="comment" placeholder="Enter your review"></textarea>

                <button  type="submit" style="margin-top:10px;margin-left:5px; background-color: #ec1c24;" class="btn btn-lg btn-success ">Submit</button>
               
            </div>
            </form>
        </div><!-- End -->
</div>

</div>


<jsp:include page="footer.jsp" /> 

<script src="assets/js/doctorJs.js"></script>

  
</body>
</html>