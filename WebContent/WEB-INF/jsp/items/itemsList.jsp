<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/queryItems.action" method="post">
        查询条件：
        <table width="50%" border=1>
            <tr>
                <td  align="right"><input type="submit" value="查询"/></td>
            </tr>
        </table>
        商品列表：
        <table width="50%" border=1>
            <tr>
            	<th>序号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品描述</th>
            </tr>
            <c:forEach items="${itemsList}" var="item">
                <tr>
                	<td>${item.id }</td>
                    <td>${item.name }</td>
                    <td>${item.price }</td>
                    <td>${item.detail }</td>
				</tr>
            </c:forEach>
        </table>
    </form>
</body>

</html>