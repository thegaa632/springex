<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/todo/register1" method="post">
    <div> 해야할 일 : <input type="text" name="title"></div>
    <div> 완료 예정일 : <input type="text" name="dueDate" value="2023-11-14"></div>
    <div> 누가 : <input type="text" name="writer"></div>
    <div> 완료 여부 : <input type="checkbox" name="finished"></div>
    <div><button type="submit"> 등록 </button></div>
</form>
</body>
</html>
