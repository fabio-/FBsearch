<?php

		//Get user id (total rows + 1)
		
		// Create connection
		$con=mysqli_connect("localhost","fabio","root","test");

		// Check connectionei
		if (mysqli_connect_errno($con))
  		{
 		 echo "Failed to connect to MySQL: " . mysqli_connect_error();
  		}
		
		$result = mysqli_query($con,"SELECT count(*) as count FROM test.ranknings;");
		
		 while($row = mysqli_fetch_array($result))
 		 {
  			echo $row['count'];
  		 }
		 mysqli_close($con);
?>
