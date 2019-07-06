<%-- 
    Document   : edit
    Created on : Jan 1, 2018, 6:23:59 PM
    Author     : kivla
--%>

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
            <span style="font-size:30px;cursor:pointer" onclick="openNav('TableEdit','350px')">&#9776; Rooster JTK</span><li style="float: right;list-style: none;">Kivlan Aziz</li>
        </div>
		
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav('TableEdit','100px')">&times;</a>
            <a href="index.jsp">Schedule</a>
            <a href="input.jsp">Input Data</a>
            <a href="edit.jsp">Update Data</a>
            <a href="delete.jsp">Delete Data</a>
        </div>
        <div id="TableEdit">

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
                            <th> Action </th>
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
                            <th> <button class="button button1" onclick="location.href='./edit?action=edit&kd_dosen=<c:out value='${dt.getKD_DOSEN()}' />&kd_matkul=<c:out value='${dt.getKD_MATKUL()}' />&kd_ruangan=<c:out value='${dt.getKD_RUANGAN()}' />&nama_kelas=<c:out value='${dt.getNAMA_KELAS()}' />&prodi=<c:out value='${dt.getPRODI()}' />&kd_jam=<c:out value='${dt.getKD_JAM()}' />'">Edit</button> </th>
                    </tr>
                    </c:forEach>
            </table>

        </div>
    </body>
</html>