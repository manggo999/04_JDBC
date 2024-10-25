<%-- studentList.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학생 관리 시스템</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        .form-group { margin-bottom: 10px; }
    </style>
</head>
<body>
    <h2>학생 등록</h2>
    <form action="${pageContext.request.contextPath}/student" method="post">
        <div class="form-group">
            <label>학번:</label>
            <input type="number" name="stdNo" required>
        </div>
        <div class="form-group">
            <label>이름:</label>
            <input type="text" name="stdName" maxlength="20" required>
        </div>
        <div class="form-group">
            <label>나이:</label>
            <input type="number" name="stdAge" required>
        </div>
        <div class="form-group">
            <label>성별:</label>
            <input type="radio" name="stdGender" value="M" required> 남
            <input type="radio" name="stdGender" value="F"> 여
        </div>
        <div class="form-group">
            <label>성적:</label>
            <select name="stdScore" required>
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
                <option value="F">F</option>
            </select>
        </div>
        <button type="submit">등록</button>
    </form>

    <h2>학생 목록</h2>
    <table>
        <thead>
            <tr>
                <th>학번</th>
                <th>이름</th>
                <th>나이</th>
                <th>성별</th>
                <th>성적</th>
                <th>관리</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.stdNo}</td>
                    <td>${student.stdName}</td>
                    <td>${student.stdAge}</td>
                    <td>${student.stdGender}</td>
                    <td>${student.stdScore}</td>
                    <td>
                        <button onclick="editStudent(${student.stdNo})">수정</button>
                        <button onclick="deleteStudent(${student.stdNo})">삭제</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script>
        function editStudent(stdNo) {
            // 수정 기능 구현
            alert('학생 수정 기능은 추가 구현이 필요합니다.');
        }

        function deleteStudent(stdNo) {
            if (confirm('정말 삭제하시겠습니까?')) {
                // DELETE 요청 구현
                alert('학생 삭제 기능은 추가 구현이 필요합니다.');
            }
        }
    </script>
</body>
</html>
