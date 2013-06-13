<html>
<head>
<title>Facebook Search</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	
	<div style="background-color:#3b5998; width:100%;height:100px;">
    	<div id="header"><img id="logo" src="FacebookSearch.png"></div>
    </div>
    
    <div id="mainArea">
    	<h1>To Search for events in your city enter your location in the searach bar...</h1>
	
   		<div id="searchBar">
    		<input type="text" name="q" id="q"/>
           	<input type="submit" class="go"​ value="Press"/>
            <input type="submit" id="reccomend" value="Go Back" onClick="location.href='http://localhost/index.html"/>
        </div>
        <div id="loading"></div>
   	</div>
    
    <div id="SearchResultsBox"></div>
    

<?php

//header("Location:http://localhost/CSVExport.php");

function csvExport(){
	$host = '127.0.0.1'; // <--  db address
 $user = 'fabio'; // <-- db user name
 $pass = 'root'; // <-- password
 $db = 'test'; // db's name
 $table = 'ranknings'; // table you want to export
 $file = 'file_name'; // csv name.
 
$link = mysql_connect($host, $user, $pass) or die("Can not connect." . mysql_error());
 mysql_select_db($db) or die("Can not connect.");
 
$result = mysql_query("SHOW COLUMNS FROM ".$table."");
 $i = 0;
 
if (mysql_num_rows($result) > 0) {
while ($row = mysql_fetch_assoc($result)) {
$csv_output .= $row['Field'].";";
$i++;}
}
$csv_output .= "\n";
 $values = mysql_query("SELECT * FROM ".$table."");
 
while ($rowr = mysql_fetch_row($values)) {
for ($j=0;$j<$i;$j++) {
$csv_output .= $rowr[$j].";";
}
$csv_output .= "\n";
}
 
 function callMhoutJar(){
	 shell_exec("java -jar http://localhost/Mahout.jar");
	 }
 

$filename ="DataRanking";
 
header("Content-type: application/vnd.ms-excel");
header("Content-disposition: csv" . date("Y-m-d") . ".csv");
header( "Content-disposition: filename=".$filename.".csv");
 
print $csv_output;
	}

$file = fopen("mahout.txt", "r");
$members = array();

while (!feof($file)) {
   $members[] = fgets($file);
}
fclose($file);

?>


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script type="text/javascript">
 
var ar = <?php echo json_encode($members); ?>;
var start = (new Date).getTime();
console.log(ar);
if(ar.length>0){
		$('#SearchResultsBox').append('<div id="wrapper"><div id="content"> </div></div>');

	for(var i = 0 ; i<ar.length ;i++){
		if(i<10){
			ar[i] = ar[i].toString().replace(/[\r\n]/g, "");
			var accessToken = getAccessToken();
			var url = 'https://graph.facebook.com/'+ar[i]+'?'+accessToken;
			getJson(url);
		}
	}
}
//Handle the "enter" event to trigger button click
	function getAccessToken(){
		var requestURL = 'https://graph.facebook.com/oauth/access_token?%20client_id=136237449885255&client_secret=9f9191c07c175024dbc495c7914625c0&%20grant_type=client_credentials';
	
		var accessToken = $.ajax({
  		url: requestURL,
  		global: false,
  		type: "POST",
  		data: "name=value",
  		dataType: "html",
  		async:false,
  		success: function(msg){ }
		} ).responseText;
		
		return accessToken;
	}
	
	function getJson(url){
		var jsonEvents = {};
    	$.ajax({
    		url: url,
    		dataType: 'json',
    		success: function(data) {
    				jsonEvents = data;					
					buildRanking(jsonEvents);
    		}
    	});
	}
	
	function addResults(jsonEvents){
		
		//create box to show results
		
		var time = "Not Provided";
		var timezone = "Not Provided";
		var location = "Not Provided"
		
		var name = jsonEvents.name;
		var date = jsonEvents.start_time;
			
		if(name.length>58){
			name = name.substring(0,58).concat("...");
		}
			
		var dateNTime = splitDateNTime(date);
			
		console.log(date);
		console.log(dateNTime[0]);
		var timeZone = jsonEvents.timezone;
		if(dateNTime[1]!=1){
			time = dateNTime[1];
		}
		if(jsonEvents.timezone != undefined){
			timezone = jsonEvents.timezone;
		}
			
		if(jsonEvents.location != undefined){
			location = jsonEvents.location;
		}
				
		var out = '<div class="multiborder"><div class="evnt"><a href=https://www.facebook.com/events/'+jsonEvents.id+'><b>'+name+'</b></a></div><div class= imgDiv><div id = "proPic">'+
		'<img src="https://graph.facebook.com/'+jsonEvents.id+'/picture?type=large "height="100%" width="100%"></div></div>'+
		'<div id="event1" ><div id="innerEvent"><div id = "iconStyle"><img class="icon" src="date.png"></div>'+
		'<div id="startTimeStyle">'+dateNTime[0]+'</div></div>'+
		'<div id ="innerEvent2"><div id = "iconStyle"><img class="icon" src="timezone-icon.png"></div>'+
		'<div id = "startTimeStyleBig">Starts at -> '+time+' </div></div>'+
		'<div id = "event2"><div id = innerEvent><div id = "startTimeStyleBig"> Going-> <b>'+jsonEvents.likes+'</b> persons</div></div>'+
		'<div id = "innerEvent2"><div id = "iconStyle"><img class="icon" src="timezone-icon.png"></div>'+
		'<div id = "startTimeStyleBig">'+timezone+'</div></div>'+
		//'<div id="info" >Going:'+jsonEvents.likes+'</div>'+
		'<div id = "event2"><div id = "innerEvent3"><div id = "iconStyle"><img class="icon" src="location.png"></div>'+
		'<div id = "locationStyle">'+location+'</div></div>'+
		'<div style="height:16px; overflow:hidden" id=ratingSystem>'+
		'<img src="star.gif" class="star"  onclick="getRating('+jsonEvents.id+',1)">'+
		'<img src="star.gif" class="star"  onclick="getRating('+jsonEvents.id+',2)">'+
		'<img src="star.gif" class="star"  onclick="getRating('+jsonEvents.id+',3)">'+
		'<img src="star.gif" class="star"  onclick="getRating('+jsonEvents.id+',4)">'+
		'<img src="star.gif" class="star"  onclick="getRating('+jsonEvents.id+',5)">'+
		'</div>'
		;
			
		//'<div id="event2"><div id="innerEvent2"><div id = "iconeStyle"><img class="icon" src="location.png"></div><div id = "startTimeStyleBig">'+jsonEvents.location+'</div></div></div></div>';
			
        $('#content').append(out);
		$('#content').append('<br>');
	}
	function buildRanking(jsonEvents){
		
		var count=0;
			
			var url = 'https://graph.facebook.com/'+jsonEvents.id+'/attending?'+accessToken;
			
			$.ajax({
   			url: url,
   			dataType: 'json',
   			success: function(data) {
					 	likes = data.data.length;
						
						//add number of likes to the Json object representing events
						jsonEvents.NewItem='likes';
						jsonEvents.likes=likes;
						
						//Perform sort on number of likes once they are all added to the json
								addResults(jsonEvents);
								diff = (new Date).getTime() - start;
								diff/=1000;
								$('#loading').empty();
								$('#loading').append("<p>"+jsonEvents.length+" events in about : "+diff+" seconds</p>");
						
						}
    		});  //close ajax to retrieve likes
	} 
	function splitDateNTime(timeDate){
		
		var actualTime;
		var actualDate;
		
		var timeDateSplited = new Array();
		try{		
			timeDateSplited = timeDate.split("T");
		
			var date = timeDateSplited[0].split("-");
			var time = timeDateSplited[1].split(":");
		
			if(time[0]>12){
			
				var t = time[0] - 12;
				actualTime = t+":"+time[1]+" pm       ";
			}else{
				actualTime= time[0]+":"+time[1]+" am";
			}
		
			var month = getMonthName(date[1]);
		
			actualDate = month+" "+date[2]+","+date[0];
		
			var returnArray= [actualDate,actualTime];
		
			return returnArray;
		}catch(err){
			var date = timeDateSplited[0].split("-");
			
			var month = getMonthName(date[1]);
		
			actualDate = month+" "+date[2]+","+date[0];
			return [actualDate,1];
			}
	}
	//This function fwill take a number and convert it as a Month
	function getMonthName(monthAsNumber){
		
		if(monthAsNumber == 1){
			return "Jan";
		} else if(monthAsNumber == 2){
			return "Feb";
		}else if(monthAsNumber == 3){
			return "March";
		}else if(monthAsNumber == 4){
			return "April";
		}else if(monthAsNumber == 5){
			return "May";
		}else if(monthAsNumber == 6){
			return "June";
		}else if(monthAsNumber == 7){
			return "July";
		}else if(monthAsNumber == 8){
			return "Aug";
		}else if(monthAsNumber == 9){
			return "Sep";
		}else if(monthAsNumber == 10){
			return "Oct";
		}else if(monthAsNumber = 11){
			return "Nov";
		}else{
			return "Dec";
			}
		
	}

</script>
</body>
</html>