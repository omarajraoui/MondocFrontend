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
  <link rel="stylesheet" href="assets/css/contact.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <title>contact</title>
</head>
<body>

  <jsp:include page="header.jsp" />  

  <div class="contain">

    <div class="wrapper">
  
      <div class="form">
        <h4>Contact Us</h4>
        <h2 class="form-headline">Envoyez-nous un message</h2>
        <form id="submit-form" action="Contacter" method="post">
          <p>
            <input id="name" name="name" class="form-input" type="text" placeholder="Votre Nom">
            <small class="name-error"></small>
          </p>
          <p>
            <input id="email" name="email" class="form-input" type="email" placeholder="Votre Prenom">
            <small class="name-error"></small>
          </p>
          <p class="full-width">
            <input id="contactNumber" name="contactNumber" class="form-input" type="text" placeholder="Votre Numero" required>
            <small></small>
          </p>
          <p class="full-width">
            <textarea  minlength="20" name="message" id="message" cols="30" rows="7" placeholder="Votre message" required></textarea>
            <small></small>
          </p>
          <p class="full-width">
            <input type="checkbox" id="checkbox" name="checkbox" checked> Yes, I would like to receive communications by call / email about Company's services.
          </p>
          <p class="full-width">
            <input type="submit" class="submit-btn" value="Submit" onclick="checkValidations()">
            <button class="reset-btn" onclick="reset()">Reset</button>
          </p>
        </form>
      </div>
  
      <div class="contacts contact-wrapper">
  
        <ul>
          <li>On est valable 24h 6/7 pour vos question,reclamation <span class="highlight-text-grey">et pour votre santé</span> Pour nos patient.
            Comment on peut vous aidez?</li>
          <span class="hightlight-contact-info">
            <li class="email-info"><i class="fa fa-envelope" aria-hidden="true"></i> CONTACT@MONDOC.COM </li>
            <li><i class="fa fa-phone" aria-hidden="true"></i> <span class="highlight-text">+212 612215103</span></li>
          </span>
        </ul>
      </div>
    </div>
  </div>

  
  <jsp:include page="footer.jsp" />  


  <script src="assets/js/book.js"></script>
</body>
</html>