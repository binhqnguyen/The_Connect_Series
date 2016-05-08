<?php
	$username = "root";
	$password = "simeca";
	$hostname = "155.98.39.74"; 
	$table_name = "UE_LOCATION_IP";

	//connection to the database
	//echo "Connecting to DB $username<br>";
	$dbhandle = mysql_connect($hostname, $username, $password) 
  		or die("Unable to connect to MySQL");
	//echo "Connected to MySQL host = $hostname, table = $table_name <br>";

	//select DB
	$selected = mysql_select_db("simeca",$dbhandle) 
  		or die("Could not select examples");
		
	$result = mysql_query("SELECT * FROM UE_LOCATION_IP;");
	//fetch tha data from the database
	$cnt = 0;
	$json = array();

	while ($row = mysql_fetch_array($result)) {
		$cnt = $cnt + 1;
		//echo "Row: #$cnt<br>";
   		//echo "ID:".$row{'IMSI'}." Name:".$row{'UE_IP'}."<br>";
		$value = array(
			'IMSI' => $row{'IMSI'},
			'UE_IP' => $row{'UE_IP'}
		);
		array_push($json, $value);
	}
	echo json_encode($json);
?>
