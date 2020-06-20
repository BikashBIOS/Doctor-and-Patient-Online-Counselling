<?php

	$con=mysql_connect("localhost","id14055876_patientdetails","RIC+9r*nkeWq6bdy","id14055876_patient_managementsystem");

	$name=$_POST["name"];
	$email=$_POST["email"];
	$age=$_POST["age"];
	$gender=$_POST["gender"];
	$address=$_POST["address"];
	$town=$_POST["town"];
	$district=$_POST["district"];
	$pincode=$_POST["pincode"];
	$phone=$_POST["phone"];
	$password=$_POST["password"];

	$sql="INSERT INTO data(name,email,age,gender,address,town,district,pincode,phone,password) values ('$name','$email',$age,$gender,$address,$town,$district,$pincode,$phone,$password)";
	$result= mysql_query($con,$sql);

	if ($result) {
		echo "Registration Sucessful";
	}
	else
	{
		echo "Error occour";
	}

	?>