<?php

		//Get event's id and ranking from the index.html as user rates events
		$idUser = $_GET['user']; 
		$event1 = $_GET['event1']; 
		$event2 = $_GET['event2']; 
		$ranking = $_GET['ranking']; 
		
		// Create connection
		$con=mysqli_connect("localhost","fabio","root","test");

		// Check connectionei
		if (mysqli_connect_errno($con))
  		{
 		 echo "Failed to connect to MySQL: " . mysqli_connect_error();
  		}
		
		$result = mysqli_query($con,"INSERT INTO test.ranknings (user,event1,event2,ranking) VALUES ('+$idUser+','+$event1+','+$event2+','+$ranking+');");
		
		mysqli_close($con);
?>
