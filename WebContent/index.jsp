<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>Welcome to Dashboard</title>
  <script src="./scripts/jquery.min.js"></script>
<script>
function selectFlow()
{
var wf= document.getElementById("wf").value;

console.log(window.location.href);
	$.get("./rest/step/"+wf, function(result){
		
	alert(result[0].stepId);
	});
}
</script>
</head>
<body>

<h1>Please select the workflow </h1>
<select id="wf">
  <option value="1001">Lookup Workflow</option> 
</select>
<button onclick="selectFlow();">Submit</button>
</body>
</html>