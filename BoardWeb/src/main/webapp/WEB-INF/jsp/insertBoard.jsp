<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록</title>
</head>
<body>
	<center>
		<h1>새 글 등록</h1>
		<a href="logout.do">Log-out</a>
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><input type="text" name="writer" size="10"></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left">
						<textarea name="content" cols="40" rows="10"></textarea>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">업로드</td>
					<td align="left">
						<input type="file" name="uploadFiles" multiple="multiple">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="새 글 등록">
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="getBoardList.do">글 목록 가기</a>
	</center>
</body>
</html>