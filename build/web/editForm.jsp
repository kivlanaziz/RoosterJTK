<%-- 
    Document   : editForm
    Created on : Jan 1, 2018, 6:58:00 PM
    Author     : kivla
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rooster JTK</title>
        <meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="script.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div id="main">
            <span style="font-size:30px;cursor:pointer" onclick="openNav('inputWrapper','250px')">&#9776; Rooster JTK</span><li style="float: right;list-style: none;">Kivlan Aziz</li>
        </div>
		
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav('inputWrapper','0px')">&times;</a>
            <a href="index.jsp">Schedule</a>
            <a href="input.jsp">Input Data</a>
            <a href="edit.jsp">Update Data</a>
            <a href="delete.jsp">Delete Data</a>
        </div>
        
        <div id="inputWrapper">
            <div class="editcontent">
            <h3>EDIT JADWAL</h3>
           
                <form action="${pageContext.request.contextPath}/Rooster?action=upd_jadwal" method="POST">
                   
                    <div class="column">
                        <jsp:include page="/Rooster?action=dosen"/>
                        <br> Dosen <br>
                        <select name="kode_dsn">
                            <c:forEach items="${dosen}" var="dt">
                                <c:if test="${dt.getKD_DOSEN() == jadwal.getKD_DOSEN()}">
                                    <option value="${dt.getKD_DOSEN()}" selected><c:out value="${dt.getNAMA_DOSEN()}"/></option>
                                </c:if>
                                <c:if test="${dt.getKD_DOSEN() != jadwal.getKD_DOSEN()}">
                                    <option value="${dt.getKD_DOSEN()}" ><c:out value="${dt.getNAMA_DOSEN()}"/></option>
                                </c:if>
                            </c:forEach>
                        </select>
                        <jsp:include page="/Rooster?action=matkul"/>
                        <br><br> Mata Kuliah <br>
                        <select name="matkul">
                            <c:forEach items="${matkul}" var="dt">
                                <c:if test="${dt.getKD_MATKUL() == jadwal.getKD_MATKUL()}">
                                    <option value="${dt.getKD_MATKUL()}" selected><c:out value="${dt.getNAMA_MATKUL()}"/></option>
                                </c:if>
                                <c:if test="${dt.getKD_MATKUL() != jadwal.getKD_MATKUL()}">
                                    <option value="${dt.getKD_MATKUL()}" ><c:out value="${dt.getNAMA_MATKUL()}"/></option>
                                </c:if>
                            </c:forEach>
                        </select>
                        <jsp:include page="/Rooster?action=ruangan"/>
                        <br><br> Ruangan <br>
                        <select name="ruangan">
                            <c:forEach items="${ruangan}" var="dt">
                                <c:if test="${dt.getKD_RUANGAN() == jadwal.getKD_RUANGAN()}">
                                    <option value="${dt.getKD_RUANGAN()}" selected><c:out value="${dt.getKD_RUANGAN()}"/></option>
                                </c:if>
                                <c:if test="${dt.getKD_RUANGAN() != jadwal.getKD_RUANGAN()}">
                                    <option value="${dt.getKD_RUANGAN()}" ><c:out value="${dt.getKD_RUANGAN()}"/></option>
                                </c:if>    
                            </c:forEach>
                        </select>
                        <jsp:include page="/Rooster?action=kelas"/>
                        <br><br> Kelas <br>
                        <select name="kelas">
                            <c:forEach items="${kelas}" var="dt">
                                <option value="${dt.getNAMA_KELAS()}"><c:out value="${dt.getNAMA_KELAS()}"/></option>
                            </c:forEach>
                        </select>
                        <jsp:include page="/Rooster?action=prodi"/>
                        <br><br> Program Studi <br>
                        <select name="prodi">
                            <c:forEach items="${kelas}" var="dt">
                                <option value="${dt.getPRODI()}"><c:out value="${dt.getPRODI()}"/></option>
                            </c:forEach>
                        </select>

                    </div>
                    <div class="column">

                        <br> Waktu Ajar<br>
                        <select style="width:50%;" name="waktu" size="4">
                                <option value="1">07:00:00-07:50:00</option>
                                <option value="2">07:50:00-08:40:00</option>
                                <option value="3">08:40:00-09:30:00</option>
                                <option value="4">09:30:00-10:20:00</option>
                                <option value="5">10:40:00-11:30:00</option>
                                <option value="6">11:30:00-12:20:00</option>
                                <option value="7">13:00:00-13:50:00</option>
                                <option value="8">13:50:00-14:40:00</option>
                                <option value="9">14:40:00-15:20:00</option>
                                <option value="10">15:20:00-16:10:00</option>
                        </select>

                        <br><br> Hari <br>
                        <input style="width:30%;" type="text" value="${jadwal.getHARI()}" id="hari" name="hari" placeholder="e.g: Senin">

                        <br><br> Tahun Ajaran <br>
                        <input style="width:30%;" type="text" value="${jadwal.getTAHUN_AJARAN()}" id="tahunajar" name="tahunajar" placeholder="e.g: 2017/2018">

                        <br><br> Semester <br>
                        <input style="width:30%;" type="number" value="${jadwal.getSEMESTER()}" id="semester" name="semester" placeholder="e.g: 3">

                        <br><br>
                        <input type="submit" style="width:20%;">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
