<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Rooster JTK</title>
        <meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="style.css">
		<script type="text/javascript" src="script.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
	
        <div id="main">
            <span style="font-size:30px;cursor:pointer" onclick="openNav('mainTable','270px')">&#9776; Rooster JTK</span><li style="float: right;list-style: none;">Kivlan Aziz</li>
        </div>
		
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav('mainTable','20px')">&times;</a>
            <a href="index.jsp">Schedule</a>
            <a href="input.jsp">Input Data</a>
            <a href="edit.jsp">Update Data</a>
            <a href="delete.jsp">Delete Data</a>
        </div>
        <div id="mainTable">

            <table>
                <jsp:include page="/Rooster?action=allschedule"/>
                    <tr class="tableTitle">
                            <th> Kode Dosen </th>
                            <th> Nama Dosen </th>
                            <th> Hari </th>
                            <th> Mata Kuliah </th>
                            <th> Kelas </th>
                            <th> Ruangan </th>
                            <th> Waktu Mulai </th>
                            <th> Waktu Selesai </th>
                    </tr>

                    <c:forEach items="${jadwal}" var="dt" >
                    <tr>
                            <th> <c:out value="${dt.getKD_DOSEN()}"/> </th>
                            <th> <c:out value="${dt.getNAMA_DOSEN()}"/> </th>
                            <th> <c:out value="${dt.getHARI()}"/> </th>
                            <th> <c:out value="${dt.getNAMA_MATKUL()}"/> </th>
                            <th> <c:out value="${dt.getNAMA_KELAS()}"/> </th>
                            <th> <c:out value="${dt.getKD_RUANGAN()}"/> </th>
                            <th> <c:out value="${dt.getWAKTU_MULAI()}"/> </th>
                            <th> <c:out value="${dt.getWAKTU_SELESAI()}"/> </th>
                    </tr>
                    </c:forEach>
            </table>

        </div>

        <div id="customSection">
            <form action="${pageContext.request.contextPath}/searchDsn?action=jadwaldsn">
                    <b>Cari Jadwal dosen tertentu</b>
                    <br>
                    <input type="text" id="JadwalDosen" name="JadwalDosen" placeholder="Kode Dosen e.g: KO001N">
                    <input type="submit" value="Cari">
            </form>
            <br>
            <form action="${pageContext.request.contextPath}/searchAjr?action=jamdsn">
                    <b>Cari Jumlah jam ajar dosen</b>
                    <br>
                    <input type="text" id="JamDosen" name="JamDosen" placeholder="Kode Dosen e.g: KO001N">
                    <input type="submit" value="Cari">
            </form>
            <br>
            <form action="">
                    <b>Cari Dosen dengan jam ajar paling sedikit</b>
                    <input type="number" id="Limit" name="Limit" placeholder="Jumlah Dosen yang ditampilkan e.g: 3">
                    <input type="submit" value="Cari">
            </form>
        </div>
    </body>
</html>
