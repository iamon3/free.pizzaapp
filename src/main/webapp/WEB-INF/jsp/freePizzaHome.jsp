<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>User Home Page</title>

	<style>
    </style>

	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
        table,th,td {
            border:1px solid black;
            border-collapse:collapse;
        }
	</style>

	<script>

    function loadDoc(){
        var pizzaResponse = loadXMLDoc1(loadXMLDoc2);
    }

    function loadXMLDoc1(callBackMethod)
    {
       var xmlhttp;
       if (window.XMLHttpRequest)
         {// code for IE7+, Firefox, Chrome, Opera, Safari
           xmlhttp=new XMLHttpRequest();
         }
       else
         {// code for IE6, IE5
           xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
         }

       xmlhttp.onreadystatechange=function(){
         if (xmlhttp.readyState==4 && (xmlhttp.status==200))
           {
              callBackMethod(xmlhttp.responseText);
           }
       }

       xmlhttp.open("GET","http://localhost:9090/freeapis/pizzas",true);
       xmlhttp.setRequestHeader("Accept","application/json");
       xmlhttp.send();
    }


    function loadXMLDoc2(response)
    {
       var toppingsXmlHttp;
       if (window.XMLHttpRequest)
         {// code for IE7+, Firefox, Chrome, Opera, Safari
           toppingsXmlHttp=new XMLHttpRequest();
         }
       else
         {// code for IE6, IE5
           toppingsXmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
         }

       toppingsXmlHttp.onreadystatechange=function(){
          if (toppingsXmlHttp.readyState==4 && (toppingsXmlHttp.status==200)){
              document.getElementById("myDiv").innerHTML=parsePizzasToppingsResponse(JSON.parse(response), JSON.parse(toppingsXmlHttp.responseText));
          }
       }
       toppingsXmlHttp.open("GET","http://localhost:9090/freeapis/toppings",true);
       toppingsXmlHttp.setRequestHeader("Accept","application/json");
       toppingsXmlHttp.send();
    }

    function getResourceURL(resource){
       var resourceURL;

       if(resource=='Pizzas'){ resourceURL='http://localhost:9090/freeapis/pizzas';}
       if(resource=='Toppings'){ resourceURL='http://localhost:9090/freeapis/toppings';}
       return resourceURL;
    }

    function parsePizzasToppingsResponse(json_obj, toppings_json_obj){
       var output="<br/><table style=\"width:300px\"> <tr> <td><b>ID</b></td> <td><b>Name</b></td> <td><b>Description</b></td> <td><b>Price</b></td> <td><b>Toppings</b></td></tr>";
       for (var i in json_obj)
         {
           output+="<tr><td>" + json_obj[i].id + "</td><td>" + json_obj[i].name + "</td><td>" + json_obj[i].description + "</td><td>" + json_obj[i].price + "</td>";
           for (var j in toppings_json_obj){
               output+="<td>" + toppings_json_obj[j].id + "</td><td>" + toppings_json_obj[j].name + "</td><td>" + toppings_json_obj[j].price + "</td></tr>";
           }
         }
       output+="</table>";
       return output;
    }

</script>
</head>
<body>

<h2>Today Menu</h2>

<!--button type="button" onclick="loadDoc()">Pizzas</button-->
<div id="myDiv"></div>
<script>
loadDoc();
</script>
</body>
</html>