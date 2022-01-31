<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="assets/css/book.css">
   <link rel="stylesheet" href="assets/css/styles.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
  <title>book
  </title>
</head>
<body>
<jsp:include page="header.jsp" />  

  <div class="containing">
    <div class="content">
      <div class="calendar-container">
        <div class="calendar"> 
          <div class="year-header"> 
            <span class="left-button" id="prev"> &lang; </span> 
            <span class="year" id="label"></span> 
            <span class="right-button" id="next"> &rang; </span>
          </div> 
          <table class="months-table"> 
            <tbody>
              <tr class="months-row">
                <td class="month">Jan</td> 
                <td class="month">Feb</td> 
                <td class="month">Mar</td> 
                <td class="month">Apr</td> 
                <td class="month">May</td> 
                <td class="month">Jun</td> 
                <td class="month">Jul</td>
                <td class="month">Aug</td> 
                <td class="month">Sep</td> 
                <td class="month">Oct</td>          
                <td class="month">Nov</td>
                <td class="month">Dec</td>
              </tr>
            </tbody>
          </table> 
          
          <table class="days-table"> 
            <td class="day">Sun</td> 
            <td class="day">Mon</td> 
            <td class="day">Tue</td> 
            <td class="day">Wed</td> 
            <td class="day">Thu</td> 
            <td class="day">Fri</td> 
            <td class="day">Sat</td>
          </table> 
          <div class="frame"> 
            <table class="dates-table"> 
                <tbody class="tbody">             
                </tbody> 
            </table>
          </div> 
          <button class="button" id="add-button">Ajouter Patient</button>
        </div>
      </div>
      <div class="events-container">
      </div>
      <div class="dialog" id="dialog">
          <h2 class="dialog-header"> Ajouter nouveau Patient </h2>
          <form class="form" id="form">
            <div class="form-container"  align="center">
              <label class="form-label" id="valueFromMyButton" for="name">Nom Patient</label>
              <input class="input" type="text" id="name" maxlength="36">
              <label class="form-label" id="valueFromMyButton" for="count">Number of people to invite</label>
              <input class="input" type="number" id="count" min="0" max="1000000" maxlength="7">
              <input type="button" value="Cancel" class="button" id="cancel-button">
              <input type="button" value="OK" class="button" id="ok-button">
            </div>
          </form>
        </div>
    </div>


  </div>
  
    <jsp:include page="footer.jsp" />

  <!-- Dialog Box-->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="assets/js/book.js"></script>
  
</body>
</html>