<?php 
    $con=mysqli_connect("localhost","id14064862_doctors","Bikash@12345","id14064862_doctorbase");

    $email = $_POST["email"];
    $password = $_POST["password"];

    $sql = "SELECT * FROM DoctorsTable WHERE  email = '$email' AND password = '$password'";
    $result = mysqli_query($con,$sql);
    
    if($result->num_rows > 0){
        echo "Logged In Successfully" ;
    }else{
        echo "User Not Found";
}
?>