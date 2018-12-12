ajax读取json数据
https://www.bbsmax.com/A/gGdX7OBY54/
首先建立json.txt文件
 
{
"programmers": [
{ "firstName": "Brett", "lastName":"McLaughlin", "email": "brett@newInstance.com" },
{ "firstName": "Jason", "lastName":"Hunter", "email": "jason@servlets.com" },
{ "firstName": "Elliotte", "lastName":"Harold", "email": "elharo@macfaq.com" }
],
"authors": [
{ "firstName": "Isaac", "lastName": "Asimov", "genre": "science fiction" },
{ "firstName": "Tad", "lastName": "Williams", "genre": "fantasy" },
{ "firstName": "Frank", "lastName": "Peretti", "genre": "christian fiction" }
],
"musicians": [
{ "firstName": "Eric", "lastName": "Clapton", "instrument": "guitar" },
{ "firstName": "Sergei", "lastName": "Rachmaninoff", "instrument": "piano" }
]
}
 
通过异步调用，来读取json数据
 
建立html文件
<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
<script type="text/javascript">
var xmlHttp;
function createXMLHttpRequest()
{
    if(window.ActiveXObject)
    {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest)
    {
        xmlHttp = new XMLHttpRequest();
    }
}
function startRequest()
{
    createXMLHttpRequest();
    try
    {
        xmlHttp.onreadystatechange = handleStateChange;
        xmlHttp.open("GET", "Json.txt", true);
        xmlHttp.send(null);
    }
    catch(exception)
    {
        alert("xmlHttp Fail");
    }
}
function handleStateChange()
{
    if(xmlHttp.readyState == 4)
    {
        if (xmlHttp.status == 200 || xmlHttp.status == 0)
        {
            var result = xmlHttp.responseText;
            var json = eval("(" + result + ")");
            alert(json.programmers[0].firstName);//读取json数据
            //alert(json.sex);
        }
    }
}
</script>
</head>
<body>
    <div>
        <input type="button" value="AjaxTest" onclick="startRequest();" />
    </div>
</body>
</html>



启动http-server -p 18090


