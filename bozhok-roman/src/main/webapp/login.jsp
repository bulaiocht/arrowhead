<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Login form</h2>
<form method="post" action="/login" >

     First name:<br>
      <input type="text" name="firstName" >
      <br>
      Second name:<br>
      <input type="text" name="secondName" >
      <br>
      Age:<br>
      <input type="text" name="age" >
      <br>
      Email:<br>
      <input type="text" name="email" >
     <br>
     Password:<br>
      <input type="password" name="password" >
      <br><br>
      <input type="submit" value="Submit">
    <br><br>
    <div style="color: #FF0000;"> ${errorMessage}</div>
    <div style="color: #49ff02;"> ${newUser}</div>

    </form>
<form method="get" action="/list">
    <br><br>
    <input type="submit" value="List Users">
</form>
</body>
</html>