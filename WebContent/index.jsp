<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>Welcome to Dashboard</title>

<script src="./scripts/jquery.min.js"></script>

<script>
var _glb;   
var _stepId;
function selectFlow()
{
var wf= $("#wf").val();

console.log(window.location.href);
	$.get("./rest/step/"+wf, function(result){
		_glb=result;
		 var str='<SELECT NAME="toppings" MULTIPLE SIZE=10 onclick="javascript:populate(this.value)"> ';
		$.each(result.step, function (index, value) {
			  console.log(value.stepId);			 
			  str+='<OPTION VALUE="'+value.stepId+'" onSelect=""> Step '+(index+1);
			});
	
		str+='</SELECT>';
		$("#jssor").html(str);
		
	});
}

function populate(sel){
	_stepId=sel;	
	 $("#req").show();
	 var wfId=$("#wf").val();
	$.each(_glb.step, function (index, value) {
		if(value.stepId==sel){
			$("#img").attr("src","./img/"+wfId+"_"+sel+".jpg");
			$("#desc").html(value.stepName);
		}
	});
}

function showRequest(){
	 $("#ctrl").show();
}
</script>

  <script src="http://code.angularjs.org/1.4.8/angular.js"></script>  
   <script src="http://code.angularjs.org/1.4.8/angular-resource.js"></script>  
   <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>  
   <script>  
     var app = angular.module('MyForm', ['ui.bootstrap', 'ngResource']);  
     app.controller('myCtrl', function ($scope) {  
       $scope.predicate = 'name';  
       $scope.reverse = true;  
       $scope.currentPage = 1;  
       $scope.order = function (predicate) {  
         $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;  
         $scope.predicate = predicate;  
       };  
       $scope.students = [  
         { name: 'Kevin', age: 25, gender: 'boy' },  
         { name: 'John', age: 30, gender: 'girl' },  
         { name: 'Laura', age: 28, gender: 'girl' },  
         { name: 'Joy', age: 15, gender: 'girl' },  
         { name: 'Mary', age: 28, gender: 'girl' },  
         { name: 'Peter', age: 95, gender: 'boy' },  
         { name: 'Bob', age: 50, gender: 'boy' },  
         { name: 'Erika', age: 27, gender: 'girl' },  
         { name: 'Patrick', age: 40, gender: 'boy' },  
         { name: 'Tery', age: 60, gender: 'girl' }  
       ];  
       $scope.totalItems = $scope.students.length;  
       $scope.numPerPage = 5;  
       $scope.paginate = function (value) {  
         var begin, end, index;  
         begin = ($scope.currentPage - 1) * $scope.numPerPage;  
         end = begin + $scope.numPerPage;  
         index = $scope.students.indexOf(value);  
         return (begin <= index && index < end);  
       };  
     });  
   </script>  
   <style>  
     .odd {  
       background-color: antiquewhite;  
       color: #008b8b;  
     }  
     td th {  
       height: 30px;  
       min-width: 100px;  
     }  
     thead {  
       background-color: darkgray;  
       color: white;  
       height: 30px;  
     }  
   </style>  
</head>
 <body ng-app="MyForm">

<h1>Please select the workflow </h1>
<select id="wf">
  <option value="1001">Lookup Workflow</option> 
</select>
<button onclick="selectFlow();">Submit</button>	
<button onclick="showRequest();" id="req" style="display:none">Show Request</button>
<table>
	<tr>
	<td valign="top"><div id="jssor">
        
    </div>
    <td>
    <td>
    <div>
    	<img id='img' src="">
    </div>
    </td>
    <td>
    <div id="desc">    	
    </div>
    </td>
    </tr>
</table>
   
 <div id="ctrl" ng-controller="myCtrl" style="display:none">  
     <h3>Step Request</h3>  
     <div class="container-fluid">  
       <pre>Click header link to sort, input into filter text to filter</pre>  
       <hr />  
       <table class="table table-striped">  
         <thead>  
           <tr>  
               
             <th>  
               <a href="" ng-click="order('name')">Name</a>  
             </th>  
             <th><a href="" ng-click="order('age')"> Age</a> </th>  
             <th><a href="" ng-click="order('gender')">Gender</a> </th>  
           </tr>  
         </thead>  
         <tbody>  
           <tr>  
             
             <td> <input type="text" ng-model="search.name" /></td>  
             <td> <input type="text" ng-model="search.age" /> </td>  
             <td><input type="text" ng-model="search.gender" /> </td>  
           </tr>  
           <tr ng-repeat="user in students | orderBy:predicate:reverse | filter:paginate| filter:search" ng-class-odd="'odd'">  
    
             <td>{{ user.name}}</td>  
             <td>{{ user.age}}</td>  
             <td>{{ user.gender}}</td>  
           </tr>  
         </tbody>  
       </table>  
       <pagination total-items="totalItems" ng-model="currentPage"  
             max-size="5" boundary-links="true"  
             items-per-page="numPerPage" class="pagination-sm">  
       </pagination>  
     </div>  
   </div>  
 </body>  
</html>