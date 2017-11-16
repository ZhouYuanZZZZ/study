
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/static/jsp/common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="div0"></div>


${a}
<br/>
${"a"}
<br/>

${b}
<br/>
${"b"}
<br/>

<input type="text" value="${city.district}">
<input type="text" value="${city.countrycode}">
</body>

<script type="text/javascript">
    var i = 0;
    var flag = 0;
  $(function () {
      try {
         debugger;
         var div0 = window.div0;
      }
      catch(err) {
          document.getElementById("demo").innerHTML = err.message;
      }
  });





</script>
</html>
