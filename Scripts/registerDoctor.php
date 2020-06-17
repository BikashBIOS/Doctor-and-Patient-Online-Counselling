<?php 
	$con=mysqli_connect("localhost","id14064862_doctors","Bikash@12345","id14064862_doctorbase");
	
    $name = $_POST["name"];
    $speciality = $_POST["speciality"];
    $qualification = $_POST["qualification"];
    $designation = $_POST["designation"];
    $institution = $_POST["institution"];    
    $email = $_POST["email"];
    $mobile = $_POST["mobile"];
    $account = $_POST["account"];
    $hours = $_POST["hours"];
    $confirmp = $_POST["confirmp"];
	$password =$_POST["password"];

	$sql = "INSERT INTO DoctorsTable(name,speciality, qualification, designation, institution, email, mobile, account, hours, password, confirmp) VALUES ('$name', '$speciality', '$qualification', '$designation', '$institution', '$email', '$mobile', '$account', '$hours', '$password', '$confirmp')";
	$result = mysqli_query( $con,$sql );
	
	if($result) {
		echo "Registered Successfully";
	}
	else {
		echo "Some ERROR Occured";
	}
?>
