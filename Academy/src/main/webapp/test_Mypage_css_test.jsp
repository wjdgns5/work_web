<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Information</title>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 20px;
        }
        .navbar {
            width: 100%;
            background-color: #003366;
            color: white;
            padding: 10px 0;
            text-align: center;
        }
        .navbar a {
            color: white;
            margin: 0 15px;
            text-decoration: none;
        }
        .content {
            display: flex;
            width: 80%;
            background-color: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .sidebar {
            width: 25%;
            border-right: 1px solid #ddd;
            padding: 20px;
        }
        .sidebar ul {
            list-style: none;
            padding: 0;
        }
        .sidebar ul li {
            margin-bottom: 10px;
        }
        .main-content {
            width: 75%;
            padding: 20px;
        }
        .info-table {
            width: 100%;
            border-collapse: collapse;
        }
        .info-table th, .info-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        .info-table th {
            background-color: #f2f2f2;
        }
        .footer {
            margin-top: 20px;
            width: 100%;
            text-align: center;
            padding: 10px 0;
            background-color: #003366;
            color: white;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="#">홈</a>
        <a href="#">MY</a>
        <a href="#">수업</a>
        <a href="#">수강신청</a>
        <a href="#">성적</a>
        <a href="#">학사정보</a>
    </div>
    <div class="container">
        <div class="content">
            <div class="sidebar">
                <h3>MY</h3>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/user/Myinformation">내 정보 조회</a></li>
                    <li>비밀번호 변경</li>
                    <li>휴학 신청</li>
                    <li>휴학 신청 조회</li>
                    <li>등록금 내역 조회</li>
                    <li>등록금 납부 고지서</li>
                </ul>
            </div>
            <div class="main-content">
                <h3>내 정보 조회</h3>
                <table class="info-table">
                    <tr>
                        <th>학번</th>
                        <td>2023000001</td>
                        <th>소속</th>
                        <td>공과대학 컴퓨터공학과</td>
                    </tr>
                    <tr>
                        <th>학년</th>
                        <td>1</td>
                        <th>학기</th>
                        <td>1</td>
                    </tr>
                    <tr>
                        <th>입학일</th>
                        <td>2021-03-02</td>
                        <th>졸업일(졸업예정일)</th>
                        <td></td>
                    </tr>
                    <tr>
                        <th>성명</th>
                        <td>박시우</td>
                        <th>생년월일</th>
                        <td>2002-06-19</td>
                    </tr>
                    <tr>
                        <th>성별</th>
                        <td>남성</td>
                        <th>주소</th>
                        <td>부산시 남구</td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td>010-5267-1815</td>
                        <th>email</th>
                        <td>psw@green.com</td>
                    </tr>
                </table>
                <button>수정하기</button>
                <h3>학적 변동 내역</h3>
                <table class="info-table">
                    <tr>
                        <th>변동 일자</th>
                        <th>변동 구분</th>
                        <th>세부</th>
                        <th>승인 여부</th>
                        <th>복학 예정 연도/학기</th>
                    </tr>
                    <tr>
                        <td>2023-03-02</td>
                        <td>재학</td>
                        <td>승인</td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="footer">
        <p>&copy; GREEN UNIVERSITY</p>
    </div>
</body>
</html>
